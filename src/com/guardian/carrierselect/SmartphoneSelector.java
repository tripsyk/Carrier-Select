package com.guardian.carrierselect;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SmartphoneSelector extends Fragment {

	private static Animation fadeOut, fadeIn;
	private static View rootView;
	private static LinearLayout onesmartbox, twosmartbox, threesmartbox,
			foursmartbox, fivesmartbox, sixsmartbox, sevensmartbox,
			eightsmartbox, ninesmartbox, tensmartbox;
	private static TextView smartphones;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.smartphone_layout, container,
				false);
		getActivity().getActionBar().hide();
		
		
		// Declare preferences
		final SharedPreferences sharedPref = getActivity().getPreferences(
				Context.MODE_PRIVATE);
		final SharedPreferences.Editor editor = sharedPref.edit();

		
		// Declare animations
		fadeIn = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.fadein);
		fadeOut = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.fadeout);

		
		// Declare TextViews
		smartphones = (TextView) rootView.findViewById(R.id.yoursmartphones);
		smartphones.setTypeface(null, Typeface.ITALIC);
		
		
		// Declare LinearLayouts
		onesmartbox = (LinearLayout) rootView.findViewById(R.id.onesmartbox);
		twosmartbox = (LinearLayout) rootView.findViewById(R.id.twosmartbox);
		threesmartbox = (LinearLayout) rootView
				.findViewById(R.id.threesmartbox);
		foursmartbox = (LinearLayout) rootView.findViewById(R.id.foursmartbox);
		fivesmartbox = (LinearLayout) rootView.findViewById(R.id.fivesmartbox);
		sixsmartbox = (LinearLayout) rootView.findViewById(R.id.sixsmartbox);
		sevensmartbox = (LinearLayout) rootView
				.findViewById(R.id.sevensmartbox);
		eightsmartbox = (LinearLayout) rootView
				.findViewById(R.id.eightsmartbox);
		ninesmartbox = (LinearLayout) rootView.findViewById(R.id.ninesmartbox);
		tensmartbox = (LinearLayout) rootView.findViewById(R.id.tensmartbox);
		
		rootView.startAnimation(fadeIn);

		
		// Set animation listeners for fragment
		fadeOut.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationEnd(Animation arg0) {
				Fragment fragment = new BasicphoneSelector();
				FragmentTransaction fragmenttran = getFragmentManager()
						.beginTransaction();
				fragmenttran.replace(R.id.fragment_container, fragment);
				fragmenttran.addToBackStack(null);
				fragmenttran.commit();
				getFragmentManager().executePendingTransactions();
				
			}

			@Override
			public void onAnimationRepeat(Animation arg0) {

			}

			@Override
			public void onAnimationStart(Animation arg0) {

			}
		});

		onesmartbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("smart", 1);
				editor.commit();
				rootView.startAnimation(fadeOut);

			}
		});

		twosmartbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("smart", 2);
				editor.commit();
				rootView.startAnimation(fadeOut);
			}
		});

		threesmartbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("smart", 3);
				editor.commit();
				rootView.startAnimation(fadeOut);
			}
		});

		foursmartbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("smart", 4);
				editor.commit();
				rootView.startAnimation(fadeOut);
			}
		});

		fivesmartbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("smart", 5);
				editor.commit();
				rootView.startAnimation(fadeOut);
			}
		});

		sixsmartbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("smart", 6);
				editor.commit();
				rootView.startAnimation(fadeOut);
			}
		});

		sevensmartbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("smart", 7);
				editor.commit();
				rootView.startAnimation(fadeOut);
			}
		});

		eightsmartbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("smart", 8);
				editor.commit();
				rootView.startAnimation(fadeOut);
			}
		});
		
		ninesmartbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("smart", 9);
				editor.commit();
				rootView.startAnimation(fadeOut);
			}
		});

		tensmartbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("smart", 10);
				editor.commit();
				rootView.startAnimation(fadeOut);
			}
		});

		return rootView;

	}

	public void onDestroy() {
		super.onDestroy();
	}

}