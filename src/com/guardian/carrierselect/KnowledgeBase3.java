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

public class KnowledgeBase3 extends Fragment {

	private static final String SEARCHTERM = "search_term";
	private String searchTerm;
	private TextView kbtitle, kbdef, kbdef2, kbdefpre, kbex, kbexpre;
	private ProgressDialog progress;
	private static View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.knowledge3, container, false);

		kbtitle = (TextView) rootView.findViewById(R.id.kb3search);
		kbdef = (TextView) rootView.findViewById(R.id.kb3def);
		kbdef2 = (TextView) rootView.findViewById(R.id.kb3def2);
		kbex = (TextView) rootView.findViewById(R.id.kb3ex);

		kbdefpre = (TextView) rootView.findViewById(R.id.kb3defpre);
		kbdefpre.setTypeface(null, Typeface.BOLD);
		kbexpre = (TextView) rootView.findViewById(R.id.kb3expre);
		kbexpre.setTypeface(null, Typeface.BOLD);

		double randomNum = Math.random() * 2;

		if ((int) randomNum == 1)
			AppLovinInterstitialAd.show(getActivity());

		performSearch();

		return rootView;
	}

	@SuppressLint("DefaultLocale")
	public void performSearch() {

		progress = new ProgressDialog(getActivity());
		progress.setTitle("Knowledge Base Search");
		progress.setMessage("Just a sec...");
		progress.show();

		ParseObject.registerSubclass(Phone.class);
		Parse.initialize(rootView.getContext(),
				"2XacmZEB9hLKANtTk7Rx9ejJipHI3GkmxhVt0Q0y",
				"mAmItywfUeIlMgZCK1LwvQSfneS0SaG1MGqfB65d");

		// Test Query
		ParseQuery<ParseObject> query = ParseQuery.getQuery("KnowledgeBase");
		query.whereContains("Title", searchTerm);
		query.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> KBResult, ParseException e) {

				if (e == null) {
					kbtitle.setText(KBResult.get(0).getString("Title"));
					kbdef.setText("\t\t"
							+ KBResult.get(0).getString("Definition"));
					kbdef2.setText("\n" + "\t\t"
							+ KBResult.get(0).getString("Definition2"));
					kbex.setText("\t\t" + KBResult.get(0).getString("Example"));

				} else {
				}

				progress.dismiss();
			}
		});

	}

	public static KnowledgeBase3 create(String searchName) {
		final KnowledgeBase3 fragment = new KnowledgeBase3();

		final Bundle args = new Bundle();

		args.putString(SEARCHTERM, searchName);
		fragment.setArguments(args);

		return fragment;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		final Bundle args = getArguments();

		searchTerm = args.getString(SEARCHTERM);

	}
}