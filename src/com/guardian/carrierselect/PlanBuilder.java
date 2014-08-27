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

public class PlanBuilder extends Fragment {

	private View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.planbuilder_layout, container,
				false);
		
		getActivity().getActionBar().setTitle("PlanBuilder");

		// Load in animations.
		final Animation righttoleft = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.right_to_left);
		final Animation lefttoright = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.left_to_right);

		// Begin startup flow.
		rootView.startAnimation(lefttoright);

		final TextView pb1next = (TextView) rootView.findViewById(R.id.pbnext1);
		righttoleft.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationEnd(Animation arg0) {

				final Fragment fragment = new PlanBuilder2();

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

		pb1next.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				rootView.startAnimation(righttoleft);
			}

		});

		return rootView;

	}

	public void onDestroy() {
		super.onDestroy();
	}

}
