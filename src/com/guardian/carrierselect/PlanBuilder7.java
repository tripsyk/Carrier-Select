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
import android.widget.TextView;
import android.widget.Toast;

public class PlanBuilder7 extends Fragment {

	private View rootView;
	private TextView pb71, pb72, pb73, pb74, pb75, pb7edit, pb7save;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.planbuilder7_layout, container,
				false);
		getActivity().getActionBar().show();

		// Load in animations.
		final Animation righttoleft = AnimationUtils.loadAnimation(
				rootView.getContext(), R.anim.right_to_left);
		final Animation lefttoright = AnimationUtils.loadAnimation(
				rootView.getContext(), R.anim.left_to_right);

		pb7edit = (TextView) rootView.findViewById(R.id.pb7edit);
		pb7save = (TextView) rootView.findViewById(R.id.pb7next);
		pb71 = (TextView) rootView.findViewById(R.id.pb7sb);
		pb72 = (TextView) rootView.findViewById(R.id.pb7min);
		pb73 = (TextView) rootView.findViewById(R.id.pb7text);
		pb74 = (TextView) rootView.findViewById(R.id.pb7data);
		pb75 = (TextView) rootView.findViewById(R.id.pb7throttle);

		// Begin startup flow.
		rootView.startAnimation(lefttoright);
		
		pb7edit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				rootView.startAnimation(righttoleft);
			}
		});
		
		pb7save.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(rootView.getContext(),
						"This feature is still being tested.",
						Toast.LENGTH_SHORT).show();
			}
		});

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

		initPlanBuilderPrefs();

		return rootView;
	}

	private void initPlanBuilderPrefs() {

		// Declare preferences
		final SharedPreferences sharedPref = getActivity().getPreferences(
				Context.MODE_PRIVATE);

		// Set the appropriate Carrier on the homescreen
		final String SMARTBASIC = sharedPref.getString("pb2", "");
		final String MINUTES = sharedPref.getString("pb3", "");
		final String TEXTS = sharedPref.getString("pb4", "");
		final String DATA = sharedPref.getString("pb5", "");
		final String THROTTLE = sharedPref.getString("pb6", "");

		// Set phone type.
		if (SMARTBASIC.equalsIgnoreCase("0")) {
			pb71.setText("Smart");
		} else if (SMARTBASIC.equalsIgnoreCase("1")) {
			pb71.setText("Basic");
		}

		// Set minutes type.
		if (MINUTES.equalsIgnoreCase("0")) {
			pb72.setText("Unlimited");
		} else if (MINUTES.equalsIgnoreCase("1")) {
			pb72.setText("Limited");
		}

		// Set text type.
		if (TEXTS.equalsIgnoreCase("0")) {
			pb73.setText("Unlimited");
		} else if (TEXTS.equalsIgnoreCase("1")) {
			pb73.setText("Limited");
		}

		// Set data type.
		if (DATA.equalsIgnoreCase("0")) {
			pb74.setText("None");
		} else if (DATA.equalsIgnoreCase("1")) {
			pb74.setText("1GB");
		} else if (DATA.equalsIgnoreCase("2")) {
			pb74.setText("2GB");
		} else if (DATA.equalsIgnoreCase("3")) {
			pb74.setText("3GB");
		} else if (DATA.equalsIgnoreCase("4")) {
			pb74.setText("4GB");
		} else if (DATA.equalsIgnoreCase("5")) {
			pb74.setText("Unlimited");
		}

		// Set throttle type.
		if (THROTTLE.equalsIgnoreCase("none")) {
			pb75.setText("None");
		} else if (THROTTLE.equalsIgnoreCase("0")) {
			pb75.setText("Yes");
		} else if (THROTTLE.equalsIgnoreCase("1")) {
			pb75.setText("No");
		}

	}

	public void onDestroy() {
		super.onDestroy();
	}

}