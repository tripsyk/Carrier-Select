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

public class CarrierSelector extends Fragment {

	private static LinearLayout attbox, sprintbox, tmobox, verizonbox,
			otherbox;
	private static View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.carrierselector_layout, container,
				false);

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
				rootView.startAnimation(righttoleft);
			}
		});

		sprintbox.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				editor.putInt("carrier", 2);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		tmobox.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				editor.putInt("carrier", 3);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		verizonbox.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				editor.putInt("carrier", 4);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		otherbox.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				editor.putInt("carrier", 5);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		lefttoright.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationEnd(Animation arg0) {
				getActivity().getActionBar().hide();
			}

			@Override
			public void onAnimationRepeat(Animation arg0) {

			}

			@Override
			public void onAnimationStart(Animation arg0) {

			}
		});

		righttoleft.setAnimationListener(new AnimationListener() {

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
