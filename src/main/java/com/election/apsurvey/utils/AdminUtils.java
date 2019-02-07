package com.election.apsurvey.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.election.apsurvey.entity.AdminProperties;
import com.election.apsurvey.service.AdminService;

@Configuration
public class AdminUtils {
	
	private Map<String, String> adminprops = new HashMap<String, String>();
	
	@Autowired
	AdminService adminService;
	
	
	public boolean reloadChanges() {
		
		try {
			List<AdminProperties> list = adminService.getAdminProperties();
			
			for(AdminProperties prop: list) {
				adminprops.put(prop.getParamName(), prop.getParamValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public String getValues(String key) {
		return adminprops.get(key);
	}

}
