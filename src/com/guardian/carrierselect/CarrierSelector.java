package com.guardian.carrierselect;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class CarrierSelector extends Fragment {

	private static Button attbox, sprintbox, tmobox, verizonbox, otherbox;
	private static View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.carrierselector_layout, container,
				false);

		final SharedPreferences sharedPref = getActivity()
				.getSharedPreferences("profile", Context.MODE_PRIVATE);
		final SharedPreferences.Editor editor = sharedPref.edit();

		attbox = (Button) rootView.findViewById(R.id.att);
		sprintbox = (Button) rootView.findViewById(R.id.sprint);
		tmobox = (Button) rootView.findViewById(R.id.tmobile);
		verizonbox = (Button) rootView.findViewById(R.id.verizon);
		otherbox = (Button) rootView.findViewById(R.id.other);

		attbox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editor.putInt("carrier", 1);
				editor.commit();
				next();
			}
		});

		sprintbox.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				editor.putInt("carrier", 2);
				editor.commit();
				next();
			}
		});

		tmobox.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				editor.putInt("carrier", 3);
				editor.commit();
				next();
			}
		});

		verizonbox.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				editor.putInt("carrier", 4);
				editor.commit();
				next();
			}
		});

		otherbox.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				editor.putInt("carrier", 5);
				editor.commit();
				next();
			}
		});

		return rootView;

	}

	public void next() {

		final Fragment fragment = new SmartphoneSelector();

		final FragmentTransaction fragmenttran = getActivity()
				.getSupportFragmentManager().beginTransaction();
		fragmenttran.setCustomAnimations(R.anim.slide_in_right,
				R.anim.slide_out_left, R.anim.slide_in_left,
				R.anim.slide_out_right);
		fragmenttran.replace(R.id.fragment_container, fragment);
		fragmenttran.addToBackStack(null);
		fragmenttran.commit();
	}

	public void onDestroy() {
		super.onDestroy();
	}

}
