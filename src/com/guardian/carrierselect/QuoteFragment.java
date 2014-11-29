package com.guardian.carrierselect;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
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

	private static int hotspotCost;
	private static View rootView;
	private static SeekBar seekBar;
	private static TextView disValue;
	private static int discount;;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.quote_layout, container, false);

		final Animation animScale = AnimationUtils.loadAnimation(
				rootView.getContext(), R.anim.scale);
		final Animation animScalet = AnimationUtils.loadAnimation(
				rootView.getContext(), R.anim.scaleinput);

		disValue = (TextView) rootView.findViewById(R.id.dis_value);
		seekBar = (SeekBar) rootView.findViewById(R.id.discount_bar);
		seekBar.setProgressDrawable(getResources().getDrawable(
				R.drawable.progressbar));
		final Drawable mDrawable = getResources().getDrawable(R.drawable.thumb);
		mDrawable.setBounds(0, 0, mDrawable.getIntrinsicWidth(),
				mDrawable.getIntrinsicHeight());
		seekBar.setThumb(mDrawable);
		final TextView eSmart = (TextView) rootView
				.findViewById(R.id.sphone_input);
		final TextView eBasic = (TextView) rootView
				.findViewById(R.id.bphone_input);
		final TextView eData = (TextView) rootView
				.findViewById(R.id.data_input);
		final TextView eTab = (TextView) rootView.findViewById(R.id.tab_input);
		final TextView extras = (TextView) rootView
				.findViewById(R.id.extras_label);
		extras.setTypeface(null, Typeface.BOLD);

		seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

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

		// When a user selects the button to receive their plan quotes.
		((Button) rootView.findViewById(R.id.button_send))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {

						int smart = Integer
								.valueOf(eSmart.getText().toString());
						int basic = Integer
								.valueOf(eBasic.getText().toString());

						if ((smart + basic) == 0) {
							Toast.makeText(
									rootView.getContext(),
									"You must have at least 1 phone on a plan.",
									Toast.LENGTH_SHORT).show();
						} else {

							next();

						}
					}

				});

		// When a user clicks on the minus button to the left of smartphones
		((Button) rootView.findViewById(R.id.sphone_m))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						int number = Integer.parseInt(eSmart.getText()
								.toString());
						if (number > 0) {
							eSmart.setText(String.valueOf(number - 1));
						}
						arg0.startAnimation(animScale);
						eSmart.startAnimation(animScalet);
					}

				});

		// When a user clicks on the plus sign next to smartphones.
		((Button) rootView.findViewById(R.id.sphone_p))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						int number = Integer.parseInt(eSmart.getText()
								.toString());
						eSmart.setText(String.valueOf(number + 1));
						arg0.startAnimation(animScale);
						eSmart.startAnimation(animScalet);
					}

				});

		// When a user clicks on the minus button to the left of basic phones
		((Button) rootView.findViewById(R.id.bphone_m))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						int number = Integer.parseInt(eBasic.getText()
								.toString());
						if (number > 0) {
							eBasic.setText(String.valueOf(number - 1));
						}
						arg0.startAnimation(animScale);
						eBasic.startAnimation(animScalet);
					}

				});

		// When a user clicks on the plus sign next to basic phones.
		((Button) rootView.findViewById(R.id.bphone_p))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						int number = Integer.parseInt(eBasic.getText()
								.toString());
						eBasic.setText(String.valueOf(number + 1));
						arg0.startAnimation(animScale);
						eBasic.startAnimation(animScalet);
					}

				});

		// When a user clicks on the minus sign next to the number of gigs they
		// would like.
		((Button) rootView.findViewById(R.id.data_m))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						int number = Integer.parseInt(eData.getText()
								.toString());
						if (number > 0) {
							eData.setText(String.valueOf(number - 1));
						}
						arg0.startAnimation(animScale);
						eData.startAnimation(animScalet);
					}

				});

		// When a user clicks on the plus sign next to the number of gigs they
		// would like.
		((Button) rootView.findViewById(R.id.data_p))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						int number = Integer.parseInt(eData.getText()
								.toString());
						eData.setText(String.valueOf(number + 1));
						arg0.startAnimation(animScale);
						eData.startAnimation(animScalet);
					}

				});

		((Button) rootView.findViewById(R.id.tab_m))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						int number = Integer
								.parseInt(eTab.getText().toString());
						if (number > 0) {
							eTab.setText(String.valueOf(number - 1));
						}
						arg0.startAnimation(animScale);
						eTab.startAnimation(animScalet);
					}

				});

		// When a user clicks on the plus sign next to the number of gigs they
		// would like.
		((Button) rootView.findViewById(R.id.tab_p))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						int number = Integer
								.parseInt(eTab.getText().toString());
						eTab.setText(String.valueOf(number + 1));
						arg0.startAnimation(animScale);
						eTab.startAnimation(animScalet);
					}

				});

		return rootView;
	}

	public void getCheckBoxes() {

		final CheckBox hotbox = (CheckBox) rootView
				.findViewById(R.id.checkbox_hotspot);
		final CheckBox currentcarrier = (CheckBox) rootView
				.findViewById(R.id.includecarrier);

		if (hotbox.isChecked()) {
			hotspotCost = 1;
		} else
			hotspotCost = 0;

		if (currentcarrier.isChecked()) {

		}

	}

	public void next() {

		getCheckBoxes();

		final TextView eSmart = (TextView) rootView
				.findViewById(R.id.sphone_input);
		final TextView eBasic = (TextView) rootView
				.findViewById(R.id.bphone_input);
		final TextView eData = (TextView) rootView
				.findViewById(R.id.data_input);
		final TextView eTab = (TextView) rootView.findViewById(R.id.tab_input);

		final String smartString = eSmart.getText().toString();
		final String basicString = eBasic.getText().toString();
		final String gigsString = eData.getText().toString();
		final String tabString = eTab.getText().toString();

		final int smart = Integer.parseInt(smartString);
		final int basic = Integer.parseInt(basicString);
		final int gigs = Integer.parseInt(gigsString);
		final int tabs = Integer.parseInt(tabString);

		final FragmentTransaction ft = getActivity().getFragmentManager()
				.beginTransaction();
		ft.setCustomAnimations(R.animator.right_in_off, R.animator.left_in_off);
		ft.replace(R.id.fragment_container, DisplayMessageFragment.create(
				smart, basic, gigs, tabs, hotspotCost, discount));
		ft.addToBackStack(null);
		ft.commit();
	}

	public void onDestroy() {
		super.onDestroy();
	}

}
