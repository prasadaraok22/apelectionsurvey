package com.election.apsurvey.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.election.apsurvey.dto.AssemblyConstituencyVotesResultsDTO;
import com.election.apsurvey.dto.PartyVotesResultsDTO;
import com.election.apsurvey.entity.AssemblyConstituency;
import com.election.apsurvey.entity.AssemblyConstituencyVotes;
import com.election.apsurvey.entity.District;
import com.election.apsurvey.entity.PartyVotes;
import com.election.apsurvey.service.APSurveyService;
import com.election.apsurvey.utils.APElectionSurveyUtils;	

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
	public String voteForAssemblyConstituency(@RequestBody AssemblyConstituencyVotes acVotes, HttpServletRequest request)
    {
		logger.info("voteForAssemblyConstituency: " + acVotes);
		
		HttpSession session = request.getSession(false);
		if(null != session) {
			String votesFlag = (String)session.getAttribute(APElectionSurveyUtils.ASSEMBLYCONSTITUENCYVOTESSESSIONFLAG);
			if("TRUE".equals(votesFlag)) {
				return "DoneAlready";
			}else {
				apSurveyService.voteForAssemblyConstituency(acVotes);
				session.setAttribute(APElectionSurveyUtils.ASSEMBLYCONSTITUENCYVOTESSESSIONFLAG, "TRUE");
				return "Success";
			}
		}
		
		return "LoadVotesPage";
    }
	
	@RequestMapping(value = "/voteforparty", method = RequestMethod.POST, produces= {"text/plain", "application/json"}, consumes="application/json")
	public String voteForParty(@RequestBody PartyVotes partyVotes, HttpServletRequest request)
    {
		logger.info("voteForAssemblyConstituency: " + partyVotes);
		
		HttpSession session = request.getSession(false);
		
		
		if(null != session) {
			String votesFlag = (String)session.getAttribute(APElectionSurveyUtils.PARTYVOTESSESSIONFLAG);
			if("TRUE".equals(votesFlag)) {
				return "DoneAlready";
			}else {
				apSurveyService.voteForParty(partyVotes);
				session.setAttribute(APElectionSurveyUtils.PARTYVOTESSESSIONFLAG, "TRUE");
				return "Success";
			}
		}
		
        return "Success";
    }
	
	@RequestMapping(value = "/partyvotesresults", method = RequestMethod.GET)
	public @ResponseBody List<Object[]> getPartyVotesResults()
    {
		logger.info("getPartyVotesResults!!!!!!!!");
		
		List<Object[]> results = apSurveyService.getPartyVotesResults("S01");
        return results;
    }
	
	@RequestMapping(value = "/acvotesresults", method = RequestMethod.GET)
	public @ResponseBody Set<AssemblyConstituencyVotesResultsDTO> getAssemblyConstituencyVotesResults(@RequestParam String districtCode)
    {
		logger.info("getAssemblyConstituencyVotesResults!!!!!!!!");
		
		String stateID = "S01";
		
		if(districtCode == null) {
			districtCode = "12";
		}
		
		logger.info("Get Votes Results for District : " + districtCode);
		
		List<Object[]> results = apSurveyService.getAssemblyConstituenciesVotesResults(stateID, districtCode);
		
		Map<String, AssemblyConstituencyVotesResultsDTO> acVotesResultsList = new TreeMap<String, AssemblyConstituencyVotesResultsDTO>();
		
		double totalVotes = 0L;
		
		for(Object[] partyvotes: results) {
			BigInteger partyVotes = (BigInteger)partyvotes[0];
			String partyName = (String)partyvotes[1];
			String constituencyName = (String)partyvotes[2];
			
			AssemblyConstituencyVotesResultsDTO ac1 = null;
			if(acVotesResultsList.get(constituencyName) != null) {
				ac1 = acVotesResultsList.get(constituencyName);
			}else {
				ac1 = new AssemblyConstituencyVotesResultsDTO();
			}
			
			ac1.getPartyVotes().put(partyName, partyVotes.longValue());
			ac1.setConstituencyName(constituencyName);
			acVotesResultsList.put(constituencyName, ac1);
		}
		
		Set<AssemblyConstituencyVotesResultsDTO> results2 = new TreeSet<AssemblyConstituencyVotesResultsDTO>();
		
		Set<String> keys = acVotesResultsList.keySet();
		
		for(String key: keys) {
			results2.add(acVotesResultsList.get(key));
		}
		
        return results2;
    }
}