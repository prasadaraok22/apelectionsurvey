package com.election.apsurvey.utils;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Initializer {
	
	@Autowired
	AdminUtils adminUtils;
	
	@PostConstruct
	public void init() {
		adminUtils.reloadChanges();
	}

}
