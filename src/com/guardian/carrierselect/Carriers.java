package com.guardian.carrierselect;

public class Carriers {

	private String[] matchedPlanNames = new String[10];
	public static double[][] matchedPlans = new double[10][0];

	// Smartphone (0), Basicphone (1)
	// Minutes (2000 unlimited), ### (limited)
	// Text Minutes (2000 unlimited), ### (limited)
	// Data Provided (100 unlimited), ### (limited)
	// Throttle Data (100 no throttle), ### (throttle threshold)
	// Price Minutes
	static double[][] preplans = new double[][] {
			{ 0, 300, 2000, 100, 2.5, 35 }, // start Virgin Mobile Plans
			{ 0, 1200, 2000, 100, 2.5, 45 },
			{ 0, 2000, 2000, 100, 2.5, 55 }, // end Virgin Mobile Plans

			{ 0, 2000, 2000, 100, .5, 40 }, // start Boost Mobile Plans
			{ 0, 2000, 2000, 100, 2.5, 50 },
			{ 0, 2000, 2000, 100, 5, 60 }, // end Boost Mobile Plans

			{ 1, 200, 0, 0, 0, 15 }, // start Net10 Plans
			{ 1, 1000, 0, 0, 0, 25 },
			{ 1, 2000, 2000, 0, 0, 35 },
			{ 2, 2000, 2000, 100, .5, 40 },
			{ 0, 2000, 2000, 100, 2.5, 50 },
			{ 0, 2000, 2000, 100, 3.5, 60 },
			{ 0, 2000, 2000, 100, 5, 70 }, // end Net10 Plans

			{ 1, 250, 2000, 0, 0, 25 }, // start ATT Plans
			{ 0, 500, 2000, .5, 100, 40 },
			{ 1, 2000, 2000, 100, 2, 45 },
			{ 0, 2000, 2000, 2.5, 100, 60 }, // end ATT Plans

			{ 0, 2000, 2000, .5, 100, 45 }, // start Verizon Plans
			{ 0, 2000, 2000, 1, 100, 50 },
			{ 0, 2000, 2000, 1.5, 100, 55 },
			{ 0, 2000, 2000, 3.5, 100, 65 }, // end Verizon Plans

			{ 1, 50, 0, 0, 0, 10 }, // start Tracfone Plans
			{ 1, 125, 0, 0, 0, 20 },
			{ 1, 200, 0, 0, 0, 30 }, // end Tracfone Plans

			{ 1, 2000, 2000, .05, 0, 40 }, // start PayLo Plans
			{ 1, 1500, 1500, .03, 0, 30 },
			{ 1, 400, 0, 0, 20 }, // end PayLo Plans

			{ 1, 2000, 2000, 0, 0, 25 }, // start SimpleMobile Plans
			{ 0, 2000, 2000, 100, 1, 40 },
			{ 0, 2000, 2000, 100, 3, 50 },
			{ 0, 2000, 2000, 100, 5, 60 }, // end SimpleMobile Plans

			{ 2, 2000, 2000, .5, 100, 30 }, // start H20 Plans
			{ 0, 2000, 2000, 1, 100, 40 },
			{ 0, 2000, 2000, 2, 100, 50 },
			{ 0, 2000, 2000, 100, 3, 60 }, // end H20 Plans

			{ 0, 2000, 2000, 100, .5, 40 }, // start TMo Plans
			{ 0, 2000, 2000, 100, 1, 50 },
			{ 0, 2000, 2000, 100, 3, 60 },
			{ 0, 2000, 2000, 100, 5, 70 },
			{ 0, 2000, 2000, 100, 100, 80 }, // end TMo Plans

			{ 0, 2000, 2000, .5, 100, 40 }, // start MetroPCS Plans
			{ 0, 2000, 2000, 2.5, 100, 50 },
			{ 0, 2000, 2000, 100, 100, 60 }, // end MetroPCS Plans

			{ 0, 2000, 2000, 100, 5, 25 }, // start Republic Wireless Plans
			{ 0, 2000, 2000, 100, 5, 40 }, // end Republic Wireless Plans

			{ 2, 1500, 2000, .1, 100, 30 }, // start Straight Talk Plans
			{ 0, 2000, 2000, 100, 3, 45 }, // end Straight Talk Plans

			{ 2, 250, 250, .01, 100, 12 }, // start Page Plus Plans
			{ 2, 1200, 2000, .5, 100, 30 },
			{ 0, 2000, 2000, 1, 100, 30 },
			{ 0, 2000, 2000, 3, 100, 55 },
			{ 0, 2000, 2000, 5, 100, 70 }, // end Page Plus Plans

			{ 2, 2000, 2000, 0, 0, 20 }, // start PlatinumTel Plans
			{ 2, 2000, 2000, 100, .5, 35 },
			{ 0, 2000, 2000, 100, 2, 50 },
			{ 0, 2000, 2000, 100, 4, 65 }, // end PlatinumTel Plans

			{ 0, 500, 2000, .5, 100, 25 }, // start Kajeet Plans
			{ 0, 1000, 2000, 1, 100, 35 },
			{ 0, 2000, 2000, 2, 100, 50 },// end Kajeet Plans

			{ 2, 2000, 2000, .5, 100, 40 }, // start Red Pocket Mobile Plans
			{ 0, 2000, 2000, 1, 100, 50 },
			{ 0, 2000, 2000, 3, 100, 60 },// end Red Pocket Mobile Plans

			{ 1, 2000, 2000, 0, 0, 25 }, // start Cricket Plans
			{ 2, 2000, 2000, 100, .5, 40 }, { 0, 2000, 2000, 100, 2.5, 50 },
			{ 0, 2000, 2000, 100, 5, 60 } // end Cricket Plans

	};

	static double[][] virginmobile = new double[][] {
			{ 0, 300, 2000, 100, 2.5, 35 }, // start Virgin Mobile Plans
			{ 0, 1200, 2000, 100, 2.5, 45 }, { 0, 2000, 2000, 100, 2.5, 55 }, // end
																				// Virgin
																				// Mobile
																				// Plans
	};

	static double[][] boostmobile = new double[][] {
			{ 0, 2000, 2000, 100, .5, 40 }, // start Boost Mobile Plans
			{ 0, 2000, 2000, 100, 2.5, 50 }, { 0, 2000, 2000, 100, 5, 60 }, // end
																			// Boost
																			// Mobile
																			// Plans
	};

	static double[][] net10 = new double[][] {
			{ 1, 200, 0, 0, 0, 15 }, // start Net10 Plans
			{ 1, 1000, 0, 0, 0, 25 }, { 1, 2000, 2000, 0, 0, 35 },
			{ 2, 2000, 2000, 100, .5, 40 }, { 0, 2000, 2000, 100, 2.5, 50 },
			{ 0, 2000, 2000, 100, 3.5, 60 }, { 0, 2000, 2000, 100, 5, 70 }, // end
																			// Net10
																			// Plans
	};

	static double[][] attprepaid = new double[][] {
			{ 1, 250, 2000, 0, 0, 25 }, // start ATT Plans
			{ 0, 500, 2000, .5, 100, 40 }, { 1, 2000, 2000, 100, 2, 45 },
			{ 0, 2000, 2000, 2.5, 100, 60 }, // end ATT Plans
	};

	static double[][] verizon = new double[][] {
			{ 0, 2000, 2000, .5, 100, 45 }, // start Verizon Plans
			{ 0, 2000, 2000, 1, 100, 50 }, { 0, 2000, 2000, 1.5, 100, 55 },
			{ 0, 2000, 2000, 3.5, 100, 65 }, // end Verizon Plans
	};

	static double[][] tracfone = new double[][] { { 1, 50, 0, 0, 0, 10 }, // start
																			// Tracfone
																			// Plans
			{ 1, 125, 0, 0, 0, 20 }, { 1, 200, 0, 0, 0, 30 }, // end Tracfone
																// Plans
	};

	static double[][] paylo = new double[][] { { 1, 2000, 2000, .05, 0, 40 }, // start
																				// PayLo
																				// Plans
			{ 1, 1500, 1500, .03, 0, 30 }, { 1, 400, 0, 0, 20 }, // end PayLo
																	// Plans
	};

	static double[][] simplemobile = new double[][] {
			{ 1, 2000, 2000, 0, 0, 25 }, // start SimpleMobile Plans
			{ 0, 2000, 2000, 100, 1, 40 }, { 0, 2000, 2000, 100, 3, 50 },
			{ 0, 2000, 2000, 100, 5, 60 }, // end SimpleMobile Plans
	};

	static double[][] h20 = new double[][] {
			{ 2, 2000, 2000, .5, 100, 30 }, // start H20 Plans
			{ 0, 2000, 2000, 1, 100, 40 }, { 0, 2000, 2000, 2, 100, 50 },
			{ 0, 2000, 2000, 100, 3, 60 }, // end H20 Plans
	};

	static double[][] tmobile = new double[][] {
			{ 2, 2000, 2000, 100, .5, 40 }, // start TMo Plans
			{ 0, 2000, 2000, 100, 1, 50 }, { 0, 2000, 2000, 100, 3, 60 },
			{ 0, 2000, 2000, 100, 5, 70 }, { 0, 2000, 2000, 100, 100, 80 }, // end
																			// TMo
																			// Plans
	};

	static double[][] metropcs = new double[][] {
			{ 0, 2000, 2000, .5, 100, 40 }, // start MetroPCS Plans
			{ 0, 2000, 2000, 2.5, 100, 50 }, { 0, 2000, 2000, 100, 100, 60 }, // end
																				// MetroPCS
																				// Plans
	};

	static double[][] republicwireless = new double[][] {
			{ 0, 2000, 2000, 100, 5, 25 }, // start Republic Wireless Plans
			{ 0, 2000, 2000, 100, 5, 40 }, // end Republic Wireless Plans
	};

	static double[][] straighttalk = new double[][] {
			{ 2, 1500, 2000, .1, 100, 30 }, // start Straight Talk Plans
			{ 0, 2000, 2000, 100, 3, 45 }, // end Straight Talk Plans
	};

	static double[][] pageplus = new double[][] {
			{ 2, 250, 250, .01, 100, 12 }, // start Page Plus Plans
			{ 2, 1200, 2000, .5, 100, 30 }, { 0, 2000, 2000, 1, 100, 30 },
			{ 0, 2000, 2000, 3, 100, 55 }, { 0, 2000, 2000, 5, 100, 70 }, // end
																			// Page
																			// Plus
																			// Plans
	};

	static double[][] platinumtel = new double[][] {
			{ 2, 2000, 2000, 0, 0, 20 }, // start PlatinumTel Plans
			{ 2, 2000, 2000, 100, .5, 35 }, { 0, 2000, 2000, 100, 2, 50 },
			{ 0, 2000, 2000, 100, 4, 65 }, // end PlatinumTel Plans
	};

	static double[][] kajeet = new double[][] { { 0, 500, 2000, .5, 100, 25 }, // start
																				// Kajeet
																				// Plans
			{ 0, 1000, 2000, 1, 100, 35 }, { 0, 2000, 2000, 2, 100, 50 },// end
																			// Kajeet
																			// Plans
	};

	static double[][] redpocketmobile = new double[][] {
			{ 2, 2000, 2000, .5, 100, 40 }, // start Red Pocket Mobile Plans
			{ 0, 2000, 2000, 1, 100, 50 }, { 0, 2000, 2000, 3, 100, 60 },// end
																			// Red
																			// Pocket
																			// Mobile
																			// Plans
	};

	static double[][] cricket = new double[][] {
			{ 1, 2000, 2000, 0, 0, 25 }, // start Cricket Plans
			{ 2, 2000, 2000, 100, .5, 40 }, { 0, 2000, 2000, 100, 2.5, 50 },
			{ 0, 2000, 2000, 100, 5, 60 } // end Cricket Plans

	};

	public static int findBestPlans(double phonetype, double minutes,
			double texts, double data, double throttle) {

		double[] request = new double[] { phonetype, minutes, texts, data,
				throttle };
		int counter = 0;
		int line = 0;

		for (int i = 0; i < 36; i++) {
			line++;
			if (request[0] == preplans[i][0]) {
				if ((request[2] % preplans[i][2]) <= 200)
					if ((request[3] % preplans[i][3]) <= 500)
						if ((request[4] % preplans[i][4]) <= 1)
							if ((request[5] % preplans[i][5]) <= 20) {
								matchedPlans[counter] = preplans[i];
								counter++;
								line = i;
								return line + 1;
							}
			}
		}

		for (int i = 0; i < 36; i++) {

			// If it is a smartphone
			if (phonetype == 0) {

				// If minutes are unlimited
				if (request[1] == 0) {

					// Else minutes are limited
				} else {

				}

				// If texts are unlimited
				if (request[2] == 0) {

					// Else texts are limited
				} else {

				}

				// If gigs are unlimited
				if (request[3] == 0) {

					// Else gigs are limited
				} else {

				}

				// If throttle is yes
				if (request[4] == 0) {

					// Else throttle is no
				} else {

				}

			} else if (phonetype == 1) {

				// If minutes are unlimited
				if (request[1] == 0) {

					// Else minutes are limited
				} else {

				}

				// If texts are unlimited
				if (request[2] == 0) {

					// Else texts are limited
				} else {

				}

				// If gigs are unlimited
				if (request[3] == 0) {

					// Else gigs are limited
				} else {

				}

				// If throttle is yes
				if (request[4] == 0) {

					// Else throttle is no
				} else {

				}

			}

			i++;

		}

		return line + 1;

	}

	public void setPlanName(String plan, int position) {

		matchedPlanNames[position] = plan;

	}

	public String getPlanName(int position) {

		return matchedPlanNames[position];

	}

	public String getPhoneType(int position) {

		if (preplans[position][0] == 0) {
			return "Basicphone";
		} else {
			return "Smartphone";
		}
	}

	public String getMinutes(int position) {

		if (preplans[position][2] == 2000) {
			return "Unlimited";
		} else {
			return String.valueOf(preplans[position][2]);
		}
	}

	public String getTexts(int position) {

		if (preplans[position][3] == 2000) {
			return "Unlimited";
		} else {
			return String.valueOf(preplans[position][3]);
		}
	}

	public String getGigs(int position) {

		if (preplans[position][4] == 2000) {
			return "Unlimited";
		} else {
			return String.valueOf(preplans[position][4]);
		}
	}

	public String getPrice(int position) {

		return String.valueOf(preplans[position][5]);

	}
	
	public static double[][] getBrowserPlan(int position){
		
		if (position == 1){
			return attprepaid;
		} else if (position == 2){
			return verizon;
		} else if (position == 3){
			return tmobile;
		} else if (position == 4){
			return boostmobile;
		} else if (position == 5){
			return virginmobile;
		} else if (position == 6){
			return net10;
		} else if (position == 7){
			return metropcs;
		} else if (position == 8){
			return paylo;
		} else if (position == 9){
			return tracfone;
		} else if (position == 10){
			return simplemobile;
		} else if (position == 11){
			return h20;
		} else if (position == 12){
			return republicwireless;
		} else if (position == 13){
			return straighttalk;
		} else if (position == 14){
			return pageplus;
		} else if (position == 15){
			return platinumtel;
		} else if (position == 16){
			return kajeet;
		} else if (position == 17){
			return redpocketmobile;
		} else if (position == 18){
			return cricket;
		}
		
		return null;
	}

}
