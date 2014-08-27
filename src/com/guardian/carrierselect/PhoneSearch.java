package com.guardian.carrierselect;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

import com.guardian.carrierselect.model.Phone;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class PhoneSearch extends Fragment {

	private TextView search, poweredby;
	private EditText searchTerm;
	private static View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.phonesearch1, container, false);
		
		getActivity().getActionBar().setTitle("Phone Search");

		search = (TextView) rootView.findViewById(R.id.searchGo);
		searchTerm = (EditText) rootView.findViewById(R.id.searchTerm);

		// Load in animations.
		final Animation righttoleft = AnimationUtils.loadAnimation(
				rootView.getContext(), R.anim.right_to_left);
		final Animation lefttoright = AnimationUtils.loadAnimation(
				rootView.getContext(), R.anim.left_to_right);

		// Begin startup flow.
		rootView.startAnimation(lefttoright);

		search.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				InputMethodManager imm = (InputMethodManager) rootView
						.getContext().getSystemService(
								Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(searchTerm.getWindowToken(), 0);

				final FragmentTransaction fragmenttran = getFragmentManager()
						.beginTransaction();
				fragmenttran.replace(R.id.fragment_container,
						PhoneSearch2.create(searchTerm.getText().toString()));
				fragmenttran.addToBackStack(null);
				fragmenttran.commit();
				getFragmentManager().executePendingTransactions();

			}
		});

		searchTerm.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId,
					KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_DONE) {
					// do something
				}
				return false;
			}
		});

		return rootView;
	}

	public void onDestroy() {
		super.onDestroy();
	}

}