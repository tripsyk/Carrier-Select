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

public class Monthly extends Fragment {

	private static Animation fadeOut, fadeIn;
	private static View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater
				.inflate(R.layout.activity_monthly, container, false);
		getActivity().getActionBar().hide();

		fadeIn = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.fadein);

		rootView.startAnimation(fadeIn);

		TextView dollarQ = (TextView) rootView.findViewById(R.id.dollarQ);
		dollarQ.setTypeface(null, Typeface.ITALIC);
		final SharedPreferences sharedPref = getActivity().getPreferences(
				Context.MODE_PRIVATE);
		final SharedPreferences.Editor editor = sharedPref.edit();

		fadeOut = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.fadeout);

		final LinearLayout less70 = (LinearLayout) rootView
				.findViewById(R.id.less70box);
		final LinearLayout less125 = (LinearLayout) rootView
				.findViewById(R.id.less125box);
		final LinearLayout less150 = (LinearLayout) rootView
				.findViewById(R.id.less150box);
		final LinearLayout less175 = (LinearLayout) rootView
				.findViewById(R.id.less175box);
		final LinearLayout less200 = (LinearLayout) rootView
				.findViewById(R.id.less200box);
		final LinearLayout less225 = (LinearLayout) rootView
				.findViewById(R.id.less225box);
		final LinearLayout less250 = (LinearLayout) rootView
				.findViewById(R.id.less250box);
		final LinearLayout plus250 = (LinearLayout) rootView
				.findViewById(R.id.plus250box);

		fadeOut.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationEnd(Animation arg0) {

				Fragment fragment = new Home();

				FragmentTransaction fragmenttran = getFragmentManager()
						.beginTransaction();
				getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
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

		less70.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("amount", 70);
				editor.commit();
				rootView.startAnimation(fadeOut);

			}
		});

		less125.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("amount", 125);
				editor.commit();
				rootView.startAnimation(fadeOut);
			}
		});

		less150.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("amount", 150);
				editor.commit();
				rootView.startAnimation(fadeOut);
			}
		});

		less175.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("amount", 175);
				editor.commit();
				rootView.startAnimation(fadeOut);
			}
		});

		less200.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("amount", 200);
				editor.commit();
				rootView.startAnimation(fadeOut);
			}
		});

		less225.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("amount", 225);
				editor.commit();
				rootView.startAnimation(fadeOut);
			}
		});

		less250.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("amount", 250);
				editor.commit();
				rootView.startAnimation(fadeOut);
			}
		});

		plus250.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("amount", 275);
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
