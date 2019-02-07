package com.election.apsurvey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.election.apsurvey.entity.AdminProperties;
import com.election.apsurvey.repository.AdminPropertiesRepository;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminPropertiesRepository adminPropertiesRepository ;

	@Override
	public List<AdminProperties> getAdminProperties() {
		List<AdminProperties> list = adminPropertiesRepository.findAll();
		
		return list;
	}

	@Override
	public void updateAdminProperties(String paramName, String paramValue) {
		adminPropertiesRepository.updateAdminProperties(paramName, paramValue);
	}

}
