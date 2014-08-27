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
import android.widget.TextView;

public class KnowledgeBase1 extends Fragment {

	private static View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.knowledge1, container, false);
		
		getActivity().getActionBar().setTitle("Knowledge Base");
		
		// Declare preferences
		final String PREFS_NAME = "MyPrefsFile";
		SharedPreferences settings = getActivity().getSharedPreferences(
				PREFS_NAME, 0);

		// Load in animations.
		final Animation righttoleft = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.right_to_left);
		final Animation lefttoright = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.left_to_right);

		// Begin startup flow.
		rootView.startAnimation(lefttoright);
		
		
		
		return rootView;
	}
}