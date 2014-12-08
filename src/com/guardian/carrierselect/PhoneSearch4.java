package com.guardian.carrierselect;

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

public class PhoneSearch4 extends Fragment {

	private Button next;
	private EditText searchTerm;
	private static View rootView;

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

				editor.putString("compareterm", searchTerm.getText().toString());
				editor.commit();

				final Fragment fragment = new PhoneSearch5();
				final FragmentTransaction fragmenttran = getActivity()
						.getSupportFragmentManager().beginTransaction();
				fragmenttran.setCustomAnimations(R.anim.slide_in_right,
						R.anim.slide_out_left, R.anim.slide_in_left,
						R.anim.slide_out_right);
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