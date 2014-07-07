package com.guardian.carrierselect;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayMessageFragment extends Fragment {

	private static final String ARGS_HOT_SPOT = "hot_spot";
	private static final String ARGS_SMARTPHONES = "smartphones";
	private static final String ARGS_BASICPHONES = "basicphones";
	private static final String ARGS_GIGS = "gigs";
	private static final String ARGS_DISCOUNT = "discount";

	private static double smartphones, basicphones, gigs, asmartprice;

	private static Animation fadeOut, scale, fadeIn;

	private static double abasicprice = 0;
	private static double agigprice = 0;
	private static double atax = 0;
	private static double adiscount = 0;
	private static double attTotal = 0;
	private static double vsmartprice = 0;
	private static double vbasicprice = 0;
	private static double vgigprice = 0;
	private static double vtax = 0;
	private static double vdiscount = 0;
	private static double verTotal = 0;
	private static double ssmartprice = 0;
	private static double sbasicprice = 0;
	private static double sgigprice = 0;
	private static double stax = 0;
	private static double sdiscount = 0;
	private static double sprTotal = 0;
	private static double hotspotprice = 0;
	private static double sprhotspotprice = 0;
	private static double tsmartprice = 0;
	private static double tbasicprice = 0;
	private static double tgigprice = 0;
	private static double ttax = 0;
	private static double tdiscount = 0;
	private static double tmoTotal = 0;
	private static double discount = 0;

	private View rootView;

	public static DisplayMessageFragment create(double smartphones,
			double basicphones, double gigs, double hotspotprice,
			double discount) {
		final DisplayMessageFragment fragment = new DisplayMessageFragment();

		final Bundle args = new Bundle();

		args.putDouble(ARGS_HOT_SPOT, hotspotprice);
		args.putDouble(ARGS_SMARTPHONES, smartphones);
		args.putDouble(ARGS_BASICPHONES, basicphones);
		args.putDouble(ARGS_GIGS, gigs);
		args.putDouble(ARGS_DISCOUNT, discount);
		fragment.setArguments(args);

		return fragment;
	}

	@SuppressLint("NewApi")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.activity_display_message,
				container, false);

		fadeIn = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.fadein);

		rootView.startAnimation(fadeIn);

		fadeOut = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.fadeout);
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

				final FragmentTransaction ft = getFragmentManager()
						.beginTransaction();
				ft.replace(R.id.fragment_container, BreakdownFragment.create(
						asmartprice, abasicprice, agigprice, atax, vsmartprice,
						vbasicprice, vgigprice, vtax, ssmartprice, sbasicprice,
						sgigprice, stax, sprhotspotprice, hotspotprice,
						adiscount, vdiscount, sdiscount, tsmartprice, tbasicprice, tgigprice, ttax, tdiscount));
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

		final TextView send = (TextView) rootView
				.findViewById(R.id.breakdown_send);
		send.setTypeface(null, Typeface.ITALIC);

		calculateATT(smartphones, basicphones, gigs);
		calculateVer(smartphones, basicphones, gigs);
		calculateSpr(smartphones, basicphones, gigs);
		calculateTmo(smartphones, basicphones, gigs);

		atax = Math
				.round(((asmartprice + abasicprice + agigprice + hotspotprice) * .16) * 100) / 100;
		vtax = Math
				.round(((vsmartprice + vbasicprice + vgigprice + hotspotprice) * .16) * 100) / 100;
		stax = Math
				.round(((ssmartprice + sbasicprice + sgigprice + sprhotspotprice) * .16) * 100) / 100;
		ttax = Math
				.round(((tsmartprice + tbasicprice + tgigprice + hotspotprice) * .16) * 100) / 100;

		attTotal = (asmartprice + abasicprice + agigprice + hotspotprice + atax);
		verTotal = (vsmartprice + vbasicprice + vgigprice + hotspotprice + vtax);
		sprTotal = (ssmartprice + sbasicprice + sgigprice + sprhotspotprice + stax);
		tmoTotal = (tsmartprice + tbasicprice + tgigprice + hotspotprice + ttax);

		calcDiscount();

		final TextView attMorph = (TextView) rootView
				.findViewById(R.id.att_total);
		attMorph.setText("Estimated AT&T Monthly Cost (After Taxes): \n" + "$"
				+ (int) (attTotal - adiscount));
		final TextView verMorph = (TextView) rootView
				.findViewById(R.id.ver_total);
		verMorph.setText("Estimated Verizon Monthly Cost (After Taxes): \n"
				+ "$" + (int) (verTotal - vdiscount));
		final TextView sprMorph = (TextView) rootView
				.findViewById(R.id.spr_total);
		sprMorph.setText("Estimated Sprint Monthly Cost (After Taxes): \n"
				+ "$" + (int) (sprTotal - sdiscount));
		final TextView tmoMorph = (TextView) rootView
				.findViewById(R.id.tmo_total);
		tmoMorph.setText("Estimated T-Mobile Monthly Cost (After Taxes): \n"
				+ "$" + (int) (tmoTotal - tdiscount));

		send.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				send.startAnimation(scale);
			}

		});

		return rootView;

	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		final Bundle args = getArguments();

		hotspotprice = args.getDouble(ARGS_HOT_SPOT);
		smartphones = args.getDouble(ARGS_SMARTPHONES);
		basicphones = args.getDouble(ARGS_BASICPHONES);
		gigs = args.getDouble(ARGS_GIGS);
		discount = args.getDouble(ARGS_DISCOUNT);

	}

	public void calcDiscount() {
		final double discountCorrection = discount / 100;
		;

		adiscount = discountCorrection * agigprice;
		vdiscount = discountCorrection * vgigprice;
		sdiscount = discountCorrection * sgigprice;
		tdiscount = (discountCorrection * .5) * tgigprice;

	}

	public void calculateATT(double smart, double basic, double gigs) {
		if (gigs == 1) {
			agigprice = 25;
			asmartprice = smart * 25;
			abasicprice = basic * 20;
		} else if (gigs == 2) {
			agigprice = 40;
			asmartprice = smart * 25;
			abasicprice = basic * 20;
		} else if (gigs == 3 || gigs == 4) {
			agigprice = 70;
			asmartprice = smart * 25;
			abasicprice = basic * 20;
		} else if (gigs == 5 || gigs == 6) {
			agigprice = 80;
			asmartprice = smart * 25;
			abasicprice = basic * 20;
		} else if (gigs == 7 || gigs == 8 || gigs == 9 || gigs == 10) {
			agigprice = 100;
			asmartprice = smart * 15;
			abasicprice = basic * 15;
		} else if (gigs == 11 || gigs == 12 || gigs == 13 || gigs == 14
				|| gigs == 15) {
			agigprice = 130;
			asmartprice = smart * 15;
			abasicprice = basic * 15;
		}
	}

	public void calculateVer(double smart, double basic, double gigs) {
		if (gigs == 1) {
			vgigprice = 40;
			vsmartprice = smart * 30;
			vbasicprice = basic * 30;
		} else if (gigs == 2) {
			vgigprice = 50;
			vsmartprice = smart * 30;
			vbasicprice = basic * 30;
		} else if (gigs == 3) {
			vgigprice = 60;
			vsmartprice = smart * 30;
			vbasicprice = basic * 30;
		} else if (gigs == 4) {
			vgigprice = 70;
			vsmartprice = smart * 30;
			vbasicprice = basic * 30;
		} else if (gigs == 5 || gigs == 6) {
			vgigprice = 80;
			vsmartprice = smart * 30;
			vbasicprice = basic * 30;
		} else if (gigs == 7 || gigs == 8) {
			vgigprice = 90;
			vsmartprice = smart * 30;
			vbasicprice = basic * 30;
		} else if (gigs == 9 || gigs == 10) {
			vgigprice = 100;
			vsmartprice = smart * 15;
			vbasicprice = basic * 30;
		} else if (gigs == 11 || gigs == 12) {
			vgigprice = 110;
			vsmartprice = smart * 15;
			vbasicprice = basic * 30;
		} else if (gigs == 13 || gigs == 14) {
			vgigprice = 120;
			vsmartprice = smart * 15;
			vbasicprice = basic * 30;
		} else if (gigs == 15 || gigs == 16) {
			vgigprice = 130;
			vsmartprice = smart * 15;
			vbasicprice = basic * 30;
		} else if (gigs == 17 || gigs == 18) {
			vgigprice = 140;
			vsmartprice = smart * 15;
			vbasicprice = basic * 30;
		} else if (gigs == 19 || gigs == 20) {
			vgigprice = 150;
			vsmartprice = smart * 15;
			vbasicprice = basic * 30;
		}

	}

	public void calculateSpr(double smart, double basic, double gigs) {

		if ((smart + basic) == 1) {
			ssmartprice = smart * 55;
			sbasicprice = basic * 55;
			if (gigs > 1)
				sgigprice = smart * 10;
		} else if ((smart + basic) == 2) {
			ssmartprice = smart * 50;
			sbasicprice = basic * 50;
			if (gigs > 2)
				sgigprice = smart * 10;
		} else if ((smart + basic) == 3) {
			ssmartprice = smart * 45;
			sbasicprice = basic * 45;
			if (gigs > 3)
				sgigprice = smart * 10;
		} else if ((smart + basic) == 4) {
			ssmartprice = smart * 40;
			sbasicprice = basic * 40;
			if (gigs > 4)
				sgigprice = smart * 10;
		} else if ((smart + basic) == 5) {
			ssmartprice = smart * 35;
			sbasicprice = basic * 35;
			if (gigs > 5)
				sgigprice = smart * 10;
		} else if ((smart + basic) == 6) {
			ssmartprice = smart * 30;
			sbasicprice = basic * 30;
			if (gigs > 6)
				sgigprice = smart * 10;
		} else if ((smart + basic) == 7) {
			ssmartprice = smart * 25;
			sbasicprice = basic * 25;
			if (gigs > 7)
				sgigprice = smart * 10;
		} else if ((smart + basic) == 8) {
			ssmartprice = smart * 25;
			sbasicprice = basic * 25;
			if (gigs > 8)
				sgigprice = smart * 10;
		} else if ((smart + basic) == 9) {
			ssmartprice = smart * 25;
			sbasicprice = basic * 25;
			if (gigs > 9)
				sgigprice = smart * 10;
		} else if ((smart + basic) == 10) {
			ssmartprice = smart * 25;
			sbasicprice = basic * 25;
			if (gigs > 10)
				sgigprice = smart * 10;
		}

		if (hotspotprice == 0)
			sprhotspotprice = 0;
		else if (hotspotprice == 20)
			sprhotspotprice = 35;

	}

	public void calculateTmo(double smart, double basic, double gigs) {
		if (smart == 1) {
			if (gigs == 1)
				tgigprice = 50;
			if (gigs == 3)
				tgigprice = 60;
			if (gigs == 5)
				tgigprice = 70;
			if (gigs > 5)
				tgigprice = 80;

		} else if (smart + basic == 2) {
			if (gigs == 1 || gigs == 2) {
				tgigprice = 80;
			} else if (gigs == 3 || gigs == 4) {
				tgigprice = 90;
			} else if (gigs == 5 || gigs == 6) {
				tgigprice = 100;
			} else if (gigs == 7 || gigs == 8) {
				tgigprice = 110;
			} else if (gigs == 9 || gigs == 10) {
				tgigprice = 120;
			} else if (gigs > 10) {
				tgigprice = 140;
			}
		} else if (smart + basic == 3) {
			if (gigs == 1 || gigs == 2 || gigs == 3) {
				tgigprice = 90;
			} else if (gigs == 4 || gigs == 5) {
				tgigprice = 100;
			} else if (gigs == 6 || gigs == 7) {
				tgigprice = 110;
			} else if (gigs == 8 || gigs == 9) {
				tgigprice = 120;
			} else if (gigs == 10 || gigs == 11) {
				tgigprice = 130;
			} else if (gigs == 12 || gigs == 13) {
				tgigprice = 140;
			} else if (gigs == 14 || gigs == 15) {
				tgigprice = 150;
			} else if (gigs > 15) {
				tgigprice = 180;
			}
		} else if (smart + basic == 4) {
			if (gigs == 1 || gigs == 2 || gigs == 3 || gigs == 4) {
				tgigprice = 100;
			} else if (gigs == 5 || gigs == 6) {
				tgigprice = 110;
			} else if (gigs == 7 || gigs == 8) {
				tgigprice = 120;
			} else if (gigs == 9 || gigs == 10) {
				tgigprice = 130;
			} else if (gigs == 11 || gigs == 12) {
				tgigprice = 140;
			} else if (gigs == 13 || gigs == 14) {
				tgigprice = 150;
			} else if (gigs == 15 || gigs == 16) {
				tgigprice = 160;
			} else if (gigs == 17 || gigs == 18) {
				tgigprice = 170;
			} else if (gigs == 19 || gigs == 20) {
				tgigprice = 180;
			} else if (gigs > 20) {
				tgigprice = 220;
			}
		} else if (smart + basic == 5) {
			if (gigs <= 5) {
				tgigprice = 110;
			} else if (gigs == 6 || gigs == 7) {
				tgigprice = 120;
			} else if (gigs == 8 || gigs == 9) {
				tgigprice = 130;
			} else if (gigs == 10 || gigs == 11) {
				tgigprice = 140;
			} else if (gigs == 12 || gigs == 13) {
				tgigprice = 150;
			} else if (gigs == 14 || gigs == 15) {
				tgigprice = 160;
			} else if (gigs == 16 || gigs == 17) {
				tgigprice = 170;
			} else if (gigs == 18 || gigs == 19) {
				tgigprice = 180;
			} else if (gigs == 20 || gigs == 21) {
				tgigprice = 190;
			} else if (gigs == 22 || gigs == 23) {
				tgigprice = 200;
			} else if (gigs == 24 || gigs == 25) {
				tgigprice = 210;
			} else if (gigs > 25) {
				tgigprice = 260;
			}
		}

	}

}