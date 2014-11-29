package com.guardian.carrierselect;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.applovin.adview.AppLovinInterstitialAd;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class NoContract2 extends Fragment {

	private ProgressDialog progress;
	private View rootView;
	private String carrier;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.nocontract2, container, false);

		double randomNum = Math.random() * 3;

		if ((int) randomNum == 1)
			AppLovinInterstitialAd.show(getActivity());

		final SharedPreferences sharedPref = getActivity().getPreferences(
				Context.MODE_PRIVATE);

		carrier = sharedPref.getString("nc1carrier", "");
		final TextView title = (TextView) rootView
				.findViewById(R.id.nocontractsub);
		title.setText(carrier);
		title.setTypeface(null, Typeface.BOLD);

		grabPlans();
		return rootView;

	}

	public void grabPlans() {

		progress = new ProgressDialog(getActivity());
		progress.setTitle("Looking up plans");
		progress.setMessage("Just a sec...");
		progress.setCancelable(false);
		progress.show();

		// Test Query
		ParseQuery<ParseObject> querypre = ParseQuery.getQuery("Prepaid");
		querypre.orderByAscending("Price");
		querypre.whereContains("Carrier", carrier);
		querypre.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> PlanList, ParseException e) {

				final CardView nc22box2 = (CardView) rootView
						.findViewById(R.id.nc22card);
				final CardView nc23box2 = (CardView) rootView
						.findViewById(R.id.nc23card);
				final CardView nc24box2 = (CardView) rootView
						.findViewById(R.id.nc24card);
				final CardView nc25box2 = (CardView) rootView
						.findViewById(R.id.nc25card);
				final CardView nc26box2 = (CardView) rootView
						.findViewById(R.id.nc26card);
				final CardView nc27box2 = (CardView) rootView
						.findViewById(R.id.nc27card);
				final TextView nc21title = (TextView) rootView
						.findViewById(R.id.nc21title);
				final TextView nc22title = (TextView) rootView
						.findViewById(R.id.nc22title);
				final TextView nc23title = (TextView) rootView
						.findViewById(R.id.nc23title);
				final TextView nc24title = (TextView) rootView
						.findViewById(R.id.nc24title);
				final TextView nc25title = (TextView) rootView
						.findViewById(R.id.nc25title);
				final TextView nc26title = (TextView) rootView
						.findViewById(R.id.nc26title);
				final TextView nc27title = (TextView) rootView
						.findViewById(R.id.nc27title);
				final TextView nc21sb = (TextView) rootView
						.findViewById(R.id.nc21sb);
				final TextView nc22sb = (TextView) rootView
						.findViewById(R.id.nc22sb);
				final TextView nc23sb = (TextView) rootView
						.findViewById(R.id.nc23sb);
				final TextView nc24sb = (TextView) rootView
						.findViewById(R.id.nc24sb);
				final TextView nc25sb = (TextView) rootView
						.findViewById(R.id.nc25sb);
				final TextView nc26sb = (TextView) rootView
						.findViewById(R.id.nc26sb);
				final TextView nc27sb = (TextView) rootView
						.findViewById(R.id.nc27sb);
				final TextView nc21min = (TextView) rootView
						.findViewById(R.id.nc21min);
				final TextView nc22min = (TextView) rootView
						.findViewById(R.id.nc22min);
				final TextView nc23min = (TextView) rootView
						.findViewById(R.id.nc23min);
				final TextView nc24min = (TextView) rootView
						.findViewById(R.id.nc24min);
				final TextView nc25min = (TextView) rootView
						.findViewById(R.id.nc25min);
				final TextView nc26min = (TextView) rootView
						.findViewById(R.id.nc26min);
				final TextView nc27min = (TextView) rootView
						.findViewById(R.id.nc27min);
				final TextView nc21text = (TextView) rootView
						.findViewById(R.id.nc21text);
				final TextView nc22text = (TextView) rootView
						.findViewById(R.id.nc22text);
				final TextView nc23text = (TextView) rootView
						.findViewById(R.id.nc23text);
				final TextView nc24text = (TextView) rootView
						.findViewById(R.id.nc24text);
				final TextView nc25text = (TextView) rootView
						.findViewById(R.id.nc25text);
				final TextView nc26text = (TextView) rootView
						.findViewById(R.id.nc26text);
				final TextView nc27text = (TextView) rootView
						.findViewById(R.id.nc27text);
				final TextView nc21data = (TextView) rootView
						.findViewById(R.id.nc21data);
				final TextView nc22data = (TextView) rootView
						.findViewById(R.id.nc22data);
				final TextView nc23data = (TextView) rootView
						.findViewById(R.id.nc23data);
				final TextView nc24data = (TextView) rootView
						.findViewById(R.id.nc24data);
				final TextView nc25data = (TextView) rootView
						.findViewById(R.id.nc25data);
				final TextView nc26data = (TextView) rootView
						.findViewById(R.id.nc26data);
				final TextView nc27data = (TextView) rootView
						.findViewById(R.id.nc27data);
				final TextView nc21throttle = (TextView) rootView
						.findViewById(R.id.nc21throttle);
				final TextView nc22throttle = (TextView) rootView
						.findViewById(R.id.nc22throttle);
				final TextView nc23throttle = (TextView) rootView
						.findViewById(R.id.nc23throttle);
				final TextView nc24throttle = (TextView) rootView
						.findViewById(R.id.nc24throttle);
				final TextView nc25throttle = (TextView) rootView
						.findViewById(R.id.nc25throttle);
				final TextView nc26throttle = (TextView) rootView
						.findViewById(R.id.nc26throttle);
				final TextView nc27throttle = (TextView) rootView
						.findViewById(R.id.nc27throttle);
				final TextView ncnetwork = (TextView) rootView
						.findViewById(R.id.ncnetwork);

				if (e == null) {

					ncnetwork.setText(PlanList.get(0).getString("Network"));

					// Set Visibility based on size of carriers returned
					if (PlanList.size() == 1) {
						nc22box2.setVisibility(View.GONE);
						nc23box2.setVisibility(View.GONE);
						nc24box2.setVisibility(View.GONE);
						nc25box2.setVisibility(View.GONE);
						nc26box2.setVisibility(View.GONE);
						nc27box2.setVisibility(View.GONE);
						nc22title.setVisibility(View.GONE);
						nc23title.setVisibility(View.GONE);
						nc24title.setVisibility(View.GONE);
						nc25title.setVisibility(View.GONE);
						nc26title.setVisibility(View.GONE);
						nc27title.setVisibility(View.GONE);

						nc21title.setText(PlanList.get(0).getString("Name"));
						nc21sb.setText(PlanList.get(0).getString("PhoneType"));
						nc21min.setText(PlanList.get(0).getString("Minutes"));
						nc21text.setText(PlanList.get(0).getString("Text"));
						nc21data.setText(PlanList.get(0).getString("Data"));
						nc21throttle.setText(PlanList.get(0).getString(
								"Throttle"));

					}

					if (PlanList.size() == 2) {
						nc23box2.setVisibility(View.GONE);
						nc24box2.setVisibility(View.GONE);
						nc25box2.setVisibility(View.GONE);
						nc26box2.setVisibility(View.GONE);
						nc27box2.setVisibility(View.GONE);
						nc23title.setVisibility(View.GONE);
						nc24title.setVisibility(View.GONE);
						nc25title.setVisibility(View.GONE);
						nc26title.setVisibility(View.GONE);
						nc27title.setVisibility(View.GONE);

						nc21title.setText(PlanList.get(0).getString("Name"));
						nc21sb.setText(PlanList.get(0).getString("PhoneType"));
						nc21min.setText(PlanList.get(0).getString("Minutes"));
						nc21text.setText(PlanList.get(0).getString("Text"));
						nc21data.setText(PlanList.get(0).getString("Data"));
						nc21throttle.setText(PlanList.get(0).getString(
								"Throttle"));

						nc22title.setText(PlanList.get(1).getString("Name"));
						nc22sb.setText(PlanList.get(1).getString("PhoneType"));
						nc22min.setText(PlanList.get(1).getString("Minutes"));
						nc22text.setText(PlanList.get(1).getString("Text"));
						nc22data.setText(PlanList.get(1).getString("Data"));
						nc22throttle.setText(PlanList.get(1).getString(
								"Throttle"));
					}

					if (PlanList.size() == 3) {
						nc24box2.setVisibility(View.GONE);
						nc25box2.setVisibility(View.GONE);
						nc26box2.setVisibility(View.GONE);
						nc27box2.setVisibility(View.GONE);
						nc24title.setVisibility(View.GONE);
						nc25title.setVisibility(View.GONE);
						nc26title.setVisibility(View.GONE);
						nc27title.setVisibility(View.GONE);

						nc21title.setText(PlanList.get(0).getString("Name"));
						nc21sb.setText(PlanList.get(0).getString("PhoneType"));
						nc21min.setText(PlanList.get(0).getString("Minutes"));
						nc21text.setText(PlanList.get(0).getString("Text"));
						nc21data.setText(PlanList.get(0).getString("Data"));
						nc21throttle.setText(PlanList.get(0).getString(
								"Throttle"));

						nc22title.setText(PlanList.get(1).getString("Name"));
						nc22sb.setText(PlanList.get(1).getString("PhoneType"));
						nc22min.setText(PlanList.get(1).getString("Minutes"));
						nc22text.setText(PlanList.get(1).getString("Text"));
						nc22data.setText(PlanList.get(1).getString("Data"));
						nc22throttle.setText(PlanList.get(1).getString(
								"Throttle"));

						nc23title.setText(PlanList.get(2).getString("Name"));
						nc23sb.setText(PlanList.get(2).getString("PhoneType"));
						nc23min.setText(PlanList.get(2).getString("Minutes"));
						nc23text.setText(PlanList.get(2).getString("Text"));
						nc23data.setText(PlanList.get(2).getString("Data"));
						nc23throttle.setText(PlanList.get(2).getString(
								"Throttle"));
					}

					if (PlanList.size() == 4) {
						nc25box2.setVisibility(View.GONE);
						nc26box2.setVisibility(View.GONE);
						nc27box2.setVisibility(View.GONE);
						nc25title.setVisibility(View.GONE);
						nc26title.setVisibility(View.GONE);
						nc27title.setVisibility(View.GONE);

						nc21title.setText(PlanList.get(0).getString("Name"));
						nc21sb.setText(PlanList.get(0).getString("PhoneType"));
						nc21min.setText(PlanList.get(0).getString("Minutes"));
						nc21text.setText(PlanList.get(0).getString("Text"));
						nc21data.setText(PlanList.get(0).getString("Data"));
						nc21throttle.setText(PlanList.get(0).getString(
								"Throttle"));

						nc22title.setText(PlanList.get(1).getString("Name"));
						nc22sb.setText(PlanList.get(1).getString("PhoneType"));
						nc22min.setText(PlanList.get(1).getString("Minutes"));
						nc22text.setText(PlanList.get(1).getString("Text"));
						nc22data.setText(PlanList.get(1).getString("Data"));
						nc22throttle.setText(PlanList.get(1).getString(
								"Throttle"));

						nc23title.setText(PlanList.get(2).getString("Name"));
						nc23sb.setText(PlanList.get(2).getString("PhoneType"));
						nc23min.setText(PlanList.get(2).getString("Minutes"));
						nc23text.setText(PlanList.get(2).getString("Text"));
						nc23data.setText(PlanList.get(2).getString("Data"));
						nc23throttle.setText(PlanList.get(2).getString(
								"Throttle"));

						nc24title.setText(PlanList.get(3).getString("Name"));
						nc24sb.setText(PlanList.get(3).getString("PhoneType"));
						nc24min.setText(PlanList.get(3).getString("Minutes"));
						nc24text.setText(PlanList.get(3).getString("Text"));
						nc24data.setText(PlanList.get(3).getString("Data"));
						nc24throttle.setText(PlanList.get(3).getString(
								"Throttle"));
					}

					if (PlanList.size() == 5) {
						nc26box2.setVisibility(View.GONE);
						nc27box2.setVisibility(View.GONE);
						nc26title.setVisibility(View.GONE);
						nc27title.setVisibility(View.GONE);

						nc21title.setText(PlanList.get(0).getString("Name"));
						nc21sb.setText(PlanList.get(0).getString("PhoneType"));
						nc21min.setText(PlanList.get(0).getString("Minutes"));
						nc21text.setText(PlanList.get(0).getString("Text"));
						nc21data.setText(PlanList.get(0).getString("Data"));
						nc21throttle.setText(PlanList.get(0).getString(
								"Throttle"));

						nc22title.setText(PlanList.get(1).getString("Name"));
						nc22sb.setText(PlanList.get(1).getString("PhoneType"));
						nc22min.setText(PlanList.get(1).getString("Minutes"));
						nc22text.setText(PlanList.get(1).getString("Text"));
						nc22data.setText(PlanList.get(1).getString("Data"));
						nc22throttle.setText(PlanList.get(1).getString(
								"Throttle"));

						nc23title.setText(PlanList.get(2).getString("Name"));
						nc23sb.setText(PlanList.get(2).getString("PhoneType"));
						nc23min.setText(PlanList.get(2).getString("Minutes"));
						nc23text.setText(PlanList.get(2).getString("Text"));
						nc23data.setText(PlanList.get(2).getString("Data"));
						nc23throttle.setText(PlanList.get(2).getString(
								"Throttle"));

						nc24title.setText(PlanList.get(3).getString("Name"));
						nc24sb.setText(PlanList.get(3).getString("PhoneType"));
						nc24min.setText(PlanList.get(3).getString("Minutes"));
						nc24text.setText(PlanList.get(3).getString("Text"));
						nc24data.setText(PlanList.get(3).getString("Data"));
						nc24throttle.setText(PlanList.get(3).getString(
								"Throttle"));

						nc25title.setText(PlanList.get(4).getString("Name"));
						nc25sb.setText(PlanList.get(4).getString("PhoneType"));
						nc25min.setText(PlanList.get(4).getString("Minutes"));
						nc25text.setText(PlanList.get(4).getString("Text"));
						nc25data.setText(PlanList.get(4).getString("Data"));
						nc25throttle.setText(PlanList.get(4).getString(
								"Throttle"));
					}

					if (PlanList.size() == 6) {
						nc27box2.setVisibility(View.GONE);
						nc27title.setVisibility(View.GONE);

						nc21title.setText(PlanList.get(0).getString("Name"));
						nc21sb.setText(PlanList.get(0).getString("PhoneType"));
						nc21min.setText(PlanList.get(0).getString("Minutes"));
						nc21text.setText(PlanList.get(0).getString("Text"));
						nc21data.setText(PlanList.get(0).getString("Data"));
						nc21throttle.setText(PlanList.get(0).getString(
								"Throttle"));

						nc22title.setText(PlanList.get(1).getString("Name"));
						nc22sb.setText(PlanList.get(1).getString("PhoneType"));
						nc22min.setText(PlanList.get(1).getString("Minutes"));
						nc22text.setText(PlanList.get(1).getString("Text"));
						nc22data.setText(PlanList.get(1).getString("Data"));
						nc22throttle.setText(PlanList.get(1).getString(
								"Throttle"));

						nc23title.setText(PlanList.get(2).getString("Name"));
						nc23sb.setText(PlanList.get(2).getString("PhoneType"));
						nc23min.setText(PlanList.get(2).getString("Minutes"));
						nc23text.setText(PlanList.get(2).getString("Text"));
						nc23data.setText(PlanList.get(2).getString("Data"));
						nc23throttle.setText(PlanList.get(2).getString(
								"Throttle"));

						nc24title.setText(PlanList.get(3).getString("Name"));
						nc24sb.setText(PlanList.get(3).getString("PhoneType"));
						nc24min.setText(PlanList.get(3).getString("Minutes"));
						nc24text.setText(PlanList.get(3).getString("Text"));
						nc24data.setText(PlanList.get(3).getString("Data"));
						nc24throttle.setText(PlanList.get(3).getString(
								"Throttle"));

						nc25title.setText(PlanList.get(4).getString("Name"));
						nc25sb.setText(PlanList.get(4).getString("PhoneType"));
						nc25min.setText(PlanList.get(4).getString("Minutes"));
						nc25text.setText(PlanList.get(4).getString("Text"));
						nc25data.setText(PlanList.get(4).getString("Data"));
						nc25throttle.setText(PlanList.get(4).getString(
								"Throttle"));

						nc26title.setText(PlanList.get(5).getString("Name"));
						nc26sb.setText(PlanList.get(5).getString("PhoneType"));
						nc26min.setText(PlanList.get(5).getString("Minutes"));
						nc26text.setText(PlanList.get(5).getString("Text"));
						nc26data.setText(PlanList.get(5).getString("Data"));
						nc26throttle.setText(PlanList.get(5).getString(
								"Throttle"));
					}

					if (PlanList.size() == 7) {

						nc21title.setText(PlanList.get(0).getString("Name"));
						nc21sb.setText(PlanList.get(0).getString("PhoneType"));
						nc21min.setText(PlanList.get(0).getString("Minutes"));
						nc21text.setText(PlanList.get(0).getString("Text"));
						nc21data.setText(PlanList.get(0).getString("Data"));
						nc21throttle.setText(PlanList.get(0).getString(
								"Throttle"));

						nc22title.setText(PlanList.get(1).getString("Name"));
						nc22sb.setText(PlanList.get(1).getString("PhoneType"));
						nc22min.setText(PlanList.get(1).getString("Minutes"));
						nc22text.setText(PlanList.get(1).getString("Text"));
						nc22data.setText(PlanList.get(1).getString("Data"));
						nc22throttle.setText(PlanList.get(1).getString(
								"Throttle"));

						nc23title.setText(PlanList.get(2).getString("Name"));
						nc23sb.setText(PlanList.get(2).getString("PhoneType"));
						nc23min.setText(PlanList.get(2).getString("Minutes"));
						nc23text.setText(PlanList.get(2).getString("Text"));
						nc23data.setText(PlanList.get(2).getString("Data"));
						nc23throttle.setText(PlanList.get(2).getString(
								"Throttle"));

						nc24title.setText(PlanList.get(3).getString("Name"));
						nc24sb.setText(PlanList.get(3).getString("PhoneType"));
						nc24min.setText(PlanList.get(3).getString("Minutes"));
						nc24text.setText(PlanList.get(3).getString("Text"));
						nc24data.setText(PlanList.get(3).getString("Data"));
						nc24throttle.setText(PlanList.get(3).getString(
								"Throttle"));

						nc25title.setText(PlanList.get(4).getString("Name"));
						nc25sb.setText(PlanList.get(4).getString("PhoneType"));
						nc25min.setText(PlanList.get(4).getString("Minutes"));
						nc25text.setText(PlanList.get(4).getString("Text"));
						nc25data.setText(PlanList.get(4).getString("Data"));
						nc25throttle.setText(PlanList.get(4).getString(
								"Throttle"));

						nc26title.setText(PlanList.get(5).getString("Name"));
						nc26sb.setText(PlanList.get(5).getString("PhoneType"));
						nc26min.setText(PlanList.get(5).getString("Minutes"));
						nc26text.setText(PlanList.get(5).getString("Text"));
						nc26data.setText(PlanList.get(5).getString("Data"));
						nc26throttle.setText(PlanList.get(5).getString(
								"Throttle"));

						nc27title.setText(PlanList.get(6).getString("Name"));
						nc27sb.setText(PlanList.get(6).getString("PhoneType"));
						nc27min.setText(PlanList.get(6).getString("Minutes"));
						nc27text.setText(PlanList.get(6).getString("Text"));
						nc27data.setText(PlanList.get(6).getString("Data"));
						nc27throttle.setText(PlanList.get(6).getString(
								"Throttle"));
					}

					final long delayInMillis = 250;
					Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							progress.dismiss();
						}
					}, delayInMillis);

				}
			}
		});
	}

	public void onDestroy() {
		super.onDestroy();
	}

}