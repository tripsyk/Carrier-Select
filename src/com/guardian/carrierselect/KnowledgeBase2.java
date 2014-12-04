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
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.guardian.carrierselect.model.Phone;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class KnowledgeBase2 extends Fragment {

	private static final String SEARCHTERM = "search_term";
	private String searchTerm;
	private TextView kb2resultstitle, kb2subtitle;
	private Button kb21, kb22, kb23, kb24, kb25;
	private ProgressDialog progress;
	private static View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.knowledge2, container, false);

		kb2subtitle = (TextView) rootView.findViewById(R.id.kb2subtitle);
		kb2resultstitle = (TextView) rootView
				.findViewById(R.id.kb2resultstitle);
		kb2resultstitle.setText(searchTerm);
		kb2resultstitle.setTypeface(null, Typeface.BOLD);

		// Load results TextViews
		kb21 = (Button) rootView.findViewById(R.id.kb21);
		kb22 = (Button) rootView.findViewById(R.id.kb22);
		kb23 = (Button) rootView.findViewById(R.id.kb23);
		kb24 = (Button) rootView.findViewById(R.id.kb24);
		kb25 = (Button) rootView.findViewById(R.id.kb25);

		kb21.setVisibility(View.GONE);
		kb22.setVisibility(View.GONE);
		kb23.setVisibility(View.GONE);
		kb24.setVisibility(View.GONE);
		kb25.setVisibility(View.GONE);

		performSearch();

		kb21.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				final FragmentTransaction fragmenttran = getActivity()
						.getSupportFragmentManager().beginTransaction();
				fragmenttran.setCustomAnimations(R.anim.slide_in_right,
						R.anim.slide_out_left, R.anim.slide_in_left,
						R.anim.slide_out_right);
				fragmenttran.replace(R.id.fragment_container,
						KnowledgeBase3.create(kb21.getText().toString()));
				fragmenttran.addToBackStack(null);
				fragmenttran.commit();
			}
		});

		kb22.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				final FragmentTransaction fragmenttran = getActivity()
						.getSupportFragmentManager().beginTransaction();
				fragmenttran.setCustomAnimations(R.anim.slide_in_right,
						R.anim.slide_out_left, R.anim.slide_in_left,
						R.anim.slide_out_right);
				fragmenttran.replace(R.id.fragment_container,
						KnowledgeBase3.create(kb22.getText().toString()));
				fragmenttran.addToBackStack(null);
				fragmenttran.commit();
			}
		});

		kb23.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				final FragmentTransaction fragmenttran = getActivity()
						.getSupportFragmentManager().beginTransaction();
				fragmenttran.setCustomAnimations(R.anim.slide_in_right,
						R.anim.slide_out_left, R.anim.slide_in_left,
						R.anim.slide_out_right);
				fragmenttran.replace(R.id.fragment_container,
						KnowledgeBase3.create(kb23.getText().toString()));
				fragmenttran.addToBackStack(null);
				fragmenttran.commit();
			}
		});

		kb24.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				final FragmentTransaction fragmenttran = getActivity()
						.getSupportFragmentManager().beginTransaction();
				fragmenttran.setCustomAnimations(R.anim.slide_in_right,
						R.anim.slide_out_left, R.anim.slide_in_left,
						R.anim.slide_out_right);
				fragmenttran.replace(R.id.fragment_container,
						KnowledgeBase3.create(kb24.getText().toString()));
				fragmenttran.addToBackStack(null);
				fragmenttran.commit();
			}
		});

		kb25.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				final FragmentTransaction fragmenttran = getActivity()
						.getSupportFragmentManager().beginTransaction();
				fragmenttran.setCustomAnimations(R.anim.slide_in_right,
						R.anim.slide_out_left, R.anim.slide_in_left,
						R.anim.slide_out_right);
				fragmenttran.replace(R.id.fragment_container,
						KnowledgeBase3.create(kb25.getText().toString()));
				fragmenttran.addToBackStack(null);
				fragmenttran.commit();
			}
		});

		return rootView;
	}

	@SuppressLint("DefaultLocale")
	public void performSearch() {

		progress = new ProgressDialog(getActivity(),
				AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
		progress.setTitle("Knowledge Base Search");
		progress.setMessage("Just a sec...");
		progress.setCancelable(false);
		progress.show();

		ParseObject.registerSubclass(Phone.class);
		Parse.initialize(rootView.getContext(),
				"2XacmZEB9hLKANtTk7Rx9ejJipHI3GkmxhVt0Q0y",
				"mAmItywfUeIlMgZCK1LwvQSfneS0SaG1MGqfB65d");

		// Test Query
		ParseQuery<ParseObject> query = ParseQuery.getQuery("KnowledgeBase");
		query.setLimit(5);
		query.whereContains("Tag", searchTerm.toLowerCase());
		query.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> PhoneList, ParseException e) {

				if (e == null) {
					if (PhoneList.size() == 1) {
						kb21.setText(PhoneList.get(0).getString("Title"));
						kb2subtitle.setText("Showing " + PhoneList.size()
								+ " results for");

						kb21.setVisibility(View.VISIBLE);
					} else if (PhoneList.size() == 2) {
						kb21.setText(PhoneList.get(0).getString("Title"));
						kb22.setText(PhoneList.get(1).getString("Title"));
						kb2subtitle.setText("Showing " + PhoneList.size()
								+ " results for");

						kb21.setVisibility(View.VISIBLE);
						kb22.setVisibility(View.VISIBLE);
					} else if (PhoneList.size() == 3) {
						kb21.setText(PhoneList.get(0).getString("Title"));
						kb22.setText(PhoneList.get(1).getString("Title"));
						kb23.setText(PhoneList.get(2).getString("Title"));
						kb2subtitle.setText("Showing " + PhoneList.size()
								+ " results for");

						kb21.setVisibility(View.VISIBLE);
						kb22.setVisibility(View.VISIBLE);
						kb23.setVisibility(View.VISIBLE);
					} else if (PhoneList.size() == 4) {
						kb21.setText(PhoneList.get(0).getString("Title"));
						kb22.setText(PhoneList.get(1).getString("Title"));
						kb23.setText(PhoneList.get(2).getString("Title"));
						kb24.setText(PhoneList.get(3).getString("Title"));
						kb2subtitle.setText("Showing " + PhoneList.size()
								+ " results for");

						kb21.setVisibility(View.VISIBLE);
						kb22.setVisibility(View.VISIBLE);
						kb23.setVisibility(View.VISIBLE);
						kb24.setVisibility(View.VISIBLE);
					} else if (PhoneList.size() == 5) {
						kb21.setText(PhoneList.get(0).getString("Title"));
						kb22.setText(PhoneList.get(1).getString("Title"));
						kb23.setText(PhoneList.get(2).getString("Title"));
						kb24.setText(PhoneList.get(3).getString("Title"));
						kb25.setText(PhoneList.get(4).getString("Title"));
						kb2subtitle.setText("Showing top 5 results for");

						kb21.setVisibility(View.VISIBLE);
						kb22.setVisibility(View.VISIBLE);
						kb23.setVisibility(View.VISIBLE);
						kb24.setVisibility(View.VISIBLE);
						kb25.setVisibility(View.VISIBLE);
					}

					final Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							progress.dismiss();
						}
					}, 200);

				} else {
					kb21.setText("No term found.");
				}
			}
		});

	}

	public static KnowledgeBase2 create(String searchName) {
		final KnowledgeBase2 fragment = new KnowledgeBase2();

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

	public void onDestroy() {
		super.onDestroy();
	}

}