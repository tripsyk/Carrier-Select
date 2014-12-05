package com.guardian.carrierselect;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.applovin.adview.AppLovinInterstitialAd;
import com.guardian.carrierselect.model.Phone;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class PhoneSearch3 extends Fragment {

	private String searchTerm;
	private ProgressDialog progress;
	private TextView ps3mantitle, manufacturer, release, sim, os, size,
			thickness, weight, display, displaytype, pixden, reso, backcam,
			hdr, dualLED, frontcam, video, cpubrand, pc, gpu, ram, storage,
			battery, microsd, charge, imagestab, bt, nfc, wifidirect, dlna,
			infra, nc, wireless, sensors;
	private Button compare;
	private View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.phonesearch3, container, false);

		final SharedPreferences sharedPref = getActivity()
				.getSharedPreferences("data", Context.MODE_PRIVATE);

		searchTerm = sharedPref.getString("ps2", "");

		compare = (Button) rootView.findViewById(R.id.compare);
		ps3mantitle = (TextView) rootView.findViewById(R.id.ps3mantitle);
		ps3mantitle.setText(searchTerm);
		ps3mantitle.setTypeface(null, Typeface.BOLD);
		manufacturer = (TextView) rootView.findViewById(R.id.manufacturer);

		// Load results TextViews
		release = (TextView) rootView.findViewById(R.id.releasetext);
		sim = (TextView) rootView.findViewById(R.id.simtext);
		os = (TextView) rootView.findViewById(R.id.ostext);
		size = (TextView) rootView.findViewById(R.id.dimentext);
		thickness = (TextView) rootView.findViewById(R.id.thicktext);
		weight = (TextView) rootView.findViewById(R.id.weighttext);
		display = (TextView) rootView.findViewById(R.id.displaytext);
		displaytype = (TextView) rootView.findViewById(R.id.displaytypetext);
		pixden = (TextView) rootView.findViewById(R.id.pixdentext);
		reso = (TextView) rootView.findViewById(R.id.resotext);
		backcam = (TextView) rootView.findViewById(R.id.backcamtext);
		hdr = (TextView) rootView.findViewById(R.id.hdrtext);
		dualLED = (TextView) rootView.findViewById(R.id.dualledtext);
		frontcam = (TextView) rootView.findViewById(R.id.frontcamtext);
		video = (TextView) rootView.findViewById(R.id.videotext);
		cpubrand = (TextView) rootView.findViewById(R.id.cpubrandtext);
		pc = (TextView) rootView.findViewById(R.id.processortext);
		gpu = (TextView) rootView.findViewById(R.id.gputext);
		ram = (TextView) rootView.findViewById(R.id.ramtext);
		storage = (TextView) rootView.findViewById(R.id.storagetext);
		battery = (TextView) rootView.findViewById(R.id.batterytext);
		microsd = (TextView) rootView.findViewById(R.id.microsdtext);
		charge = (TextView) rootView.findViewById(R.id.chargetext);
		imagestab = (TextView) rootView.findViewById(R.id.istext);
		bt = (TextView) rootView.findViewById(R.id.bttext);
		nfc = (TextView) rootView.findViewById(R.id.nfctext);
		wifidirect = (TextView) rootView.findViewById(R.id.wifidirecttext);
		dlna = (TextView) rootView.findViewById(R.id.dlnatext);
		infra = (TextView) rootView.findViewById(R.id.infratext);
		wireless = (TextView) rootView.findViewById(R.id.wirelesstext);
		nc = (TextView) rootView.findViewById(R.id.nctext);
		sensors = (TextView) rootView.findViewById(R.id.sensortext);
		double randomNum = Math.random() * 3;

		if ((int) randomNum == 1)
			AppLovinInterstitialAd.show(getActivity());

		performSearch();

		compare.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				final Fragment fragment = new PhoneSearch4();
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

	@SuppressLint("DefaultLocale")
	public void performSearch() {

		progress = new ProgressDialog(getActivity(),
				AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
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
		query.whereContains("Name", searchTerm);
		query.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> PhoneList, ParseException e) {

				if (e == null) {
					manufacturer.setText(PhoneList.get(0).getString(
							"Manufacturer"));
					release.setText(PhoneList.get(0).getString("ReleaseDate"));
					sim.setText(PhoneList.get(0).getString("SIM"));
					os.setText(PhoneList.get(0).getString("OS"));
					size.setText(PhoneList.get(0).getString("Dimensions"));
					thickness.setText(PhoneList.get(0).getString("Thickness"));
					weight.setText(PhoneList.get(0).getString("Weight"));
					display.setText(PhoneList.get(0).getNumber("Screensize")
							.toString()
							+ "\"");
					displaytype.setText(PhoneList.get(0).getString(
							"DisplayType"));
					pixden.setText(PhoneList.get(0).getString("PPI"));
					reso.setText(PhoneList.get(0).getString("Resolution"));
					backcam.setText(PhoneList.get(0).getString("RearCam"));
					if (PhoneList.get(0).getBoolean("HDR")) {
						hdr.setText("Yes");
					} else {
						hdr.setText("No");
					}
					if (PhoneList.get(0).getBoolean("DualLED")) {
						dualLED.setText("Yes");
					} else {
						dualLED.setText("No");
					}
					frontcam.setText(PhoneList.get(0).getString("FrontCam"));
					video.setText(PhoneList.get(0).getString("VideoRate"));
					cpubrand.setText(PhoneList.get(0).getString("CPUBrand"));
					pc.setText(PhoneList.get(0).getString("CPU"));
					gpu.setText(PhoneList.get(0).getString("GPU"));
					ram.setText(PhoneList.get(0).getString("RAM"));
					storage.setText(PhoneList.get(0).getString("Storage"));
					battery.setText(PhoneList.get(0).getString("Battery"));
					if (PhoneList.get(0).getBoolean("MicroSD")) {
						microsd.setText("Yes");
					} else {
						microsd.setText("No");
					}
					if (PhoneList.get(0).getBoolean("BoostCharge")) {
						charge.setText("Yes");
					} else {
						charge.setText("No");
					}
					if (PhoneList.get(0).getBoolean("OIS")) {
						imagestab.setText("Yes");
					} else {
						imagestab.setText("No");
					}
					bt.setText(PhoneList.get(0).getString("Bluetooth"));
					if (PhoneList.get(0).getBoolean("NFC")) {
						nfc.setText("Yes");
					} else {
						nfc.setText("No");
					}
					if (PhoneList.get(0).getBoolean("WifiDirect")) {
						wifidirect.setText("Yes");
					} else {
						wifidirect.setText("No");
					}
					if (PhoneList.get(0).getBoolean("DLNA")) {
						dlna.setText("Yes");
					} else {
						dlna.setText("No");
					}
					if (PhoneList.get(0).getBoolean("Infrared")) {
						infra.setText("Yes");
					} else {
						infra.setText("No");
					}
					if (PhoneList.get(0).getBoolean("WirelessCharge")) {
						wireless.setText("Yes");
					} else {
						wireless.setText("No");
					}
					if (PhoneList.get(0).getBoolean("NoiseCanceling")) {
						nc.setText("Yes");
					} else {
						nc.setText("No");
					}
					sensors.setText(PhoneList.get(0).getString("Sensors"));

					final Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							progress.dismiss();
						}
					}, 200);
				} else {
				}
			}
		});

	}

}
