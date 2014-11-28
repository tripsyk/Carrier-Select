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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class BasicphoneSelector extends Fragment {

	private static View rootView;
	private static Button next;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.basicphone_layout, container,
				false);

		// Declare preferences
		final SharedPreferences sharedPref = getActivity().getSharedPreferences(
				"profile", Context.MODE_PRIVATE);
		final SharedPreferences.Editor editor = sharedPref.edit();
		
		next = (Button) rootView.findViewById(R.id.next);
		final Spinner spinner = (Spinner) rootView
				.findViewById(R.id.basicspinner);

		// Create an ArrayAdapter using the string array and a default spinner
		// layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				(rootView.getContext()), R.array.phonespinner,
				R.layout.spinnerdropdown);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(R.layout.spinnerdropdown);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);

		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				editor.putString(
						"basic",
						spinner.getItemAtPosition(
								spinner.getSelectedItemPosition()).toString());
				editor.commit();

			}

			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

		next.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				final Fragment fragment = new DataSelector();

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