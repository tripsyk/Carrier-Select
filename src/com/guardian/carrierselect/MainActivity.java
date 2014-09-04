package com.guardian.carrierselect;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.applovin.sdk.AppLovinSdk;
import com.parse.Parse;
import com.parse.ParseAnalytics;

public class MainActivity extends Activity {

	private ListView mDrawerList;
	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;
	static CharSequence abholder = "My Profile";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getActionBar().setTitle("News");

		AppLovinSdk.initializeSdk(getApplicationContext());
		Parse.initialize(getApplicationContext(),
				"2XacmZEB9hLKANtTk7Rx9ejJipHI3GkmxhVt0Q0y",
				"mAmItywfUeIlMgZCK1LwvQSfneS0SaG1MGqfB65d");

		ParseAnalytics.trackAppOpened(getIntent());

		final int titleId = getResources().getIdentifier("action_bar_title",
				"id", "android");
		final TextView abTitle = (TextView) findViewById(titleId);
		abTitle.setTextColor(getResources().getColor(R.color.titlenoback));

		String[] listItems = getResources().getStringArray(R.array.menu_list);
		
		

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		// set up the drawer's list view with items and click listener
		mDrawerList.setAdapter(new MenuListAdapter(this,
				R.layout.drawer_list_item, listItems));
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
		) 
		
		{
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(abholder);
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}

			public void onDrawerOpened(View drawerView) {
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		final String PREFS_NAME = "MyPrefsFile";

		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

		if (settings.getBoolean("my_first_time", true) != true) {

			abholder = "News";
			getActionBar().setTitle("News");

			final Fragment fragment = new Home();

			final FragmentTransaction fragmenttran = getFragmentManager()
					.beginTransaction();
			fragmenttran.replace(R.id.fragment_container, fragment);
			fragmenttran.commit();
			getFragmentManager().executePendingTransactions();

		} else {
			FragmentManager fm = getFragmentManager();
			fm.popBackStack();

			FragmentTransaction ft = getFragmentManager().beginTransaction();
			ft.add(R.id.fragment_container, new StartScreen());
			ft.commit();
			this.getFragmentManager().executePendingTransactions();
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

		getActionBar().setTitle("Carrier Select");
		
		if(this.getCurrentFocus() != null && this.getCurrentFocus() instanceof EditText){
	         InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
	        imm.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
	     }

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

			abholder = "News";
			getActionBar().setTitle("News");

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

			abholder = "My Profile";

			final Fragment fragment = new MyProfile();
			getActionBar().setTitle("My Profile");

			final FragmentTransaction fragmenttran = getFragmentManager()
					.beginTransaction();
			fragmenttran.replace(R.id.fragment_container, fragment);
			fragmenttran.addToBackStack(null);
			fragmenttran.commit();
			getFragmentManager().executePendingTransactions();

			// update selected item and title, then close the drawer
			mDrawerList.setItemChecked(position, true);
			mDrawerLayout.closeDrawer(mDrawerList);

/*		} else if (position == 2) {

			abholder = "PlanBuilder";
			getActionBar().setTitle("PlanBuilder");

			final Fragment fragment = new PlanBuilder();

			final FragmentTransaction fragmenttran = getFragmentManager()
					.beginTransaction();
			fragmenttran.replace(R.id.fragment_container, fragment);
			fragmenttran.addToBackStack(null);
			fragmenttran.commit();
			getFragmentManager().executePendingTransactions();

			// update selected item and title, then close the drawer
			mDrawerList.setItemChecked(position, true);
			mDrawerLayout.closeDrawer(mDrawerList);*/

		} else if (position == 2) {

			abholder = "Service Plans";
			getActionBar().setTitle("Service Plans");

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

			abholder = "No Contract Plans";
			getActionBar().setTitle("No Contract Plans");

			final Fragment fragment = new NoContract1();

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

			abholder = "Phone Search";
			getActionBar().setTitle("Phone Search");

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

		} else if (position == 5) {

			abholder = "Knowledge Base";
			getActionBar().setTitle("Knowledge Base");

			final Fragment fragment = new KnowledgeBase1();

			final FragmentTransaction fragmenttran = getFragmentManager()
					.beginTransaction();
			fragmenttran.replace(R.id.fragment_container, fragment);
			fragmenttran.addToBackStack(null);
			fragmenttran.commit();
			getFragmentManager().executePendingTransactions();

			// update selected item and title, then close the drawer
			mDrawerList.setItemChecked(position, true);
			mDrawerLayout.closeDrawer(mDrawerList);
/*		} else if (position == 7) {

			abholder = "Settings";
			getActionBar().setTitle("Settings");

			final Fragment fragment = new Settings();

			final FragmentTransaction fragmenttran = getFragmentManager()
					.beginTransaction();
			fragmenttran.replace(R.id.fragment_container, fragment);
			fragmenttran.addToBackStack(null);
			fragmenttran.commit();
			getFragmentManager().executePendingTransactions();

			// update selected item and title, then close the drawer
			mDrawerList.setItemChecked(position, true);
			mDrawerLayout.closeDrawer(mDrawerList);*/
		} else if (position == 6) {

			abholder = "About";
			getActionBar().setTitle("About");

			final Fragment fragment = new About();

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

	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}

}
