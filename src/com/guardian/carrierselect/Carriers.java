package com.guardian.carrierselect;


public class Carriers {
	
	
	private String[] matchedPlanNames = new String[10];
	public static double[][] matchedPlans = new double[10][0];
	
	// Texts over 2,000 stand for unlimited. Minutes over 2,000 stand for unlimited.
	static double[][] preplans = new double[][]{
			  { 1, 0, 300, 2000, 2.5, 35}, //start Virgin Mobile Plans
			  { 1, 0, 1200, 2000, 2.5, 45},
			  { 1, 0, 2000, 2000, 2.5, 55},
			  { 0, 1, 300, 2000, 2.5, 35},
			  { 0, 1, 1200, 2000, 2.5, 45},
			  { 0, 1, 2000, 2000, 2.5, 55}, //end Virgin Mobile Plans
			  { 1, 0, 2000, 2000, 2.5, 55}, //start Boost Mobile Plans
			  { 0, 1, 2000, 2000, 2.5, 50}, //end Boost Mobile Plans
			  { 0, 1, 1000, 0, 0, 25}, //start Net10 Plans
			  { 0, 1, 2000, 2000, .5, 45}, //end Net10 Plans
			  { 1, 0, 250, 2000, 0, 25}, //start ATT Plans
			  { 1, 0, 500, 2000, .2, 40},
			  { 1, 0, 2000, 2000, 0, 50},
			  { 0, 1, 2000, 2000, 100, 50},
			  { 0, 1, 500, 2000, 200, 35},
			  { 0, 1, 250, 2000, 0, 25}, //end ATT Plans
			  { 1, 0, 2000, 2000, 4, 70}, //start Verizon Plans
			  { 1, 0, 2000, 2000, 2, 60},
			  { 1, 0, 2000, 2000, 1, 50}, //end Verizon Plans
			  { 0, 1, 50, 0, 0, 10}, //start Tracfone Plans
			  { 0, 1, 125, 0, 0, 20},
			  { 0, 1, 200, 0, 0, 30}, //end Tracfone Plans
			  { 0, 1, 2000, 2000, .05, 40}, //start PayLo Plans
			  { 0, 1, 1500, 1500, .03, 30},
			  { 0, 1, 400, 0, 0, 20}, //end PayLo Plans
			  { 0, 1, 2000, 2000, 0, 25}, //start SimpleMobile Plans
			  { 1, 0, 2000, 2000, 1, 40},
			  { 1, 0, 2000, 2000, 3, 50},
			  { 1, 0, 2000, 2000, 5, 60}, //end SimpleMobile Plans
			  { 0, 1, 2000, 2000, .5, 30}, //start H20 Plans
			  { 1, 0, 2000, 2000, .5, 30},
			  { 1, 0, 2000, 2000, 100, 60}, //end H20 Plans
			  { 1, 0, 2000, 2000, .5, 50}, //start TMo Plans
			  { 1, 0, 2000, 2000, 2.5, 60},
			  { 1, 0, 2000, 2000, 100, 70},
			  { 0, 1, 30, 0, 0, 10} //end TMo Plans
			  
			};
	
	public static int findBestPlans(double smartphones, double basicphones, double minutes, double texts, double data, double price){
		
		double[] request = new double[] {smartphones, basicphones, minutes, texts, data, price};
		int counter = 0;
		int line = 0;
		
		for (int i = 0; i < 36; i++){
			
			line++;
			
			if (request[0] == preplans[i][0]){
				if (request[1] == preplans[i][1])
					if((request[2] % preplans[i][2]) <= 200)
						if((request[3] % preplans[i][3]) <= 500)
							if((request[4] % preplans[i][4]) <= 1)
								if((request[5] % preplans[i][5]) <= 20){
									matchedPlans[counter] = preplans[i];
									counter++;
									line = i;
									return line + 1;
								}
				
								
			}
			
			
		}
		return line + 1;
		
		
		
		
		
		
		
		
	}
	
	public void setPlanName(String plan, int position){
		
		matchedPlanNames[position] = plan;
		
		
	}
	
	public String getPlanName(int position){
		
		return matchedPlanNames[position];
		
		
	}
	
	
	

}
