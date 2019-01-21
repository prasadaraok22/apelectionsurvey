package com.election.apsurvey.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.election.apsurvey.utils.APElectionSurveyUtils;

@Controller
@RequestMapping("/apelections/suvery")
public class APElectionSurveyController {
	
	@RequestMapping("/index")
	String home(ModelMap modal) {
		modal.addAttribute("title","CRUD Example");
		return "index";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	
	@RequestMapping("/acvotes")
	public String acVotes(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession(true);
		
		String votesFlag = (String)session.getAttribute(APElectionSurveyUtils.ASSEMBLYCONSTITUENCYVOTESSESSIONFLAG);
		if("TRUE".equals(votesFlag)) {
			return "acvotes";
		}
		session.setAttribute(APElectionSurveyUtils.ASSEMBLYCONSTITUENCYVOTESSESSIONFLAG, "FALSE");
		// Cookie acVoteCookie = new Cookie("ACVote", "true");
		// acVoteCookie.setMaxAge(60*60);
		// acVoteCookie.setDomain("example.com");
		// acVoteCookie.setPath("/welcomeUser");
		// response.addCookie(acVoteCookie);
		return "acvotes";
	}
	
	@RequestMapping("/partyvotes")
	public String partyVotes(HttpServletRequest request, HttpServletResponse response) {
		// Cookie acVoteCookie = new Cookie("PartyVote", "true");
		// acVoteCookie.setMaxAge(60*60);
		// acVoteCookie.setDomain("example.com");
		// acVoteCookie.setPath("/welcomeUser");
		// response.addCookie(acVoteCookie);
		return "partyvotes";
	}

}
