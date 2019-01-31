package com.election.apsurvey.dto;

import java.util.Map;
import java.util.TreeMap;

public class AssemblyConstituencyVotesResultsDTO implements Comparable<AssemblyConstituencyVotesResultsDTO>{
	
	public AssemblyConstituencyVotesResultsDTO() {
		partyVotes = new TreeMap<String, Long>();
	}
	
	private String constituencyName;
    
	private Map<String, Long> partyVotes;
	
	private String leadParty = "";

	public String getConstituencyName() {
		return constituencyName;
	}

	public void setConstituencyName(String constituencyName) {
		this.constituencyName = constituencyName;
	}

	public Map<String, Long> getPartyVotes() {
		return partyVotes;
	}

	public void setPartyVotes(Map<String, Long> partyVotes) {
		this.partyVotes = partyVotes;
	}

	public String getLeadParty() {
		
		Long votes = 0L;
		for(String partyName: partyVotes.keySet()) {
			if(partyVotes.get(partyName) > votes) {
				votes = partyVotes.get(partyName);
				leadParty = partyName;
			}
		}
		return leadParty;
	}

	@Override
	public int hashCode() {
		return constituencyName.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
 
		if (this == obj)
			return true;

		if (obj == null || obj.getClass() != this.getClass())
			return false;

		// type casting of the argument.
		AssemblyConstituencyVotesResultsDTO acvr = (AssemblyConstituencyVotesResultsDTO) obj;

		// comparing the state of argument with
		// the state of 'this' Object.
		return (acvr.getConstituencyName() == this.getConstituencyName());
	}

	@Override
	public int compareTo(AssemblyConstituencyVotesResultsDTO o) {
		return this.constituencyName.compareTo(o.getConstituencyName());
	}
	
	
}
