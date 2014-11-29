package com.guardian.carrierselect;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InstallSelector extends Fragment {

	private static View rootView;
	private static TextView installments;
	private static Button next;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.installselector, container, false);

		// Declare preferences
		final SharedPreferences sharedPref = getActivity()
				.getSharedPreferences("profile", Context.MODE_PRIVATE);
		final SharedPreferences.Editor editor = sharedPref.edit();
		next = (Button) rootView.findViewById(R.id.next);

		installments = (EditText) rootView.findViewById(R.id.theinstalls);

		next.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				InputMethodManager imm = (InputMethodManager) rootView
						.getContext().getSystemService(
								Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(installments.getWindowToken(), 0);

				editor.putInt("installments",
						Integer.parseInt(installments.getText().toString()));
				editor.commit();

				final Fragment fragment = new MonthlySelector();

				final FragmentManager fm = getActivity().getFragmentManager();

				final FragmentTransaction fragmenttran = fm.beginTransaction();

				fragmenttran.setCustomAnimations(R.animator.right_in_off,
						R.animator.left_in_off);
				fragmenttran.replace(R.id.fragment_container, fragment);
				fragmenttran.addToBackStack(null);
				fragmenttran.commit();
			}
		});

		return rootView;

	}

	public void onDestroy() {
		super.onDestroy();
	}

}