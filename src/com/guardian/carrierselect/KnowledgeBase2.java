package com.guardian.carrierselect;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
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
	private TextView kb2resultstitle, kb2subtitle, kb21, kb22, kb23, kb24,
			kb25;
	private int clicked;
	private ProgressDialog progress;
	private static View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.knowledge2, container, false);

		getActivity().getActionBar().setTitle("Knowledge Base");
		// Load in animations.
		final Animation righttoleft = AnimationUtils.loadAnimation(
				rootView.getContext(), R.anim.right_to_left);
		final Animation lefttoright = AnimationUtils.loadAnimation(
				rootView.getContext(), R.anim.left_to_right);

		// Begin startup flow.
		rootView.startAnimation(lefttoright);

		kb2subtitle = (TextView) rootView.findViewById(R.id.kb2subtitle);
		kb2resultstitle = (TextView) rootView
				.findViewById(R.id.kb2resultstitle);
		kb2resultstitle.setText(searchTerm);
		kb2resultstitle.setTypeface(null, Typeface.BOLD);

		// Load results TextViews
		kb21 = (TextView) rootView.findViewById(R.id.kb21);
		kb22 = (TextView) rootView.findViewById(R.id.kb22);
		kb23 = (TextView) rootView.findViewById(R.id.kb23);
		kb24 = (TextView) rootView.findViewById(R.id.kb24);
		kb25 = (TextView) rootView.findViewById(R.id.kb25);

		kb21.setVisibility(View.GONE);
		kb22.setVisibility(View.GONE);
		kb23.setVisibility(View.GONE);
		kb24.setVisibility(View.GONE);
		kb25.setVisibility(View.GONE);

		performSearch();

		kb21.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				clicked = 1;
				rootView.startAnimation(righttoleft);
			}
		});

		kb22.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				clicked = 2;
				rootView.startAnimation(righttoleft);
			}
		});

		kb23.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				clicked = 3;
				rootView.startAnimation(righttoleft);
			}
		});

		kb24.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				clicked = 4;
				rootView.startAnimation(righttoleft);
			}
		});

		kb25.setOnClickListener(new View.OnClickListener() {

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
							KnowledgeBase3.create(kb21.getText().toString()));
					fragmenttran.addToBackStack(null);
					fragmenttran.commit();
					getFragmentManager().executePendingTransactions();

				} else if (clicked == 2) {

					final FragmentTransaction fragmenttran = getFragmentManager()
							.beginTransaction();
					fragmenttran.replace(R.id.fragment_container,
							KnowledgeBase3.create(kb22.getText().toString()));
					fragmenttran.addToBackStack(null);
					fragmenttran.commit();
					getFragmentManager().executePendingTransactions();

				} else if (clicked == 3) {

					final FragmentTransaction fragmenttran = getFragmentManager()
							.beginTransaction();
					fragmenttran.replace(R.id.fragment_container,
							KnowledgeBase3.create(kb23.getText().toString()));
					fragmenttran.addToBackStack(null);
					fragmenttran.commit();
					getFragmentManager().executePendingTransactions();

				} else if (clicked == 4) {

					final FragmentTransaction fragmenttran = getFragmentManager()
							.beginTransaction();
					fragmenttran.replace(R.id.fragment_container,
							KnowledgeBase3.create(kb24.getText().toString()));
					fragmenttran.addToBackStack(null);
					fragmenttran.commit();
					getFragmentManager().executePendingTransactions();

				} else if (clicked == 5) {

					final FragmentTransaction fragmenttran = getFragmentManager()
							.beginTransaction();
					fragmenttran.replace(R.id.fragment_container,
							KnowledgeBase3.create(kb25.getText().toString()));
					fragmenttran.addToBackStack(null);
					fragmenttran.commit();
					getFragmentManager().executePendingTransactions();

				}

			}

			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}

		});

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
		query.setLimit(5);
		query.whereContains("Tag", searchTerm.toLowerCase());
		query.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> PhoneList, ParseException e) {
				progress.dismiss();

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