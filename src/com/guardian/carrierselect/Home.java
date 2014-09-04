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

	private TextView newstitle, news;
	private ProgressDialog progress;
	private static View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.home, container, false);
		
		getActivity().getActionBar().show();

		getActivity().getActionBar().setTitle("News");

		// Load in animations.
		final Animation lefttoright = AnimationUtils.loadAnimation(
				rootView.getContext(), R.anim.left_to_right);

		newstitle = (TextView) rootView.findViewById(R.id.newsupdatetitle);
		news = (TextView) rootView.findViewById(R.id.newsupdates);

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
							+ NewsList.get(0).getString("Date") + "\n");
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
								+ "\n\n");
					}
				} else {
				}
				
				progress.dismiss();
			}
		});

	}
}