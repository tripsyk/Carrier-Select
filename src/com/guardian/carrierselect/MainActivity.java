package com.guardian.carrierselect;

import android.app.FragmentTransaction;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getSupportActionBar().hide();

		final String PREFS_NAME = "MyPrefsFile";
		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

		if (settings.getBoolean("my_first_time", true) != true) {

			Intent intent = new Intent(this, InteractiveAct.class);
			startActivity(intent);

		} else {

			FragmentManager fm = getFragmentManager();
			fm.popBackStack();
			FragmentTransaction ft = fm.beginTransaction();
			ft.add(R.id.fragment_container, new StartScreen());
			ft.commit();
		}

	}

}
