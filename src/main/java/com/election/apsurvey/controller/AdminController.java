package com.election.apsurvey.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.election.apsurvey.dto.AdminForm;
import com.election.apsurvey.entity.AdminProperties;
import com.election.apsurvey.service.APSurveyService;
import com.election.apsurvey.service.AdminService;
import com.election.apsurvey.utils.APElectionSurveyUtils;
import com.election.apsurvey.utils.AdminUtils;

@Controller
@RequestMapping("/apelections")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	AdminUtils adminUtil;
	
	@RequestMapping(value="/admin/login", method = RequestMethod.GET)
	public ModelAndView getAdminLogin() {
		
		List<AdminProperties> list = adminService.getAdminProperties();
		AdminForm form = new AdminForm();
		
		for(AdminProperties prop: list) {
			String key = prop.getParamName();
			switch(key) {
				case "partyResults":
					form.setPartyResults(prop.getParamValue());
					break;
				case "acResults":
					form.setAcResults(prop.getParamValue());
					break;
				case "emailID":
					form.setEmailID(prop.getParamValue());
					break;
			}
		}
		
		return new ModelAndView("admin", "adminform", form);
	}
	
	@RequestMapping(value="/admin/form", method = RequestMethod.GET)
	public ModelAndView getAdminForm() {
		
		List<AdminProperties> list = adminService.getAdminProperties();
		AdminForm form = new AdminForm();
		
		for(AdminProperties prop: list) {
			String key = prop.getParamName();
			switch(key) {
				case APElectionSurveyUtils.PARTYRESULTS:
					form.setPartyResults(prop.getParamValue());
					break;
				case APElectionSurveyUtils.ACRESULTS:
					form.setAcResults(prop.getParamValue());
					break;
				case APElectionSurveyUtils.EMAILID:
					form.setEmailID(prop.getParamValue());
					break;
			}
		}
		
		return new ModelAndView("admin", "adminform", form);
	}
	
	@RequestMapping(value="/admin/form", method = RequestMethod.POST)
	public String getAdminFormPost(@ModelAttribute("employee")AdminForm form) {
		
		System.out.println("adminform email: " + form.getEmailID());
		
		adminService.updateAdminProperties(APElectionSurveyUtils.ACRESULTS, form.getAcResults());
		adminService.updateAdminProperties(APElectionSurveyUtils.PARTYRESULTS, form.getPartyResults());
		adminService.updateAdminProperties(APElectionSurveyUtils.EMAILID, form.getEmailID());
		
		return "redirect:form";
		
	}

	@RequestMapping(value="/admin/reload", method = RequestMethod.POST)
	public String getAdminReload() {
		boolean reloadStatus = adminUtil.reloadChanges();
		
		System.out.println("Reload status " + reloadStatus);
		return "redirect:form";
	}
}
