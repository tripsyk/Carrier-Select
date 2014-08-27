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
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class DataSelector extends Fragment {

	private static View rootView;
	private static LinearLayout zerodatabox, onedatabox, twodatabox,
			threedatabox, fourdatabox, fivedatabox, sixdatabox, sevendatabox,
			eightdatabox, ninedatabox, tendatabox;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.dataselector_layout, container,
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
		zerodatabox = (LinearLayout) rootView.findViewById(R.id.zerodatabox);
		onedatabox = (LinearLayout) rootView.findViewById(R.id.onedatabox);
		twodatabox = (LinearLayout) rootView.findViewById(R.id.twodatabox);
		threedatabox = (LinearLayout) rootView.findViewById(R.id.threedatabox);
		fourdatabox = (LinearLayout) rootView.findViewById(R.id.fourdatabox);
		fivedatabox = (LinearLayout) rootView.findViewById(R.id.fivedatabox);
		sixdatabox = (LinearLayout) rootView.findViewById(R.id.sixdatabox);
		sevendatabox = (LinearLayout) rootView.findViewById(R.id.sevendatabox);
		eightdatabox = (LinearLayout) rootView.findViewById(R.id.eightdatabox);
		ninedatabox = (LinearLayout) rootView.findViewById(R.id.ninedatabox);
		tendatabox = (LinearLayout) rootView.findViewById(R.id.tendatabox);

		// Set animation listeners for fragment
		righttoleft.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationEnd(Animation arg0) {
				Fragment fragment = new MonthlySelector();
				FragmentTransaction fragmenttran = getFragmentManager()
						.beginTransaction();
				getFragmentManager().popBackStack(null,
						FragmentManager.POP_BACK_STACK_INCLUSIVE);
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

		zerodatabox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("data", 0);
				editor.commit();
				rootView.startAnimation(righttoleft);

			}
		});

		onedatabox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("data", 1);
				editor.commit();
				rootView.startAnimation(righttoleft);

			}
		});

		twodatabox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("data", 2);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		threedatabox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("data", 3);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		fourdatabox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("data", 4);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		fivedatabox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("data", 5);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		sixdatabox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("data", 6);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		sevendatabox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("data", 7);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		eightdatabox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("data", 8);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		ninedatabox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("data", 9);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		tendatabox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("data", 10);
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