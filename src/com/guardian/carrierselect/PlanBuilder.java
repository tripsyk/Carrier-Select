package com.guardian.carrierselect;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class PlanBuilder extends Fragment {

	private View rootView;
	private static Animation scalenext, fadeIn;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.planbuilder_layout, container,
				false);

		fadeIn = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.fadein);

		rootView.startAnimation(fadeIn);

		final TextView pb1 = (TextView) rootView
				.findViewById(R.id.planbuilder1tv);
		pb1.setTypeface(null, Typeface.ITALIC);
		final TextView pb1next = (TextView) rootView.findViewById(R.id.pbnext1);
		pb1next.setTypeface(null, Typeface.ITALIC);
		scalenext = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.scalenext);
		scalenext.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationEnd(Animation arg0) {

				final Fragment fragment = new PlanBuilder2();

				final FragmentTransaction fragmenttran = getFragmentManager()
						.beginTransaction();

				fragmenttran.setCustomAnimations(R.anim.card_flip_right_in,
						R.anim.card_flip_right_out, R.anim.card_flip_left_in,
						R.anim.card_flip_left_out);
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

		pb1next.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				pb1next.startAnimation(scalenext);
			}

		});

		return rootView;

	}

	public void onDestroy() {
		super.onDestroy();
	}

}
