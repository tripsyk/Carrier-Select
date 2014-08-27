package com.guardian.carrierselect.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Phones")
public class Phone extends ParseObject{

	public String getName() {
		return getString("Name");
	}
	
	public void setName(String name) {
		put("Name", name);
	}
	
	public String getManufacturer() {
		return getString("Name");
	}
	
	public void setManufacturer(String manufacturer) {
		put("Manufacturer", manufacturer);
	}
}
