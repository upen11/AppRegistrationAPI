package com.company.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.binding.CititzenApp;
import com.company.service.ArService;

@RestController
public class ArRestController {

	@Autowired
	private ArService service;

	@PostMapping("/app")
	public ResponseEntity<String> createCitizenApp(@RequestBody CititzenApp citizenData) {

		Integer appId = service.createApplication(citizenData);

		if (appId > 0) {
			return new ResponseEntity<>("App created with App Id:" + appId , HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Invalid SSN", HttpStatus.BAD_REQUEST);
		}
	}
}
