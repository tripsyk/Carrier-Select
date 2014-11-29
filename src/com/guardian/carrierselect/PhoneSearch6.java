package com.guardian.carrierselect;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.applovin.adview.AppLovinInterstitialAd;
import com.guardian.carrierselect.model.Phone;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class PhoneSearch6 extends Fragment {

	private String initial, compare;
	private ProgressDialog progress;
	private TextView phone1, phone1carrier, phone2, phone2carrier, release1,
			os1, size1, thickness1, weight1, release2, os2, size2, thickness2,
			weight2, display1, pixden1, reso1, display2, pixden2, reso2,
			backcam1, frontcam1, video1, backcam2, frontcam2, video2, pc1,
			ram1, storage1, battery1, microsd1, pc2, ram2, storage2, battery2,
			microsd2, imagestab1, bt1, nfc1, infra1, nc1, wireless1, sensors1,
			imagestab2, bt2, nfc2, infra2, nc2, wireless2, sensors2;
	private TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13,
			t14, t15, t16, t17, t18, t19, t20, t21, t22, t23;
	private View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.phonesearch6, container, false);

		final SharedPreferences sharedPref = getActivity()
				.getSharedPreferences("data", Context.MODE_PRIVATE);

		initial = sharedPref.getString("ps2", "");
		compare = sharedPref.getString("compare", "");

		phone1 = (TextView) rootView.findViewById(R.id.phone1);
		phone1.setText(initial);
		phone1carrier = (TextView) rootView.findViewById(R.id.phone1carrier);
		phone2 = (TextView) rootView.findViewById(R.id.phone2);
		phone2.setText(compare);
		phone2carrier = (TextView) rootView.findViewById(R.id.phone2carrier);

		// Load results TextViews
		release1 = (TextView) rootView.findViewById(R.id.releasetext1);
		os1 = (TextView) rootView.findViewById(R.id.ostext1);
		size1 = (TextView) rootView.findViewById(R.id.dimentext1);
		thickness1 = (TextView) rootView.findViewById(R.id.thicktext1);
		weight1 = (TextView) rootView.findViewById(R.id.weighttext1);
		release2 = (TextView) rootView.findViewById(R.id.releasetext2);
		os2 = (TextView) rootView.findViewById(R.id.ostext2);
		size2 = (TextView) rootView.findViewById(R.id.dimentext2);
		thickness2 = (TextView) rootView.findViewById(R.id.thicktext2);
		weight2 = (TextView) rootView.findViewById(R.id.weighttext2);

		display1 = (TextView) rootView.findViewById(R.id.displaytext1);
		pixden1 = (TextView) rootView.findViewById(R.id.pixdentext1);
		reso1 = (TextView) rootView.findViewById(R.id.resotext1);
		display2 = (TextView) rootView.findViewById(R.id.displaytext2);
		pixden2 = (TextView) rootView.findViewById(R.id.pixdentext2);
		reso2 = (TextView) rootView.findViewById(R.id.resotext2);

		backcam1 = (TextView) rootView.findViewById(R.id.backcamtext1);
		frontcam1 = (TextView) rootView.findViewById(R.id.frontcamtext1);
		video1 = (TextView) rootView.findViewById(R.id.videotext1);
		backcam2 = (TextView) rootView.findViewById(R.id.backcamtext2);
		frontcam2 = (TextView) rootView.findViewById(R.id.frontcamtext2);
		video2 = (TextView) rootView.findViewById(R.id.videotext2);

		pc1 = (TextView) rootView.findViewById(R.id.processortext1);
		ram1 = (TextView) rootView.findViewById(R.id.ramtext1);
		storage1 = (TextView) rootView.findViewById(R.id.storagetext1);
		battery1 = (TextView) rootView.findViewById(R.id.batterytext1);
		microsd1 = (TextView) rootView.findViewById(R.id.microsdtext1);
		pc2 = (TextView) rootView.findViewById(R.id.processortext2);
		ram2 = (TextView) rootView.findViewById(R.id.ramtext2);
		storage2 = (TextView) rootView.findViewById(R.id.storagetext2);
		battery2 = (TextView) rootView.findViewById(R.id.batterytext2);
		microsd2 = (TextView) rootView.findViewById(R.id.microsdtext2);

		imagestab1 = (TextView) rootView.findViewById(R.id.istext1);
		bt1 = (TextView) rootView.findViewById(R.id.bttext1);
		nfc1 = (TextView) rootView.findViewById(R.id.nfctext1);
		infra1 = (TextView) rootView.findViewById(R.id.infratext1);
		wireless1 = (TextView) rootView.findViewById(R.id.wirelesstext1);
		nc1 = (TextView) rootView.findViewById(R.id.nctext1);
		sensors1 = (TextView) rootView.findViewById(R.id.sensortext1);
		imagestab2 = (TextView) rootView.findViewById(R.id.istext2);
		bt2 = (TextView) rootView.findViewById(R.id.bttext2);
		nfc2 = (TextView) rootView.findViewById(R.id.nfctext2);
		infra2 = (TextView) rootView.findViewById(R.id.infratext2);
		wireless2 = (TextView) rootView.findViewById(R.id.wirelesstext2);
		nc2 = (TextView) rootView.findViewById(R.id.nctext2);
		sensors2 = (TextView) rootView.findViewById(R.id.sensortext2);

		t1 = (TextView) rootView.findViewById(R.id.releasedate);
		t1.setTypeface(null, Typeface.BOLD);
		t2 = (TextView) rootView.findViewById(R.id.os);
		t2.setTypeface(null, Typeface.BOLD);
		t3 = (TextView) rootView.findViewById(R.id.dimensions);
		t3.setTypeface(null, Typeface.BOLD);
		t4 = (TextView) rootView.findViewById(R.id.thickness);
		t4.setTypeface(null, Typeface.BOLD);
		t5 = (TextView) rootView.findViewById(R.id.weight);
		t5.setTypeface(null, Typeface.BOLD);
		t6 = (TextView) rootView.findViewById(R.id.displaysize);
		t6.setTypeface(null, Typeface.BOLD);
		t7 = (TextView) rootView.findViewById(R.id.pixden);
		t7.setTypeface(null, Typeface.BOLD);
		t8 = (TextView) rootView.findViewById(R.id.resolution);
		t8.setTypeface(null, Typeface.BOLD);
		t9 = (TextView) rootView.findViewById(R.id.backcam);
		t9.setTypeface(null, Typeface.BOLD);
		t10 = (TextView) rootView.findViewById(R.id.frontcam);
		t10.setTypeface(null, Typeface.BOLD);
		t11 = (TextView) rootView.findViewById(R.id.video);
		t11.setTypeface(null, Typeface.BOLD);
		t12 = (TextView) rootView.findViewById(R.id.processor);
		t12.setTypeface(null, Typeface.BOLD);
		t13 = (TextView) rootView.findViewById(R.id.ram);
		t13.setTypeface(null, Typeface.BOLD);
		t14 = (TextView) rootView.findViewById(R.id.storage);
		t14.setTypeface(null, Typeface.BOLD);
		t15 = (TextView) rootView.findViewById(R.id.battery);
		t15.setTypeface(null, Typeface.BOLD);
		t16 = (TextView) rootView.findViewById(R.id.microsd);
		t16.setTypeface(null, Typeface.BOLD);
		t17 = (TextView) rootView.findViewById(R.id.imagestab);
		t17.setTypeface(null, Typeface.BOLD);
		t18 = (TextView) rootView.findViewById(R.id.bt);
		t18.setTypeface(null, Typeface.BOLD);
		t19 = (TextView) rootView.findViewById(R.id.nfc);
		t19.setTypeface(null, Typeface.BOLD);
		t20 = (TextView) rootView.findViewById(R.id.infra);
		t20.setTypeface(null, Typeface.BOLD);
		t21 = (TextView) rootView.findViewById(R.id.wireless);
		t21.setTypeface(null, Typeface.BOLD);
		t22 = (TextView) rootView.findViewById(R.id.noisecanceling);
		t22.setTypeface(null, Typeface.BOLD);
		t23 = (TextView) rootView.findViewById(R.id.sensors);
		t23.setTypeface(null, Typeface.BOLD);
		double randomNum = Math.random() * 3;

		if ((int) randomNum == 1)
			AppLovinInterstitialAd.show(getActivity());

		grabInitial();
		grabCompare();

		return rootView;
	}

	@SuppressLint("DefaultLocale")
	public void grabInitial() {

		progress = new ProgressDialog(getActivity());
		progress.setTitle("Phone Search");
		progress.setMessage("Just a sec...");
		progress.setCancelable(false);
		progress.show();

		ParseObject.registerSubclass(Phone.class);
		Parse.initialize(rootView.getContext(),
				"2XacmZEB9hLKANtTk7Rx9ejJipHI3GkmxhVt0Q0y",
				"mAmItywfUeIlMgZCK1LwvQSfneS0SaG1MGqfB65d");

		// Test Query
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Phones");
		query.setLimit(5);
		query.whereContains("Name", initial);
		query.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> PhoneList, ParseException e) {

				if (e == null) {
					phone1carrier.setText(PhoneList.get(0)
							.getString("Carriers"));
					release1.setText(PhoneList.get(0).getString("ReleaseDate"));
					os1.setText(PhoneList.get(0).getString("OS"));
					size1.setText(PhoneList.get(0).getString("Dimensions"));
					thickness1.setText(PhoneList.get(0).getString("Thickness"));
					weight1.setText(PhoneList.get(0).getString("Weight"));

					display1.setText(PhoneList.get(0).getNumber("Screensize")
							.toString()
							+ "\"");
					pixden1.setText(PhoneList.get(0).getString("PPI"));
					reso1.setText(PhoneList.get(0).getString("Resolution"));

					backcam1.setText(PhoneList.get(0).getString("RearCam"));
					frontcam1.setText(PhoneList.get(0).getString("FrontCam"));
					video1.setText(PhoneList.get(0).getString("VideoRate"));

					pc1.setText(PhoneList.get(0).getString("CPU"));
					ram1.setText(PhoneList.get(0).getString("RAM"));
					storage1.setText(PhoneList.get(0).getString("Storage"));
					battery1.setText(PhoneList.get(0).getString("Battery"));
					if (PhoneList.get(0).getBoolean("MicroSD")) {
						microsd1.setText("Yes");
					} else {
						microsd1.setText("No");
					}

					if (PhoneList.get(0).getBoolean("OIS")) {
						imagestab1.setText("Yes");
					} else {
						imagestab1.setText("No");
					}
					bt1.setText(PhoneList.get(0).getString("Bluetooth"));
					if (PhoneList.get(0).getBoolean("NFC")) {
						nfc1.setText("Yes");
					} else {
						nfc1.setText("No");
					}
					if (PhoneList.get(0).getBoolean("Infrared")) {
						infra1.setText("Yes");
					} else {
						infra1.setText("No");
					}
					if (PhoneList.get(0).getBoolean("WirelessCharge")) {
						wireless1.setText("Yes");
					} else {
						wireless1.setText("No");
					}
					if (PhoneList.get(0).getBoolean("NoiseCanceling")) {
						nc1.setText("Yes");
					} else {
						nc1.setText("No");
					}
					sensors1.setText(PhoneList.get(0).getString("Sensors"));
				} else {
				}
			}
		});

	}

	@SuppressLint("DefaultLocale")
	public void grabCompare() {

		ParseObject.registerSubclass(Phone.class);
		Parse.initialize(rootView.getContext(),
				"2XacmZEB9hLKANtTk7Rx9ejJipHI3GkmxhVt0Q0y",
				"mAmItywfUeIlMgZCK1LwvQSfneS0SaG1MGqfB65d");

		// Test Query
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Phones");
		query.setLimit(5);
		query.whereContains("Name", compare);
		query.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> PhoneList, ParseException e) {

				if (e == null) {

					phone2carrier.setText(PhoneList.get(0)
							.getString("Carriers"));

					release2.setText(PhoneList.get(0).getString("ReleaseDate"));
					os2.setText(PhoneList.get(0).getString("OS"));
					size2.setText(PhoneList.get(0).getString("Dimensions"));
					thickness2.setText(PhoneList.get(0).getString("Thickness"));
					weight2.setText(PhoneList.get(0).getString("Weight"));

					display2.setText(PhoneList.get(0).getNumber("Screensize")
							.toString()
							+ "\"");
					pixden2.setText(PhoneList.get(0).getString("PPI"));
					reso2.setText(PhoneList.get(0).getString("Resolution"));

					backcam2.setText(PhoneList.get(0).getString("RearCam"));
					frontcam2.setText(PhoneList.get(0).getString("FrontCam"));
					video2.setText(PhoneList.get(0).getString("VideoRate"));

					pc2.setText(PhoneList.get(0).getString("CPU"));
					ram2.setText(PhoneList.get(0).getString("RAM"));
					storage2.setText(PhoneList.get(0).getString("Storage"));
					battery2.setText(PhoneList.get(0).getString("Battery"));
					if (PhoneList.get(0).getBoolean("MicroSD")) {
						microsd2.setText("Yes");
					} else {
						microsd2.setText("No");
					}

					if (PhoneList.get(0).getBoolean("OIS")) {
						imagestab2.setText("Yes");
					} else {
						imagestab2.setText("No");
					}
					bt2.setText(PhoneList.get(0).getString("Bluetooth"));
					if (PhoneList.get(0).getBoolean("NFC")) {
						nfc2.setText("Yes");
					} else {
						nfc2.setText("No");
					}
					if (PhoneList.get(0).getBoolean("Infrared")) {
						infra2.setText("Yes");
					} else {
						infra2.setText("No");
					}
					if (PhoneList.get(0).getBoolean("WirelessCharge")) {
						wireless2.setText("Yes");
					} else {
						wireless2.setText("No");
					}
					if (PhoneList.get(0).getBoolean("NoiseCanceling")) {
						nc2.setText("Yes");
					} else {
						nc2.setText("No");
					}
					sensors2.setText(PhoneList.get(0).getString("Sensors"));

					final long delayInMillis = 250;
					Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							progress.dismiss();
						}
					}, delayInMillis);
				} else {
				}
			}

		});
	}

}
