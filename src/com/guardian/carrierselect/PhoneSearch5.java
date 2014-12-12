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

public class PhoneSearch5 extends Fragment {

	private String searchTerm;
	private TextView ps2resultstitle, ps2subtitle;
	private Button ps21, ps22, ps23, ps24, ps25;
	private static View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.phonesearch5, container, false);
		final SharedPreferences sharedPref = getActivity()
				.getSharedPreferences("data", Context.MODE_PRIVATE);
		final SharedPreferences.Editor editor = sharedPref.edit();

		searchTerm = sharedPref.getString("ps4", "");
		ps2resultstitle = (TextView) rootView
				.findViewById(R.id.ps2resultstitle);
		ps2resultstitle.setText(searchTerm);
		ps2resultstitle.setTypeface(null, Typeface.BOLD);
		ps2subtitle = (TextView) rootView.findViewById(R.id.ps2subtitle);

		// Load results TextViews
		ps21 = (Button) rootView.findViewById(R.id.ps21);
		ps22 = (Button) rootView.findViewById(R.id.ps22);
		ps23 = (Button) rootView.findViewById(R.id.ps23);
		ps24 = (Button) rootView.findViewById(R.id.ps24);
		ps25 = (Button) rootView.findViewById(R.id.ps25);

		ps21.setVisibility(View.GONE);
		ps22.setVisibility(View.GONE);
		ps23.setVisibility(View.GONE);
		ps24.setVisibility(View.GONE);
		ps25.setVisibility(View.GONE);

		init();

		ps21.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				editor.putString("ps5", ps21.getText().toString());
				editor.commit();

				final Fragment fragment = new PhoneSearch6();

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

		ps22.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				editor.putString("ps5", ps22.getText().toString());
				editor.commit();

				final Fragment fragment = new PhoneSearch6();

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

		ps23.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				editor.putString("ps5", ps23.getText().toString());
				editor.commit();

				final Fragment fragment = new PhoneSearch6();

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

		ps24.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				editor.putString("ps5", ps24.getText().toString());
				editor.commit();

				final Fragment fragment = new PhoneSearch6();

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

		ps25.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				editor.putString("ps5", ps25.getText().toString());
				editor.commit();

				final Fragment fragment = new PhoneSearch6();

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
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Phones");
		query.whereContains("SearchName", searchTerm);
		query.setLimit(5);
		query.orderByAscending("ReleaseOrder");
		query.fromLocalDatastore();
		query.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> PhoneList, ParseException e) {
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

				}
			}
		});
	}

	public void onDestroy() {
		super.onDestroy();
	}

}