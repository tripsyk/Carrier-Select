package com.guardian.carrierselect;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.applovin.adview.AppLovinInterstitialAd;
import com.guardian.carrierselect.model.Phone;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class PhoneSearch2 extends Fragment {

	private static final String SEARCHTERM = "search_term";
	private String searchTerm;
	private TextView ps2resultstitle, ps2subtitle, ps21, ps22, ps23, ps24,
			ps25;
	private ProgressDialog progress;
	private int clicked;
	private static View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.phonesearch2, container, false);
		getActivity().getActionBar().show();

		ps2resultstitle = (TextView) rootView
				.findViewById(R.id.ps2resultstitle);
		ps2resultstitle.setText(searchTerm);
		ps2subtitle = (TextView) rootView.findViewById(R.id.ps2subtitle);

		// Load results TextViews
		ps21 = (TextView) rootView.findViewById(R.id.ps21);
		ps22 = (TextView) rootView.findViewById(R.id.ps22);
		ps23 = (TextView) rootView.findViewById(R.id.ps23);
		ps24 = (TextView) rootView.findViewById(R.id.ps24);
		ps25 = (TextView) rootView.findViewById(R.id.ps25);

		ps21.setVisibility(View.GONE);
		ps22.setVisibility(View.GONE);
		ps23.setVisibility(View.GONE);
		ps24.setVisibility(View.GONE);
		ps25.setVisibility(View.GONE);

		// Load in animations.
		final Animation righttoleft = AnimationUtils.loadAnimation(
				rootView.getContext(), R.anim.right_to_left);

		performSearch();

		ps21.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				clicked = 1;
				rootView.startAnimation(righttoleft);
			}
		});

		ps22.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				clicked = 2;
				rootView.startAnimation(righttoleft);
			}
		});

		ps23.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				clicked = 3;
				rootView.startAnimation(righttoleft);
			}
		});

		ps24.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				clicked = 4;
				rootView.startAnimation(righttoleft);
			}
		});

		ps25.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				clicked = 5;
				rootView.startAnimation(righttoleft);
			}
		});

		righttoleft.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationEnd(Animation arg0) {

				if (clicked == 1) {

					final FragmentTransaction fragmenttran = getFragmentManager()
							.beginTransaction();
					fragmenttran.replace(R.id.fragment_container,
							PhoneSearch3.create(ps21.getText().toString()));
					fragmenttran.addToBackStack(null);
					fragmenttran.commit();
					getFragmentManager().executePendingTransactions();

				} else if (clicked == 2) {

					final FragmentTransaction fragmenttran = getFragmentManager()
							.beginTransaction();
					fragmenttran.replace(R.id.fragment_container,
							PhoneSearch3.create(ps22.getText().toString()));
					fragmenttran.addToBackStack(null);
					fragmenttran.commit();
					getFragmentManager().executePendingTransactions();

				} else if (clicked == 3) {

					final FragmentTransaction fragmenttran = getFragmentManager()
							.beginTransaction();
					fragmenttran.replace(R.id.fragment_container,
							PhoneSearch3.create(ps23.getText().toString()));
					fragmenttran.addToBackStack(null);
					fragmenttran.commit();
					getFragmentManager().executePendingTransactions();

				} else if (clicked == 4) {

					final FragmentTransaction fragmenttran = getFragmentManager()
							.beginTransaction();
					fragmenttran.replace(R.id.fragment_container,
							PhoneSearch3.create(ps24.getText().toString()));
					fragmenttran.addToBackStack(null);
					fragmenttran.commit();
					getFragmentManager().executePendingTransactions();

				} else if (clicked == 5) {

					final FragmentTransaction fragmenttran = getFragmentManager()
							.beginTransaction();
					fragmenttran.replace(R.id.fragment_container,
							PhoneSearch3.create(ps25.getText().toString()));
					fragmenttran.addToBackStack(null);
					fragmenttran.commit();
					getFragmentManager().executePendingTransactions();

				}

			}

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}

		});

		return rootView;
	}

	@SuppressLint("DefaultLocale")
	public void performSearch() {

		progress = new ProgressDialog(getActivity());
		progress.setTitle("Phone Search");
		progress.setMessage("Just a sec...");
		progress.show();

		ParseObject.registerSubclass(Phone.class);
		Parse.initialize(rootView.getContext(),
				"2XacmZEB9hLKANtTk7Rx9ejJipHI3GkmxhVt0Q0y",
				"mAmItywfUeIlMgZCK1LwvQSfneS0SaG1MGqfB65d");

		// Test Query
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Phones");
		query.setLimit(5);
		query.orderByAscending("ReleaseOrder");
		query.whereContains("SearchName", searchTerm.toLowerCase());
		query.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> PhoneList, ParseException e) {
				progress.dismiss();

				if (e == null) {
					if (PhoneList.size() == 1) {
						ps21.setText(PhoneList.get(0).getString("Name"));
						ps2subtitle.setText("Showing " + PhoneList.size()
								+ " results for");

						ps21.setVisibility(View.VISIBLE);
					} else if (PhoneList.size() == 2) {
						ps21.setText(PhoneList.get(0).getString("Name"));
						ps22.setText(PhoneList.get(1).getString("Name"));
						ps2subtitle.setText("Showing " + PhoneList.size()
								+ " results for");

						ps21.setVisibility(View.VISIBLE);
						ps22.setVisibility(View.VISIBLE);
					} else if (PhoneList.size() == 3) {
						ps21.setText(PhoneList.get(0).getString("Name"));
						ps22.setText(PhoneList.get(1).getString("Name"));
						ps23.setText(PhoneList.get(2).getString("Name"));
						ps2subtitle.setText("Showing " + PhoneList.size()
								+ " results for");

						ps21.setVisibility(View.VISIBLE);
						ps22.setVisibility(View.VISIBLE);
						ps23.setVisibility(View.VISIBLE);
					} else if (PhoneList.size() == 4) {
						ps21.setText(PhoneList.get(0).getString("Name"));
						ps22.setText(PhoneList.get(1).getString("Name"));
						ps23.setText(PhoneList.get(2).getString("Name"));
						ps24.setText(PhoneList.get(3).getString("Name"));
						ps2subtitle.setText("Showing " + PhoneList.size()
								+ " results for");

						ps21.setVisibility(View.VISIBLE);
						ps22.setVisibility(View.VISIBLE);
						ps23.setVisibility(View.VISIBLE);
						ps24.setVisibility(View.VISIBLE);
					} else if (PhoneList.size() == 5) {
						ps21.setText(PhoneList.get(0).getString("Name"));
						ps22.setText(PhoneList.get(1).getString("Name"));
						ps23.setText(PhoneList.get(2).getString("Name"));
						ps24.setText(PhoneList.get(3).getString("Name"));
						ps25.setText(PhoneList.get(4).getString("Name"));
						ps2subtitle.setText("Showing top 5 results for");

						ps21.setVisibility(View.VISIBLE);
						ps22.setVisibility(View.VISIBLE);
						ps23.setVisibility(View.VISIBLE);
						ps24.setVisibility(View.VISIBLE);
						ps25.setVisibility(View.VISIBLE);
					}
				} else {
					ps21.setText("No phone found.");
				}
			}
		});

	}

	public static PhoneSearch2 create(String searchName) {
		final PhoneSearch2 fragment = new PhoneSearch2();

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