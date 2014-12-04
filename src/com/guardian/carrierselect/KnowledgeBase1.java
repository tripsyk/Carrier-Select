package com.guardian.carrierselect;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class KnowledgeBase1 extends Fragment {

	private Button search;
	private EditText searchTerm;
	private static View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.knowledge1, container, false);

		search = (Button) rootView.findViewById(R.id.kbsearchgo);
		searchTerm = (EditText) rootView.findViewById(R.id.searchTerm);

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

				final FragmentTransaction fragmenttran = getActivity()
						.getSupportFragmentManager().beginTransaction();
				fragmenttran.setCustomAnimations(R.anim.slide_in_right,
						R.anim.slide_out_left, R.anim.slide_in_left,
						R.anim.slide_out_right);
				fragmenttran.replace(R.id.fragment_container,
						KnowledgeBase2.create(searchTerm.getText().toString()));
				fragmenttran.addToBackStack(null);
				fragmenttran.commit();

			}
		});

		return rootView;
	}

	private void hideKeyboard() {
		InputMethodManager imm = (InputMethodManager) rootView.getContext()
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(searchTerm.getWindowToken(), 0);
	}

}