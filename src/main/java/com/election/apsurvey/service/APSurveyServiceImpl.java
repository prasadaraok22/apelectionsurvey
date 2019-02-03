package com.election.apsurvey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.election.apsurvey.entity.AssemblyConstituency;
import com.election.apsurvey.entity.AssemblyConstituencyVotes;
import com.election.apsurvey.entity.District;
import com.election.apsurvey.entity.PartyVotes;
import com.election.apsurvey.repository.AssemblyConstituencyRepository;
import com.election.apsurvey.repository.AssemblyConstituencyVotesRepository;
import com.election.apsurvey.repository.DistrictRepository;
import com.election.apsurvey.repository.PartyVotesRepository;

@Service
public class APSurveyServiceImpl implements APSurveyService {
	
	@Autowired
	DistrictRepository districtRepository ;
	
	@Autowired
	AssemblyConstituencyRepository assemblyConstituencyRepository ;
	
	@Autowired
	AssemblyConstituencyVotesRepository assemblyConstituencyVotesRepository ;
	
	@Autowired
	PartyVotesRepository partyVotesRepository ;
	
	@Override
	public List<District> getDistricts() {
	
		List<District> districts = districtRepository.findAll();
		
		return districts;
	}

	@Override
	public List<AssemblyConstituency> getAssemblyConstituencies() {
		
		List<AssemblyConstituency> constituencies = assemblyConstituencyRepository.findAll();
		return constituencies;
	}

	@Override
	public List<AssemblyConstituency> getAssemblyConstituencies(String stateID, String districtCode) {
		List<AssemblyConstituency> constituencies = assemblyConstituencyRepository.findByStateIDAndDistrictCode(stateID, districtCode);
		return constituencies;
	}

	@Override
	public void voteForAssemblyConstituency(AssemblyConstituencyVotes assemblyConstituencyVotes) {
		assemblyConstituencyVotesRepository.save(assemblyConstituencyVotes);
	}

	@Override
	public void voteForParty(PartyVotes partyVotes) {
		partyVotesRepository.save(partyVotes);
	}
	
	@Override
	public List<Object[]> getTotalPartyVotes(String stateID) {
		List<Object[]> results = partyVotesRepository.findTotalPartyVotes(stateID);
		
		return results;
	}
	
	@Override
	public long getTotalPartyVotes() {
		long results = partyVotesRepository.count();
		
		return results;
	}
	
	@Override
	public long getTotalACVotes() {
		long results = assemblyConstituencyVotesRepository.count();
		
		return results;
	}

	@Override
	public List<Object[]> getPartyVotesResults(String stateID) {
		List<Object[]> results = partyVotesRepository.findPartyVotesResults(stateID);
		
		return results;
	}

	@Override
	public List<Object[]> getAssemblyConstituenciesVotesResults(String stateID, String districtCode) {
		List<Object[]> results = assemblyConstituencyVotesRepository.findAssemblyConstituencyVotesResults(stateID, districtCode);
		
		return results;
	}
	
}
