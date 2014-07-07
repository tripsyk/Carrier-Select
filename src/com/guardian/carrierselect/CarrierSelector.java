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
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CarrierSelector extends Fragment {

	private static Animation fadeOut, fadeIn;
	private static LinearLayout attbox, sprintbox, tmobox, verizonbox, otherbox;
	private static View rootView;
	private static TextView title;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.carrierselector_layout, container,
				false);
		getActivity().getActionBar().hide();

		fadeIn = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.fadein);

		rootView.startAnimation(fadeIn);

		title = (TextView) rootView.findViewById(R.id.carriertitle);
		title.setTypeface(null, Typeface.ITALIC);
		final SharedPreferences sharedPref = getActivity().getPreferences(
				Context.MODE_PRIVATE);
		final SharedPreferences.Editor editor = sharedPref.edit();

		fadeOut = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.fadeout);

		attbox = (LinearLayout) rootView.findViewById(R.id.attbox);
		sprintbox = (LinearLayout) rootView.findViewById(R.id.sprintbox);
		tmobox = (LinearLayout) rootView.findViewById(R.id.tmobox);
		verizonbox = (LinearLayout) rootView.findViewById(R.id.verizonbox);
		otherbox = (LinearLayout) rootView.findViewById(R.id.otherbox);

		attbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("carrier", 1);
				editor.commit();
				rootView.startAnimation(fadeOut);
			}
		});

		sprintbox.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				editor.putInt("carrier", 2);
				editor.commit();
				rootView.startAnimation(fadeOut);
			}
		});

		tmobox.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				editor.putInt("carrier", 3);
				editor.commit();
				rootView.startAnimation(fadeOut);
			}
		});
		
		verizonbox.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				editor.putInt("carrier", 4);
				editor.commit();
				rootView.startAnimation(fadeOut);
			}
		});
		
		otherbox.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				editor.putInt("carrier", 5);
				editor.commit();
				rootView.startAnimation(fadeOut);
			}
		});

		fadeOut.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationEnd(Animation arg0) {

				final Fragment fragment = new SmartphoneSelector();

				final FragmentTransaction fragmenttran = getFragmentManager()
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

		return rootView;

	}

	public void onDestroy() {
		super.onDestroy();
	}

}

