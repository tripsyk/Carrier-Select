package com.guardian.carrierselect;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class BreakdownFragment extends Fragment {

	private static View rootView;
	private static double asmartprice = 0;
	private static double abasicprice = 0;
	private static double agigprice = 0;
	private static double atax = 0;
	private static double adiscount = 0;
	private static double vsmartprice = 0;
	private static double vbasicprice = 0;
	private static double vgigprice = 0;
	private static double vtax = 0;
	private static double vdiscount = 0;
	private static double ssmartprice = 0;
	private static double sbasicprice = 0;
	private static double sgigprice = 0;
	private static double stax = 0;
	private static double sdiscount = 0;
	private static double tsmartprice = 0;
	private static double tbasicprice = 0;
	private static double tgigprice = 0;
	private static double ttax = 0;
	private static double tdiscount = 0;
	private static double hotspotprice = 0;
	private static double sprhotspotprice = 0;
	private static Animation fadeIn;

	public static BreakdownFragment create(double asmart, double abasic,
			double agigs, double ataxes, double vsmart, double vbasic,
			double vgigs, double vtaxes, double ssmart, double sbasic,
			double sgigs, double staxes, double sprhot, double hotspot,
			double attdiscount, double verdiscount, double sprdiscount,
			double tsmart, double tbasic, double tgigs, double ttaxes,
			double tdiscount) {
		final BreakdownFragment fragment = new BreakdownFragment();

		final Bundle args = new Bundle();

		args.putDouble("asmart", asmart);
		args.putDouble("abasic", abasic);
		args.putDouble("agigs", agigs);
		args.putDouble("atax", ataxes);
		args.putDouble("vsmart", vsmart);
		args.putDouble("vbasic", vbasic);
		args.putDouble("vgigs", vgigs);
		args.putDouble("vtax", vtaxes);
		args.putDouble("ssmart", ssmart);
		args.putDouble("sbasic", sbasic);
		args.putDouble("sgigs", sgigs);
		args.putDouble("stax", staxes);
		args.putDouble("tsmart", tsmart);
		args.putDouble("tbasic", tbasic);
		args.putDouble("tgigs", tgigs);
		args.putDouble("ttax", ttaxes);
		args.putDouble("sprhot", sprhot);
		args.putDouble("hot", hotspot);
		args.putDouble("adis", attdiscount);
		args.putDouble("vdis", verdiscount);
		args.putDouble("sdis", sprdiscount);
		args.putDouble("tdis", tdiscount);
		fragment.setArguments(args);

		return fragment;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		Bundle args = getArguments();

		asmartprice = args.getDouble("asmart");
		abasicprice = args.getDouble("abasic");
		agigprice = args.getDouble("agigs");
		atax = args.getDouble("atax");
		vsmartprice = args.getDouble("vsmart");
		vbasicprice = args.getDouble("vbasic");
		vgigprice = args.getDouble("vgigs");
		vtax = args.getDouble("vtax");
		ssmartprice = args.getDouble("ssmart");
		sbasicprice = args.getDouble("sbasic");
		sgigprice = args.getDouble("sgigs");
		stax = args.getDouble("stax");
		sprhotspotprice = args.getDouble("sprhot");
		hotspotprice = args.getDouble("hot");
		tsmartprice = args.getDouble("tsmart");
		tbasicprice = args.getDouble("tbasic");
		tgigprice = args.getDouble("tgigs");
		ttax = args.getDouble("ttax");
		adiscount = args.getDouble("adis");
		vdiscount = args.getDouble("vdis");
		sdiscount = args.getDouble("sdis");
		tdiscount = args.getDouble("tdis");

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.activity_breakdown, container,
				false);

		fadeIn = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.fadein);

		rootView.startAnimation(fadeIn);

		final TextView attBreakdown = (TextView) rootView
				.findViewById(R.id.att_breakdown_message);
		final TextView verBreakdown = (TextView) rootView
				.findViewById(R.id.ver_breakdown_message);
		final TextView sprBreakdown = (TextView) rootView
				.findViewById(R.id.spr_breakdown_message);
		final TextView tmoBreakdown = (TextView) rootView
				.findViewById(R.id.tmo_breakdown_message);

		attBreakdown.setText(Html
				.fromHtml("<u>ATT Breakdown</u><br>Cost of Smartphones: $"
						+ (int) asmartprice + "<br>Cost of Basicphones: $"
						+ (int) abasicprice + "<br>Cost of Data: $"
						+ (int) (agigprice + hotspotprice)
						+ "<br>Taxes & Government Chargers: $" + (int) atax
						+ "<br>Bill Discount: -$" + (int) adiscount));
		verBreakdown.setText(Html
				.fromHtml("<u>Verizon Breakdown</u><br>Cost of Smartphones: $"
						+ (int) vsmartprice + "<br>Cost of Basicphones: $"
						+ (int) vbasicprice + "<br>Cost of Data: $"
						+ (int) (vgigprice + hotspotprice)
						+ "<br>Taxes & Government Chargers: $" + (int) vtax
						+ "<br>Bill Discount: -$" + (int) vdiscount));
		sprBreakdown.setText(Html
				.fromHtml("<u>Sprint Breakdown</u><br>Cost of Phones: $"
						+ (int) (ssmartprice + sbasicprice)
						+ "<br>Cost of Data: $"
						+ (int) (sgigprice + sprhotspotprice)
						+ "<br>Taxes & Government Charges: $" + (int) stax
						+ "<br>Bill Discount: -$" + (int) sdiscount));
		tmoBreakdown.setText(Html
				.fromHtml("<u>T-Mobile Breakdown</u><br>Cost of Phones: $"
						+ (int) (tsmartprice + tbasicprice)
						+ "<br>Cost of Data: $"
						+ (int) (tgigprice + hotspotprice)
						+ "<br>Taxes & Government Charges: $" + (int) ttax
						+ "<br>Bill Discount: -$" + (int) tdiscount));

		return rootView;
	}

}
