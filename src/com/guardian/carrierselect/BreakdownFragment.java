package com.guardian.carrierselect;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.guardian.carrierselect.model.Phone;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class BreakdownFragment extends Fragment {

	private static final String ARGS_TWOYEAR = "twoyear";
	private static final String ARGS_HOT_SPOT = "hot_spot";
	private static final String ARGS_SMARTPHONES = "smartphones";
	private static final String ARGS_BASICPHONES = "basicphones";
	private static final String ARGS_GIGS = "gigs";
	private static final String ARGS_TABS = "tabs";
	private static final String ARGS_DISCOUNT = "discount";
	private static final String ARGS_INSTALLS = "installments";

	private static int smartphones, basicphones, gigs, tabs, hotspots, devices;
	private double discount, installs;

	private String carrier;

	private ProgressDialog progress;

	private boolean twoyear;

	private TextView attname, attplan, attsmart, attbasic, atttablets, attmifi,
			attinstalls, atttax, attdiscount, atttotal;
	private TextView vername, verplan, versmart, verbasic, vertablets, vermifi,
			verinstalls, vertax, verdiscount, vertotal;
	private TextView sprname, sprplan, sprsmart, sprbasic, sprtablets, sprmifi,
			sprinstalls, sprtax, sprdiscount, sprtotal;
	private TextView tmoname, tmoplan, tmophones, tmotax, tmodiscount,
			tmoinstalls, tmototal;

	private static View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.activity_breakdown, container,
				false);

		devices = smartphones + basicphones + tabs + hotspots;

		final Button attviewer = (Button) rootView.findViewById(R.id.gotoatt);
		final Button verviewer = (Button) rootView.findViewById(R.id.gotover);
		final Button sprviewer = (Button) rootView.findViewById(R.id.gotospr);
		final Button tmoviewer = (Button) rootView.findViewById(R.id.gototmo);
		final TextView equipnotice = (TextView) rootView
				.findViewById(R.id.equipnotice);
		final TextView tmonotice = (TextView) rootView
				.findViewById(R.id.tmonotice);

		attname = (TextView) rootView.findViewById(R.id.attname);
		vername = (TextView) rootView.findViewById(R.id.vername);
		sprname = (TextView) rootView.findViewById(R.id.sprname);
		tmoname = (TextView) rootView.findViewById(R.id.tmoname);

		attplan = (TextView) rootView.findViewById(R.id.attplan);
		verplan = (TextView) rootView.findViewById(R.id.verplan);
		sprplan = (TextView) rootView.findViewById(R.id.sprplan);
		tmoplan = (TextView) rootView.findViewById(R.id.tmoplan);

		attsmart = (TextView) rootView.findViewById(R.id.attsmart);
		versmart = (TextView) rootView.findViewById(R.id.versmart);
		sprsmart = (TextView) rootView.findViewById(R.id.sprsmart);
		tmophones = (TextView) rootView.findViewById(R.id.tmophone);

		attbasic = (TextView) rootView.findViewById(R.id.attbasic);
		verbasic = (TextView) rootView.findViewById(R.id.verbasic);
		sprbasic = (TextView) rootView.findViewById(R.id.sprbasic);

		atttablets = (TextView) rootView.findViewById(R.id.atttablet);
		vertablets = (TextView) rootView.findViewById(R.id.vertablet);
		sprtablets = (TextView) rootView.findViewById(R.id.sprtablet);

		attmifi = (TextView) rootView.findViewById(R.id.attmifi);
		vermifi = (TextView) rootView.findViewById(R.id.vermifi);
		sprmifi = (TextView) rootView.findViewById(R.id.sprmifi);

		attinstalls = (TextView) rootView.findViewById(R.id.attinstalls);
		verinstalls = (TextView) rootView.findViewById(R.id.verinstalls);
		sprinstalls = (TextView) rootView.findViewById(R.id.sprinstalls);
		tmoinstalls = (TextView) rootView.findViewById(R.id.tmoinstalls);

		atttax = (TextView) rootView.findViewById(R.id.atttax);
		vertax = (TextView) rootView.findViewById(R.id.vertax);
		sprtax = (TextView) rootView.findViewById(R.id.sprtax);
		tmotax = (TextView) rootView.findViewById(R.id.tmotax);

		attdiscount = (TextView) rootView.findViewById(R.id.attdiscount);
		verdiscount = (TextView) rootView.findViewById(R.id.verdiscount);
		sprdiscount = (TextView) rootView.findViewById(R.id.sprdiscount);
		tmodiscount = (TextView) rootView.findViewById(R.id.tmodiscount);

		atttotal = (TextView) rootView.findViewById(R.id.atttotal);
		vertotal = (TextView) rootView.findViewById(R.id.vertotal);
		sprtotal = (TextView) rootView.findViewById(R.id.sprtotal);
		tmototal = (TextView) rootView.findViewById(R.id.tmototal);

		if (twoyear == true) {
			equipnotice.setVisibility(View.GONE);
		}

		if (hotspots + tabs == 0 && twoyear == false) {
			tmonotice.setVisibility(View.GONE);
		}

		buildATT();
		buildVer();
		buildSpr();
		buildTmo();

		equipnotice.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				final Fragment fragment = new KnowledgeBase3();

				final FragmentTransaction fragmenttran = getActivity()
						.getSupportFragmentManager().beginTransaction();
				fragmenttran.setCustomAnimations(R.anim.slide_in_right,
						R.anim.slide_out_left, R.anim.slide_in_left,
						R.anim.slide_out_right);
				fragmenttran.replace(R.id.fragment_container, fragment);
				fragmenttran.addToBackStack(null);
				fragmenttran.commit();
			}

		});

		attviewer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				carrier = "AT&T";
				next();
			}

		});

		verviewer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				carrier = "Verizon Wireless";
				next();
			}

		});

		sprviewer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				carrier = "Sprint";
				next();
			}

		});

		tmoviewer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				carrier = "T-Mobile";
				next();
			}

		});

		return rootView;
	}

	public void next() {

		final FragmentTransaction fragmenttran = getActivity()
				.getSupportFragmentManager().beginTransaction();
		fragmenttran.setCustomAnimations(R.anim.slide_in_right,
				R.anim.slide_out_left, R.anim.slide_in_left,
				R.anim.slide_out_right);
		fragmenttran.replace(R.id.fragment_container, PlanViewer.create(
				smartphones, basicphones, gigs, tabs, hotspots, discount,
				carrier));
		fragmenttran.addToBackStack(null);
		fragmenttran.commit();
	}

	// init att search
	@SuppressLint("DefaultLocale")
	public void buildATT() {

		progress = new ProgressDialog(getActivity(),
				AlertDialog.THEME_DEVICE_DEFAULT_DARK);
		progress.setTitle("Building your plans");
		progress.setMessage("Just a sec...");
		progress.setCancelable(false);
		progress.show();

		ParseObject.registerSubclass(Phone.class);

		final ParseQuery<ParseObject> query = ParseQuery.getQuery("Postpaid");
		query.whereContains("Carrier", "AT&T");
		query.whereContains("DataFinder", "A" + Integer.toString(gigs) + "GB");
		query.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> PlanList, ParseException e) {

				if (e == null) {
					int smart;

					final int plan = Integer.parseInt(PlanList.get(0)
							.getString("PlanCost"));

					if (twoyear == false) {

						smart = Integer.parseInt(PlanList.get(0).getString(
								"SmartPrice"));

					} else {

						smart = Integer.parseInt(PlanList.get(0).getString(
								"ContractLine"));

					}

					int basic = Integer.valueOf(PlanList.get(0).getString(
							"BasicPrice"));
					int tablets = Integer.valueOf(PlanList.get(0).getString(
							"TabPrice"));
					int mifi = Integer.valueOf(PlanList.get(0).getString(
							"MifiPrice"));

					smart = smart * smartphones;
					basic = basic * basicphones;
					tablets = tablets * tabs;
					mifi = mifi * hotspots;
					double dis = 1 - (discount / 100);
					final int tax = (int) Math
							.round((((plan * dis) + smart + basic + tablets + mifi) * .16 + (devices * 2)) * 100) / 100;
					dis = Math.round(plan - (plan * dis));

					attname.setText(PlanList.get(0).getString("Name"));
					attplan.setText("$" + plan);
					attsmart.setText("$" + smart);
					attbasic.setText("$" + basic);
					atttablets.setText("$" + tablets);
					attmifi.setText("$" + mifi);
					attinstalls.setText("$" + Math.round(installs));
					attdiscount.setText("-$" + Math.round(dis));
					atttax.setText("$" + tax);
					atttotal.setText("$"
							+ Math.round(((plan + smart + basic + tablets + mifi)
									+ tax - dis + installs)));

				} else {
				}
			}
		});

	}

	// init ver search
	@SuppressLint("DefaultLocale")
	public void buildVer() {
		ParseObject.registerSubclass(Phone.class);
		Parse.initialize(rootView.getContext(),
				"2XacmZEB9hLKANtTk7Rx9ejJipHI3GkmxhVt0Q0y",
				"mAmItywfUeIlMgZCK1LwvQSfneS0SaG1MGqfB65d");

		String phones = "Individual or Family";

		if ((smartphones + basicphones + tabs == 1) && gigs < 3) {
			phones = "Individual";
		}

		final ParseQuery<ParseObject> query = ParseQuery.getQuery("Postpaid");
		query.whereContains("Carrier", "Verizon Wireless");
		query.whereEqualTo("Type", phones);
		query.whereContains("DataFinder", "A" + Integer.toString(gigs) + "GB");
		query.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> PlanList, ParseException e) {

				if (e == null) {
					int smart;

					final int plan = Integer.parseInt(PlanList.get(0)
							.getString("PlanCost"));

					if (twoyear == false) {

						smart = Integer.parseInt(PlanList.get(0).getString(
								"SmartPrice"));

					} else {

						smart = Integer.parseInt(PlanList.get(0).getString(
								"ContractLine"));

					}

					int basic = Integer.valueOf(PlanList.get(0).getString(
							"BasicPrice"));
					int tablets = Integer.valueOf(PlanList.get(0).getString(
							"TabPrice"));
					int mifi = Integer.valueOf(PlanList.get(0).getString(
							"MifiPrice"));

					smart = smart * smartphones;
					basic = basic * basicphones;
					tablets = tablets * tabs;
					mifi = mifi * hotspots;
					double dis = 1 - (discount / 100);
					final int tax = (int) Math
							.round((((plan * dis) + smart + basic + tablets + mifi) * .16 + (devices * 2)) * 100) / 100;
					dis = Math.round(plan - (plan * dis));

					vername.setText(PlanList.get(0).getString("Name"));
					verplan.setText("$" + plan);
					versmart.setText("$" + smart);
					verbasic.setText("$" + basic);
					vertablets.setText("$" + tablets);
					vermifi.setText("$" + mifi);
					verinstalls.setText("$" + Math.round(installs));
					verdiscount.setText("-$" + Math.round(dis));
					vertax.setText("$" + tax);
					vertotal.setText("$"
							+ Math.round(((plan + smart + basic + tablets + mifi)
									+ tax - dis + installs)));

				} else {
				}
			}
		});

	}

	// init spr search
	@SuppressLint("DefaultLocale")
	public void buildSpr() {
		ParseObject.registerSubclass(Phone.class);
		Parse.initialize(rootView.getContext(),
				"2XacmZEB9hLKANtTk7Rx9ejJipHI3GkmxhVt0Q0y",
				"mAmItywfUeIlMgZCK1LwvQSfneS0SaG1MGqfB65d");

		String adjustedGB = String.valueOf(gigs);

		if ((smartphones + basicphones + tabs == 1) && gigs > 2) {
			adjustedGB = "Unlimited";
		}

		final ParseQuery<ParseObject> query = ParseQuery.getQuery("Postpaid");
		query.whereContains("Carrier", "Sprint");
		query.whereContains("DataFinder", "A" + adjustedGB + "GB");
		query.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> PlanList, ParseException e) {

				if (e == null) {
					int smart;

					final int plan = Integer.parseInt(PlanList.get(0)
							.getString("PlanCost"));

					if (twoyear == false) {

						smart = Integer.parseInt(PlanList.get(0).getString(
								"SmartPrice"));

					} else {

						smart = Integer.parseInt(PlanList.get(0).getString(
								"ContractLine"));

					}

					int basic = Integer.valueOf(PlanList.get(0).getString(
							"BasicPrice"));
					int tablets = Integer.valueOf(PlanList.get(0).getString(
							"TabPrice"));
					int mifi = Integer.valueOf(PlanList.get(0).getString(
							"MifiPrice"));

					smart = smart * smartphones;
					basic = basic * basicphones;
					tablets = tablets * tabs;
					mifi = mifi * hotspots;
					double dis = 1 - (discount / 100);
					final int tax = (int) Math
							.round((((plan * dis) + smart + basic + tablets + mifi) * .16 + (devices * 2)) * 100) / 100;
					dis = Math.round(plan - (plan * dis));

					sprname.setText(PlanList.get(0).getString("Name"));
					sprplan.setText("$" + plan);
					sprsmart.setText("$" + smart);
					sprbasic.setText("$" + basic);
					sprtablets.setText("$" + tablets);
					sprmifi.setText("$" + mifi);
					sprinstalls.setText("$" + Math.round(installs));
					sprdiscount.setText("-$" + Math.round(dis));
					sprtax.setText("$" + tax);
					sprtotal.setText("$"
							+ Math.round(((plan + smart + basic + tablets + mifi)
									+ tax - dis + installs)));

				} else {
				}
			}
		});
	}

	// init tmo search
	@SuppressLint("DefaultLocale")
	public void buildTmo() {

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

		ParseObject.registerSubclass(Phone.class);
		Parse.initialize(rootView.getContext(),
				"2XacmZEB9hLKANtTk7Rx9ejJipHI3GkmxhVt0Q0y",
				"mAmItywfUeIlMgZCK1LwvQSfneS0SaG1MGqfB65d");

		final ParseQuery<ParseObject> query = ParseQuery.getQuery("Postpaid");
		query.whereContains("Carrier", "T-Mobile");
		query.whereContains("Name", phones + " Lines");
		query.whereContains("DataFinder", "A" + adjustedGB + "GB");
		query.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> PlanList, ParseException e) {

				if (e == null) {

					final int plan = Integer.parseInt(PlanList.get(0)
							.getString("PlanCost"));
					final int smart = Integer.parseInt(PlanList.get(0)
							.getString("SmartPrice"));

					final int tax = (int) Math
							.round(((smart + plan) * .16 + ((smartphones + basicphones) * 2))) * 100 / 100;

					tmoname.setText(PlanList.get(0).getString("Name"));
					tmoplan.setText("$" + plan);
					tmophones.setText("$" + smart);
					tmoinstalls.setText("$" + Math.round(installs));
					tmodiscount.setText("-$0");
					tmotax.setText("$" + tax);
					tmototal.setText("$"
							+ Math.round(((plan + smart) + tax + installs)));

					final Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							progress.dismiss();
						}
					}, 200);
				} else {
				}
			}
		});
	}

	public static BreakdownFragment create(boolean twoyear, int smartphones,
			int basicphones, int gigs, int tabs, int hotspots, double discount,
			double installs) {
		final BreakdownFragment fragment = new BreakdownFragment();

		final Bundle args = new Bundle();

		args.putBoolean(ARGS_TWOYEAR, twoyear);
		args.putInt(ARGS_HOT_SPOT, hotspots);
		args.putInt(ARGS_SMARTPHONES, smartphones);
		args.putInt(ARGS_BASICPHONES, basicphones);
		args.putInt(ARGS_GIGS, gigs);
		args.putInt(ARGS_TABS, tabs);
		args.putDouble(ARGS_DISCOUNT, discount);
		args.putDouble(ARGS_INSTALLS, installs);
		fragment.setArguments(args);

		return fragment;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		final Bundle args = getArguments();

		twoyear = args.getBoolean(ARGS_TWOYEAR);
		hotspots = args.getInt(ARGS_HOT_SPOT);
		smartphones = args.getInt(ARGS_SMARTPHONES);
		basicphones = args.getInt(ARGS_BASICPHONES);
		gigs = args.getInt(ARGS_GIGS);
		tabs = args.getInt(ARGS_TABS);
		discount = args.getDouble(ARGS_DISCOUNT);
		installs = args.getDouble(ARGS_INSTALLS);

	}

}
