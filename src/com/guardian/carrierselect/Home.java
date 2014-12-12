package com.guardian.carrierselect;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class Home extends Fragment {

	private static TextView attnews1, attnews2, attnews3, attnews4, attnews5,
			vernews1, vernews2, vernews3, vernews4, vernews5, sprnews1,
			sprnews2, sprnews3, sprnews4, sprnews5, tmonews1, tmonews2,
			tmonews3, tmonews4, tmonews5, prenews1, prenews2, prenews3,
			prenews4, prenews5, devnews1, devnews2, devnews3, devnews4,
			devnews5;
	private ProgressDialog progress;
	private static View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.home, container, false);

		initHomeNews();

		return rootView;
	}

	@SuppressLint("DefaultLocale")
	public void initHomeNews() {

		progress = new ProgressDialog(getActivity(),
				AlertDialog.THEME_DEVICE_DEFAULT_DARK);
		progress.setTitle("Just a sec...");
		progress.setMessage("Updating your news...");
		progress.setCancelable(false);
		progress.show();

		ParseQuery<ParseObject> queryplanscontent = ParseQuery
				.getQuery("Plan_Promo");
		queryplanscontent.whereEqualTo("Carrier", "AT&T");
		queryplanscontent.orderByAscending("PromoAdded");
		queryplanscontent.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> NewsList, ParseException e) {

				if (e == null) {

					final int attSize = NewsList.size();
					if (attSize == 1) {

						attnews1 = (TextView) rootView
								.findViewById(R.id.attupdates1);

						attnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

					} else if (attSize == 2) {

						attnews1 = (TextView) rootView
								.findViewById(R.id.attupdates1);
						attnews2 = (TextView) rootView
								.findViewById(R.id.attupdates2);

						attnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

						attnews2.setVisibility(View.VISIBLE);
						attnews2.setText(NewsList.get(1)
								.getString("PromoAdded"));

					} else if (attSize == 3) {

						attnews1 = (TextView) rootView
								.findViewById(R.id.attupdates1);
						attnews2 = (TextView) rootView
								.findViewById(R.id.attupdates2);
						attnews3 = (TextView) rootView
								.findViewById(R.id.attupdates3);

						attnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

						attnews2.setVisibility(View.VISIBLE);
						attnews2.setText(NewsList.get(1)
								.getString("PromoAdded"));

						attnews3.setVisibility(View.VISIBLE);
						attnews3.setText(NewsList.get(2)
								.getString("PromoAdded"));

					} else if (attSize == 4) {

						attnews1 = (TextView) rootView
								.findViewById(R.id.attupdates1);
						attnews2 = (TextView) rootView
								.findViewById(R.id.attupdates2);
						attnews3 = (TextView) rootView
								.findViewById(R.id.attupdates3);
						attnews4 = (TextView) rootView
								.findViewById(R.id.attupdates4);

						attnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

						attnews2.setVisibility(View.VISIBLE);
						attnews2.setText(NewsList.get(1)
								.getString("PromoAdded"));

						attnews3.setVisibility(View.VISIBLE);
						attnews3.setText(NewsList.get(2)
								.getString("PromoAdded"));

						attnews4.setVisibility(View.VISIBLE);
						attnews4.setText(NewsList.get(3)
								.getString("PromoAdded"));

					} else if (attSize == 5) {

						attnews1 = (TextView) rootView
								.findViewById(R.id.attupdates1);
						attnews2 = (TextView) rootView
								.findViewById(R.id.attupdates2);
						attnews3 = (TextView) rootView
								.findViewById(R.id.attupdates3);
						attnews4 = (TextView) rootView
								.findViewById(R.id.attupdates4);
						attnews5 = (TextView) rootView
								.findViewById(R.id.attupdates5);

						attnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

						attnews2.setVisibility(View.VISIBLE);
						attnews2.setText(NewsList.get(1)
								.getString("PromoAdded"));

						attnews3.setVisibility(View.VISIBLE);
						attnews3.setText(NewsList.get(2)
								.getString("PromoAdded"));

						attnews4.setVisibility(View.VISIBLE);
						attnews4.setText(NewsList.get(3)
								.getString("PromoAdded"));

						attnews5.setVisibility(View.VISIBLE);
						attnews5.setText(NewsList.get(4)
								.getString("PromoAdded"));

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

					final int verSize = NewsList.size();
					if (verSize == 1) {

						vernews1 = (TextView) rootView
								.findViewById(R.id.verupdates1);

						vernews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

					} else if (verSize == 2) {

						vernews1 = (TextView) rootView
								.findViewById(R.id.verupdates1);
						vernews2 = (TextView) rootView
								.findViewById(R.id.verupdates2);

						vernews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

						vernews2.setVisibility(View.VISIBLE);
						vernews2.setText(NewsList.get(1)
								.getString("PromoAdded"));

					} else if (verSize == 3) {

						vernews1 = (TextView) rootView
								.findViewById(R.id.verupdates1);
						vernews2 = (TextView) rootView
								.findViewById(R.id.verupdates2);
						vernews3 = (TextView) rootView
								.findViewById(R.id.verupdates3);

						vernews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

						vernews2.setVisibility(View.VISIBLE);
						vernews2.setText(NewsList.get(1)
								.getString("PromoAdded"));

						vernews3.setVisibility(View.VISIBLE);
						vernews3.setText(NewsList.get(2)
								.getString("PromoAdded"));

					} else if (verSize == 4) {

						vernews1 = (TextView) rootView
								.findViewById(R.id.verupdates1);
						vernews2 = (TextView) rootView
								.findViewById(R.id.verupdates2);
						vernews3 = (TextView) rootView
								.findViewById(R.id.verupdates3);
						vernews4 = (TextView) rootView
								.findViewById(R.id.verupdates4);

						vernews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

						vernews2.setVisibility(View.VISIBLE);
						vernews2.setText(NewsList.get(1)
								.getString("PromoAdded"));

						vernews3.setVisibility(View.VISIBLE);
						vernews3.setText(NewsList.get(2)
								.getString("PromoAdded"));

						vernews4.setVisibility(View.VISIBLE);
						vernews4.setText(NewsList.get(3)
								.getString("PromoAdded"));

					} else if (verSize == 5) {

						vernews1 = (TextView) rootView
								.findViewById(R.id.verupdates1);
						vernews2 = (TextView) rootView
								.findViewById(R.id.verupdates2);
						vernews3 = (TextView) rootView
								.findViewById(R.id.verupdates3);
						vernews4 = (TextView) rootView
								.findViewById(R.id.verupdates4);
						vernews5 = (TextView) rootView
								.findViewById(R.id.verupdates5);

						vernews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

						vernews2.setVisibility(View.VISIBLE);
						vernews2.setText(NewsList.get(1)
								.getString("PromoAdded"));

						vernews3.setVisibility(View.VISIBLE);
						vernews3.setText(NewsList.get(2)
								.getString("PromoAdded"));

						vernews4.setVisibility(View.VISIBLE);
						vernews4.setText(NewsList.get(3)
								.getString("PromoAdded"));

						vernews5.setVisibility(View.VISIBLE);
						vernews5.setText(NewsList.get(4)
								.getString("PromoAdded"));

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

					final int sprSize = NewsList.size();
					if (sprSize == 1) {

						sprnews1 = (TextView) rootView
								.findViewById(R.id.sprupdates1);

						sprnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

					} else if (sprSize == 2) {

						sprnews1 = (TextView) rootView
								.findViewById(R.id.sprupdates1);
						sprnews2 = (TextView) rootView
								.findViewById(R.id.sprupdates2);

						sprnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

						sprnews2.setVisibility(View.VISIBLE);
						sprnews2.setText(NewsList.get(1)
								.getString("PromoAdded"));

					} else if (sprSize == 3) {

						sprnews1 = (TextView) rootView
								.findViewById(R.id.sprupdates1);
						sprnews2 = (TextView) rootView
								.findViewById(R.id.sprupdates2);
						sprnews3 = (TextView) rootView
								.findViewById(R.id.sprupdates3);

						sprnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

						sprnews2.setVisibility(View.VISIBLE);
						sprnews2.setText(NewsList.get(1)
								.getString("PromoAdded"));

						sprnews3.setVisibility(View.VISIBLE);
						sprnews3.setText(NewsList.get(2)
								.getString("PromoAdded"));

					} else if (sprSize == 4) {

						sprnews1 = (TextView) rootView
								.findViewById(R.id.sprupdates1);
						sprnews2 = (TextView) rootView
								.findViewById(R.id.sprupdates2);
						sprnews3 = (TextView) rootView
								.findViewById(R.id.sprupdates3);
						sprnews4 = (TextView) rootView
								.findViewById(R.id.sprupdates4);

						sprnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

						sprnews2.setVisibility(View.VISIBLE);
						sprnews2.setText(NewsList.get(1)
								.getString("PromoAdded"));

						sprnews3.setVisibility(View.VISIBLE);
						sprnews3.setText(NewsList.get(2)
								.getString("PromoAdded"));

						sprnews4.setVisibility(View.VISIBLE);
						sprnews4.setText(NewsList.get(3)
								.getString("PromoAdded"));

					} else if (sprSize == 5) {

						sprnews1 = (TextView) rootView
								.findViewById(R.id.sprupdates1);
						sprnews2 = (TextView) rootView
								.findViewById(R.id.sprupdates2);
						sprnews3 = (TextView) rootView
								.findViewById(R.id.sprupdates3);
						sprnews4 = (TextView) rootView
								.findViewById(R.id.sprupdates4);
						sprnews5 = (TextView) rootView
								.findViewById(R.id.sprupdates5);

						sprnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

						sprnews2.setVisibility(View.VISIBLE);
						sprnews2.setText(NewsList.get(1)
								.getString("PromoAdded"));

						sprnews3.setVisibility(View.VISIBLE);
						sprnews3.setText(NewsList.get(2)
								.getString("PromoAdded"));

						sprnews4.setVisibility(View.VISIBLE);
						sprnews4.setText(NewsList.get(3)
								.getString("PromoAdded"));

						sprnews5.setVisibility(View.VISIBLE);
						sprnews5.setText(NewsList.get(4)
								.getString("PromoAdded"));

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

					final int tmoSize = NewsList.size();
					if (tmoSize == 1) {

						tmonews1 = (TextView) rootView
								.findViewById(R.id.tmoupdates1);

						tmonews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

					} else if (tmoSize == 2) {

						tmonews1 = (TextView) rootView
								.findViewById(R.id.tmoupdates1);
						tmonews2 = (TextView) rootView
								.findViewById(R.id.tmoupdates2);

						tmonews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

						tmonews2.setVisibility(View.VISIBLE);
						tmonews2.setText(NewsList.get(1)
								.getString("PromoAdded"));

					} else if (tmoSize == 3) {

						tmonews1 = (TextView) rootView
								.findViewById(R.id.tmoupdates1);
						tmonews2 = (TextView) rootView
								.findViewById(R.id.tmoupdates2);
						tmonews3 = (TextView) rootView
								.findViewById(R.id.tmoupdates3);

						tmonews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

						tmonews2.setVisibility(View.VISIBLE);
						tmonews2.setText(NewsList.get(1)
								.getString("PromoAdded"));

						tmonews3.setVisibility(View.VISIBLE);
						tmonews3.setText(NewsList.get(2)
								.getString("PromoAdded"));

					} else if (tmoSize == 4) {

						tmonews1 = (TextView) rootView
								.findViewById(R.id.tmoupdates1);
						tmonews2 = (TextView) rootView
								.findViewById(R.id.tmoupdates2);
						tmonews3 = (TextView) rootView
								.findViewById(R.id.tmoupdates3);
						tmonews4 = (TextView) rootView
								.findViewById(R.id.tmoupdates4);

						tmonews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

						tmonews2.setVisibility(View.VISIBLE);
						tmonews2.setText(NewsList.get(1)
								.getString("PromoAdded"));

						tmonews3.setVisibility(View.VISIBLE);
						tmonews3.setText(NewsList.get(2)
								.getString("PromoAdded"));

						tmonews4.setVisibility(View.VISIBLE);
						tmonews4.setText(NewsList.get(3)
								.getString("PromoAdded"));

					} else if (tmoSize == 5) {

						tmonews1 = (TextView) rootView
								.findViewById(R.id.tmoupdates1);
						tmonews2 = (TextView) rootView
								.findViewById(R.id.tmoupdates2);
						tmonews3 = (TextView) rootView
								.findViewById(R.id.tmoupdates3);
						tmonews4 = (TextView) rootView
								.findViewById(R.id.tmoupdates4);
						tmonews5 = (TextView) rootView
								.findViewById(R.id.tmoupdates5);

						tmonews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

						tmonews2.setVisibility(View.VISIBLE);
						tmonews2.setText(NewsList.get(1)
								.getString("PromoAdded"));

						tmonews3.setVisibility(View.VISIBLE);
						tmonews3.setText(NewsList.get(2)
								.getString("PromoAdded"));

						tmonews4.setVisibility(View.VISIBLE);
						tmonews4.setText(NewsList.get(3)
								.getString("PromoAdded"));

						tmonews5.setVisibility(View.VISIBLE);
						tmonews5.setText(NewsList.get(4)
								.getString("PromoAdded"));

					}

				} else {
				}
			}
		});

		queryplanscontent = ParseQuery.getQuery("Plan_Promo");
		queryplanscontent.whereEqualTo("Carrier", "Prepaid");
		queryplanscontent.orderByAscending("PromoAdded");
		queryplanscontent.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> NewsList, ParseException e) {

				if (e == null) {

					final int preSize = NewsList.size();
					if (preSize == 1) {

						prenews1 = (TextView) rootView
								.findViewById(R.id.preupdates1);

						prenews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

					} else if (preSize == 2) {

						prenews1 = (TextView) rootView
								.findViewById(R.id.preupdates1);
						prenews2 = (TextView) rootView
								.findViewById(R.id.preupdates2);

						prenews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

						prenews2.setVisibility(View.VISIBLE);
						prenews2.setText(NewsList.get(1)
								.getString("PromoAdded"));

					} else if (preSize == 3) {

						prenews1 = (TextView) rootView
								.findViewById(R.id.preupdates1);
						prenews2 = (TextView) rootView
								.findViewById(R.id.preupdates2);
						prenews3 = (TextView) rootView
								.findViewById(R.id.preupdates3);

						prenews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

						prenews2.setVisibility(View.VISIBLE);
						prenews2.setText(NewsList.get(1)
								.getString("PromoAdded"));

						prenews3.setVisibility(View.VISIBLE);
						prenews3.setText(NewsList.get(2)
								.getString("PromoAdded"));

					} else if (preSize == 4) {

						prenews1 = (TextView) rootView
								.findViewById(R.id.preupdates1);
						prenews2 = (TextView) rootView
								.findViewById(R.id.preupdates2);
						prenews3 = (TextView) rootView
								.findViewById(R.id.preupdates3);
						prenews4 = (TextView) rootView
								.findViewById(R.id.preupdates4);

						prenews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

						prenews2.setVisibility(View.VISIBLE);
						prenews2.setText(NewsList.get(1)
								.getString("PromoAdded"));

						prenews3.setVisibility(View.VISIBLE);
						prenews3.setText(NewsList.get(2)
								.getString("PromoAdded"));

						prenews4.setVisibility(View.VISIBLE);
						prenews4.setText(NewsList.get(3)
								.getString("PromoAdded"));

					} else if (preSize == 5) {

						prenews1 = (TextView) rootView
								.findViewById(R.id.preupdates1);
						prenews2 = (TextView) rootView
								.findViewById(R.id.preupdates2);
						prenews3 = (TextView) rootView
								.findViewById(R.id.preupdates3);
						prenews4 = (TextView) rootView
								.findViewById(R.id.preupdates4);
						prenews5 = (TextView) rootView
								.findViewById(R.id.preupdates5);

						prenews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

						prenews2.setVisibility(View.VISIBLE);
						prenews2.setText(NewsList.get(1)
								.getString("PromoAdded"));

						prenews3.setVisibility(View.VISIBLE);
						prenews3.setText(NewsList.get(2)
								.getString("PromoAdded"));

						prenews4.setVisibility(View.VISIBLE);
						prenews4.setText(NewsList.get(3)
								.getString("PromoAdded"));

						prenews5.setVisibility(View.VISIBLE);
						prenews5.setText(NewsList.get(4)
								.getString("PromoAdded"));

					}
				} else {
				}
			}
		});

		queryplanscontent = ParseQuery.getQuery("Plan_Promo");
		queryplanscontent.whereEqualTo("Carrier", "Device");
		queryplanscontent.orderByAscending("PromoAdded");
		queryplanscontent.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> NewsList, ParseException e) {

				if (e == null) {

					final int devSize = NewsList.size();
					if (devSize == 1) {

						devnews1 = (TextView) rootView
								.findViewById(R.id.devupdates1);

						devnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

					} else if (devSize == 2) {

						devnews1 = (TextView) rootView
								.findViewById(R.id.devupdates1);
						devnews2 = (TextView) rootView
								.findViewById(R.id.devupdates2);

						devnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

						devnews2.setVisibility(View.VISIBLE);
						devnews2.setText(NewsList.get(1)
								.getString("PromoAdded"));

					} else if (devSize == 3) {

						devnews1 = (TextView) rootView
								.findViewById(R.id.devupdates1);
						devnews2 = (TextView) rootView
								.findViewById(R.id.devupdates2);
						devnews3 = (TextView) rootView
								.findViewById(R.id.devupdates3);

						devnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

						devnews2.setVisibility(View.VISIBLE);
						devnews2.setText(NewsList.get(1)
								.getString("PromoAdded"));

						devnews3.setVisibility(View.VISIBLE);
						devnews3.setText(NewsList.get(2)
								.getString("PromoAdded"));

					} else if (devSize == 4) {

						devnews1 = (TextView) rootView
								.findViewById(R.id.devupdates1);
						devnews2 = (TextView) rootView
								.findViewById(R.id.devupdates2);
						devnews3 = (TextView) rootView
								.findViewById(R.id.devupdates3);
						devnews4 = (TextView) rootView
								.findViewById(R.id.devupdates4);

						devnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

						devnews2.setVisibility(View.VISIBLE);
						devnews2.setText(NewsList.get(1)
								.getString("PromoAdded"));

						devnews3.setVisibility(View.VISIBLE);
						devnews3.setText(NewsList.get(2)
								.getString("PromoAdded"));

						devnews4.setVisibility(View.VISIBLE);
						devnews4.setText(NewsList.get(3)
								.getString("PromoAdded"));

					} else if (devSize == 5) {

						devnews1 = (TextView) rootView
								.findViewById(R.id.devupdates1);
						devnews2 = (TextView) rootView
								.findViewById(R.id.devupdates2);
						devnews3 = (TextView) rootView
								.findViewById(R.id.devupdates3);
						devnews4 = (TextView) rootView
								.findViewById(R.id.devupdates4);
						devnews5 = (TextView) rootView
								.findViewById(R.id.devupdates5);

						devnews1.setText(NewsList.get(0)
								.getString("PromoAdded"));

						devnews2.setVisibility(View.VISIBLE);
						devnews2.setText(NewsList.get(1)
								.getString("PromoAdded"));

						devnews3.setVisibility(View.VISIBLE);
						devnews3.setText(NewsList.get(2)
								.getString("PromoAdded"));

						devnews4.setVisibility(View.VISIBLE);
						devnews4.setText(NewsList.get(3)
								.getString("PromoAdded"));

						devnews5.setVisibility(View.VISIBLE);
						devnews5.setText(NewsList.get(4)
								.getString("PromoAdded"));

					}

					progress.dismiss();
				} else {
				}
			}
		});
	}
}