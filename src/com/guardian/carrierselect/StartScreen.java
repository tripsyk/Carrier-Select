package com.guardian.carrierselect;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
		final AlphaAnimation animation1 = new AlphaAnimation(0.0f, 1.0f);
		animation1.setDuration(2000);
		rootView.startAnimation(animation1);

		next.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				final Fragment fragment = new TellUs();

				final FragmentTransaction fragmenttran = getActivity()
						.getSupportFragmentManager().beginTransaction();

				fragmenttran.setCustomAnimations(R.anim.slide_in_right,
						R.anim.slide_out_left, R.anim.slide_in_left,
						R.anim.slide_out_right);
				fragmenttran.replace(R.id.fragment_container, fragment);
				fragmenttran.commit();
			}

		});

		return rootView;

	}

	public void onDestroy() {
		super.onDestroy();
	}

}
