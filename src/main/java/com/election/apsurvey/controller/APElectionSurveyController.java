package com.election.apsurvey.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.election.apsurvey.dto.PartyVotesResultsDTO;
import com.election.apsurvey.service.APSurveyService;	

@Controller
@RequestMapping("/apelections/suvery")
public class APElectionSurveyController {
	
	public static final Logger logger = LoggerFactory.getLogger(APElectionSurveyController.class);
	
	@Autowired
	APSurveyService apSurveyService;
	
	@RequestMapping("/index")
	String home(ModelMap modal) {
		modal.addAttribute("title","CRUD Example");
		return "index";
	}
	
	@GetMapping(value = "/acvotes")
	public String acVotes(HttpServletRequest request) {

		return "acvotes";
	}
	
	@GetMapping(value = "/acvotesresults")
	public String acVotesResults(HttpServletRequest request) {

		return "acvotesresults";
	}
	
	@GetMapping(value ="/partyvotes")
	public String partyVotes(HttpServletRequest request) {
		return "partyvotes";
	}
	
	@GetMapping("/partyvotesresults")
	public String partyVotesResults(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		logger.info("partyVotesResults!!!!!!!!");
		
		List<Object[]> results = apSurveyService.getPartyVotesResults("S01");
		
		List<PartyVotesResultsDTO> partyVotesResultsList = new ArrayList<PartyVotesResultsDTO>();
		
		double totalVotes = 0L;
		for(Object[] partyvotes: results) {
			BigInteger partyVotes = (BigInteger)partyvotes[0];
			String partyName = (String)partyvotes[1];
			
			totalVotes = totalVotes + partyVotes.longValue();
			PartyVotesResultsDTO p1 = new PartyVotesResultsDTO();
			
			p1.setPartyName(partyName);
			p1.setPartyVotes(partyVotes);
			
			partyVotesResultsList.add(p1);
		}
		
		for(PartyVotesResultsDTO partyvotes: partyVotesResultsList) {
			
			
			long partyVotes = partyvotes.getPartyVotes().longValue();
			
			double voteShare = (partyVotes/totalVotes)*100 ;
			
			partyvotes.setVotesShare(new BigDecimal(voteShare).setScale(2, RoundingMode.FLOOR));
		}
		
		for(PartyVotesResultsDTO partyvotes: partyVotesResultsList) {
			System.out.println(partyvotes);
		}
		model.addAttribute("partyVotesResultsList", partyVotesResultsList);
		return "partyvotesresults";
	}

}
