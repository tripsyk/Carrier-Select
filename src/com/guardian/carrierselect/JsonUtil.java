package com.guardian.carrierselect;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil {
	public static String toJSon(Phones phone) {
		try {
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("name", phone.getName());
			jsonObj.put("release", phone.getRelease());
			jsonObj.put("screensize", phone.getScreensize());
			jsonObj.put("density", phone.getDensity());
			jsonObj.put("backcam", phone.getBackCam());
			jsonObj.put("frontcam", phone.getFrontCam());
			jsonObj.put("weight", phone.getWeight());
			jsonObj.put("thickness", phone.getThickness());
			jsonObj.put("cpu", phone.getCPU());
			jsonObj.put("ram", phone.getRAM());
			jsonObj.put("battery", phone.getBattery());
			JSONArray jsonArr = new JSONArray();

			jsonArr.put(jsonObj);
			
			

			return jsonObj.toString();

		} catch (JSONException ex) {
			ex.printStackTrace();
		}

		return null;
	}
}