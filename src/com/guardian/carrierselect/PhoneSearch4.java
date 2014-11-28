package com.guardian.carrierselect;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class PhoneSearch4 extends Fragment {

	private TextView search;
	private EditText searchTerm;
	private static View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.phonesearch4, container, false);

		search = (TextView) rootView.findViewById(R.id.searchGo);
		searchTerm = (EditText) rootView.findViewById(R.id.searchTerm);

		final SharedPreferences sharedPref = getActivity()
				.getSharedPreferences("data", Context.MODE_PRIVATE);
		final SharedPreferences.Editor editor = sharedPref.edit();

		search.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				InputMethodManager imm = (InputMethodManager) rootView
						.getContext().getSystemService(
								Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(searchTerm.getWindowToken(), 0);

				editor.putString("compareterm", searchTerm.getText().toString());
				editor.commit();

				final Fragment fragment = new PhoneSearch5();
				final FragmentManager fm = getActivity().getFragmentManager();
				final FragmentTransaction fragmenttran = fm.beginTransaction();
				fragmenttran.setCustomAnimations(R.animator.right_in_off,
						R.animator.left_in_off);
				fragmenttran.replace(R.id.fragment_container, fragment);
				fragmenttran.addToBackStack(null);
				fragmenttran.commit();

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

	public void onDestroy() {
		super.onDestroy();
	}

}