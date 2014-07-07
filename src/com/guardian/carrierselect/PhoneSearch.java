package com.guardian.carrierselect;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class PhoneSearch extends Fragment {

	private TextView search, searchTerm, poweredby;
	private static View rootView;
	private static Animation fadeIn;
	private static Phones thePhones[] = new Phones[13];
	private Phones iPhone4, iPhone4S, iPhone5, iPhone5C, iPhone5S, GNexus,
			Nexus4, Nexus5, G2, G3, GPro, GPro2, OptimusG;
	private static final String NO_PHONE = "No phone has been found.";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.phone_search, container, false);
		getActivity().getActionBar().show();

		poweredby = (TextView) rootView.findViewById(R.id.powerBy);
		search = (TextView) rootView.findViewById(R.id.searchGo);
		searchTerm = (EditText) rootView.findViewById(R.id.searchTerm);

		fadeIn = AnimationUtils.loadAnimation(rootView.getContext(),
				R.anim.fadein);

		rootView.startAnimation(fadeIn);
		setPhones();

		search.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				InputMethodManager imm = (InputMethodManager) rootView
						.getContext().getSystemService(
								Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(searchTerm.getWindowToken(), 0);

				/*
				 * ProgressDialog progress = new ProgressDialog(getActivity());
				 * progress.setTitle("Phone Search");
				 * progress.setMessage("Searching for your dream phone");
				 * progress.show();
				 */
				poweredby
						.setText(searchPhones(searchTerm.getText().toString()));

			}
		});

		return rootView;
	}

	public String searchPhones(String phone) {

		
		for (int i = 0; i< thePhones.length; i++){
			String tempName = (thePhones[i].getName());
			if (tempName.toLowerCase().contains(phone.toLowerCase())){
				return tempName;
			}
		}

		return NO_PHONE;

	}

	public void setPhones() {
		iPhone4 = new Phones("Apple iPhone 4", "June 2010", "3.5", "330ppi",
				"5MP", "VGA", "137g", "9.3mm", "1GHz Dual Core", "512GB",
				"1420mAH");
		thePhones[0] = iPhone4;
		iPhone4S = new Phones("Apple iPhone 4S", "September 2011", "3.5",
				"330ppi", "8MP", "VGA", "140g", "9.3mm", "1GHz Single Core",
				"512MB", "1432mAH");
		thePhones[1] = iPhone4S;
		iPhone5 = new Phones("Apple iPhone 5", "September 2012", "4", "326ppi",
				"8MP", "1.2MP", "112g", "7.6mm", "1.2GHz Single Core", "1GB",
				"1400mAH");
		thePhones[2] = iPhone5;
		iPhone5C = new Phones("Apple iPhone 5C", "September 2013", "4",
				"326ppi", "8MP", "1.2MP", "132g", "9mm", "1.3GHz Dual Core",
				"1GB", "1510mAH");
		thePhones[3] = iPhone5C;
		iPhone5S = new Phones("Apple iPhone 5S", "September 2013", "4",
				"326ppi", "8MP", "1.2MP", "112g", "7.6mm", "1.3GHz Dual Core",
				"1GB", "1560mAH");
		thePhones[4] = iPhone5S;
		GNexus = new Phones("Samsung Galaxy Nexus", "November 2011", "4.65",
				"5MP", "1.3MP", "316ppi", "135g", "8.9mm", "1.2GHz Dual Core",
				"1GB", "1750mAH");
		thePhones[5] = GNexus;
		Nexus4 = new Phones("LG Nexus 4", "November 2012", "4.7", "318ppi",
				"8MP", "1.3MP", "139g", "9.1mm", "1.5GHz Quad Core", "2GB",
				"2100mAH");
		thePhones[6] = Nexus4;
		Nexus5 = new Phones("LG Nexus 5", "November 2013", "4.95", "445ppi",
				"8MP", "1.3MP", "130g", "8.6mm", "2.3GHz Quad Core", "2GB",
				"2300mAH");
		thePhones[7] = Nexus5;
		G2 = new Phones("LG G2", "September 2013", "5.2", "424ppi", "13MP",
				"2.1MP", "143g", "8.9mm", "2.26GHz Quad Core", "2GB", "3000mAH");
		thePhones[8] = G2;
		G3 = new Phones("LG G3", "July 2014", "5.5", "534ppi", "13MP", "2.1MP",
				"149g", "8.9mm", "2.5GHz Quad Core", "3GB", "3000mAH");
		thePhones[9] = G3;
		GPro = new Phones("LG G Pro", "April 2013", "5.5", "401ppi", "13MP",
				"2.1MP", "172g", "9.4mm", "1.7GHz Quad Core", "2GB", "3140mAH");
		thePhones[10] = GPro;
		GPro2 = new Phones("LG G Pro 2", "April 2014", "5.9", "373ppi", "13MP",
				"2.1MP", "172g", "8.3mm", "2.26GHz Quad Core", "3GB", "3200mAH");
		thePhones[11] = GPro2;
		OptimusG = new Phones("LG Optimus G", "November 2012", "4.7", "318ppi",
				"13MP", "1.3MP", "145g", "8.5mm", "1.5GHz Quad Core", "2GB",
				"2100mAH");
		thePhones[12] = OptimusG;
	}

	public void onDestroy() {
		super.onDestroy();
	}

}