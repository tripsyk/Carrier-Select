package com.guardian.carrierselect;

import android.app.Application;

import com.guardian.carrierselect.model.Phone;
import com.parse.Parse;
import com.parse.ParseObject;

public class CarrierSelectApplication extends Application {
	
	@Override
	public void onCreate(){
		super.onCreate();

		ParseObject.registerSubclass(Phone.class);
		Parse.initialize(this, "2XacmZEB9hLKANtTk7Rx9ejJipHI3GkmxhVt0Q0y",
				"mAmItywfUeIlMgZCK1LwvQSfneS0SaG1MGqfB65d");
	}
	
	

}
