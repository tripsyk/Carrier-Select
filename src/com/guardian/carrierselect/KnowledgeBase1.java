package com.guardian.carrierselect;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

@SuppressLint("DefaultLocale")
public class KnowledgeBase1 extends Fragment {

	private Button search;
	private EditText searchTerm;
	private static View rootView;
	private ProgressDialog progress;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.knowledge1, container, false);

		search = (Button) rootView.findViewById(R.id.next);
		searchTerm = (EditText) rootView.findViewById(R.id.searchTerm);

		final SharedPreferences sharedPref = getActivity()
				.getSharedPreferences("data", Context.MODE_PRIVATE);
		final SharedPreferences.Editor editor = sharedPref.edit();

		searchTerm.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (!hasFocus) {
					hideKeyboard();
				}

			}
		});

		search.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				InputMethodManager imm = (InputMethodManager) rootView
						.getContext().getSystemService(
								Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(searchTerm.getWindowToken(), 0);

				init();

				editor.putString("kb1", searchTerm.getText().toString()
						.toLowerCase());
				editor.commit();

			}
		});

		return rootView;
	}

	private void hideKeyboard() {
		InputMethodManager imm = (InputMethodManager) rootView.getContext()
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(searchTerm.getWindowToken(), 0);
	}

	public void init() {

		progress = new ProgressDialog(getActivity(),
				AlertDialog.THEME_DEVICE_DEFAULT_DARK);
		progress.setTitle("Knowledge Search");
		progress.setMessage("Just a sec...");
		progress.setCancelable(false);
		progress.show();

		// Test Query
		ParseQuery<ParseObject> query = ParseQuery.getQuery("KnowledgeBase");
		query.setLimit(5);
		query.whereContains("Tag", searchTerm.getText().toString()
				.toLowerCase());
		query.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> PhoneList, ParseException e) {

				if (e == null) {

					for (int i = 0; i < PhoneList.size(); i++) {
						ParseObject phone = PhoneList.get(i);
						phone.pinInBackground(null);
					}

					final Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {

							final Fragment fragment = new KnowledgeBase2();
							final FragmentTransaction fragmenttran = getActivity()
									.getSupportFragmentManager()
									.beginTransaction();
							fragmenttran.setCustomAnimations(
									R.anim.slide_in_right,
									R.anim.slide_out_left,
									R.anim.slide_in_left,
									R.anim.slide_out_right);
							fragmenttran.replace(R.id.fragment_container,
									fragment);
							fragmenttran.addToBackStack(null);
							fragmenttran.commit();

							progress.dismiss();
						}
					}, 400);

				} else {
				}
			}
		});

	}

}