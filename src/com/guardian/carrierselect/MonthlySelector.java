package com.guardian.carrierselect;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;

public class MonthlySelector extends Fragment {

	private static Animation fadeOut, fadeIn, scalenext;
	private static View rootView;
	private static TextView monthlyTitle, next, userMonthly;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.monthlyselector, container,
				false);
		getActivity().getActionBar().hide();
		
		
		// Declare preferences
		final SharedPreferences sharedPref = getActivity().getPreferences(
				Context.MODE_PRIVATE);
		final SharedPreferences.Editor editor = sharedPref.edit();

		
		// Declare animations
		fadeIn = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.fadein);
		fadeOut = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.fadeout);
		scalenext = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.scalenext);

		
		// Declare TextView and italicize correctly.
		monthlyTitle = (TextView) rootView.findViewById(R.id.monthlyTitle);
		monthlyTitle.setTypeface(null, Typeface.ITALIC);
		next = (TextView) rootView.findViewById(R.id.next);
		next.setTypeface(null, Typeface.ITALIC);
		
		
		userMonthly = (EditText) rootView.findViewById(R.id.theMonthly);
		
		
		rootView.startAnimation(fadeIn);

		
		// Set animation listeners for fragment
		fadeOut.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationEnd(Animation arg0) {
				Fragment fragment = new Home();
				FragmentTransaction fragmenttran = getFragmentManager()
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

		
		next.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("monthly", Integer.parseInt(userMonthly.getText().toString()));
				editor.commit();
				next.startAnimation(scalenext);
			}
		});
		
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

		return rootView;

	}

	public void onDestroy() {
		super.onDestroy();
	}

}