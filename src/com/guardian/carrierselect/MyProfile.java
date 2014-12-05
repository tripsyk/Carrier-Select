package com.guardian.carrierselect;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
			theMifi, theDiscount, theInstalls, theMonthly;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.myprofile, container, false);

		// Declare TextViews
		theCarrier = (TextView) rootView.findViewById(R.id.yourcarrier);
		theSmarts = (TextView) rootView.findViewById(R.id.numsmartphones);
		theBasics = (TextView) rootView.findViewById(R.id.numbasicphones);
		theData = (TextView) rootView.findViewById(R.id.gigsofdata);
		theTabs = (TextView) rootView.findViewById(R.id.numtablets);
		theMifi = (TextView) rootView.findViewById(R.id.nummifi);
		theDiscount = (TextView) rootView.findViewById(R.id.numdiscount);
		theInstalls = (TextView) rootView.findViewById(R.id.numinstall);
		theMonthly = (TextView) rootView.findViewById(R.id.monthlybill);
		final Button edit = (Button) rootView.findViewById(R.id.editprofile);

		edit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				final Fragment fragment = new CarrierSelector();
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

		// Set the appropriate data usage on the homescreen
		String discount = sharedPref.getString("discount", "Not Set");
		theDiscount.setText(discount);

		// Set the appropriate monthly bill on the homescreen
		String installs = sharedPref.getString("installments", "Not Set");
		theInstalls.setText("$" + String.valueOf(installs) + "/month");

		// Set the appropriate monthly bill on the homescreen
		String monthly = sharedPref.getString("monthly", "Not Set");
		theMonthly.setText("$" + String.valueOf(monthly));
	}

	public void onDestroy() {
		super.onDestroy();
	}

}
