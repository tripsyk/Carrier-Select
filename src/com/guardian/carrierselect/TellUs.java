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

public class TellUs extends Fragment {

	private static TextView next;
	private static View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.tellus_layout, container, false);
		getActivity().getActionBar().hide();

		// Load in animations.
		final Animation righttoleft = AnimationUtils.loadAnimation(
				rootView.getContext(), R.anim.right_to_left);
		final Animation lefttoright = AnimationUtils.loadAnimation(
				rootView.getContext(), R.anim.left_to_right);

		// Load in TVs
		next = (TextView) rootView.findViewById(R.id.next2);

		// Begin startup flow.
		rootView.startAnimation(lefttoright);

		next.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				rootView.startAnimation(righttoleft);

			}
		});

		righttoleft.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationEnd(Animation arg0) {

				final Fragment fragment = new UserBasics();

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