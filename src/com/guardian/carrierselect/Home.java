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
import android.widget.ImageView;
import android.widget.LinearLayout;
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
	private LinearLayout att1, att2, att3, att4, att5, ver1, ver2, ver3, ver4,
			ver5, spr1, spr2, spr3, spr4, spr5, tmo1, tmo2, tmo3, tmo4, tmo5;
	private ImageView ai1, ai2, ai3, ai4, ai5, vi1, vi2, vi3, vi4, vi5, si1,
			si2, si3, si4, si5, ti1, ti2, ti3, ti4, ti5;
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
		att1 = (LinearLayout) rootView.findViewById(R.id.att1);
		att2 = (LinearLayout) rootView.findViewById(R.id.att2);
		att3 = (LinearLayout) rootView.findViewById(R.id.att3);
		att4 = (LinearLayout) rootView.findViewById(R.id.att4);
		att5 = (LinearLayout) rootView.findViewById(R.id.att5);
		ai1 = (ImageView) rootView.findViewById(R.id.atticon1);
		ai2 = (ImageView) rootView.findViewById(R.id.atticon2);
		ai3 = (ImageView) rootView.findViewById(R.id.atticon3);
		ai4 = (ImageView) rootView.findViewById(R.id.atticon4);
		ai5 = (ImageView) rootView.findViewById(R.id.atticon5);
		vernews1 = (TextView) rootView.findViewById(R.id.verupdates1);
		vernews2 = (TextView) rootView.findViewById(R.id.verupdates2);
		vernews3 = (TextView) rootView.findViewById(R.id.verupdates3);
		vernews4 = (TextView) rootView.findViewById(R.id.verupdates4);
		vernews5 = (TextView) rootView.findViewById(R.id.verupdates5);
		ver1 = (LinearLayout) rootView.findViewById(R.id.ver1);
		ver2 = (LinearLayout) rootView.findViewById(R.id.ver2);
		ver3 = (LinearLayout) rootView.findViewById(R.id.ver3);
		ver4 = (LinearLayout) rootView.findViewById(R.id.ver4);
		ver5 = (LinearLayout) rootView.findViewById(R.id.ver5);
		vi1 = (ImageView) rootView.findViewById(R.id.vericon1);
		vi2 = (ImageView) rootView.findViewById(R.id.vericon2);
		vi3 = (ImageView) rootView.findViewById(R.id.vericon3);
		vi4 = (ImageView) rootView.findViewById(R.id.vericon4);
		vi5 = (ImageView) rootView.findViewById(R.id.vericon5);
		sprnews1 = (TextView) rootView.findViewById(R.id.sprupdates1);
		sprnews2 = (TextView) rootView.findViewById(R.id.sprupdates2);
		sprnews3 = (TextView) rootView.findViewById(R.id.sprupdates3);
		sprnews4 = (TextView) rootView.findViewById(R.id.sprupdates4);
		sprnews5 = (TextView) rootView.findViewById(R.id.sprupdates5);
		spr1 = (LinearLayout) rootView.findViewById(R.id.spr1);
		spr2 = (LinearLayout) rootView.findViewById(R.id.spr2);
		spr3 = (LinearLayout) rootView.findViewById(R.id.spr3);
		spr4 = (LinearLayout) rootView.findViewById(R.id.spr4);
		spr5 = (LinearLayout) rootView.findViewById(R.id.spr5);
		si1 = (ImageView) rootView.findViewById(R.id.spricon1);
		si2 = (ImageView) rootView.findViewById(R.id.spricon2);
		si3 = (ImageView) rootView.findViewById(R.id.spricon3);
		si4 = (ImageView) rootView.findViewById(R.id.spricon4);
		si5 = (ImageView) rootView.findViewById(R.id.spricon5);
		tmonews1 = (TextView) rootView.findViewById(R.id.tmoupdates1);
		tmonews2 = (TextView) rootView.findViewById(R.id.tmoupdates2);
		tmonews3 = (TextView) rootView.findViewById(R.id.tmoupdates3);
		tmonews4 = (TextView) rootView.findViewById(R.id.tmoupdates4);
		tmonews5 = (TextView) rootView.findViewById(R.id.tmoupdates5);
		tmo1 = (LinearLayout) rootView.findViewById(R.id.tmo1);
		tmo2 = (LinearLayout) rootView.findViewById(R.id.tmo2);
		tmo3 = (LinearLayout) rootView.findViewById(R.id.tmo3);
		tmo4 = (LinearLayout) rootView.findViewById(R.id.tmo4);
		tmo5 = (LinearLayout) rootView.findViewById(R.id.tmo5);
		ti1 = (ImageView) rootView.findViewById(R.id.tmoicon1);
		ti2 = (ImageView) rootView.findViewById(R.id.tmoicon2);
		ti3 = (ImageView) rootView.findViewById(R.id.tmoicon3);
		ti4 = (ImageView) rootView.findViewById(R.id.tmoicon4);
		ti5 = (ImageView) rootView.findViewById(R.id.tmoicon5);

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
					if (attSize == 0) {

						att1.setVisibility(View.GONE);

						att2.setVisibility(View.GONE);

						att3.setVisibility(View.GONE);

						att4.setVisibility(View.GONE);

						att5.setVisibility(View.GONE);

					} else if (attSize == 1) {

						attnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(ai1, iconer);

						att2.setVisibility(View.GONE);

						att3.setVisibility(View.GONE);

						att4.setVisibility(View.GONE);

						att5.setVisibility(View.GONE);

					} else if (attSize == 2) {

						attnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(ai1, iconer);

						attnews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(ai2, iconer);

						att3.setVisibility(View.GONE);

						att4.setVisibility(View.GONE);

						att5.setVisibility(View.GONE);

					} else if (attSize == 3) {

						attnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(ai1, iconer);

						attnews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(ai2, iconer);

						attnews3.setText(NewsList.get(2)
								.getString("PromoAdded"));
						iconer = NewsList.get(2).getInt("IconType");
						setNewsIcon(ai3, iconer);

						att4.setVisibility(View.GONE);

						att5.setVisibility(View.GONE);

					} else if (attSize == 4) {

						attnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(ai1, iconer);

						attnews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(ai2, iconer);

						attnews3.setText(NewsList.get(2)
								.getString("PromoAdded"));
						iconer = NewsList.get(2).getInt("IconType");
						setNewsIcon(ai3, iconer);

						attnews4.setText(NewsList.get(3)
								.getString("PromoAdded"));
						iconer = NewsList.get(3).getInt("IconType");
						setNewsIcon(ai4, iconer);

						att5.setVisibility(View.GONE);

					} else if (attSize == 5) {

						attnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(ai1, iconer);

						attnews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(ai2, iconer);

						attnews3.setText(NewsList.get(2)
								.getString("PromoAdded"));
						iconer = NewsList.get(2).getInt("IconType");
						setNewsIcon(ai3, iconer);

						attnews4.setText(NewsList.get(3)
								.getString("PromoAdded"));
						iconer = NewsList.get(3).getInt("IconType");
						setNewsIcon(ai4, iconer);

						attnews5.setText(NewsList.get(4)
								.getString("PromoAdded"));
						iconer = NewsList.get(4).getInt("IconType");
						setNewsIcon(ai5, iconer);

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
					if (verSize == 0) {

						ver1.setVisibility(View.GONE);

						ver2.setVisibility(View.GONE);

						ver3.setVisibility(View.GONE);

						ver4.setVisibility(View.GONE);

						ver5.setVisibility(View.GONE);

					} else if (verSize == 1) {

						vernews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(vi1, iconer);

						ver2.setVisibility(View.GONE);

						ver3.setVisibility(View.GONE);

						ver4.setVisibility(View.GONE);

						ver5.setVisibility(View.GONE);

					} else if (verSize == 2) {

						vernews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(vi1, iconer);

						vernews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(vi2, iconer);

						ver3.setVisibility(View.GONE);

						ver4.setVisibility(View.GONE);

						ver5.setVisibility(View.GONE);

					} else if (verSize == 3) {
						vernews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(vi1, iconer);

						vernews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(vi2, iconer);

						vernews3.setText(NewsList.get(2)
								.getString("PromoAdded"));
						iconer = NewsList.get(2).getInt("IconType");
						setNewsIcon(vi3, iconer);

						ver4.setVisibility(View.GONE);

						ver5.setVisibility(View.GONE);

					} else if (verSize == 4) {
						vernews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(vi1, iconer);

						vernews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(vi2, iconer);

						vernews3.setText(NewsList.get(2)
								.getString("PromoAdded"));
						iconer = NewsList.get(2).getInt("IconType");
						setNewsIcon(vi3, iconer);

						vernews4.setText(NewsList.get(3)
								.getString("PromoAdded"));
						iconer = NewsList.get(3).getInt("IconType");
						setNewsIcon(vi4, iconer);

						ver5.setVisibility(View.GONE);

					} else if (verSize == 5) {
						vernews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(vi1, iconer);

						vernews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(vi2, iconer);

						vernews3.setText(NewsList.get(2)
								.getString("PromoAdded"));
						iconer = NewsList.get(2).getInt("IconType");
						setNewsIcon(vi3, iconer);

						vernews4.setText(NewsList.get(3)
								.getString("PromoAdded"));
						iconer = NewsList.get(3).getInt("IconType");
						setNewsIcon(vi4, iconer);

						vernews5.setText(NewsList.get(4)
								.getString("PromoAdded"));
						iconer = NewsList.get(4).getInt("IconType");
						setNewsIcon(vi5, iconer);

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
					if (sprSize == 0) {

						spr1.setVisibility(View.GONE);

						spr2.setVisibility(View.GONE);

						spr3.setVisibility(View.GONE);

						spr4.setVisibility(View.GONE);

						spr5.setVisibility(View.GONE);

					} else if (sprSize == 1) {
						sprnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(si1, iconer);

						spr2.setVisibility(View.GONE);

						spr3.setVisibility(View.GONE);

						spr4.setVisibility(View.GONE);

						spr5.setVisibility(View.GONE);

					} else if (sprSize == 2) {
						sprnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(si1, iconer);

						sprnews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(si2, iconer);

						spr3.setVisibility(View.GONE);

						spr4.setVisibility(View.GONE);

						spr5.setVisibility(View.GONE);

					} else if (sprSize == 3) {
						sprnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(si1, iconer);

						sprnews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(si2, iconer);

						sprnews3.setText(NewsList.get(2)
								.getString("PromoAdded"));
						iconer = NewsList.get(2).getInt("IconType");
						setNewsIcon(si3, iconer);

						spr4.setVisibility(View.GONE);

						spr5.setVisibility(View.GONE);

					} else if (sprSize == 4) {
						sprnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(si1, iconer);

						sprnews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(si2, iconer);

						sprnews3.setText(NewsList.get(2)
								.getString("PromoAdded"));
						iconer = NewsList.get(2).getInt("IconType");
						setNewsIcon(si3, iconer);

						sprnews4.setText(NewsList.get(3)
								.getString("PromoAdded"));
						iconer = NewsList.get(2).getInt("IconType");
						setNewsIcon(si4, iconer);

						spr5.setVisibility(View.GONE);

					} else if (sprSize == 5) {
						sprnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(si1, iconer);

						sprnews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(si2, iconer);

						sprnews3.setText(NewsList.get(2)
								.getString("PromoAdded"));
						iconer = NewsList.get(2).getInt("IconType");
						setNewsIcon(si3, iconer);

						sprnews4.setText(NewsList.get(3)
								.getString("PromoAdded"));
						iconer = NewsList.get(3).getInt("IconType");
						setNewsIcon(si4, iconer);

						sprnews5.setText(NewsList.get(4)
								.getString("PromoAdded"));
						iconer = NewsList.get(4).getInt("IconType");
						setNewsIcon(si5, iconer);

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
					if (tmoSize == 0) {

						tmo1.setVisibility(View.GONE);

						tmo2.setVisibility(View.GONE);

						tmo3.setVisibility(View.GONE);

						tmo4.setVisibility(View.GONE);

						tmo5.setVisibility(View.GONE);

					} else if (tmoSize == 1) {
						tmonews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(ti1, iconer);

						tmo2.setVisibility(View.GONE);

						tmo3.setVisibility(View.GONE);

						tmo4.setVisibility(View.GONE);

						tmo5.setVisibility(View.GONE);

					} else if (tmoSize == 2) {
						tmonews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(ti1, iconer);

						tmonews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(ti2, iconer);

						tmo3.setVisibility(View.GONE);

						tmo4.setVisibility(View.GONE);

						tmo5.setVisibility(View.GONE);

					} else if (tmoSize == 3) {
						tmonews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(ti1, iconer);

						tmonews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(ti2, iconer);

						tmonews3.setText(NewsList.get(2)
								.getString("PromoAdded"));
						iconer = NewsList.get(2).getInt("IconType");
						setNewsIcon(ti3, iconer);

						tmo4.setVisibility(View.GONE);

						tmo5.setVisibility(View.GONE);

					} else if (tmoSize == 4) {
						tmonews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(ti1, iconer);

						tmonews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(ti2, iconer);

						tmonews3.setText(NewsList.get(2)
								.getString("PromoAdded"));
						iconer = NewsList.get(2).getInt("IconType");
						setNewsIcon(ti3, iconer);

						tmonews4.setText(NewsList.get(3)
								.getString("PromoAdded"));
						iconer = NewsList.get(3).getInt("IconType");
						setNewsIcon(ti4, iconer);

						tmo5.setVisibility(View.GONE);

					} else if (tmoSize == 5) {
						tmonews1.setText(NewsList.get(0)
								.getString("PromoAdded"));
						iconer = NewsList.get(0).getInt("IconType");
						setNewsIcon(ti1, iconer);

						tmonews2.setText(NewsList.get(1)
								.getString("PromoAdded"));
						iconer = NewsList.get(1).getInt("IconType");
						setNewsIcon(ti2, iconer);

						tmonews3.setText(NewsList.get(2)
								.getString("PromoAdded"));
						iconer = NewsList.get(2).getInt("IconType");
						setNewsIcon(ti3, iconer);

						tmonews4.setText(NewsList.get(3)
								.getString("PromoAdded"));
						iconer = NewsList.get(3).getInt("IconType");
						setNewsIcon(ti4, iconer);

						tmonews5.setText(NewsList.get(4)
								.getString("PromoAdded"));
						iconer = NewsList.get(4).getInt("IconType");
						setNewsIcon(ti5, iconer);

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

	private void setNewsIcon(ImageView image, int iconId) {
		if (iconId == 0) {
			image.setImageResource(R.drawable.newsmoney);
		} else if (iconId == 1) {
			image.setImageResource(R.drawable.newsdata);
		}
	}
}