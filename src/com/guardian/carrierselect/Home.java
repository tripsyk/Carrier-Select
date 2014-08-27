package com.guardian.carrierselect;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.guardian.carrierselect.model.NewsUpdater;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class Home extends Fragment {

	private TextView newstitle, plantitle, phonetitle, kbtitle, news, plan,
			phone, kb;
	private ProgressDialog progress;
	private static View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.home, container, false);

		getActivity().getActionBar().setTitle("News");

		// Load in animations.
		final Animation lefttoright = AnimationUtils.loadAnimation(
				rootView.getContext(), R.anim.left_to_right);

		newstitle = (TextView) rootView.findViewById(R.id.newsupdatetitle);
		plantitle = (TextView) rootView.findViewById(R.id.planupdatetitle);
		phonetitle = (TextView) rootView.findViewById(R.id.phoneupdatetitle);
		kbtitle = (TextView) rootView.findViewById(R.id.kbupdatetitle);
		news = (TextView) rootView.findViewById(R.id.newsupdates);
		plan = (TextView) rootView.findViewById(R.id.planupdates);
		phone = (TextView) rootView.findViewById(R.id.phoneupdates);
		kb = (TextView) rootView.findViewById(R.id.kbupdates);

		// Begin startup flow.
		rootView.startAnimation(lefttoright);

		initHomeNews();
		return rootView;
	}

	@SuppressLint("DefaultLocale")
	public void initHomeNews() {

		progress = new ProgressDialog(getActivity());
		progress.setTitle("Just a sec...");
		progress.setMessage("Updating your news...");
		progress.show();

		ParseObject.registerSubclass(NewsUpdater.class);
		Parse.initialize(rootView.getContext(),
				"2XacmZEB9hLKANtTk7Rx9ejJipHI3GkmxhVt0Q0y",
				"mAmItywfUeIlMgZCK1LwvQSfneS0SaG1MGqfB65d");

		ParseQuery<ParseObject> querynews = ParseQuery.getQuery("Plan_Promo");
		querynews.whereEqualTo("Tag", "Title");
		querynews.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> NewsList, ParseException e) {

				if (e == null) {
					newstitle.setText("");
					newstitle.setText(NewsList.get(0).getString("Title") + "\n"
							+ NewsList.get(0).getString("Date") + "\n\n"
							+ NewsList.get(0).getString("Subtitle"));
				} else {
				}
			}
		});

		// Test Query
		ParseQuery<ParseObject> queryplanscontent = ParseQuery
				.getQuery("Plan_Promo");
		queryplanscontent.whereEqualTo("Top", "1");
		queryplanscontent.orderByAscending("PromoAdded");
		queryplanscontent.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> NewsList, ParseException e) {

				if (e == null) {

					news.setText("");

					for (int i = 0; i < NewsList.size(); i++) {
						news.setText(news.getText()
								+ NewsList.get(i).getString("PromoAdded")
								+ "\n");
					}
				} else {
				}
			}
		});

		ParseObject.registerSubclass(NewsUpdater.class);
		Parse.initialize(rootView.getContext(),
				"2XacmZEB9hLKANtTk7Rx9ejJipHI3GkmxhVt0Q0y",
				"mAmItywfUeIlMgZCK1LwvQSfneS0SaG1MGqfB65d");

		ParseQuery<ParseObject> queryplans = ParseQuery
				.getQuery("Changes_Plans");
		queryplans.whereEqualTo("Tag", "Title");
		queryplans.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> PlanList, ParseException e) {

				if (e == null) {
					plantitle.setText("");
					plantitle.setText(PlanList.get(0).getString("Title") + "\n"
							+ PlanList.get(0).getString("Date") + "\n\n"
							+ PlanList.get(0).getString("Subtitle"));
				} else {
				}
			}
		});

		// Test Query
		ParseQuery<ParseObject> queryplans2 = ParseQuery
				.getQuery("Changes_Plans");
		queryplans2.whereEqualTo("Top", "1");
		queryplans2.orderByAscending("PlanAdded");
		queryplans2.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> PlanList, ParseException e) {

				if (e == null) {

					plan.setText("");

					for (int i = 0; i < PlanList.size(); i++) {
						plan.setText(plan.getText()
								+ PlanList.get(i).getString("PlanAdded") + "\n");
					}
				} else {
				}
			}
		});

		// Test Query
		ParseQuery<ParseObject> queryphone = ParseQuery.getQuery("Changes_PS");
		queryphone.orderByAscending("PhoneAdded");
		queryphone.whereEqualTo("NewsID", "1");
		queryphone.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> PhoneList, ParseException e) {

				if (e == null) {
					phonetitle.setText("");
					phonetitle.setText(PhoneList.get(0).getString("Title")
							+ "\n" + PhoneList.get(0).getString("Date")
							+ "\n\n" + PhoneList.get(0).getString("Subtitle"));
				} else {
				}
			}
		});

		// Test Query
		ParseQuery<ParseObject> queryphonecontent = ParseQuery
				.getQuery("Changes_PS");
		queryphonecontent.whereEqualTo("NewsID", "11");
		queryphonecontent.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> PhoneList, ParseException e) {

				if (e == null) {

					phone.setText("");

					for (int i = 0; i < PhoneList.size(); i++) {
						phone.setText(phone.getText()
								+ PhoneList.get(i).getString("PhoneAdded")
								+ "\n");
					}
				} else {
				}
			}
		});

		// Test Query
		ParseQuery<ParseObject> querykb = ParseQuery.getQuery("Changes_KB");
		querykb.whereEqualTo("Top", "1");
		querykb.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> KBList, ParseException e) {

				if (e == null) {
					kbtitle.setText("");
					kbtitle.setText(KBList.get(0).getString("Title") + "\n"
							+ KBList.get(0).getString("Date") + "\n\n"
							+ KBList.get(0).getString("Subtitle"));
				} else {
				}
			}
		});

		// Test Query
		ParseQuery<ParseObject> querykbcontent = ParseQuery
				.getQuery("Changes_KB");
		querykbcontent.whereEqualTo("Top", "content");
		querykbcontent.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> KBList, ParseException e) {

				if (e == null) {
					kb.setText("");

					for (int i = 0; i < KBList.size(); i++) {
						kb.setText(kb.getText()
								+ KBList.get(i).getString("KBAdded") + "\n");
					}
				} else {
				}

				progress.dismiss();
			}

		});
	}
}