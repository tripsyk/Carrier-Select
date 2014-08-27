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
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MonthlySelector extends Fragment {

	private static View rootView;
	private static TextView next, userMonthly;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.monthlyselector, container, false);
		getActivity().getActionBar().hide();

		// Declare preferences
		final SharedPreferences sharedPref = getActivity().getPreferences(
				Context.MODE_PRIVATE);
		final SharedPreferences.Editor editor = sharedPref.edit();

		// Load in animations.
		final Animation righttoleft = AnimationUtils.loadAnimation(
				rootView.getContext(), R.anim.right_to_left);
		final Animation lefttoright = AnimationUtils.loadAnimation(
				rootView.getContext(), R.anim.left_to_right);

		// Begin startup flow.
		rootView.startAnimation(lefttoright);
		next = (TextView) rootView.findViewById(R.id.next);

		userMonthly = (EditText) rootView.findViewById(R.id.theMonthly);

		// Set animation listeners for fragment
		righttoleft.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationEnd(Animation arg0) {
				Fragment fragment = new Home();
				FragmentTransaction fragmenttran = getFragmentManager()
						.beginTransaction();
				fragmenttran.replace(R.id.fragment_container, fragment);
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

				InputMethodManager imm = (InputMethodManager) rootView
						.getContext().getSystemService(
								Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(userMonthly.getWindowToken(), 0);

				editor.putInt("monthly",
						Integer.parseInt(userMonthly.getText().toString()));
				editor.commit();
				rootView.startAnimation(righttoleft);
			}
		});

		return rootView;

	}

	public void onDestroy() {
		super.onDestroy();
	}

}