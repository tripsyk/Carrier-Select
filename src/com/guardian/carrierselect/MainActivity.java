package com.guardian.carrierselect;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SharedPreferences settings = getSharedPreferences("data", 0);

		if (settings.getBoolean("my_first_time", true) != true) {

			final Intent intent = new Intent(this, InteractiveAct.class);
			startActivity(intent);
			this.finish();

		} else {

			final FragmentManager fm = getSupportFragmentManager();
			fm.popBackStack();
			FragmentTransaction ft = fm.beginTransaction();
			ft.add(R.id.fragment_container, new StartScreen());
			ft.commit();
		}

	}

}
