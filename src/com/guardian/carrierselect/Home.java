package com.guardian.carrierselect;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guardian.carrierselect.model.NewsUpdaterr;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class Home extends Fragment {

	private TextView attnews1, attnews2, attnews3, attnews4, attnews5,
			vernews1, vernews2, vernews3, vernews4, vernews5, sprnews1,
			sprnews2, sprnews3, sprnews4, sprnews5, tmonews1, tmonews2,
			tmonews3, tmonews4, tmonews5;
	private ProgressDialog progress;
	private static View rootView;
	private int iconer;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.home, container, false);

		attnews1 = (TextView) rootView.findViewById(R.id.attupdates1);
		attnews2 = (TextView) rootView.findViewById(R.id.attupdates2);
		attnews3 = (TextView) rootView.findViewById(R.id.attupdates3);
		attnews4 = (TextView) rootView.findViewById(R.id.attupdates4);
		attnews5 = (TextView) rootView.findViewById(R.id.attupdates5);
		vernews1 = (TextView) rootView.findViewById(R.id.verupdates1);
		vernews2 = (TextView) rootView.findViewById(R.id.verupdates2);
		vernews3 = (TextView) rootView.findViewById(R.id.verupdates3);
		vernews4 = (TextView) rootView.findViewById(R.id.verupdates4);
		vernews5 = (TextView) rootView.findViewById(R.id.verupdates5);
		sprnews1 = (TextView) rootView.findViewById(R.id.sprupdates1);
		sprnews2 = (TextView) rootView.findViewById(R.id.sprupdates2);
		sprnews3 = (TextView) rootView.findViewById(R.id.sprupdates3);
		sprnews4 = (TextView) rootView.findViewById(R.id.sprupdates4);
		sprnews5 = (TextView) rootView.findViewById(R.id.sprupdates5);
		tmonews1 = (TextView) rootView.findViewById(R.id.tmoupdates1);
		tmonews2 = (TextView) rootView.findViewById(R.id.tmoupdates2);
		tmonews3 = (TextView) rootView.findViewById(R.id.tmoupdates3);
		tmonews4 = (TextView) rootView.findViewById(R.id.tmoupdates4);
		tmonews5 = (TextView) rootView.findViewById(R.id.tmoupdates5);

		initHomeNews();

		return rootView;
	}

	@SuppressLint("DefaultLocale")
	public void initHomeNews() {

		progress = new ProgressDialog(getActivity());
		progress.setTitle("Just a sec...");
		progress.setMessage("Updating your news...");
		progress.setCancelable(false);
		progress.show();

		ParseObject.registerSubclass(NewsUpdaterr.class);
		Parse.initialize(rootView.getContext(),
				"2XacmZEB9hLKANtTk7Rx9ejJipHI3GkmxhVt0Q0y",
				"mAmItywfUeIlMgZCK1LwvQSfneS0SaG1MGqfB65d");

		/*
		 * ParseQuery<ParseObject> querynews =
		 * ParseQuery.getQuery("Plan_Promo"); querynews.whereEqualTo("Tag",
		 * "Title"); querynews.findInBackground(new FindCallback<ParseObject>()
		 * { public void done(List<ParseObject> NewsList, ParseException e) {
		 * 
		 * if (e == null) { newstitle.setText("");
		 * newstitle.setText(NewsList.get(0).getString("Title") + "\n" +
		 * NewsList.get(0).getString("Date") + "\n"); } else { } } });
		 */

		// Test Query
		ParseQuery<ParseObject> queryplanscontent = ParseQuery
				.getQuery("Plan_Promo");
		queryplanscontent.whereEqualTo("Carrier", "AT&T");
		queryplanscontent.orderByAscending("PromoAdded");
		queryplanscontent.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> NewsList, ParseException e) {

				if (e == null) {

					attnews1.setText("");
					attnews2.setText("");
					attnews3.setText("");
					attnews4.setText("");
					attnews5.setText("");

					int attSize = NewsList.size();
					if (attSize == 1) {

						attnews1.setVisibility(View.VISIBLE);
						attnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(attnews1, iconer);

					} else if (attSize == 2) {

						attnews1.setVisibility(View.VISIBLE);
						attnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(attnews1, iconer);

						attnews2.setVisibility(View.VISIBLE);
						attnews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(attnews2, iconer);

					} else if (attSize == 3) {

						attnews1.setVisibility(View.VISIBLE);
						attnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(attnews1, iconer);

						attnews2.setVisibility(View.VISIBLE);
						attnews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(attnews2, iconer);

						attnews3.setVisibility(View.VISIBLE);
						attnews3.setText(NewsList.get(2)
								.getString("PromoAdded"));
						iconer = NewsList.get(2).getInt("IconType");
						setNewsIcon(attnews3, iconer);

					} else if (attSize == 4) {

						attnews1.setVisibility(View.VISIBLE);
						attnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(attnews1, iconer);

						attnews2.setVisibility(View.VISIBLE);
						attnews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(attnews2, iconer);

						attnews3.setVisibility(View.VISIBLE);
						attnews3.setText(NewsList.get(2)
								.getString("PromoAdded"));
						iconer = NewsList.get(2).getInt("IconType");
						setNewsIcon(attnews3, iconer);

						attnews4.setVisibility(View.VISIBLE);
						attnews4.setText(NewsList.get(3)
								.getString("PromoAdded"));
						iconer = NewsList.get(3).getInt("IconType");
						setNewsIcon(attnews4, iconer);

					} else if (attSize == 5) {

						attnews1.setVisibility(View.VISIBLE);
						attnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(attnews1, iconer);

						attnews2.setVisibility(View.VISIBLE);
						attnews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(attnews2, iconer);

						attnews3.setVisibility(View.VISIBLE);
						attnews3.setText(NewsList.get(2)
								.getString("PromoAdded"));
						iconer = NewsList.get(2).getInt("IconType");
						setNewsIcon(attnews3, iconer);

						attnews4.setVisibility(View.VISIBLE);
						attnews4.setText(NewsList.get(3)
								.getString("PromoAdded"));
						iconer = NewsList.get(3).getInt("IconType");
						setNewsIcon(attnews4, iconer);

						attnews5.setVisibility(View.VISIBLE);
						attnews5.setText(NewsList.get(4)
								.getString("PromoAdded"));
						iconer = NewsList.get(4).getInt("IconType");
						setNewsIcon(attnews5, iconer);

					}
				} else {
				}
			}
		});

		queryplanscontent = ParseQuery.getQuery("Plan_Promo");
		queryplanscontent.whereEqualTo("Carrier", "Verizon");
		queryplanscontent.orderByAscending("PromoAdded");
		queryplanscontent.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> NewsList, ParseException e) {

				if (e == null) {

					vernews1.setText("");
					vernews2.setText("");
					vernews3.setText("");

					int verSize = NewsList.size();
					if (verSize == 1) {

						vernews1.setVisibility(View.VISIBLE);
						vernews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(vernews1, iconer);

					} else if (verSize == 2) {

						vernews1.setVisibility(View.VISIBLE);
						vernews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(vernews1, iconer);

						vernews2.setVisibility(View.VISIBLE);
						vernews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(vernews2, iconer);

					} else if (verSize == 3) {

						vernews1.setVisibility(View.VISIBLE);
						vernews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(vernews1, iconer);

						vernews2.setVisibility(View.VISIBLE);
						vernews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(vernews2, iconer);

						vernews3.setVisibility(View.VISIBLE);
						vernews3.setText(NewsList.get(2)
								.getString("PromoAdded"));
						iconer = NewsList.get(2).getInt("IconType");
						setNewsIcon(vernews3, iconer);

					} else if (verSize == 4) {

						vernews1.setVisibility(View.VISIBLE);
						vernews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(vernews1, iconer);

						vernews2.setVisibility(View.VISIBLE);
						vernews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(vernews2, iconer);

						vernews3.setVisibility(View.VISIBLE);
						vernews3.setText(NewsList.get(2)
								.getString("PromoAdded"));
						iconer = NewsList.get(2).getInt("IconType");
						setNewsIcon(vernews3, iconer);

						vernews4.setVisibility(View.VISIBLE);
						vernews4.setText(NewsList.get(3)
								.getString("PromoAdded"));
						iconer = NewsList.get(3).getInt("IconType");
						setNewsIcon(vernews4, iconer);

					} else if (verSize == 5) {

						vernews1.setVisibility(View.VISIBLE);
						vernews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(vernews1, iconer);

						vernews2.setVisibility(View.VISIBLE);
						vernews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(vernews2, iconer);

						vernews3.setVisibility(View.VISIBLE);
						vernews3.setText(NewsList.get(2)
								.getString("PromoAdded"));
						iconer = NewsList.get(2).getInt("IconType");
						setNewsIcon(vernews3, iconer);

						vernews4.setVisibility(View.VISIBLE);
						vernews4.setText(NewsList.get(3)
								.getString("PromoAdded"));
						iconer = NewsList.get(3).getInt("IconType");
						setNewsIcon(vernews4, iconer);

						vernews5.setVisibility(View.VISIBLE);
						vernews5.setText(NewsList.get(4)
								.getString("PromoAdded"));
						iconer = NewsList.get(4).getInt("IconType");
						setNewsIcon(vernews5, iconer);

					}
				} else {
				}
			}
		});

		queryplanscontent = ParseQuery.getQuery("Plan_Promo");
		queryplanscontent.whereEqualTo("Carrier", "Sprint");
		queryplanscontent.orderByAscending("PromoAdded");
		queryplanscontent.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> NewsList, ParseException e) {

				if (e == null) {

					sprnews1.setText("");
					sprnews2.setText("");
					sprnews3.setText("");

					int sprSize = NewsList.size();
					if (sprSize == 1) {

						sprnews1.setVisibility(View.VISIBLE);
						sprnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(sprnews1, iconer);

					} else if (sprSize == 2) {

						sprnews1.setVisibility(View.VISIBLE);
						sprnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(sprnews1, iconer);

						sprnews2.setVisibility(View.VISIBLE);
						sprnews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(sprnews2, iconer);

					} else if (sprSize == 3) {

						sprnews1.setVisibility(View.VISIBLE);
						sprnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(sprnews1, iconer);

						sprnews2.setVisibility(View.VISIBLE);
						sprnews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(sprnews2, iconer);

						sprnews3.setVisibility(View.VISIBLE);
						sprnews3.setText(NewsList.get(2)
								.getString("PromoAdded"));
						iconer = NewsList.get(2).getInt("IconType");
						setNewsIcon(sprnews3, iconer);

					} else if (sprSize == 4) {

						sprnews1.setVisibility(View.VISIBLE);
						sprnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(sprnews1, iconer);

						sprnews2.setVisibility(View.VISIBLE);
						sprnews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(sprnews2, iconer);

						sprnews3.setVisibility(View.VISIBLE);
						sprnews3.setText(NewsList.get(2)
								.getString("PromoAdded"));
						iconer = NewsList.get(2).getInt("IconType");
						setNewsIcon(sprnews3, iconer);

						sprnews4.setVisibility(View.VISIBLE);
						sprnews4.setText(NewsList.get(3)
								.getString("PromoAdded"));
						iconer = NewsList.get(3).getInt("IconType");
						setNewsIcon(sprnews4, iconer);

					} else if (sprSize == 5) {

						sprnews1.setVisibility(View.VISIBLE);
						sprnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(sprnews1, iconer);

						sprnews2.setVisibility(View.VISIBLE);
						sprnews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(sprnews2, iconer);

						sprnews3.setVisibility(View.VISIBLE);
						sprnews3.setText(NewsList.get(2)
								.getString("PromoAdded"));
						iconer = NewsList.get(2).getInt("IconType");
						setNewsIcon(sprnews3, iconer);

						sprnews4.setVisibility(View.VISIBLE);
						sprnews4.setText(NewsList.get(3)
								.getString("PromoAdded"));
						iconer = NewsList.get(3).getInt("IconType");
						setNewsIcon(sprnews4, iconer);

						sprnews5.setVisibility(View.VISIBLE);
						sprnews5.setText(NewsList.get(4)
								.getString("PromoAdded"));
						iconer = NewsList.get(4).getInt("IconType");
						setNewsIcon(sprnews5, iconer);

					}
				} else {
				}
			}
		});

		queryplanscontent = ParseQuery.getQuery("Plan_Promo");
		queryplanscontent.whereEqualTo("Carrier", "T-Mobile");
		queryplanscontent.orderByAscending("PromoAdded");
		queryplanscontent.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> NewsList, ParseException e) {

				if (e == null) {

					tmonews1.setText("");
					tmonews2.setText("");
					tmonews3.setText("");

					int tmoSize = NewsList.size();
					if (tmoSize == 1) {

						tmonews1.setVisibility(View.VISIBLE);
						tmonews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(tmonews1, iconer);

					} else if (tmoSize == 2) {

						tmonews1.setVisibility(View.VISIBLE);
						tmonews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(tmonews1, iconer);

						tmonews2.setVisibility(View.VISIBLE);
						tmonews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(tmonews2, iconer);

					} else if (tmoSize == 3) {

						tmonews1.setVisibility(View.VISIBLE);
						tmonews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(tmonews1, iconer);

						tmonews2.setVisibility(View.VISIBLE);
						tmonews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(tmonews2, iconer);

						tmonews3.setVisibility(View.VISIBLE);
						tmonews3.setText(NewsList.get(2)
								.getString("PromoAdded"));
						iconer = NewsList.get(2).getInt("IconType");
						setNewsIcon(tmonews3, iconer);

					} else if (tmoSize == 4) {

						tmonews1.setVisibility(View.VISIBLE);
						tmonews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(tmonews1, iconer);

						tmonews2.setVisibility(View.VISIBLE);
						tmonews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(tmonews2, iconer);

						tmonews3.setVisibility(View.VISIBLE);
						tmonews3.setText(NewsList.get(2)
								.getString("PromoAdded"));
						iconer = NewsList.get(2).getInt("IconType");
						setNewsIcon(tmonews3, iconer);

						tmonews4.setVisibility(View.VISIBLE);
						tmonews4.setText(NewsList.get(3)
								.getString("PromoAdded"));
						iconer = NewsList.get(3).getInt("IconType");
						setNewsIcon(tmonews4, iconer);

					} else if (tmoSize == 5) {

						tmonews1.setVisibility(View.VISIBLE);
						tmonews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(tmonews1, iconer);

						tmonews2.setVisibility(View.VISIBLE);
						tmonews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(tmonews2, iconer);

						tmonews3.setVisibility(View.VISIBLE);
						tmonews3.setText(NewsList.get(2)
								.getString("PromoAdded"));
						iconer = NewsList.get(2).getInt("IconType");
						setNewsIcon(tmonews3, iconer);

						tmonews4.setVisibility(View.VISIBLE);
						tmonews4.setText(NewsList.get(3)
								.getString("PromoAdded"));
						iconer = NewsList.get(3).getInt("IconType");
						setNewsIcon(tmonews4, iconer);

						tmonews5.setVisibility(View.VISIBLE);
						tmonews5.setText(NewsList.get(4)
								.getString("PromoAdded"));
						iconer = NewsList.get(4).getInt("IconType");
						setNewsIcon(tmonews5, iconer);

					}

					final long delayInMillis = 250;
					Timer timer = new Timer();
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

	private void setNewsIcon(TextView tv, int iconId) {
		if (iconId == 0) {
			tv.setCompoundDrawablesWithIntrinsicBounds(0,
					R.drawable.newssavings, 0, 0);
		} else if (iconId == 1) {
			tv.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.newsdata,
					0, 0);
		}
	}
}