package com.guardian.carrierselect;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class QuoteFragment extends Fragment {

	private static double hotspotCost;
	private static View rootView;
	private static SeekBar seekBar;
	private static TextView disValue, send;
	private static int discount;
	private static Animation scale, animScale, animScalet, fadeOut, fadeIn;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.quote_layout, container, false);
		getActivity().getActionBar().show();

		fadeIn = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.fadein);

		rootView.startAnimation(fadeIn);
		fadeOut = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.fadeout);

		send = (TextView) rootView.findViewById(R.id.button_send);
		send.setTypeface(null, Typeface.ITALIC);

		animScale = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.scale);
		animScalet = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.scaleinput);

		seekBar = (SeekBar) rootView.findViewById(R.id.discount_bar);
		final TextView eSmart = (TextView) rootView
				.findViewById(R.id.sphone_input);
		final TextView eBasic = (TextView) rootView
				.findViewById(R.id.bphone_input);
		final TextView eData = (TextView) rootView
				.findViewById(R.id.data_input);
		disValue = (TextView) rootView.findViewById(R.id.dis_value);

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
		((TextView) rootView.findViewById(R.id.button_send))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						sendMessage();
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

		scale = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.scalenext);

		scale.setAnimationListener(new AnimationListener() {

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

		fadeOut.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationEnd(Animation arg0) {

				final TextView eSmart = (TextView) rootView
						.findViewById(R.id.sphone_input);
				final TextView eBasic = (TextView) rootView
						.findViewById(R.id.bphone_input);
				final TextView eData = (TextView) rootView
						.findViewById(R.id.data_input);

				final String smartString = eSmart.getText().toString();
				final String basicString = eBasic.getText().toString();
				final String gigsString = eData.getText().toString();

				final double smart = Double.parseDouble(smartString);
				final double basic = Double.parseDouble(basicString);
				final double gigs = Double.parseDouble(gigsString);

				final FragmentTransaction ft = getFragmentManager()
						.beginTransaction();
				ft.replace(R.id.fragment_container, DisplayMessageFragment
						.create(smart, basic, gigs, hotspotCost, discount));
				ft.addToBackStack(null);
				ft.commit();
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

	public static void onCheck(boolean isit) {

		if (isit)
			hotspotCost = 20;
		else
			hotspotCost = 0;

	}

	public void onDestroy() {
		super.onDestroy();
	}

	/** Called when the user clicks the Send button */
	public void sendMessage() {
		send.startAnimation(scale);
	}

}
