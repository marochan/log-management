package com.filmlebendczil.logmanagement.entities;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin
public class LogConfig {

	public Map<String, Boolean> actualTypes;
	
	
	
	public LogConfig() {
		actualTypes = new HashMap<String, Boolean>();
		actualTypes.put("error", true);
		actualTypes.put("success", true);
		actualTypes.put("config", true);
	}



	public Map<String, Boolean> getActualTypes() {
		return actualTypes;
	}



	public void setActualTypes(Map<String, Boolean> actualTypes) {
		this.actualTypes = actualTypes;
	}
	
	
}
