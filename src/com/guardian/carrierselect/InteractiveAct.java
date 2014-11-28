package com.guardian.carrierselect;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class InteractiveAct extends ActionBarActivity {

	private String[] listItems;
	private DrawerLayout mDrawerLayout;
	private LinearLayout mDrawer;
	private ListView mDrawerList;
	private ActionBarHelper mActionBar;
	private ActionBarDrawerToggle mDrawerToggle;
	private int[] icon;
	private TextView mCarrier, mDevices, mData, mCost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.interactive);

		mCarrier = (TextView) findViewById(R.id.carrier);
		mDevices = (TextView) findViewById(R.id.devices);
		mData = (TextView) findViewById(R.id.data);
		mCost = (TextView) findViewById(R.id.cost);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawer = (LinearLayout) findViewById(R.id.left_drawer);
		mDrawerList = (ListView) findViewById(R.id.start_drawer);
		mDrawerLayout.setDrawerListener(new DemoDrawerListener());
		listItems = getResources().getStringArray(R.array.menu_list);
		icon = new int[] { R.drawable.news, R.drawable.myprofile,
				R.drawable.service_plans, R.drawable.nocontract,
				R.drawable.phonesearch2, R.drawable.knowledgebase,
				R.drawable.about };

		mDrawerLayout.setDrawerTitle(GravityCompat.START,
				getString(R.string.drawer_title));
		mDrawerList.setAdapter(new MenuListAdapter(this,
				R.layout.drawer_list_item, listItems, icon));
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		mActionBar = createActionBarHelper();
		mActionBar.init();
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.string.drawer_open, R.string.drawer_close);
		
		final String PREFS_NAME = "MyPrefsFile";
		final SharedPreferences settings = getSharedPreferences(
				PREFS_NAME, 0);
		final SharedPreferences.Editor editor = settings.edit();
		editor.putBoolean("my_first_time", false);
		editor.commit();

		initHomePrefs();

		final Fragment fragment = new Home();
		final FragmentTransaction fragmenttran = getFragmentManager()
				.beginTransaction();
		fragmenttran.replace(R.id.fragment_container, fragment);
		fragmenttran.commit();

	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {

		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (mDrawerToggle.onOptionsItemSelected(item)) {

			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {

		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {

			setNavDrawerItemNormal();
			TextView txtview = ((TextView) view.findViewById(R.id.menuTitle));
			txtview.setTypeface(null, Typeface.BOLD);
			txtview.setTextColor(getResources().getColor(android.R.color.black));
			txtview.getTextColors();

			selectItem(position);

			mActionBar.setTitle(listItems[position]);
			mDrawerLayout.closeDrawer(mDrawer);

		}

	}

	private void selectItem(int position) {

		if (position == 0) {

			final Fragment fragment = new Home();
			final FragmentTransaction fragmenttran = getFragmentManager()
					.beginTransaction();
			fragmenttran.replace(R.id.fragment_container, fragment);
			fragmenttran.addToBackStack(null);
			fragmenttran.commit();
			getFragmentManager().executePendingTransactions();
			mDrawerList.setItemChecked(position, true);
			mDrawerLayout.closeDrawer(mDrawer);
		} else if (position == 1) {

			final Fragment fragment = new MyProfile();
			final FragmentTransaction fragmenttran = getFragmentManager()
					.beginTransaction();
			fragmenttran.replace(R.id.fragment_container, fragment);
			fragmenttran.addToBackStack(null);
			fragmenttran.commit();
			getFragmentManager().executePendingTransactions();
			mDrawerList.setItemChecked(position, true);
			mDrawerLayout.closeDrawer(mDrawer);
		} else if (position == 2) {

			final Fragment fragment = new QuoteFragment();
			final FragmentTransaction fragmenttran = getFragmentManager()
					.beginTransaction();
			fragmenttran.replace(R.id.fragment_container, fragment);
			fragmenttran.addToBackStack(null);
			fragmenttran.commit();
			getFragmentManager().executePendingTransactions();
			mDrawerList.setItemChecked(position, true);
			mDrawerLayout.closeDrawer(mDrawer);

		} else if (position == 3) {

			final Fragment fragment = new NoContract1();
			final FragmentTransaction fragmenttran = getFragmentManager()
					.beginTransaction();
			fragmenttran.replace(R.id.fragment_container, fragment);
			fragmenttran.addToBackStack(null);
			fragmenttran.commit();
			getFragmentManager().executePendingTransactions();
			mDrawerList.setItemChecked(position, true);
			mDrawerLayout.closeDrawer(mDrawer);

		} else if (position == 4) {

			final Fragment fragment = new PhoneSearch();
			final FragmentTransaction fragmenttran = getFragmentManager()
					.beginTransaction();
			fragmenttran.replace(R.id.fragment_container, fragment);
			fragmenttran.addToBackStack(null);
			fragmenttran.commit();
			getFragmentManager().executePendingTransactions();
			mDrawerList.setItemChecked(position, true);
			mDrawerLayout.closeDrawer(mDrawer);

		} else if (position == 5) {

			final Fragment fragment = new KnowledgeBase1();
			final FragmentTransaction fragmenttran = getFragmentManager()
					.beginTransaction();
			fragmenttran.replace(R.id.fragment_container, fragment);
			fragmenttran.addToBackStack(null);
			fragmenttran.commit();
			getFragmentManager().executePendingTransactions();
			mDrawerList.setItemChecked(position, true);
			mDrawerLayout.closeDrawer(mDrawer);

		} else if (position == 6) {

			final Fragment fragment = new About();
			final FragmentTransaction fragmenttran = getFragmentManager()
					.beginTransaction();
			fragmenttran.replace(R.id.fragment_container, fragment);
			fragmenttran.addToBackStack(null);
			fragmenttran.commit();
			getFragmentManager().executePendingTransactions();
			mDrawerList.setItemChecked(position, true);
			mDrawerLayout.closeDrawer(mDrawer);

		}

	}

	public void setNavDrawerItemNormal() {
		for (int i = 0; i < mDrawerList.getChildCount(); i++) {
			View v = mDrawerList.getChildAt(i);
			TextView txtview = ((TextView) v.findViewById(R.id.menuTitle));
			txtview.setTypeface(Typeface.DEFAULT);
			txtview.setTextColor(getResources().getColor(R.color.menunormal));
		}
	}

	private class DemoDrawerListener implements DrawerLayout.DrawerListener {

		@Override
		public void onDrawerOpened(View drawerView) {
			mDrawerToggle.onDrawerOpened(drawerView);
			mActionBar.onDrawerOpened();
		}

		@Override
		public void onDrawerClosed(View drawerView) {

			mDrawerToggle.onDrawerClosed(drawerView);
			mActionBar.onDrawerClosed();
		}

		@Override
		public void onDrawerSlide(View drawerView, float slideOffset) {

			mDrawerToggle.onDrawerSlide(drawerView, slideOffset);
		}

		@Override
		public void onDrawerStateChanged(int newState) {

			mDrawerToggle.onDrawerStateChanged(newState);
		}
	}

	/**
	 * 
	 * Create a compatible helper that will manipulate the action bar if
	 * available.
	 */

	private ActionBarHelper createActionBarHelper() {

		return new ActionBarHelper();
	}

	private class ActionBarHelper {

		private final ActionBar mActionBar;
		private CharSequence mDrawerTitle;
		private CharSequence mTitle;

		ActionBarHelper() {

			mActionBar = getSupportActionBar();
		}

		public void init() {

			mActionBar.setDisplayHomeAsUpEnabled(true);
			mActionBar.setDisplayShowHomeEnabled(false);
			mTitle = mDrawerTitle = getTitle();
		}

		public void onDrawerClosed() {

			mActionBar.setTitle(mTitle);

		}

		public void onDrawerOpened() {

			mActionBar.setTitle(mDrawerTitle);
		}

		public void setTitle(CharSequence title) {

			mTitle = title;

		}
	}

	public String getDeviceName() {
		String manufacturer = Build.MANUFACTURER;
		String model = Build.MODEL;
		if (model.startsWith(manufacturer)) {
			return capitalize(model);
		} else {
			return capitalize(manufacturer) + " " + model;
		}
	}

	private String capitalize(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		char first = s.charAt(0);
		if (Character.isUpperCase(first)) {
			return s;
		} else {
			return Character.toUpperCase(first) + s.substring(1);
		}
	}

	private void initHomePrefs() {

		// Declare preferences
		final SharedPreferences sharedPref = getSharedPreferences("profile",
				Context.MODE_PRIVATE);

		// Set the appropriate Carrier on the homescreen
		int carrier = sharedPref.getInt("carrier", 0);
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

		// Set the appropriate Smartphones on the homescreen
		String smartphones = sharedPref.getString("smart", "Not Set");
		int numsmart = convertWord(smartphones);

		// Set the appropriate Basic phones on the homescreen
		String basicphones = sharedPref.getString("basic", "Not Set");
		int numbasic = convertWord(basicphones);

		// Set the appropriate data usage on the homescreen
		String thegigs = sharedPref.getString("data", "Not Set");
		mData.setText(thegigs);

		// Set the appropriate data usage on the homescreen
		String tabs = sharedPref.getString("tabs", "Not Set");
		int numtabs = convertWord(tabs);

		// Set the appropriate mifi devices on the homescreen
		String mifi = sharedPref.getString("mifi", "Not Set");
		int nummifi = convertWord(mifi);

		mDevices.setText(String
				.valueOf(numsmart + numbasic + numtabs + nummifi));

		// Set the appropriate monthly bill on the homescreen
		int monthly = sharedPref.getInt("monthly", 0);
		mCost.setText("$" + String.valueOf(monthly));
	}

	private int convertWord(String word) {
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
