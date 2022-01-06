package com.filmlebendczil.logmanagement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.filmlebendczil.logmanagement.entities.Log;
import com.filmlebendczil.logmanagement.entities.LogConfig;
import com.filmlebendczil.logmanagement.repository.LogRepository;

@RestController
@CrossOrigin
public class LogManagementController {

	private LogConfig config = new LogConfig();

	@Autowired(required = true)
	private LogRepository repository;

	Map<String, Boolean> actualTypes = config.getActualTypes();

	@PostMapping("add")
	public ResponseEntity<Object> addLog(@RequestBody ArrayList<Log> logs) {
		for (Log log : logs) {
			if (actualTypes.containsKey(log.getType()) != true) {
				actualTypes.put(log.getType(), true);
			}
			
			if (actualTypes.get(log.getType()) == false) {
				continue;
			}
			repository.save(log);
		}

		return ResponseEntity.ok(logs);
	}

	@PostMapping("/modify")
	public ResponseEntity<Object> modifyLogFilters(@RequestBody Map<String, Boolean> types) {
		for (Map.Entry<String, Boolean> entry : types.entrySet()) {
			String key = entry.getKey();
			if (actualTypes.containsKey(key) != true) {
				actualTypes.put(key, entry.getValue());
			}
			if (actualTypes.get(key) != types.get(key)) {
				actualTypes.put(key, entry.getValue());
			}
		}
		return ResponseEntity.ok(config.actualTypes);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Object> addNewType(@RequestBody Map<String, Boolean> toDelete) {
		for (Map.Entry<String, Boolean> entry : toDelete.entrySet()) {
			String key = entry.getKey();
			actualTypes.remove(key);
		}

		return ResponseEntity.ok(actualTypes);
	}
}
