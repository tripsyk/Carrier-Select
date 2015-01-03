package com.guardian.carrierselect;

import java.util.List;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class PhoneSearch6 extends Fragment {

	private String initial, compare;
	private TextView phone1, manufacturer1, phone2, manufacturer2, release1,
			sim1, os1, size1, thickness1, weight1, release2, sim2, os2, size2,
			thickness2, weight2, display1, displaytype1, pixden1, reso1,
			display2, displaytype2, pixden2, reso2, backcam1, hdr1, dualLED1,
			frontcam1, video1, backcam2, hdr2, dualLED2, frontcam2, video2,
			cpubrand1, pc1, gpu1, ram1, storage1, battery1, microsd1,
			cpubrand2, pc2, gpu2, ram2, storage2, battery2, microsd2, charge1,
			imagestab1, bt1, nfc1, wifidirect1, dlna1, infra1, nc1, wireless1,
			sensors1, charge2, imagestab2, bt2, nfc2, wifidirect2, dlna2,
			infra2, nc2, wireless2, sensors2;
	private static View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.phonesearch6, container, false);

		final SharedPreferences sharedPref = getActivity()
				.getSharedPreferences("data", Context.MODE_PRIVATE);

		initial = sharedPref.getString("ps2", "");
		compare = sharedPref.getString("ps5", "");

		phone1 = (TextView) rootView.findViewById(R.id.phone1);
		phone1.setText(initial);
		manufacturer1 = (TextView) rootView.findViewById(R.id.manufacturer1);
		phone2 = (TextView) rootView.findViewById(R.id.phone2);
		phone2.setText(compare);
		manufacturer2 = (TextView) rootView.findViewById(R.id.manufacturer2);

		// Load results TextViews
		release1 = (TextView) rootView.findViewById(R.id.releasetext1);
		sim1 = (TextView) rootView.findViewById(R.id.simtext1);
		os1 = (TextView) rootView.findViewById(R.id.ostext1);
		size1 = (TextView) rootView.findViewById(R.id.dimentext1);
		thickness1 = (TextView) rootView.findViewById(R.id.thicktext1);
		weight1 = (TextView) rootView.findViewById(R.id.weighttext1);
		release2 = (TextView) rootView.findViewById(R.id.releasetext2);
		sim2 = (TextView) rootView.findViewById(R.id.simtext2);
		os2 = (TextView) rootView.findViewById(R.id.ostext2);
		size2 = (TextView) rootView.findViewById(R.id.dimentext2);
		thickness2 = (TextView) rootView.findViewById(R.id.thicktext2);
		weight2 = (TextView) rootView.findViewById(R.id.weighttext2);

		display1 = (TextView) rootView.findViewById(R.id.displaytext1);
		displaytype1 = (TextView) rootView.findViewById(R.id.displaytypetext1);
		pixden1 = (TextView) rootView.findViewById(R.id.pixdentext1);
		reso1 = (TextView) rootView.findViewById(R.id.resotext1);
		display2 = (TextView) rootView.findViewById(R.id.displaytext2);
		displaytype2 = (TextView) rootView.findViewById(R.id.displaytypetext2);
		pixden2 = (TextView) rootView.findViewById(R.id.pixdentext2);
		reso2 = (TextView) rootView.findViewById(R.id.resotext2);

		backcam1 = (TextView) rootView.findViewById(R.id.backcamtext1);
		hdr1 = (TextView) rootView.findViewById(R.id.hdrtext1);
		dualLED1 = (TextView) rootView.findViewById(R.id.dualledtext1);
		frontcam1 = (TextView) rootView.findViewById(R.id.frontcamtext1);
		video1 = (TextView) rootView.findViewById(R.id.videotext1);
		backcam2 = (TextView) rootView.findViewById(R.id.backcamtext2);
		hdr2 = (TextView) rootView.findViewById(R.id.hdrtext2);
		dualLED2 = (TextView) rootView.findViewById(R.id.dualledtext2);
		frontcam2 = (TextView) rootView.findViewById(R.id.frontcamtext2);
		video2 = (TextView) rootView.findViewById(R.id.videotext2);

		cpubrand1 = (TextView) rootView.findViewById(R.id.cpubrandtext1);
		pc1 = (TextView) rootView.findViewById(R.id.processortext1);
		gpu1 = (TextView) rootView.findViewById(R.id.gputext1);
		ram1 = (TextView) rootView.findViewById(R.id.ramtext1);
		storage1 = (TextView) rootView.findViewById(R.id.storagetext1);
		battery1 = (TextView) rootView.findViewById(R.id.batterytext1);
		microsd1 = (TextView) rootView.findViewById(R.id.microsdtext1);
		cpubrand2 = (TextView) rootView.findViewById(R.id.cpubrandtext2);
		pc2 = (TextView) rootView.findViewById(R.id.processortext2);
		gpu2 = (TextView) rootView.findViewById(R.id.gputext2);
		ram2 = (TextView) rootView.findViewById(R.id.ramtext2);
		storage2 = (TextView) rootView.findViewById(R.id.storagetext2);
		battery2 = (TextView) rootView.findViewById(R.id.batterytext2);
		microsd2 = (TextView) rootView.findViewById(R.id.microsdtext2);

		charge1 = (TextView) rootView.findViewById(R.id.chargetext1);
		imagestab1 = (TextView) rootView.findViewById(R.id.istext1);
		bt1 = (TextView) rootView.findViewById(R.id.bttext1);
		nfc1 = (TextView) rootView.findViewById(R.id.nfctext1);
		wifidirect1 = (TextView) rootView.findViewById(R.id.wifidirecttext1);
		dlna1 = (TextView) rootView.findViewById(R.id.dlnatext1);
		infra1 = (TextView) rootView.findViewById(R.id.infratext1);
		wireless1 = (TextView) rootView.findViewById(R.id.wirelesstext1);
		nc1 = (TextView) rootView.findViewById(R.id.nctext1);
		sensors1 = (TextView) rootView.findViewById(R.id.sensortext1);
		charge2 = (TextView) rootView.findViewById(R.id.chargetext2);
		imagestab2 = (TextView) rootView.findViewById(R.id.istext2);
		bt2 = (TextView) rootView.findViewById(R.id.bttext2);
		nfc2 = (TextView) rootView.findViewById(R.id.nfctext2);
		wifidirect2 = (TextView) rootView.findViewById(R.id.wifidirecttext2);
		dlna2 = (TextView) rootView.findViewById(R.id.dlnatext2);
		infra2 = (TextView) rootView.findViewById(R.id.infratext2);
		wireless2 = (TextView) rootView.findViewById(R.id.wirelesstext2);
		nc2 = (TextView) rootView.findViewById(R.id.nctext2);
		sensors2 = (TextView) rootView.findViewById(R.id.sensortext2);
		init1();
		init2();

		return rootView;
	}

	private void init1() {
		ParseQuery<ParseObject> phone1 = ParseQuery.getQuery("Phones");
		phone1.whereEqualTo("Name", initial);
		phone1.fromLocalDatastore();
		phone1.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> PhoneList, ParseException e) {
				if (e == null) {

					manufacturer1.setText(PhoneList.get(0).getString(
							"Manufacturer"));
					release1.setText(PhoneList.get(0).getString("ReleaseDate"));
					sim1.setText(PhoneList.get(0).getString("SIM"));
					os1.setText(PhoneList.get(0).getString("OS"));
					size1.setText(PhoneList.get(0).getString("Dimensions"));
					thickness1.setText(PhoneList.get(0).getString("Thickness"));
					weight1.setText(PhoneList.get(0).getString("Weight"));

					display1.setText(PhoneList.get(0).getNumber("Screensize")
							.toString()
							+ "\"");
					displaytype1.setText(PhoneList.get(0).getString(
							"DisplayType"));
					pixden1.setText(PhoneList.get(0).getString("PPI"));
					reso1.setText(PhoneList.get(0).getString("Resolution"));

					backcam1.setText(PhoneList.get(0).getString("RearCam"));
					if (PhoneList.get(0).getBoolean("HDR")) {
						hdr1.setText("Yes");
					} else {
						hdr1.setText("No");
					}
					if (PhoneList.get(0).getBoolean("DualLED")) {
						dualLED1.setText("Yes");
					} else {
						dualLED1.setText("No");
					}
					frontcam1.setText(PhoneList.get(0).getString("FrontCam"));
					video1.setText(PhoneList.get(0).getString("VideoRate"));

					cpubrand1.setText(PhoneList.get(0).getString("CPUBrand"));
					pc1.setText(PhoneList.get(0).getString("CPU"));
					gpu1.setText(PhoneList.get(0).getString("GPU"));
					ram1.setText(PhoneList.get(0).getString("RAM"));
					storage1.setText(PhoneList.get(0).getString("Storage"));
					battery1.setText(PhoneList.get(0).getString("Battery"));
					if (PhoneList.get(0).getBoolean("MicroSD")) {
						microsd1.setText("Yes");
					} else {
						microsd1.setText("No");
					}

					if (PhoneList.get(0).getBoolean("BoostCharge")) {
						charge1.setText("Yes");
					} else {
						charge1.setText("No");
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
					if (PhoneList.get(0).getBoolean("WifiDirect")) {
						wifidirect1.setText("Yes");
					} else {
						wifidirect1.setText("No");
					}
					if (PhoneList.get(0).getBoolean("DLNA")) {
						dlna1.setText("Yes");
					} else {
						dlna1.setText("No");
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

	private void init2() {
		ParseQuery<ParseObject> phone2 = ParseQuery.getQuery("Phones");
		phone2.whereEqualTo("Name", compare);
		phone2.fromLocalDatastore();
		phone2.findInBackground(new FindCallback<ParseObject>() {
			public void done(List<ParseObject> PhoneList, ParseException e) {
				if (e == null) {
					manufacturer2.setText(PhoneList.get(0).getString(
							"Manufacturer"));
					release2.setText(PhoneList.get(0).getString("ReleaseDate"));
					sim2.setText(PhoneList.get(0).getString("SIM"));
					os2.setText(PhoneList.get(0).getString("OS"));
					size2.setText(PhoneList.get(0).getString("Dimensions"));
					thickness2.setText(PhoneList.get(0).getString("Thickness"));
					weight2.setText(PhoneList.get(0).getString("Weight"));

					display2.setText(PhoneList.get(0).getNumber("Screensize")
							.toString()
							+ "\"");
					displaytype2.setText(PhoneList.get(0).getString(
							"DisplayType"));
					pixden2.setText(PhoneList.get(0).getString("PPI"));
					reso2.setText(PhoneList.get(0).getString("Resolution"));

					backcam2.setText(PhoneList.get(0).getString("RearCam"));
					if (PhoneList.get(0).getBoolean("HDR")) {
						hdr2.setText("Yes");
					} else {
						hdr2.setText("No");
					}
					if (PhoneList.get(0).getBoolean("DualLED")) {
						dualLED2.setText("Yes");
					} else {
						dualLED2.setText("No");
					}
					frontcam2.setText(PhoneList.get(0).getString("FrontCam"));
					video2.setText(PhoneList.get(0).getString("VideoRate"));

					cpubrand2.setText(PhoneList.get(0).getString("CPUBrand"));
					pc2.setText(PhoneList.get(0).getString("CPU"));
					gpu2.setText(PhoneList.get(0).getString("GPU"));
					ram2.setText(PhoneList.get(0).getString("RAM"));
					storage2.setText(PhoneList.get(0).getString("Storage"));
					battery2.setText(PhoneList.get(0).getString("Battery"));
					if (PhoneList.get(0).getBoolean("MicroSD")) {
						microsd2.setText("Yes");
					} else {
						microsd2.setText("No");
					}

					if (PhoneList.get(0).getBoolean("BoostCharge")) {
						charge2.setText("Yes");
					} else {
						charge2.setText("No");
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
					if (PhoneList.get(0).getBoolean("WifiDirect")) {
						wifidirect2.setText("Yes");
					} else {
						wifidirect2.setText("No");
					}
					if (PhoneList.get(0).getBoolean("DLNA")) {
						dlna2.setText("Yes");
					} else {
						dlna2.setText("No");
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
				} else {
				}
			}

		});
	}

}
