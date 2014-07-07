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

public class StartScreen extends Fragment {

	private static Animation scalenext, fadeOut, fadeIn;
	private static TextView next;
	private static View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.startscreen_layout, container,
				false);
		getActivity().getActionBar().hide();

		fadeIn = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.fadein);

		rootView.startAnimation(fadeIn);

		final TextView welcome = (TextView) rootView.findViewById(R.id.welcome);
		welcome.setTypeface(null, Typeface.ITALIC);
		next = (TextView) rootView.findViewById(R.id.next1);
		next.setTypeface(null, Typeface.ITALIC);

		fadeOut = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.fadeout);
		scalenext = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.scalenext);

		scalenext.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationEnd(Animation arg0) {
				rootView.startAnimation(fadeOut);
			}

			@Override
			public void onAnimationRepeat(Animation arg0) {

			}

			@Override
			public void onAnimationStart(Animation arg0) {

			}
		});

		fadeOut.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationEnd(Animation arg0) {

				welcome.setVisibility(View.INVISIBLE);
				next.setVisibility(View.INVISIBLE);

				final Fragment fragment = new TellUs();

				final FragmentTransaction fragmenttran = getFragmentManager()
						.beginTransaction();

				// fragmenttran.setCustomAnimations(R.anim.card_flip_right_in,
				// R.anim.card_flip_right_out,
				// R.anim.card_flip_left_in, R.anim.card_flip_left_out);
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

		next.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				next.startAnimation(scalenext);
			}

		});

		return rootView;

	}

	public void onDestroy() {
		super.onDestroy();
	}

}
