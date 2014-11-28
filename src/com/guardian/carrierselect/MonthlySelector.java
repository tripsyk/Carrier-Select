package com.guardian.carrierselect;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MonthlySelector extends Fragment {

	private static View rootView;
	private static TextView userMonthly;
	private static Button next;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.monthlyselector, container, false);

		// Declare preferences
		final SharedPreferences sharedPref = getActivity()
				.getSharedPreferences("profile", Context.MODE_PRIVATE);
		final SharedPreferences.Editor editor = sharedPref.edit();
		next = (Button) rootView.findViewById(R.id.next);

		userMonthly = (EditText) rootView.findViewById(R.id.theMonthly);

		next.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				InputMethodManager imm = (InputMethodManager) rootView
						.getContext().getSystemService(
								Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(userMonthly.getWindowToken(), 0);

				editor.putInt("monthly",
						Integer.parseInt(userMonthly.getText().toString()));
				editor.commit();

				Intent intent = new Intent(getActivity(), InteractiveAct.class);
				startActivity(intent);
			}
		});

		return rootView;

	}

	public void onDestroy() {
		super.onDestroy();
	}

}