package com.guardian.carrierselect;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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

public class NoContract1 extends Fragment {

	private View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.nocontract1, container, false);

		final SharedPreferences sharedPref = getActivity().getPreferences(
				Context.MODE_PRIVATE);
		final SharedPreferences.Editor editor = sharedPref.edit();
		final Button next = (Button) rootView.findViewById(R.id.next);
		final Spinner spinner = (Spinner) rootView
				.findViewById(R.id.carrierspinner);

		// Create an ArrayAdapter using the string array and a default spinner
		// layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				(rootView.getContext()), R.array.nocontractarray,
				R.layout.widespinnerdropdown);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(R.layout.widespinnerdropdown);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);

		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				if (arg3 >= 0) {
					editor.putString(
							"nc1carrier",
							spinner.getItemAtPosition(
									spinner.getSelectedItemPosition())
									.toString());
					editor.commit();
				}

			}

			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

		next.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				final Fragment fragment = new NoContract2();

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

		return rootView;

	}

	public void onDestroy() {
		super.onDestroy();
	}

}