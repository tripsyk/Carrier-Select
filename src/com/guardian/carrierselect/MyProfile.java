package com.guardian.carrierselect;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MyProfile extends Fragment {

	private static View rootView;
	private static TextView theCarrier, theSmarts, theBasics, theData,
			theMonthly;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.myprofile, container, false);
		getActivity().getActionBar().setTitle("My Profile");
		getActivity().getActionBar().show();

		// Declare preferences
		final String PREFS_NAME = "MyPrefsFile";
		SharedPreferences settings = getActivity().getSharedPreferences(
				PREFS_NAME, 0);

		// Load in animations.
		final Animation righttoleft = AnimationUtils.loadAnimation(
				rootView.getContext(), R.anim.right_to_left);
		final Animation lefttoright = AnimationUtils.loadAnimation(
				rootView.getContext(), R.anim.left_to_right);

		// Begin startup flow.
		rootView.startAnimation(lefttoright);

		// Declare TextViews
		theCarrier = (TextView) rootView.findViewById(R.id.yourcarrier);
		theSmarts = (TextView) rootView.findViewById(R.id.numsmartphones);
		theBasics = (TextView) rootView.findViewById(R.id.numbasicphones);
		theData = (TextView) rootView.findViewById(R.id.gigsofdata);
		theMonthly = (TextView) rootView.findViewById(R.id.monthlybill);
		final TextView edit = (TextView) rootView
				.findViewById(R.id.editprofile);

		// Initial operations on View Create
		settings.edit().putBoolean("my_first_time", false).commit();

		// Set animation listeners for Fragment
		righttoleft.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationEnd(Animation arg0) {
				final Fragment fragment = new CarrierSelector();
				final FragmentTransaction fragmenttran = getFragmentManager()
						.beginTransaction();
				fragmenttran.replace(R.id.fragment_container, fragment);
				fragmenttran.addToBackStack(null);
				fragmenttran.commit();

			}

			@Override
			public void onAnimationRepeat(Animation arg0) {
			}

			@Override
			public void onAnimationStart(Animation arg0) {
			}
		});

		edit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				rootView.startAnimation(righttoleft);

			}
		});

		initHomePrefs();

		// Send the view back to the main Activity
		return rootView;
	}

	private void initHomePrefs() {

		// Declare preferences
		final SharedPreferences sharedPref = getActivity().getPreferences(
				Context.MODE_PRIVATE);

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
		int smartphones = sharedPref.getInt("smart", 0);
		theSmarts.setText(String.valueOf(smartphones));

		// Set the appropriate Basic phones on the homescreen
		int basicphones = sharedPref.getInt("basic", 0);
		theBasics.setText(String.valueOf(basicphones));

		// Set the appropriate data usage on the homescreen
		int thegigs = sharedPref.getInt("data", 0);
		theData.setText(String.valueOf(thegigs) + "GB");

		// Set the appropriate monthly bill on the homescreen
		int monthly = sharedPref.getInt("monthly", 0);
		theMonthly.setText("$" + String.valueOf(monthly));
	}

	public void onDestroy() {
		super.onDestroy();
	}

}
