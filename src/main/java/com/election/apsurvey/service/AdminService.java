package com.election.apsurvey.service;

import java.util.List;

import com.election.apsurvey.entity.AdminProperties;

public interface AdminService {

	public List<AdminProperties> getAdminProperties();	
	
	public void updateAdminProperties(String paramName, String paramValue);
}
