package com.guardian.carrierselect;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

public class PlanQuote extends Activity {

	private ListView mDrawerList;
	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		int titleId = getResources().getIdentifier("action_bar_title", "id",
				"android");
		TextView abTitle = (TextView) findViewById(titleId);
		abTitle.setTextColor((Color.parseColor("#00C4FF")));
		// ActionBar bar = getActionBar();
		// for color
		// bar.setBackgroundDrawable(new
		// ColorDrawable(Color.parseColor("#E9FBFF")));

		int[] micons = new int[] { R.drawable.home, R.drawable.pin,
				R.drawable.phone, R.drawable.unlocked, R.drawable.tools,
				R.drawable.about };

		String[] listItems = getResources().getStringArray(R.array.menu_list);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		// set up the drawer's list view with items and click listener
		mDrawerList.setAdapter(new MenuListAdapter(this,
				R.layout.drawer_list_item, listItems, micons));
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		// enable ActionBar app icon to behave as action to toggle nav drawer
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		// ActionBarDrawerToggle ties together the the proper interactions
		// between the sliding drawer and the action bar app icon
		mDrawerToggle = new ActionBarDrawerToggle(this, /* host Activity */
		mDrawerLayout, /* DrawerLayout object */
		R.drawable.ic_drawer, /* nav drawer image to replace 'Up' caret */
		R.string.drawer_open, /* "open drawer" description for accessibility */
		R.string.drawer_close /* "close drawer" description for accessibility */
		) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle("Carrier Select");
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle("Carrier Select");
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		// This will be the start screen fragment
		if (savedInstanceState == null) {
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			ft.add(R.id.fragment_container, new StartScreen());
			ft.commit();
			this.getFragmentManager().executePendingTransactions();
		}

		final String PREFS_NAME = "MyPrefsFile";

		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

		if (settings.getBoolean("my_first_time", true) != true) {

			final Fragment fragment = new Home();

			final FragmentTransaction fragmenttran = getFragmentManager()
					.beginTransaction();
			fragmenttran.replace(R.id.fragment_container, fragment);
			fragmenttran.addToBackStack(null);
			fragmenttran.commit();
			getFragmentManager().executePendingTransactions();

		}
		

	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			selectItem(position);
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// The action bar home/up action should open or close the drawer.
		// ActionBarDrawerToggle will take care of this.
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle action buttons
		switch (item.getItemId()) {

		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void selectItem(int position) {
		// update the main content by replacing fragments

		if (position == 0) {
			final Fragment fragment = new Home();

			final FragmentTransaction fragmenttran = getFragmentManager()
					.beginTransaction();
			fragmenttran.replace(R.id.fragment_container, fragment);
			fragmenttran.addToBackStack(null);
			fragmenttran.commit();
			getFragmentManager().executePendingTransactions();

			// update selected item and title, then close the drawer
			mDrawerList.setItemChecked(position, true);
			mDrawerLayout.closeDrawer(mDrawerList);

		} else if (position == 1) {
			final Fragment fragment = new PlanBuilder();

			final FragmentTransaction fragmenttran = getFragmentManager()
					.beginTransaction();
			fragmenttran.replace(R.id.fragment_container, fragment);
			fragmenttran.addToBackStack(null);
			fragmenttran.commit();
			getFragmentManager().executePendingTransactions();

			// update selected item and title, then close the drawer
			mDrawerList.setItemChecked(position, true);
			mDrawerLayout.closeDrawer(mDrawerList);

		} else if (position == 2) {
			final Fragment fragment = new QuoteFragment();

			final FragmentTransaction fragmenttran = getFragmentManager()
					.beginTransaction();
			fragmenttran.replace(R.id.fragment_container, fragment);
			fragmenttran.addToBackStack(null);
			fragmenttran.commit();
			getFragmentManager().executePendingTransactions();

			// update selected item and title, then close the drawer
			mDrawerList.setItemChecked(position, true);
			mDrawerLayout.closeDrawer(mDrawerList);

		} else if (position == 3) {
			final Fragment fragment = new PlanBuilder();

			final FragmentTransaction fragmenttran = getFragmentManager()
					.beginTransaction();
			fragmenttran.replace(R.id.fragment_container, fragment);
			fragmenttran.addToBackStack(null);
			fragmenttran.commit();
			getFragmentManager().executePendingTransactions();

			// update selected item and title, then close the drawer
			mDrawerList.setItemChecked(position, true);
			mDrawerLayout.closeDrawer(mDrawerList);
		} else if (position == 4) {
			final Fragment fragment = new PhoneSearch();

			final FragmentTransaction fragmenttran = getFragmentManager()
					.beginTransaction();
			fragmenttran.replace(R.id.fragment_container, fragment);
			fragmenttran.addToBackStack(null);
			fragmenttran.commit();
			getFragmentManager().executePendingTransactions();

			// update selected item and title, then close the drawer
			mDrawerList.setItemChecked(position, true);
			mDrawerLayout.closeDrawer(mDrawerList);
		}
	}

	public void onCheck(View view) {
		CheckBox hotbox = (CheckBox) findViewById(R.id.checkbox_hotspot);

		QuoteFragment.onCheck(hotbox.isChecked());
	}

	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);
	}

}
