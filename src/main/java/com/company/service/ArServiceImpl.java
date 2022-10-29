package com.company.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.company.binding.CititzenApp;
import com.company.entity.CitizenAppEntity;
import com.company.repository.CitizenAppRepository;

@Service
public class ArServiceImpl implements ArService {

	@Autowired
	private CitizenAppRepository repo;

	@Override
	public Integer createApplication(CititzenApp citizenData) {

		// make rest call to ssa-web api with ssn as input

		String endpointUrl = "https://ssa-web-api.herokuapp.com/ssn/{ssn}";

		// RestTemplate is a predefined class which is used to make HTTP request
		// RestTemplate is synchronous and will not block the executing thread while waiting for the response to come back.
		RestTemplate rt = new RestTemplate();

		ResponseEntity<String> resEntity = rt.getForEntity(endpointUrl, String.class, citizenData.getSsn());
		
		System.out.println(citizenData.getFullName());

		String stateName = resEntity.getBody();

		if ("New Jersey".equals(stateName)) {
			CitizenAppEntity entity = new CitizenAppEntity();
			BeanUtils.copyProperties(citizenData, entity);

			CitizenAppEntity save = repo.save(entity);

			return save.getAppId();
		}
		return 0;
	}

}
