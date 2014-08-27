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
import android.widget.TextView;

public class BasicphoneSelector extends Fragment {

	private static View rootView;
	private static LinearLayout onebasicbox, twobasicbox,
			threebasicbox, fourbasicbox, fivebasicbox, sixbasicbox,
			sevenbasicbox, eightbasicbox, ninebasicbox, tenbasicbox;
	private static TextView zerobasicbox;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.basicphone_layout, container,
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
		zerobasicbox = (TextView) rootView.findViewById(R.id.zerobasicbox);
		onebasicbox = (LinearLayout) rootView.findViewById(R.id.onebasicbox);
		twobasicbox = (LinearLayout) rootView.findViewById(R.id.twobasicbox);
		threebasicbox = (LinearLayout) rootView
				.findViewById(R.id.threebasicbox);
		fourbasicbox = (LinearLayout) rootView.findViewById(R.id.fourbasicbox);
		fivebasicbox = (LinearLayout) rootView.findViewById(R.id.fivebasicbox);
		sixbasicbox = (LinearLayout) rootView.findViewById(R.id.sixbasicbox);
		sevenbasicbox = (LinearLayout) rootView
				.findViewById(R.id.sevenbasicbox);
		eightbasicbox = (LinearLayout) rootView
				.findViewById(R.id.eightbasicbox);
		ninebasicbox = (LinearLayout) rootView.findViewById(R.id.ninebasicbox);
		tenbasicbox = (LinearLayout) rootView.findViewById(R.id.tenbasicbox);

		// Set animation listeners for fragment
		righttoleft.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationEnd(Animation arg0) {
				Fragment fragment = new DataSelector();
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

		zerobasicbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("basic", 0);
				editor.commit();
				rootView.startAnimation(righttoleft);

			}
		});

		onebasicbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("basic", 1);
				editor.commit();
				rootView.startAnimation(righttoleft);

			}
		});

		twobasicbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("basic", 2);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		threebasicbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("basic", 3);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		fourbasicbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("basic", 4);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		fivebasicbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("basic", 5);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		sixbasicbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("basic", 6);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		sevenbasicbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("basic", 7);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		eightbasicbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("basic", 8);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		ninebasicbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("basic", 9);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		tenbasicbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("basic", 10);
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