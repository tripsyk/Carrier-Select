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
import android.widget.LinearLayout;

public class SmartphoneSelector extends Fragment {

	private static View rootView;
	private static LinearLayout zerosmartbox, onesmartbox, twosmartbox,
			threesmartbox, foursmartbox, fivesmartbox, sixsmartbox,
			sevensmartbox, eightsmartbox, ninesmartbox, tensmartbox;

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

		// Load in animations.
		final Animation righttoleft = AnimationUtils.loadAnimation(
				rootView.getContext(), R.anim.right_to_left);
		final Animation lefttoright = AnimationUtils.loadAnimation(
				rootView.getContext(), R.anim.left_to_right);

		// Begin startup flow.
		rootView.startAnimation(lefttoright);

		// Declare LinearLayouts
		zerosmartbox = (LinearLayout) rootView.findViewById(R.id.zerosmartbox);
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

		// Set animation listeners for fragment
		righttoleft.setAnimationListener(new AnimationListener() {

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

		zerosmartbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("smart", 0);
				editor.commit();
				rootView.startAnimation(righttoleft);

			}
		});

		onesmartbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("smart", 1);
				editor.commit();
				rootView.startAnimation(righttoleft);

			}
		});

		twosmartbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("smart", 2);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		threesmartbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("smart", 3);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		foursmartbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("smart", 4);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		fivesmartbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("smart", 5);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		sixsmartbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("smart", 6);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		sevensmartbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("smart", 7);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		eightsmartbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("smart", 8);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		ninesmartbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("smart", 9);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		tensmartbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("smart", 10);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		return rootView;

	}

	public void onDestroy() {
		super.onDestroy();
	}

}