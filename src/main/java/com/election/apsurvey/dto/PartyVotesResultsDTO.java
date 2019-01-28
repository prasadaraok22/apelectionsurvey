package com.election.apsurvey.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class PartyVotesResultsDTO {
    private String partyName;
    private BigInteger partyVotes;
    private BigDecimal votesShare;
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public BigInteger getPartyVotes() {
		return partyVotes;
	}
	public void setPartyVotes(BigInteger partyVotes) {
		this.partyVotes = partyVotes;
	}
	public BigDecimal getVotesShare() {
		return votesShare;
	}
	public void setVotesShare(BigDecimal votesShare) {
		this.votesShare = votesShare;
	}
	
	
	@Override
	public String toString() {
		return "partyName: " + partyName + " partyVotes: " + partyVotes + " votesShare: " + votesShare;
	}
    
}
