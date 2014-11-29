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
import android.widget.Button;
import android.widget.TextView;

public class MyProfile extends Fragment {

	private static View rootView;
	private static TextView theCarrier, theSmarts, theBasics, theData, theTabs,
			theMifi, theMonthly;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.myprofile, container, false);

		// Declare preferences
		final String PREFS_NAME = "MyPrefsFile";
		SharedPreferences settings = getActivity().getSharedPreferences(
				PREFS_NAME, 0);

		// Declare TextViews
		theCarrier = (TextView) rootView.findViewById(R.id.yourcarrier);
		theSmarts = (TextView) rootView.findViewById(R.id.numsmartphones);
		theBasics = (TextView) rootView.findViewById(R.id.numbasicphones);
		theData = (TextView) rootView.findViewById(R.id.gigsofdata);
		theTabs = (TextView) rootView.findViewById(R.id.numtablets);
		theMifi = (TextView) rootView.findViewById(R.id.nummifi);
		theMonthly = (TextView) rootView.findViewById(R.id.monthlybill);
		final Button edit = (Button) rootView.findViewById(R.id.editprofile);
		
		
		edit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				final Fragment fragment = new CarrierSelector();
				final FragmentManager fm = getActivity().getFragmentManager();
				final FragmentTransaction fragmenttran = fm.beginTransaction();
				fragmenttran.setCustomAnimations(R.animator.right_in_off,
						R.animator.left_in_off);
				fragmenttran.replace(R.id.fragment_container, fragment);
				fragmenttran.addToBackStack(null);
				fragmenttran.commit();
			}
		});

		initHomePrefs();

		// Send the view back to the main Activity
		return rootView;
	}

	private void initHomePrefs() {

		// Declare preferences
		final SharedPreferences sharedPref = getActivity()
				.getSharedPreferences("profile", Context.MODE_PRIVATE);

		// Set the appropriate Carrier on the homescreen
		int carrier = sharedPref.getInt("carrier", 0);
		if (carrier == 1) {
			theCarrier.setText("AT&T");

		} else if (carrier == 2) {
			theCarrier.setText("Sprint");

		} else if (carrier == 3) {
			theCarrier.setText("T-Mobile");

		} else if (carrier == 4) {
			theCarrier.setText("Verizon");

		} else if (carrier == 5) {
			theCarrier.setText("Prepaid");

		}

		// Set the appropriate Smartphones on the homescreen
		String smartphones = sharedPref.getString("smart", "Not Set");
		theSmarts.setText(String.valueOf(smartphones));

		// Set the appropriate Basic phones on the homescreen
		String basicphones = sharedPref.getString("basic", "Not Set");
		theBasics.setText(String.valueOf(basicphones));

		// Set the appropriate data usage on the homescreen
		String thegigs = sharedPref.getString("data", "Not Set");
		theData.setText(thegigs);

		// Set the appropriate data usage on the homescreen
		String tabs = sharedPref.getString("tabs", "Not Set");
		theTabs.setText(tabs);

		// Set the appropriate mifi devices on the homescreen
		String mifi = sharedPref.getString("mifi", "Not Set");
		theMifi.setText(mifi);

		// Set the appropriate monthly bill on the homescreen
		int monthly = sharedPref.getInt("monthly", 0);
		theMonthly.setText("$" + String.valueOf(monthly));
	}

	public void onDestroy() {
		super.onDestroy();
	}

}
