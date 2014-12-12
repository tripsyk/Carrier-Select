package com.guardian.carrierselect;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
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

@SuppressLint("DefaultLocale")
public class PhoneSearch4 extends Fragment {

	private Button next;
	private EditText searchTerm;
	private static View rootView;
	private ProgressDialog progress;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.phonesearch4, container, false);

		next = (Button) rootView.findViewById(R.id.next);
		searchTerm = (EditText) rootView.findViewById(R.id.searchTerm);

		final SharedPreferences sharedPref = getActivity()
				.getSharedPreferences("data", Context.MODE_PRIVATE);
		final SharedPreferences.Editor editor = sharedPref.edit();

		next.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				InputMethodManager imm = (InputMethodManager) rootView
						.getContext().getSystemService(
								Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(searchTerm.getWindowToken(), 0);

				init();

				editor.putString("ps4", searchTerm.getText().toString()
						.toLowerCase());
				editor.commit();

			}
		});

		searchTerm.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (!hasFocus) {
					hideKeyboard();
				}

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
		progress.setTitle("Phone Search");
		progress.setMessage("Just a sec...");
		progress.setCancelable(false);
		progress.show();

		// Test Query
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Phones");
		query.whereContains("SearchName", searchTerm.getText().toString()
				.toLowerCase());
		query.setLimit(5);
		query.orderByAscending("ReleaseOrder");
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

							final Fragment fragment = new PhoneSearch5();
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

	public void onDestroy() {
		super.onDestroy();
	}

}