package com.guardian.carrierselect;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class StartScreen extends Fragment {

	private static TextView next;
	private static View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.startscreen_layout, container,
				false);
		getActivity().getActionBar().hide();

		final TextView welcome = (TextView) rootView.findViewById(R.id.welcome);
		next = (TextView) rootView.findViewById(R.id.next1);

		// Load in animations.
		final Animation righttoleft = AnimationUtils.loadAnimation(
				rootView.getContext(), R.anim.right_to_left);
		final Animation lefttoright = AnimationUtils.loadAnimation(
				rootView.getContext(), R.anim.left_to_right);

		// Begin startup flow.
		rootView.startAnimation(lefttoright);

		righttoleft.setAnimationListener(new AnimationListener() {

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
				// next.startAnimation(scalenext);
				rootView.startAnimation(righttoleft);
			}

		});

		return rootView;

	}

	public void onDestroy() {
		super.onDestroy();
	}

}
