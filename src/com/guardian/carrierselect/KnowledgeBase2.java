package com.guardian.carrierselect;

import java.util.List;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class KnowledgeBase2 extends Fragment {

	private String searchTerm;
	private TextView kb2resultstitle, kb2subtitle;
	private Button kb21, kb22, kb23, kb24, kb25;
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
		final SharedPreferences sharedPref = getActivity()
				.getSharedPreferences("data", Context.MODE_PRIVATE);
		final SharedPreferences.Editor editor = sharedPref.edit();
		searchTerm = sharedPref.getString("kb1", "");

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

		init();

		kb21.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				editor.putString("kb2", kb21.getText().toString());
				editor.commit();

				final Fragment fragment = new KnowledgeBase3();

				final FragmentTransaction fragmenttran = getActivity()
						.getSupportFragmentManager().beginTransaction();
				fragmenttran.setCustomAnimations(R.anim.slide_in_right,
						R.anim.slide_out_left, R.anim.slide_in_left,
						R.anim.slide_out_right);
				fragmenttran.replace(R.id.fragment_container, fragment);
				fragmenttran.addToBackStack(null);
				fragmenttran.commit();
			}
		});

		kb22.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				final Fragment fragment = new KnowledgeBase3();

				editor.putString("kb2", kb22.getText().toString());
				editor.commit();

				final FragmentTransaction fragmenttran = getActivity()
						.getSupportFragmentManager().beginTransaction();
				fragmenttran.setCustomAnimations(R.anim.slide_in_right,
						R.anim.slide_out_left, R.anim.slide_in_left,
						R.anim.slide_out_right);
				fragmenttran.replace(R.id.fragment_container, fragment);
				fragmenttran.addToBackStack(null);
				fragmenttran.commit();
			}
		});

		kb23.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				final Fragment fragment = new KnowledgeBase3();

				editor.putString("kb2", kb23.getText().toString());
				editor.commit();

				final FragmentTransaction fragmenttran = getActivity()
						.getSupportFragmentManager().beginTransaction();
				fragmenttran.setCustomAnimations(R.anim.slide_in_right,
						R.anim.slide_out_left, R.anim.slide_in_left,
						R.anim.slide_out_right);
				fragmenttran.replace(R.id.fragment_container, fragment);
				fragmenttran.addToBackStack(null);
				fragmenttran.commit();
			}
		});

		kb24.setOnClickListener(new View.OnClickListener() {

			final Fragment fragment = new KnowledgeBase3();

			@Override
			public void onClick(View view) {

				editor.putString("kb2", kb24.getText().toString());
				editor.commit();

				final FragmentTransaction fragmenttran = getActivity()
						.getSupportFragmentManager().beginTransaction();
				fragmenttran.setCustomAnimations(R.anim.slide_in_right,
						R.anim.slide_out_left, R.anim.slide_in_left,
						R.anim.slide_out_right);
				fragmenttran.replace(R.id.fragment_container, fragment);
				fragmenttran.addToBackStack(null);
				fragmenttran.commit();
			}
		});

		kb25.setOnClickListener(new View.OnClickListener() {

			final Fragment fragment = new KnowledgeBase3();

			@Override
			public void onClick(View view) {

				editor.putString("kb2", kb25.getText().toString());
				editor.commit();

				final FragmentTransaction fragmenttran = getActivity()
						.getSupportFragmentManager().beginTransaction();
				fragmenttran.setCustomAnimations(R.anim.slide_in_right,
						R.anim.slide_out_left, R.anim.slide_in_left,
						R.anim.slide_out_right);
				fragmenttran.replace(R.id.fragment_container, fragment);
				fragmenttran.addToBackStack(null);
				fragmenttran.commit();
			}
		});

		return rootView;
	}

	private void init() {
		ParseQuery<ParseObject> query = ParseQuery.getQuery("KnowledgeBase");
		query.whereContains("Tag", searchTerm);
		query.setLimit(5);
		query.fromLocalDatastore();
		query.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> PhoneList, ParseException e) {

				if (e == null) {
					if (PhoneList.size() == 1) {

						kb21.setText(PhoneList.get(0).getString("Title"));
						kb2subtitle.setText("Showing " + PhoneList.size()
								+ " result for:");

						kb21.setVisibility(View.VISIBLE);
					} else if (PhoneList.size() == 2) {
						kb21.setText(PhoneList.get(0).getString("Title"));
						kb22.setText(PhoneList.get(1).getString("Title"));
						kb2subtitle.setText("Showing " + PhoneList.size()
								+ " results for:");

						kb21.setVisibility(View.VISIBLE);
						kb22.setVisibility(View.VISIBLE);
					} else if (PhoneList.size() == 3) {
						kb21.setText(PhoneList.get(0).getString("Title"));
						kb22.setText(PhoneList.get(1).getString("Title"));
						kb23.setText(PhoneList.get(2).getString("Title"));
						kb2subtitle.setText("Showing " + PhoneList.size()
								+ " results for:");

						kb21.setVisibility(View.VISIBLE);
						kb22.setVisibility(View.VISIBLE);
						kb23.setVisibility(View.VISIBLE);
					} else if (PhoneList.size() == 4) {
						kb21.setText(PhoneList.get(0).getString("Title"));
						kb22.setText(PhoneList.get(1).getString("Title"));
						kb23.setText(PhoneList.get(2).getString("Title"));
						kb24.setText(PhoneList.get(3).getString("Title"));
						kb2subtitle.setText("Showing " + PhoneList.size()
								+ " results for:");

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
						kb2subtitle.setText("Showing top 5 results for:");

						kb21.setVisibility(View.VISIBLE);
						kb22.setVisibility(View.VISIBLE);
						kb23.setVisibility(View.VISIBLE);
						kb24.setVisibility(View.VISIBLE);
						kb25.setVisibility(View.VISIBLE);
					}

				} else {

				}
			}
		});
	}

	public void onDestroy() {
		super.onDestroy();
	}

}