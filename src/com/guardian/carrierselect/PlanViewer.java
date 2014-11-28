package com.guardian.carrierselect;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.applovin.adview.AppLovinInterstitialAd;
import com.guardian.carrierselect.model.Phone;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class PlanViewer extends Fragment {

	private static final String ARGS_HOT_SPOT = "hot_spot";
	private static final String ARGS_SMARTPHONES = "smartphones";
	private static final String ARGS_BASICPHONES = "basicphones";
	private static final String ARGS_GIGS = "gigs";
	private static final String ARGS_TABS = "tabs";
	private static final String ARGS_DISCOUNT = "discount";
	private static final String ARGS_CARRIER = "carrier";

	@SuppressWarnings("unused")
	private static int smartphones, basicphones, gigs, tabs, hotspotprice;
	@SuppressWarnings("unused")
	private double discount;

	private String carrier;

	private ProgressDialog progress;
	private TextView title;

	private static View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.planviewer, container, false);

		title = (TextView) rootView.findViewById(R.id.pvsubtitle);
		title.setTypeface(null, Typeface.BOLD);

		double randomNum = Math.random() * 3;

		if ((int) randomNum == 1)
			AppLovinInterstitialAd.show(getActivity());

		if (carrier.equalsIgnoreCase("AT&T")) {
			buildATT();
		} else if (carrier.equalsIgnoreCase("Verizon Wireless")) {
			buildVer();
		} else if (carrier.equalsIgnoreCase("Sprint")) {
			buildSpr();
		} else if (carrier.equalsIgnoreCase("T-Mobile")) {
			buildTmo();
		}

		return rootView;
	}

	@SuppressLint("DefaultLocale")
	public void buildATT() {

		progress = new ProgressDialog(getActivity());
		progress.setTitle("Building your plan");
		progress.setMessage("Just a sec...");
		progress.show();

		ParseObject.registerSubclass(Phone.class);
		Parse.initialize(rootView.getContext(),
				"2XacmZEB9hLKANtTk7Rx9ejJipHI3GkmxhVt0Q0y",
				"mAmItywfUeIlMgZCK1LwvQSfneS0SaG1MGqfB65d");

		// Test Query
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Postpaid");
		query.whereContains("Carrier", "AT&T");
		query.whereContains("DataFinder", "A" + Integer.toString(gigs) + "GB");
		query.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> PlanList, ParseException e) {

				if (e == null) {

					title.setText(PlanList.get(0).getString("Name"));

					final TextView b1typepre = (TextView) rootView
							.findViewById(R.id.box1typepre);
					b1typepre.setTypeface(null, Typeface.BOLD);
					final TextView b1devicespre = (TextView) rootView
							.findViewById(R.id.box1devicespre);
					b1devicespre.setTypeface(null, Typeface.BOLD);
					final TextView b1ttpre = (TextView) rootView
							.findViewById(R.id.box1ttpre);
					b1ttpre.setTypeface(null, Typeface.BOLD);
					final TextView b1datapre = (TextView) rootView
							.findViewById(R.id.box1datapre);
					b1datapre.setTypeface(null, Typeface.BOLD);
					final TextView b1overpre = (TextView) rootView
							.findViewById(R.id.box1overagepre);
					b1overpre.setTypeface(null, Typeface.BOLD);
					final TextView b1etfpre = (TextView) rootView
							.findViewById(R.id.box1etfpre);
					b1etfpre.setTypeface(null, Typeface.BOLD);
					final TextView b1etfinstallpre = (TextView) rootView
							.findViewById(R.id.box1etfinstallpre);
					b1etfinstallpre.setTypeface(null, Typeface.BOLD);

					final TextView b1type = (TextView) rootView
							.findViewById(R.id.box1type);
					final TextView b1devices = (TextView) rootView
							.findViewById(R.id.box1devices);
					final TextView b1tt = (TextView) rootView
							.findViewById(R.id.box1tt);
					final TextView b1data = (TextView) rootView
							.findViewById(R.id.box1data);
					final TextView b1over = (TextView) rootView
							.findViewById(R.id.box1overage);
					final TextView b1etfsmart = (TextView) rootView
							.findViewById(R.id.box1etfsmart);
					final TextView b1etfbasic = (TextView) rootView
							.findViewById(R.id.box1etfbasic);
					final TextView b1etfinstall = (TextView) rootView
							.findViewById(R.id.box1etfinstall);

					String type = PlanList.get(0).getString("Type");
					String devices = PlanList.get(0).getString("Devices");
					String data = PlanList.get(0).getString("Data");
					String overage = PlanList.get(0).getString("Overage");
					String smartetf = PlanList.get(0).getString("SmartETF");
					String smartetflower = PlanList.get(0).getString(
							"SmartETFDown");
					String basicetf = PlanList.get(0).getString("BasicETF");
					String basicetflower = PlanList.get(0).getString(
							"BasicETFDown");
					String installetf = PlanList.get(0).getString(
							"ETFInstallments");

					b1type.setText(type);
					b1devices.setText(devices);
					b1tt.setText("Unlimited Talk & Text Nationwide");
					b1data.setText(data + " shared for group");
					b1over.setText(overage);
					b1etfsmart.setText("Smartphones - $" + smartetf
							+ " and declines $" + smartetflower
							+ " per month into contract.");
					b1etfbasic.setText("Basic phones, Tablets, Hotspots - $"
							+ basicetf + " and declines $" + basicetflower
							+ " per month into contract.");
					b1etfinstall.setText(installetf);

					progress.dismiss();
				} else {
				}

			}
		});

	}

	@SuppressLint("DefaultLocale")
	public void buildVer() {

		progress = new ProgressDialog(getActivity());
		progress.setTitle("Building your plan");
		progress.setMessage("Just a sec...");
		progress.show();

		ParseObject.registerSubclass(Phone.class);
		Parse.initialize(rootView.getContext(),
				"2XacmZEB9hLKANtTk7Rx9ejJipHI3GkmxhVt0Q0y",
				"mAmItywfUeIlMgZCK1LwvQSfneS0SaG1MGqfB65d");

		String phones = "Shared / Individual";

		if (smartphones + basicphones + tabs == 1 && gigs < 3) {
			phones = "Individual";
		}

		// Test Query
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Postpaid");
		query.whereContains("Carrier", "Verizon Wireless");
		query.whereEqualTo("Type", phones);
		query.whereContains("DataFinder", "A" + Integer.toString(gigs) + "GB");
		query.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> PlanList, ParseException e) {

				if (e == null) {

					title.setText(PlanList.get(0).getString("Name"));

					final TextView b1typepre = (TextView) rootView
							.findViewById(R.id.box1typepre);
					b1typepre.setTypeface(null, Typeface.BOLD);
					final TextView b1devicespre = (TextView) rootView
							.findViewById(R.id.box1devicespre);
					b1devicespre.setTypeface(null, Typeface.BOLD);
					final TextView b1ttpre = (TextView) rootView
							.findViewById(R.id.box1ttpre);
					b1ttpre.setTypeface(null, Typeface.BOLD);
					final TextView b1datapre = (TextView) rootView
							.findViewById(R.id.box1datapre);
					b1datapre.setTypeface(null, Typeface.BOLD);
					final TextView b1overpre = (TextView) rootView
							.findViewById(R.id.box1overagepre);
					b1overpre.setTypeface(null, Typeface.BOLD);
					final TextView b1etfpre = (TextView) rootView
							.findViewById(R.id.box1etfpre);
					b1etfpre.setTypeface(null, Typeface.BOLD);
					final TextView b1etfinstallpre = (TextView) rootView
							.findViewById(R.id.box1etfinstallpre);
					b1etfinstallpre.setTypeface(null, Typeface.BOLD);

					final TextView b1type = (TextView) rootView
							.findViewById(R.id.box1type);
					final TextView b1devices = (TextView) rootView
							.findViewById(R.id.box1devices);
					final TextView b1tt = (TextView) rootView
							.findViewById(R.id.box1tt);
					final TextView b1data = (TextView) rootView
							.findViewById(R.id.box1data);
					final TextView b1over = (TextView) rootView
							.findViewById(R.id.box1overage);
					final TextView b1etfsmart = (TextView) rootView
							.findViewById(R.id.box1etfsmart);
					final TextView b1etfbasic = (TextView) rootView
							.findViewById(R.id.box1etfbasic);
					final TextView b1etfinstall = (TextView) rootView
							.findViewById(R.id.box1etfinstall);

					String type = PlanList.get(0).getString("Type");
					String devices = PlanList.get(0).getString("Devices");
					String data = PlanList.get(0).getString("Data");
					String overage = PlanList.get(0).getString("Overage");
					String smartetf = PlanList.get(0).getString("SmartETF");
					String smartetflower = PlanList.get(0).getString(
							"SmartETFDown");
					String basicetf = PlanList.get(0).getString("BasicETF");
					String basicetflower = PlanList.get(0).getString(
							"BasicETFDown");
					String installetf = PlanList.get(0).getString(
							"ETFInstallments");

					b1type.setText(type);
					b1devices.setText(devices);
					b1tt.setText("Unlimited Talk & Text Nationwide");

					if (smartphones + basicphones + tabs == 1 && gigs < 3) {
						b1data.setText(data + " for individual");
					} else {
						b1data.setText(data + " shared for group");
					}

					b1over.setText(overage);
					b1etfsmart.setText("Smartphones - $" + smartetf
							+ " and declines $" + smartetflower
							+ " per month into contract.");
					b1etfbasic.setText("Basic phones, Tablets, Hotspots - $"
							+ basicetf + " and declines $" + basicetflower
							+ " per month into contract.");
					b1etfinstall.setText(installetf);

					progress.dismiss();
				} else {
				}
			}
		});

	}

	@SuppressLint("DefaultLocale")
	public void buildSpr() {

		progress = new ProgressDialog(getActivity());
		progress.setTitle("Building your plan");
		progress.setMessage("Just a sec...");
		progress.show();

		ParseObject.registerSubclass(Phone.class);
		Parse.initialize(rootView.getContext(),
				"2XacmZEB9hLKANtTk7Rx9ejJipHI3GkmxhVt0Q0y",
				"mAmItywfUeIlMgZCK1LwvQSfneS0SaG1MGqfB65d");

		String adjustedGB = String.valueOf(gigs);

		if ((smartphones + basicphones + tabs == 1) && gigs > 2) {
			adjustedGB = "Unlimited";
		}

		// Test Query
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Postpaid");
		query.whereContains("Carrier", "Sprint");
		query.whereContains("DataFinder", "A" + adjustedGB + "GB");
		query.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> PlanList, ParseException e) {

				if (e == null) {

					title.setText(PlanList.get(0).getString("Name"));

					final TextView b1typepre = (TextView) rootView
							.findViewById(R.id.box1typepre);
					b1typepre.setTypeface(null, Typeface.BOLD);
					final TextView b1devicespre = (TextView) rootView
							.findViewById(R.id.box1devicespre);
					b1devicespre.setTypeface(null, Typeface.BOLD);
					final TextView b1ttpre = (TextView) rootView
							.findViewById(R.id.box1ttpre);
					b1ttpre.setTypeface(null, Typeface.BOLD);
					final TextView b1datapre = (TextView) rootView
							.findViewById(R.id.box1datapre);
					b1datapre.setTypeface(null, Typeface.BOLD);
					final TextView b1overpre = (TextView) rootView
							.findViewById(R.id.box1overagepre);
					b1overpre.setTypeface(null, Typeface.BOLD);
					final TextView b1etfpre = (TextView) rootView
							.findViewById(R.id.box1etfpre);
					b1etfpre.setTypeface(null, Typeface.BOLD);
					final TextView b1etfinstallpre = (TextView) rootView
							.findViewById(R.id.box1etfinstallpre);
					b1etfinstallpre.setTypeface(null, Typeface.BOLD);

					final TextView b1type = (TextView) rootView
							.findViewById(R.id.box1type);
					final TextView b1devices = (TextView) rootView
							.findViewById(R.id.box1devices);
					final TextView b1tt = (TextView) rootView
							.findViewById(R.id.box1tt);
					final TextView b1data = (TextView) rootView
							.findViewById(R.id.box1data);
					final TextView b1over = (TextView) rootView
							.findViewById(R.id.box1overage);
					final TextView b1etfsmart = (TextView) rootView
							.findViewById(R.id.box1etfsmart);
					final TextView b1etfbasic = (TextView) rootView
							.findViewById(R.id.box1etfbasic);
					final TextView b1etfinstall = (TextView) rootView
							.findViewById(R.id.box1etfinstall);

					String type = PlanList.get(0).getString("Type");
					String devices = PlanList.get(0).getString("Devices");
					String data = PlanList.get(0).getString("Data");
					String overage = PlanList.get(0).getString("Overage");
					String smartetf = PlanList.get(0).getString("SmartETF");
					String smartetflower = PlanList.get(0).getString(
							"SmartETFDown");
					String basicetf = PlanList.get(0).getString("BasicETF");
					String basicetflower = PlanList.get(0).getString(
							"BasicETFDown");
					String installetf = PlanList.get(0).getString(
							"ETFInstallments");

					b1type.setText(type);
					b1devices.setText(devices);
					b1tt.setText("Unlimited Talk & Text Nationwide");
					b1data.setText(data + " shared for group");
					b1over.setText(overage);
					b1etfsmart.setText("Smartphones - $" + smartetf
							+ " and declines $" + smartetflower
							+ " per month starting at 17 months.");
					b1etfbasic.setText("Basic phones, Tablets, Hotspots - $"
							+ basicetf + " and declines $" + basicetflower
							+ " per starting at 19 months.");
					b1etfinstall.setText(installetf);

					progress.dismiss();
				} else {
				}
			}
		});
	}

	@SuppressLint("DefaultLocale")
	public void buildTmo() {

		progress = new ProgressDialog(getActivity());
		progress.setTitle("Building your plan");
		progress.setMessage("Just a sec...");
		progress.show();

		String phones = String.valueOf(smartphones + basicphones + tabs);
		String adjustedGB = String.valueOf(gigs);

		if (phones.equals("1") && gigs > 5) {
			adjustedGB = "Unlimited";
		} else if (phones.equals("2") && gigs > 10) {
			adjustedGB = "Unlimited";
		} else if (phones.equals("3") && gigs > 15) {
			adjustedGB = "Unlimited";
		} else if (phones.equals("4") && gigs > 20) {
			adjustedGB = "Unlimited";
		} else if (phones.equals("5") && gigs > 25) {
			adjustedGB = "Unlimited";
		} else if (phones.equals("6") && gigs > 30) {
			adjustedGB = "Unlimited";
		}

		Parse.initialize(rootView.getContext(),
				"2XacmZEB9hLKANtTk7Rx9ejJipHI3GkmxhVt0Q0y",
				"mAmItywfUeIlMgZCK1LwvQSfneS0SaG1MGqfB65d");

		// Test Query
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Postpaid");
		query.whereContains("Carrier", "T-Mobile");
		query.whereContains("Name", phones + " Lines");
		query.whereContains("DataFinder", "A" + adjustedGB + "GB");
		query.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> PlanList, ParseException e) {

				if (e == null) {

					title.setText(PlanList.get(0).getString("Name"));

					final TextView b1typepre = (TextView) rootView
							.findViewById(R.id.box1typepre);
					b1typepre.setTypeface(null, Typeface.BOLD);
					final TextView b1devicespre = (TextView) rootView
							.findViewById(R.id.box1devicespre);
					b1devicespre.setTypeface(null, Typeface.BOLD);
					final TextView b1ttpre = (TextView) rootView
							.findViewById(R.id.box1ttpre);
					b1ttpre.setTypeface(null, Typeface.BOLD);
					final TextView b1datapre = (TextView) rootView
							.findViewById(R.id.box1datapre);
					b1datapre.setText("High Speed Data");
					b1datapre.setTypeface(null, Typeface.BOLD);
					final TextView b1overpre = (TextView) rootView
							.findViewById(R.id.box1overagepre);
					b1overpre.setTypeface(null, Typeface.BOLD);
					final TextView b1etfpre = (TextView) rootView
							.findViewById(R.id.box1etfpre);
					b1etfpre.setTypeface(null, Typeface.BOLD);
					final TextView b1etfinstallpre = (TextView) rootView
							.findViewById(R.id.box1etfinstallpre);
					b1etfinstallpre.setTypeface(null, Typeface.BOLD);

					final TextView b1type = (TextView) rootView
							.findViewById(R.id.box1type);
					final TextView b1devices = (TextView) rootView
							.findViewById(R.id.box1devices);
					final TextView b1tt = (TextView) rootView
							.findViewById(R.id.box1tt);
					final TextView b1data = (TextView) rootView
							.findViewById(R.id.box1data);
					final TextView b1over = (TextView) rootView
							.findViewById(R.id.box1overage);
					final TextView b1etfsmart = (TextView) rootView
							.findViewById(R.id.box1etfsmart);
					final TextView b1etfbasic = (TextView) rootView
							.findViewById(R.id.box1etfbasic);
					b1etfbasic.setVisibility(View.GONE);
					final TextView b1etfinstall = (TextView) rootView
							.findViewById(R.id.box1etfinstall);

					String type = PlanList.get(0).getString("Type");
					String devices = PlanList.get(0).getString("Devices");
					String data = PlanList.get(0).getString("Data");
					String overage = PlanList.get(0).getString("Overage");
					String smartetf = PlanList.get(0).getString("SmartETF");
					String basicetf = PlanList.get(0).getString("BasicETF");
					String basicetflower = PlanList.get(0).getString(
							"BasicETFDown");
					String installetf = PlanList.get(0).getString(
							"ETFInstallments");

					b1type.setText(type);
					b1devices.setText(devices);
					b1tt.setText("Unlimited Talk & Text Nationwide");
					b1data.setText(data);
					b1over.setText(overage + " " + data);
					b1etfsmart.setText("Smartphones - $" + smartetf
							+ " if 6 months or longer remain, $" + basicetf
							+ " if 3-6 months remain, $" + basicetflower
							+ " if less than 3 months remain.");
					b1etfinstall.setText(installetf);

					progress.dismiss();
				} else {
				}
			}
		});
	}

	public static PlanViewer create(int smartphones, int basicphones, int gigs,
			int tabs, int hotspotprice, double discount, String carrier) {
		final PlanViewer fragment = new PlanViewer();

		final Bundle args = new Bundle();

		args.putInt(ARGS_HOT_SPOT, hotspotprice);
		args.putInt(ARGS_SMARTPHONES, smartphones);
		args.putInt(ARGS_BASICPHONES, basicphones);
		args.putInt(ARGS_GIGS, gigs);
		args.putInt(ARGS_TABS, tabs);
		args.putDouble(ARGS_DISCOUNT, discount);
		args.putString(ARGS_CARRIER, carrier);
		fragment.setArguments(args);

		return fragment;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		final Bundle args = getArguments();

		hotspotprice = args.getInt(ARGS_HOT_SPOT);
		smartphones = args.getInt(ARGS_SMARTPHONES);
		basicphones = args.getInt(ARGS_BASICPHONES);
		gigs = args.getInt(ARGS_GIGS);
		tabs = args.getInt(ARGS_TABS);
		discount = args.getDouble(ARGS_DISCOUNT);
		carrier = args.getString(ARGS_CARRIER);

	}

}