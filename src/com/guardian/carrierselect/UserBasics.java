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

public class UserBasics extends Fragment {

	private static LinearLayout lightbox;
	private static LinearLayout moderatebox;
	private static LinearLayout heavybox;
	private static View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.activity_user_basics, container,
				false);

		final Animation righttoleft = AnimationUtils.loadAnimation(
				rootView.getContext(), R.anim.right_to_left);
		final Animation lefttoright = AnimationUtils.loadAnimation(
				rootView.getContext(), R.anim.left_to_right);

		rootView.startAnimation(lefttoright);

		final SharedPreferences sharedPref = getActivity().getPreferences(
				Context.MODE_PRIVATE);
		final SharedPreferences.Editor editor = sharedPref.edit();

		lightbox = (LinearLayout) rootView.findViewById(R.id.lightbox);
		moderatebox = (LinearLayout) rootView.findViewById(R.id.moderatebox);
		heavybox = (LinearLayout) rootView.findViewById(R.id.heavybox);

		lightbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("userType", 1);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		moderatebox.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				editor.putInt("userType", 2);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		heavybox.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				editor.putInt("userType", 3);
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		righttoleft.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationEnd(Animation arg0) {

				final Fragment fragment = new CarrierSelector();

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
