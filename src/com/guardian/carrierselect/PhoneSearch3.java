package com.guardian.carrierselect;

import java.util.List;

import com.guardian.carrierselect.model.Phone;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class PhoneSearch3 extends Fragment {

	private static final String SEARCHTERM = "search_term";
	private String searchTerm;
	private ProgressDialog progress;
	private TextView ps3mantitle, ps3carrier, release, os, size, thickness,
			weight, display, pixden, reso, backcam, frontcam, video, pc, ram,
			storage, battery, microsd, imagestab, bt, nfc, infra, nc, wireless,
			sensors;
	private TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13,
			t14, t15, t16, t17, t18, t19, t20, t21, t22, t23;
	private View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.phonesearch3, container, false);

		ps3mantitle = (TextView) rootView.findViewById(R.id.ps3mantitle);
		ps3mantitle.setText(searchTerm);
		ps3mantitle.setTypeface(null, Typeface.BOLD);
		ps3carrier = (TextView) rootView.findViewById(R.id.ps3carrier);

		// Load results TextViews
		release = (TextView) rootView.findViewById(R.id.releasetext);
		os = (TextView) rootView.findViewById(R.id.ostext);
		size = (TextView) rootView.findViewById(R.id.dimentext);
		thickness = (TextView) rootView.findViewById(R.id.thicktext);
		weight = (TextView) rootView.findViewById(R.id.weighttext);
		display = (TextView) rootView.findViewById(R.id.displaytext);
		pixden = (TextView) rootView.findViewById(R.id.pixdentext);
		reso = (TextView) rootView.findViewById(R.id.resotext);
		reso = (TextView) rootView.findViewById(R.id.resotext);
		backcam = (TextView) rootView.findViewById(R.id.backcamtext);
		frontcam = (TextView) rootView.findViewById(R.id.frontcamtext);
		video = (TextView) rootView.findViewById(R.id.videotext);
		pc = (TextView) rootView.findViewById(R.id.processortext);
		ram = (TextView) rootView.findViewById(R.id.ramtext);
		storage = (TextView) rootView.findViewById(R.id.storagetext);
		battery = (TextView) rootView.findViewById(R.id.batterytext);
		microsd = (TextView) rootView.findViewById(R.id.microsdtext);
		imagestab = (TextView) rootView.findViewById(R.id.istext);
		bt = (TextView) rootView.findViewById(R.id.bttext);
		nfc = (TextView) rootView.findViewById(R.id.nfctext);
		infra = (TextView) rootView.findViewById(R.id.infratext);
		wireless = (TextView) rootView.findViewById(R.id.wirelesstext);
		nc = (TextView) rootView.findViewById(R.id.nctext);
		sensors = (TextView) rootView.findViewById(R.id.sensortext);

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

		// Load in animations.
		final Animation lefttoright = AnimationUtils.loadAnimation(
				rootView.getContext(), R.anim.left_to_right);

		// Begin startup flow.
		rootView.startAnimation(lefttoright);
		performSearch();

		return rootView;
	}

	@SuppressLint("DefaultLocale")
	public void performSearch() {

		progress = new ProgressDialog(getActivity());
		progress.setTitle("Phone Search");
		progress.setMessage("Just a sec...");
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
				progress.dismiss();

				if (e == null) {
					ps3carrier.setText(PhoneList.get(0).getString("Carriers"));
					release.setText(PhoneList.get(0).getString("ReleaseDate"));
					os.setText(PhoneList.get(0).getString("OS"));
					size.setText(PhoneList.get(0).getString("Dimensions"));
					thickness.setText(PhoneList.get(0).getString("Thickness"));
					weight.setText(PhoneList.get(0).getString("Weight"));
					display.setText(PhoneList.get(0).getNumber("Screensize")
							.toString()
							+ "\"");
					pixden.setText(PhoneList.get(0).getString("PPI"));
					reso.setText(PhoneList.get(0).getString("Resolution"));
					backcam.setText(PhoneList.get(0).getString("RearCam"));
					frontcam.setText(PhoneList.get(0).getString("FrontCam"));
					video.setText(PhoneList.get(0).getString("VideoRate"));
					pc.setText(PhoneList.get(0).getString("CPU"));
					ram.setText(PhoneList.get(0).getString("RAM"));
					storage.setText(PhoneList.get(0).getString("Storage"));
					battery.setText(PhoneList.get(0).getString("Battery"));
					if (PhoneList.get(0).getBoolean("MicroSD")) {
						microsd.setText("Yes");
					} else {
						microsd.setText("No");
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
				} else {
				}
			}
		});

	}

	public static PhoneSearch3 create(String searchName) {
		final PhoneSearch3 fragment = new PhoneSearch3();

		final Bundle args = new Bundle();

		args.putString(SEARCHTERM, searchName);
		fragment.setArguments(args);

		return fragment;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		final Bundle args = getArguments();

		searchTerm = args.getString(SEARCHTERM);

	}

}
