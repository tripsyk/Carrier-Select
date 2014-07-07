package com.guardian.carrierselect;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class PlanBuilder2 extends Fragment {

	private View rootView;
	private static Animation fadeIn;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.planbuilder2_layout, container,
				false);
		getActivity().getActionBar().show();

		fadeIn = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.fadein);

		rootView.startAnimation(fadeIn);

		return rootView;
	}

	public void onDestroy() {
		super.onDestroy();
	}

}
