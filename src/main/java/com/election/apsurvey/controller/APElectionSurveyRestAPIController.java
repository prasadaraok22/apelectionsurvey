package com.election.apsurvey.controller;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.election.apsurvey.entity.AssemblyConstituency;
import com.election.apsurvey.entity.AssemblyConstituencyVotes;
import com.election.apsurvey.entity.District;
import com.election.apsurvey.entity.PartyVotes;
import com.election.apsurvey.service.APSurveyService;	

@RestController
@RequestMapping(path = "/api")
public class APElectionSurveyRestAPIController {

	public static final Logger logger = LoggerFactory.getLogger(APElectionSurveyRestAPIController.class);
	
	@Autowired
	APSurveyService apSurveyService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String testApp() {
		return "App is running successfully!!!!!";
	}
	
	@RequestMapping(value = "/districts", method = RequestMethod.GET)
	public @ResponseBody List<District> getDistricts()
    {
		logger.info("getDistricts!!!!!!!!");
		
		List<District> districts = apSurveyService.getDistricts();
		
        return districts;
    }
	
	@RequestMapping(value = "/assemblyconstituencies", method = RequestMethod.GET)
	public @ResponseBody List<AssemblyConstituency> getAssemblyConstituencies(@RequestParam("stateID") String stateID, @RequestParam("districtCode") String districtCode)
    {
		logger.info("getAssemblyConstituencies!!!!!!!!");
		logger.info("stateID..." + stateID + "  districtCode..." + districtCode);
		
		List<AssemblyConstituency> constituencies = apSurveyService.getAssemblyConstituencies("S01", districtCode);
        return constituencies;
    }

	@RequestMapping(value = "/assemblyconstituencyvote", method = RequestMethod.POST, produces= {"text/plain", "application/json"}, consumes="application/json")
	public String voteForAssemblyConstituency(@RequestBody AssemblyConstituencyVotes acVotes)
    {
		logger.info("voteForAssemblyConstituency: " + acVotes);
		
		apSurveyService.voteForAssemblyConstituency(acVotes);
        return "Success";
    }
	
	@RequestMapping(value = "/voteforparty", method = RequestMethod.POST, produces= {"text/plain", "application/json"}, consumes="application/json")
	public String voteForParty(@RequestBody PartyVotes partyVotes, HttpServletResponse response)
    {
		logger.info("voteForAssemblyConstituency: " + partyVotes);
		
		apSurveyService.voteForParty(partyVotes);
		
		Cookie acVoteCookie = new Cookie("PartyVoteREST", "true");
		// acVoteCookie.setMaxAge(60*60);
		// acVoteCookie.setDomain("example.com");
		// acVoteCookie.setPath("/welcomeUser");
		response.addCookie(acVoteCookie);
		
        return "Success";
    }
	
}