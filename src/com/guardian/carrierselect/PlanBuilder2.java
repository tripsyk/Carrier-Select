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

public class PlanBuilder2 extends Fragment {

	private View rootView;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.planbuilder2_layout, container,
				false);
		getActivity().getActionBar().show();
		
		// Load in animations.
		final Animation righttoleft = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.right_to_left);
		final Animation lefttoright = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.left_to_right);
		
		final LinearLayout pb2smart = (LinearLayout) rootView.findViewById(R.id.pb2smartbox);
		final LinearLayout pb2basic = (LinearLayout) rootView.findViewById(R.id.pb2basicbox);
		
		final SharedPreferences sharedPref = getActivity().getPreferences(
				Context.MODE_PRIVATE);
		final SharedPreferences.Editor editor = sharedPref.edit();

		// Begin startup flow.
		rootView.startAnimation(lefttoright);
		
		pb2smart.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				editor.putString("pb2", "0");
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});
		
		pb2basic.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				editor.putString("pb2", "1");
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		righttoleft.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationEnd(Animation arg0) {

				final Fragment fragment = new PlanBuilder3();

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
