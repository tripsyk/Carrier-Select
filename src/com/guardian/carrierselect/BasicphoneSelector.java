package com.guardian.carrierselect;

import android.app.Fragment;
import android.app.FragmentManager;
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

public class BasicphoneSelector extends Fragment {

	private static Animation fadeOut, fadeIn;
	private static View rootView;
	private static LinearLayout zerobasicbox, onebasicbox, twobasicbox, threebasicbox,
			fourbasicbox, fivebasicbox, sixbasicbox, sevenbasicbox,
			eightbasicbox, ninebasicbox, tenbasicbox;
	private static TextView basicphones;

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

		// Declare animations
		fadeIn = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.fadein);
		fadeOut = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.fadeout);

		// Declare TextViews
		basicphones = (TextView) rootView.findViewById(R.id.yourbasicphones);
		basicphones.setTypeface(null, Typeface.ITALIC);

		// Declare LinearLayouts
		zerobasicbox = (LinearLayout) rootView.findViewById(R.id.zerobasicbox);
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

		rootView.startAnimation(fadeIn);

		// Set animation listeners for fragment
		fadeOut.setAnimationListener(new AnimationListener() {

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
				rootView.startAnimation(fadeOut);

			}
		});

		onebasicbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("basic", 1);
				editor.commit();
				rootView.startAnimation(fadeOut);

			}
		});

		twobasicbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("basic", 2);
				editor.commit();
				rootView.startAnimation(fadeOut);
			}
		});

		threebasicbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("basic", 3);
				editor.commit();
				rootView.startAnimation(fadeOut);
			}
		});

		fourbasicbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("basic", 4);
				editor.commit();
				rootView.startAnimation(fadeOut);
			}
		});

		fivebasicbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("basic", 5);
				editor.commit();
				rootView.startAnimation(fadeOut);
			}
		});

		sixbasicbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("basic", 6);
				editor.commit();
				rootView.startAnimation(fadeOut);
			}
		});

		sevenbasicbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("basic", 7);
				editor.commit();
				rootView.startAnimation(fadeOut);
			}
		});

		eightbasicbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("basic", 8);
				editor.commit();
				rootView.startAnimation(fadeOut);
			}
		});

		ninebasicbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("basic", 9);
				editor.commit();
				rootView.startAnimation(fadeOut);
			}
		});

		tenbasicbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("basic", 10);
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