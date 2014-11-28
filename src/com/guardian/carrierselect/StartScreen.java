package com.guardian.carrierselect;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;

public class StartScreen extends Fragment {

	private static Button next;
	private static View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.startscreen_layout, container,
				false);

		next = (Button) rootView.findViewById(R.id.next1);

		// Begin startup flow.
		AlphaAnimation animation1 = new AlphaAnimation(0.0f, 1.0f);
		animation1.setDuration(1250);
		rootView.startAnimation(animation1);

		next.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				final Fragment fragment = new TellUs();

				final FragmentManager fm = getActivity().getFragmentManager();

				final FragmentTransaction fragmenttran = fm.beginTransaction();

				fragmenttran.setCustomAnimations(R.animator.right_in_off,
						R.animator.left_in_off);
				fragmenttran.replace(R.id.fragment_container, fragment);
				fragmenttran.addToBackStack(null);
				fragmenttran.commit();
			}

		});

		return rootView;

	}

	public void onDestroy() {
		super.onDestroy();
	}

}
