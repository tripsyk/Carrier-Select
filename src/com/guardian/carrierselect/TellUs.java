package com.guardian.carrierselect;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class TellUs extends Fragment {

	private static Button next;
	private static View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.tellus_layout, container, false);
		next = (Button) rootView.findViewById(R.id.next2);

		next.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				final Fragment fragment = new CarrierSelector();

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