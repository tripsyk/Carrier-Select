package com.guardian.carrierselect;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class InteractiveAct extends ActionBarActivity {

	private Button savingsCheck;
	private Toolbar toolbar;
	private String[] listItems;
	private ListView mDrawerList;
	private int[] icon;
	private CharSequence mTitle;
	private DrawerLayout drawerLayout;
	private ActionBarDrawerToggle drawerToggle;
	private LinearLayout drawer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.interactive);

		toolbar = (Toolbar) findViewById(R.id.intertool);
		setSupportActionBar(toolbar);

		final SharedPreferences profilepref = getSharedPreferences("profile",
				Context.MODE_PRIVATE);
		final TextView mCarrier = (TextView) findViewById(R.id.carrier);
		final TextView mDevices = (TextView) findViewById(R.id.devices);
		final TextView mData = (TextView) findViewById(R.id.data);
		final TextView mCost = (TextView) findViewById(R.id.cost);
		mDrawerList = (ListView) findViewById(R.id.start_drawer);
		listItems = getResources().getStringArray(R.array.menu_list);
		icon = new int[] { R.drawable.news, R.drawable.myprofile,
				R.drawable.serviceplans, R.drawable.nocontract,
				R.drawable.devicesearch, R.drawable.knowledgebase,
				R.drawable.about };
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawer = (LinearLayout) findViewById(R.id.left_drawer);
		savingsCheck = (Button) findViewById(R.id.savecheck);
		final SharedPreferences settings = getSharedPreferences("MyPrefsFile",
				0);
		final SharedPreferences.Editor editor = settings.edit();
		editor.putBoolean("my_first_time", false);
		editor.commit();

		mDrawerList.setAdapter(new MenuListAdapter(this,
				R.layout.drawer_list_item, listItems, icon));
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		if (toolbar != null) {
			mTitle = "News";
			toolbar.setTitle("News");
			setSupportActionBar(toolbar);
		}

		initDrawer();

		final int carrier = profilepref.getInt("carrier", 0);
		if (carrier == 1) {
			mCarrier.setText("AT&T");
		} else if (carrier == 2) {
			mCarrier.setText("Sprint");
		} else if (carrier == 3) {
			mCarrier.setText("T-Mobile");
		} else if (carrier == 4) {
			mCarrier.setText("Verizon");
		} else if (carrier == 5) {
			mCarrier.setText("Prepaid");
		}

		savingsCheck.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				getSupportActionBar().hide();
			}

		});

		mDevices.setText(String.valueOf(convertWord(profilepref.getString(
				"smart", "Not Set"))
				+ convertWord(profilepref.getString("basic", "Not Set"))
				+ convertWord(profilepref.getString("tabs", "Not Set"))
				+ convertWord(profilepref.getString("mifi", "Not Set"))));
		mCost.setText("$" + profilepref.getString("monthly", "Not Set"));
		mData.setText(profilepref.getString("data", "Not Set"));

		final Fragment fragment = new Home();
		final FragmentTransaction fragmenttran = getSupportFragmentManager()
				.beginTransaction();
		fragmenttran.replace(R.id.fragment_container, fragment);
		fragmenttran.commit();

	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {

			setNavDrawerItemNormal();
			TextView txtview = ((TextView) view.findViewById(R.id.menuTitle));
			txtview.setTypeface(null, Typeface.BOLD);
			txtview.setBackgroundColor(getResources().getColor(
					R.color.backgroundhighlight));
			selectItem(position);

		}

	}

	private void selectItem(int position) {

		if (position == 0) {

			mTitle = (listItems[position]);
			toolbar.setTitle(listItems[position]);
			mDrawerList.setItemChecked(position, true);
			drawerLayout.closeDrawer(drawer);

			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					final Fragment fragment = new Home();
					final FragmentTransaction fragmenttran = getSupportFragmentManager()
							.beginTransaction();
					fragmenttran.setCustomAnimations(R.anim.slide_in_right,
							R.anim.slide_out_left, R.anim.slide_in_left,
							R.anim.slide_out_right);
					fragmenttran.replace(R.id.fragment_container, fragment);
					fragmenttran.addToBackStack(null);
					fragmenttran.commit();
				}
			}, 275);
		} else if (position == 1) {

			mTitle = (listItems[position]);
			toolbar.setTitle(listItems[position]);
			mDrawerList.setItemChecked(position, true);
			drawerLayout.closeDrawer(drawer);

			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					final Fragment fragment = new MyProfile();
					final FragmentTransaction fragmenttran = getSupportFragmentManager()
							.beginTransaction();
					fragmenttran.setCustomAnimations(R.anim.slide_in_right,
							R.anim.slide_out_left, R.anim.slide_in_left,
							R.anim.slide_out_right);
					fragmenttran.replace(R.id.fragment_container, fragment);
					fragmenttran.addToBackStack(null);
					fragmenttran.commit();
				}
			}, 275);
		} else if (position == 2) {

			mTitle = (listItems[position]);
			toolbar.setTitle(listItems[position]);
			mDrawerList.setItemChecked(position, true);
			drawerLayout.closeDrawer(drawer);

			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					final Fragment fragment = new QuoteFragment();
					final FragmentTransaction fragmenttran = getSupportFragmentManager()
							.beginTransaction();
					fragmenttran.setCustomAnimations(R.anim.slide_in_right,
							R.anim.slide_out_left, R.anim.slide_in_left,
							R.anim.slide_out_right);
					fragmenttran.replace(R.id.fragment_container, fragment);
					fragmenttran.addToBackStack(null);
					fragmenttran.commit();
				}
			}, 275);
		} else if (position == 3) {

			mTitle = (listItems[position]);
			toolbar.setTitle(listItems[position]);
			mDrawerList.setItemChecked(position, true);
			drawerLayout.closeDrawer(drawer);

			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					final Fragment fragment = new NoContract1();
					final FragmentTransaction fragmenttran = getSupportFragmentManager()
							.beginTransaction();
					fragmenttran.setCustomAnimations(R.anim.slide_in_right,
							R.anim.slide_out_left, R.anim.slide_in_left,
							R.anim.slide_out_right);
					fragmenttran.replace(R.id.fragment_container, fragment);
					fragmenttran.addToBackStack(null);
					fragmenttran.commit();
				}
			}, 275);
		} else if (position == 4) {

			mTitle = (listItems[position]);
			toolbar.setTitle(listItems[position]);
			mDrawerList.setItemChecked(position, true);
			drawerLayout.closeDrawer(drawer);

			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					final Fragment fragment = new SearchType();
					final FragmentTransaction fragmenttran = getSupportFragmentManager()
							.beginTransaction();
					fragmenttran.setCustomAnimations(R.anim.slide_in_right,
							R.anim.slide_out_left, R.anim.slide_in_left,
							R.anim.slide_out_right);
					fragmenttran.replace(R.id.fragment_container, fragment);
					fragmenttran.addToBackStack(null);
					fragmenttran.commit();
				}
			}, 275);
		} else if (position == 5) {

			mTitle = (listItems[position]);
			toolbar.setTitle(listItems[position]);
			mDrawerList.setItemChecked(position, true);
			drawerLayout.closeDrawer(drawer);

			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					final Fragment fragment = new KnowledgeBase1();
					final FragmentTransaction fragmenttran = getSupportFragmentManager()
							.beginTransaction();
					fragmenttran.setCustomAnimations(R.anim.slide_in_right,
							R.anim.slide_out_left, R.anim.slide_in_left,
							R.anim.slide_out_right);
					fragmenttran.replace(R.id.fragment_container, fragment);
					fragmenttran.addToBackStack(null);
					fragmenttran.commit();
				}
			}, 275);
		} else if (position == 6) {

			mTitle = (listItems[position]);
			toolbar.setTitle(listItems[position]);
			mDrawerList.setItemChecked(position, true);
			drawerLayout.closeDrawer(drawer);

			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					final Fragment fragment = new About();
					final FragmentTransaction fragmenttran = getSupportFragmentManager()
							.beginTransaction();
					fragmenttran.setCustomAnimations(R.anim.slide_in_right,
							R.anim.slide_out_left, R.anim.slide_in_left,
							R.anim.slide_out_right);
					fragmenttran.replace(R.id.fragment_container, fragment);
					fragmenttran.addToBackStack(null);
					fragmenttran.commit();
				}
			}, 275);
		}

	}

	public void setNavDrawerItemNormal() {
		for (int i = 0; i < mDrawerList.getChildCount(); i++) {
			View v = mDrawerList.getChildAt(i);
			TextView txtview = ((TextView) v.findViewById(R.id.menuTitle));
			txtview.setBackgroundColor(getResources().getColor(
					R.color.background));
			txtview.setTypeface(Typeface.DEFAULT);
			txtview.setBackgroundColor(getResources().getColor(
					R.color.background));
		}
	}

	private void initDrawer() {
		// setup navigation drawer
		drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
				R.string.drawer_open, R.string.drawer_close) {
			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
				// when drawer closed
				toolbar.setTitle(mTitle);
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				// when drawer open
				toolbar.setTitle("Carrier Select");
			}
		};

		// setDrawerlisterner
		drawerLayout.setDrawerListener(drawerToggle);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		drawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		drawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getSupportActionBar().setTitle(mTitle);
	}

	private static int convertWord(String word) {
		int number = 0;

		if (word.equals("One")) {
			number = 1;
		} else if (word.equals("Two")) {
			number = 2;
		} else if (word.equals("Three")) {
			number = 3;
		} else if (word.equals("Four")) {
			number = 4;
		} else if (word.equals("Five")) {
			number = 5;
		} else if (word.equals("Six")) {
			number = 6;
		} else if (word.equals("Seven")) {
			number = 7;
		} else if (word.equals("Eight")) {
			number = 8;
		} else if (word.equals("Nine")) {
			number = 9;
		} else if (word.equals("Ten")) {
			number = 10;
		}

		return number;
	}
}
