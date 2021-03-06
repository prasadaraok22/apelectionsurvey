package com.election.apsurvey.service;

import java.util.List;

import com.election.apsurvey.entity.AssemblyConstituency;
import com.election.apsurvey.entity.AssemblyConstituencyVotes;
import com.election.apsurvey.entity.District;
import com.election.apsurvey.entity.PartyVotes;

public interface APSurveyService {

	public List<District> getDistricts();
	
	public List<AssemblyConstituency> getAssemblyConstituencies();
	
	public List<AssemblyConstituency> getAssemblyConstituencies(String stateID, String districtCode);

	public void voteForAssemblyConstituency(AssemblyConstituencyVotes assemblyConstituencyVotes);
	
	public void voteForParty(PartyVotes partyVotes);
	
	public long getTotalPartyVotes();
	
	public List<Object[]> getTotalPartyVotes(String stateID);
	
	public List<Object[]> getPartyVotesResults(String stateID);
	
	public long getTotalACVotes();
	
	public List<Object[]> getAssemblyConstituenciesVotesResults(String stateID, String districtCode);
}
