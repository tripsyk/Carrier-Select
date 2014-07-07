package com.guardian.carrierselect;



public class Phones {
	
	public static Phones thePhones[] = new Phones[13];
	private String name;
	private String release;
	private String screensize;
	private String density;
	private String backCam;
	private String frontCam;
	private String weight;
	private String thickness;
	private String cpu;
	private String ram;
	private String battery;
	
	public Phones(){
		
	}

	public Phones(String aName, String aRelease, String aScreensize, String aDensity, String aBackCam, String aFrontCam,
			String aWeight, String aThickness, String aCPU, String aRAM, String aBattery){
		
		this.name = aName;
		this.release = aRelease;
		this.screensize = aScreensize;
		this.density = aDensity;
		this.backCam = aBackCam;
		this.frontCam = aFrontCam;
		this.weight = aWeight;
		this.thickness = aThickness;
		this.cpu = aCPU;
		this.ram = aRAM;
		this.battery = aBattery;
		

		
		
	}

	
	public String getName(){
		return this.name;
	}
	
	public String getRelease(){
		return this.release;
	}
	
	public String getScreensize(){
		return this.screensize;
	}
	
	public String getDensity(){
		return this.density;
	}
	
	public String getBackCam(){
		return this.backCam;
	}
	
	public String getFrontCam(){
		return this.frontCam;
	}
	
	public String getWeight(){
		return this.weight;
	}
	
	public String getThickness(){
		return this.thickness;
	}
	
	public String getCPU(){
		return this.cpu;
	}
	
	public String getRAM(){
		return this.ram;
	}
	
	public String getBattery(){
		return this.battery;
	}
	
	
	
	
}