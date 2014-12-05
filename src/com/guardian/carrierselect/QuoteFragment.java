package com.guardian.carrierselect;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class QuoteFragment extends Fragment {

	private static View rootView;
	private static int discount;;
	private static boolean twoyear;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.quote_layout, container, false);

		// init animations for '-' and '+'
		final Animation animScale = AnimationUtils.loadAnimation(
				rootView.getContext(), R.anim.scale);
		final Animation animScalet = AnimationUtils.loadAnimation(
				rootView.getContext(), R.anim.scaleinput);

		// init SeekBar and value TV
		final TextView disValue = (TextView) rootView
				.findViewById(R.id.dis_value);
		final SeekBar discBar = (SeekBar) rootView
				.findViewById(R.id.discount_bar);

		// init TVs for retrieving values
		final TextView eSmart = (TextView) rootView
				.findViewById(R.id.sphone_input);
		final TextView eBasic = (TextView) rootView
				.findViewById(R.id.bphone_input);
		final TextView eData = (TextView) rootView
				.findViewById(R.id.data_input);
		final TextView eTab = (TextView) rootView.findViewById(R.id.tab_input);
		final TextView eMifi = (TextView) rootView
				.findViewById(R.id.mifi_input);

		// init buttons for - and +
		final Button sphonem = (Button) rootView.findViewById(R.id.sphone_m);
		final Button sphonep = (Button) rootView.findViewById(R.id.sphone_p);
		final Button bphonem = (Button) rootView.findViewById(R.id.bphone_m);
		final Button bphonep = (Button) rootView.findViewById(R.id.bphone_p);
		final Button datam = (Button) rootView.findViewById(R.id.data_m);
		final Button datap = (Button) rootView.findViewById(R.id.data_p);
		final Button tabm = (Button) rootView.findViewById(R.id.tab_m);
		final Button tabp = (Button) rootView.findViewById(R.id.tab_p);
		final Button mifim = (Button) rootView.findViewById(R.id.mifi_m);
		final Button mifip = (Button) rootView.findViewById(R.id.mifi_p);
		final Button send = (Button) rootView.findViewById(R.id.next);

		discBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			public void onStopTrackingTouch(SeekBar bar) {

			}

			public void onStartTrackingTouch(SeekBar bar) {
			}

			public void onProgressChanged(SeekBar bar, int paramInt,
					boolean paramBoolean) {
				discount = paramInt;
				disValue.setText(paramInt + "%");// here in textView the
													// percent will be shown
			}
		});

		// user hits next
		send.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				if (Integer.valueOf(eSmart.getText().toString())
						+ Integer.valueOf(eBasic.getText().toString()) == 0) {
					Toast.makeText(rootView.getContext(),
							"You must have at least 1 phone on a plan.",
							Toast.LENGTH_SHORT).show();
				} else {
					next();
				}
			}
		});

		// -1 smartphone
		sphonem.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				final int number = Integer
						.parseInt(eSmart.getText().toString());
				if (number > 0) {
					eSmart.setText(String.valueOf(number - 1));
				}
				arg0.startAnimation(animScale);
				eSmart.startAnimation(animScalet);
			}

		});

		sphonep.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				eSmart.setText(String.valueOf(Integer.parseInt(eSmart.getText()
						.toString()) + 1));
				arg0.startAnimation(animScale);
				eSmart.startAnimation(animScalet);
			}

		});

		bphonem.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				final int number = Integer
						.parseInt(eBasic.getText().toString());
				if (number > 0) {
					eBasic.setText(String.valueOf(number - 1));
				}
				arg0.startAnimation(animScale);
				eBasic.startAnimation(animScalet);
			}

		});

		bphonep.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				eBasic.setText(String.valueOf(Integer.parseInt(eBasic.getText()
						.toString()) + 1));
				arg0.startAnimation(animScale);
				eBasic.startAnimation(animScalet);
			}

		});

		datam.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				int number = Integer.parseInt(eData.getText().toString());
				if (number > 0) {
					eData.setText(String.valueOf(number - 1));
				}
				arg0.startAnimation(animScale);
				eData.startAnimation(animScalet);
			}

		});

		datap.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				eData.setText(String.valueOf(Integer.parseInt(eData.getText()
						.toString()) + 1));
				arg0.startAnimation(animScale);
				eData.startAnimation(animScalet);
			}

		});

		tabm.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				final int number = Integer.parseInt(eTab.getText().toString());
				if (number > 0) {
					eTab.setText(String.valueOf(number - 1));
				}
				arg0.startAnimation(animScale);
				eTab.startAnimation(animScalet);
			}

		});

		tabp.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				eTab.setText(String.valueOf(Integer.parseInt(eTab.getText()
						.toString()) + 1));
				arg0.startAnimation(animScale);
				eTab.startAnimation(animScalet);
			}

		});

		mifim.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				final int number = Integer.parseInt(eMifi.getText().toString());
				if (number > 0) {
					eMifi.setText(String.valueOf(Integer.parseInt(eMifi
							.getText().toString()) - 1));
				}
				arg0.startAnimation(animScale);
				eMifi.startAnimation(animScalet);
			}

		});

		mifip.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				eMifi.setText(String.valueOf(Integer.parseInt(eMifi.getText()
						.toString()) + 1));
				arg0.startAnimation(animScale);
				eMifi.startAnimation(animScalet);
			}

		});

		return rootView;
	}

	private void next() {

		// assign twoyear boolean
		final CheckBox checkBox = (CheckBox) rootView
				.findViewById(R.id.twoyear);
		if (checkBox.isChecked()) {
			twoyear = true;
		} else {
			twoyear = false;
		}

		// retrieve final values from user input
		final TextView eSmart = (TextView) rootView
				.findViewById(R.id.sphone_input);
		final TextView eBasic = (TextView) rootView
				.findViewById(R.id.bphone_input);
		final TextView eData = (TextView) rootView
				.findViewById(R.id.data_input);
		final TextView eTab = (TextView) rootView.findViewById(R.id.tab_input);
		final TextView eMifi = (TextView) rootView
				.findViewById(R.id.mifi_input);

		// begin fragment trans
		final FragmentTransaction ft = getActivity()
				.getSupportFragmentManager().beginTransaction();
		ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,
				R.anim.slide_in_left, R.anim.slide_out_right);
		ft.replace(
				R.id.fragment_container,
				DisplayMessageFragment.create(twoyear,
						Integer.parseInt(eSmart.getText().toString()),
						Integer.parseInt(eBasic.getText().toString()),
						Integer.parseInt(eData.getText().toString()),
						Integer.parseInt(eTab.getText().toString()),
						Integer.parseInt(eMifi.getText().toString()), discount));
		ft.addToBackStack(null);
		ft.commit();
	}

	public void onDestroy() {
		super.onDestroy();
	}

}
