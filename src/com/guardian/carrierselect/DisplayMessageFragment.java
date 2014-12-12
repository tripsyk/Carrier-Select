package com.guardian.carrierselect;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.guardian.carrierselect.model.Phone;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class DisplayMessageFragment extends Fragment {

	private static final String ARGS_TWOYEAR = "twoyear";
	private static final String ARGS_HOT_SPOT = "hot_spot";
	private static final String ARGS_SMARTPHONES = "smartphones";
	private static final String ARGS_BASICPHONES = "basicphones";
	private static final String ARGS_GIGS = "gigs";
	private static final String ARGS_TABS = "tabs";
	private static final String ARGS_DISCOUNT = "discount";
	private static final String ARGS_INSTALLS = "installments";

	private static int smartphones, basicphones, gigs, tabs, hotspots, devices;

	private boolean twoyear;

	private double discount, installs;

	private ProgressDialog progress;

	private View rootView;

	private TextView equipnotice, tmonotice;

	public static DisplayMessageFragment create(boolean twoyear,
			int smartphones, int basicphones, int gigs, int tabs, int hotspots,
			double discount, double installs) {
		final DisplayMessageFragment fragment = new DisplayMessageFragment();

		final Bundle args = new Bundle();

		args.putBoolean(ARGS_TWOYEAR, twoyear);
		args.putInt(ARGS_SMARTPHONES, smartphones);
		args.putInt(ARGS_BASICPHONES, basicphones);
		args.putInt(ARGS_GIGS, gigs);
		args.putInt(ARGS_TABS, tabs);
		args.putInt(ARGS_HOT_SPOT, hotspots);
		args.putDouble(ARGS_DISCOUNT, discount);
		args.putDouble(ARGS_INSTALLS, installs);
		fragment.setArguments(args);

		return fragment;
	}

	@SuppressLint("NewApi")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.activity_display_message,
				container, false);

		// init next
		final Button sendbox = (Button) rootView.findViewById(R.id.next);

		equipnotice = (TextView) rootView.findViewById(R.id.equipnotice);
		tmonotice = (TextView) rootView.findViewById(R.id.tmonotice);
		devices = smartphones + basicphones + tabs + hotspots;

		sendbox.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				final FragmentTransaction fragmenttran = getActivity()
						.getSupportFragmentManager().beginTransaction();
				fragmenttran.setCustomAnimations(R.anim.slide_in_right,
						R.anim.slide_out_left, R.anim.slide_in_left,
						R.anim.slide_out_right);
				fragmenttran.replace(R.id.fragment_container, BreakdownFragment
						.create(twoyear, smartphones, basicphones, gigs, tabs,
								hotspots, discount, installs));
				fragmenttran.addToBackStack(null);
				fragmenttran.commit();
			}

		});

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

		buildPlans();

		return rootView;

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

	@SuppressLint("DefaultLocale")
	private void buildPlans() {

		ParseObject.registerSubclass(Phone.class);

		progress = new ProgressDialog(getActivity(),
				AlertDialog.THEME_DEVICE_DEFAULT_DARK);
		progress.setTitle("Building your plans");
		progress.setMessage("Just a sec...");
		progress.setCancelable(false);
		progress.show();

		// begin att search
		final ParseQuery<ParseObject> query = ParseQuery.getQuery("Postpaid");
		query.whereContains("Carrier", "AT&T");
		query.whereContains("DataFinder", "A" + Integer.toString(gigs) + "GB");
		query.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> PlanList, ParseException e) {

				if (e == null) {

					final TextView attplan = (TextView) rootView
							.findViewById(R.id.attplan);
					final TextView att = (TextView) rootView
							.findViewById(R.id.att_total);
					int smart;
					final int plan = Integer.parseInt(PlanList.get(0)
							.getString("PlanCost"));

					if (twoyear == false) {
						smart = Integer.parseInt(PlanList.get(0).getString(
								"SmartPrice"));
					} else {
						smart = Integer.parseInt(PlanList.get(0).getString(
								"ContractLine"));
						equipnotice.setVisibility(View.GONE);
					}

					int basic = Integer.parseInt(PlanList.get(0).getString(
							"BasicPrice"));
					int tablets = Integer.parseInt(PlanList.get(0).getString(
							"TabPrice"));
					int mifi = Integer.parseInt(PlanList.get(0).getString(
							"MifiPrice"));

					if (hotspots + tabs == 0 && twoyear == false) {
						tmonotice.setVisibility(View.GONE);
					}

					attplan.setText(PlanList.get(0).getString("Name"));

					smart = smart * smartphones;
					basic = basic * basicphones;
					tablets = tablets * tabs;
					mifi = mifi * hotspots;
					double dis = 1 - (discount / 100);

					final int tax = (int) Math
							.round((((plan * (1 - (discount / 100))) + smart
									+ basic + tablets + mifi) * .16 + (devices * 2)) * 100) / 100;

					dis = Math.round(plan - (plan * dis));
					att.setText("$"
							+ Math.round(((plan + smart + basic + tablets + mifi)
									+ tax - dis + installs)));

				} else {
				}

			}
		});

		// begin verizon search
		String phones = "Individual or Family";

		if (smartphones + basicphones + tabs == 1 && gigs < 3) {
			phones = "Individual";
		}

		final ParseQuery<ParseObject> queryVZW = ParseQuery
				.getQuery("Postpaid");
		queryVZW.whereContains("Carrier", "Verizon Wireless");
		queryVZW.whereEqualTo("Type", phones);
		queryVZW.whereContains("DataFinder", "A" + Integer.toString(gigs)
				+ "GB");
		queryVZW.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> PlanList, ParseException e) {

				if (e == null) {

					final TextView verplan = (TextView) rootView
							.findViewById(R.id.verplan);
					final TextView ver = (TextView) rootView
							.findViewById(R.id.ver_total);

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

					int basic = Integer.parseInt(PlanList.get(0).getString(
							"BasicPrice"));
					int tablets = Integer.parseInt(PlanList.get(0).getString(
							"TabPrice"));
					int mifi = Integer.parseInt(PlanList.get(0).getString(
							"MifiPrice"));

					verplan.setText(PlanList.get(0).getString("Name"));

					smart = smart * smartphones;
					basic = basic * basicphones;
					tablets = tablets * tabs;
					mifi = mifi * hotspots;
					double dis = 1 - (discount / 100);
					final int tax = (int) Math
							.round((((plan * dis) + smart + basic + tablets + mifi) * .16 + (devices * 2)) * 100) / 100;
					dis = Math.round(plan - (plan * dis));

					ver.setText("$"
							+ Math.round(((plan + smart + basic + tablets + mifi)
									+ tax - dis + installs)));

				} else {
				}
			}
		});

		String adjustedGB = String.valueOf(gigs);

		if ((smartphones + basicphones + tabs == 1) && gigs > 2) {
			adjustedGB = "Unlimited";
		}

		// begin sprint search
		final ParseQuery<ParseObject> querySpr = ParseQuery
				.getQuery("Postpaid");
		querySpr.whereContains("Carrier", "Sprint");
		querySpr.whereContains("DataFinder", "A" + adjustedGB + "GB");
		querySpr.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> PlanList, ParseException e) {

				if (e == null) {

					final TextView sprplan = (TextView) rootView
							.findViewById(R.id.sprplan);

					final TextView spr = (TextView) rootView
							.findViewById(R.id.spr_total);

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

					int basic = Integer.parseInt(PlanList.get(0).getString(
							"BasicPrice"));
					int tablets = Integer.parseInt(PlanList.get(0).getString(
							"TabPrice"));
					int mifi = Integer.parseInt(PlanList.get(0).getString(
							"MifiPrice"));

					sprplan.setText(PlanList.get(0).getString("Name"));

					smart = smart * smartphones;
					basic = basic * basicphones;
					tablets = tablets * tabs;
					mifi = mifi * hotspots;
					double dis = 1 - (discount / 100);
					final int tax = (int) Math
							.round((((plan * dis) + smart + basic + tablets + mifi) * .16 + (devices * 2)) * 100) / 100;
					dis = Math.round(plan - (plan * dis));

					spr.setText("$"
							+ Math.round(((plan + smart + basic + tablets + mifi)
									+ tax - dis + installs)));

				} else {
				}
			}
		});

		phones = String.valueOf(smartphones + basicphones + tabs);
		adjustedGB = String.valueOf(gigs);

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

		// init tmo search
		final ParseQuery<ParseObject> queryTmo = ParseQuery
				.getQuery("Postpaid");
		queryTmo.whereContains("Carrier", "T-Mobile");
		queryTmo.whereContains("Name", phones + " Lines");
		queryTmo.whereContains("DataFinder", "A" + adjustedGB + "GB");
		queryTmo.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> PlanList, ParseException e) {

				if (e == null) {

					final TextView tmoplan = (TextView) rootView
							.findViewById(R.id.tmoplan);
					final TextView tmo = (TextView) rootView
							.findViewById(R.id.tmo_total);

					final int plan = Integer.parseInt(PlanList.get(0)
							.getString("PlanCost"));
					final int smart = Integer.parseInt(PlanList.get(0)
							.getString("SmartPrice"));

					tmoplan.setText(PlanList.get(0).getString("Name"));

					final int tax = (int) Math
							.round(((smart + plan) * .16 + ((smartphones + basicphones) * 2)) * 100) / 100;

					tmo.setText("$" + Math.round(smart + plan + tax + installs));

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

}