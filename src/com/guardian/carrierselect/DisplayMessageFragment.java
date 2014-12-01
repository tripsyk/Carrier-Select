package com.guardian.carrierselect;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.graphics.Typeface;
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

public class DisplayMessageFragment extends Fragment {

	private static final String ARGS_TWOYEAR = "twoyear";
	private static final String ARGS_HOT_SPOT = "hot_spot";
	private static final String ARGS_SMARTPHONES = "smartphones";
	private static final String ARGS_BASICPHONES = "basicphones";
	private static final String ARGS_GIGS = "gigs";
	private static final String ARGS_TABS = "tabs";
	private static final String ARGS_DISCOUNT = "discount";

	private static int smartphones, basicphones, gigs, tabs, hotspots;

	private boolean twoyear;

	private double discount;

	private ProgressDialog progress;

	private View rootView;

	private TextView equipnotice, tmonotice;

	public static DisplayMessageFragment create(boolean twoyear,
			int smartphones, int basicphones, int gigs, int tabs, int hotspots,
			double discount) {
		final DisplayMessageFragment fragment = new DisplayMessageFragment();

		final Bundle args = new Bundle();

		args.putBoolean(ARGS_TWOYEAR, twoyear);
		args.putInt(ARGS_SMARTPHONES, smartphones);
		args.putInt(ARGS_BASICPHONES, basicphones);
		args.putInt(ARGS_GIGS, gigs);
		args.putInt(ARGS_TABS, tabs);
		args.putInt(ARGS_HOT_SPOT, hotspots);
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

		final Button sendbox = (Button) rootView
				.findViewById(R.id.breakdown_send);

		equipnotice = (TextView) rootView.findViewById(R.id.equipnotice);
		tmonotice = (TextView) rootView.findViewById(R.id.tmonotice);

		buildATT();
		buildVer();
		buildSpr();
		buildTmo();

		sendbox.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				final FragmentManager fm = getActivity().getFragmentManager();
				final FragmentTransaction fragmenttran = fm.beginTransaction();
				fragmenttran.setCustomAnimations(R.animator.right_in_off,
						R.animator.left_in_off);
				fragmenttran.replace(R.id.fragment_container, BreakdownFragment
						.create(twoyear, smartphones, basicphones, gigs, tabs,
								hotspots, discount));
				fragmenttran.addToBackStack(null);
				fragmenttran.commit();
			}

		});

		equipnotice.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				final FragmentManager fm = getActivity().getFragmentManager();
				final FragmentTransaction fragmenttran = fm.beginTransaction();
				fragmenttran.setCustomAnimations(R.animator.right_in_off,
						R.animator.left_in_off);
				fragmenttran.replace(R.id.fragment_container,
						KnowledgeBase3.create("Installment Billing"));
				fragmenttran.addToBackStack(null);
				fragmenttran.commit();
			}

		});

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

	}

	@SuppressLint("DefaultLocale")
	private void buildATT() {

		progress = new ProgressDialog(getActivity());
		progress.setTitle("Building your plans");
		progress.setMessage("Just a sec...");
		progress.setCancelable(false);
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

					int smart;

					int plan = Integer.parseInt(PlanList.get(0).getString(
							"PlanCost"));

					if (twoyear == false) {

						smart = Integer.parseInt(PlanList.get(0).getString(
								"SmartPrice"));

					} else {

						smart = Integer.parseInt(PlanList.get(0).getString(
								"ContractLine"));
						equipnotice.setVisibility(View.GONE);

					}

					if (hotspots + tabs == 0) {
						tmonotice.setVisibility(View.GONE);
					}

					int basic = Integer.parseInt(PlanList.get(0).getString(
							"BasicPrice"));
					int tablets = Integer.parseInt(PlanList.get(0).getString(
							"TabPrice"));
					int mifi = Integer.parseInt(PlanList.get(0).getString(
							"MifiPrice"));

					final TextView attplan = (TextView) rootView
							.findViewById(R.id.attplan);

					attplan.setText(PlanList.get(0).getString("Name"));

					final TextView att = (TextView) rootView
							.findViewById(R.id.att_total);

					smart = smart * smartphones;
					basic = basic * basicphones;
					tablets = tablets * tabs;
					mifi = mifi * hotspots;
					double dis = 1 - (discount / 100);
					int tax = (int) Math.round((((plan * dis) + smart + basic
							+ tablets + mifi) * .16) * 100) / 100;
					dis = Math.round(plan - (plan * dis));

					att.setText("$"
							+ Math.round(((plan + smart + basic + tablets + mifi)
									+ tax - dis)));
					att.setTypeface(null, Typeface.BOLD);

				} else {
				}
			}
		});

	}

	@SuppressLint("DefaultLocale")
	private void buildVer() {
		ParseObject.registerSubclass(Phone.class);
		Parse.initialize(rootView.getContext(),
				"2XacmZEB9hLKANtTk7Rx9ejJipHI3GkmxhVt0Q0y",
				"mAmItywfUeIlMgZCK1LwvQSfneS0SaG1MGqfB65d");

		String phones = "Individual or Family";

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

					int smart;

					int plan = Integer.parseInt(PlanList.get(0).getString(
							"PlanCost"));

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

					final TextView verplan = (TextView) rootView
							.findViewById(R.id.verplan);

					verplan.setText(PlanList.get(0).getString("Name"));

					final TextView ver = (TextView) rootView
							.findViewById(R.id.ver_total);

					smart = smart * smartphones;
					basic = basic * basicphones;
					tablets = tablets * tabs;
					mifi = mifi * hotspots;
					double dis = 1 - (discount / 100);
					int tax = (int) Math.round((((plan * dis) + smart + basic
							+ tablets + mifi) * .16) * 100) / 100;
					dis = Math.round(plan - (plan * dis));

					ver.setText("$"
							+ Math.round(((plan + smart + basic + tablets + mifi)
									+ tax - dis)));
					ver.setTypeface(null, Typeface.BOLD);

				} else {
				}
			}
		});

	}

	@SuppressLint("DefaultLocale")
	private void buildSpr() {
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

					int smart;

					int plan = Integer.parseInt(PlanList.get(0).getString(
							"PlanCost"));

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

					final TextView sprplan = (TextView) rootView
							.findViewById(R.id.sprplan);

					sprplan.setText(PlanList.get(0).getString("Name"));

					final TextView spr = (TextView) rootView
							.findViewById(R.id.spr_total);

					smart = smart * smartphones;
					basic = basic * basicphones;
					tablets = tablets * tabs;
					mifi = mifi * hotspots;
					double dis = 1 - (discount / 100);
					int tax = (int) Math.round((((plan * dis) + smart + basic
							+ tablets + mifi) * .16) * 100) / 100;
					dis = Math.round(plan - (plan * dis));

					spr.setText("$"
							+ Math.round(((plan + smart + basic + tablets + mifi)
									+ tax - dis)));
					spr.setTypeface(null, Typeface.BOLD);

				} else {
				}
			}
		});
	}

	@SuppressLint("DefaultLocale")
	private void buildTmo() {
		ParseObject.registerSubclass(Phone.class);
		Parse.initialize(rootView.getContext(),
				"2XacmZEB9hLKANtTk7Rx9ejJipHI3GkmxhVt0Q0y",
				"mAmItywfUeIlMgZCK1LwvQSfneS0SaG1MGqfB65d");

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

		// Test Query
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Postpaid");
		query.whereContains("Carrier", "T-Mobile");
		query.whereContains("Name", phones + " Lines");
		query.whereContains("DataFinder", "A" + adjustedGB + "GB");
		query.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> PlanList, ParseException e) {

				if (e == null) {

					int plan = Integer.parseInt(PlanList.get(0).getString(
							"PlanCost"));
					int smart = Integer.parseInt(PlanList.get(0).getString(
							"SmartPrice"));

					final TextView tmoplan = (TextView) rootView
							.findViewById(R.id.tmoplan);

					tmoplan.setText(PlanList.get(0).getString("Name"));

					final TextView tmo = (TextView) rootView
							.findViewById(R.id.tmo_total);

					double dis = 1 - (discount / 100);
					int tax = (int) Math
							.round((((smart * dis) + plan) * .16) * 100) / 100;
					dis = Math.round(smart - (smart * dis));

					tmo.setText("$" + Math.round(smart + plan + tax - dis));
					tmo.setTypeface(null, Typeface.BOLD);

					final long delayInMillis = 250;
					final Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							progress.dismiss();
						}
					}, delayInMillis);
				} else {
				}
			}
		});
	}
}