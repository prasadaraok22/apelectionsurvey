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
	public List<Object[]> getAssemblyConstituenciesVotesResults(String stateID) {
		List<Object[]> results= assemblyConstituencyVotesRepository.findVotesResults(stateID);
		
		return results;
	}

}
