package com.election.apsurvey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.election.apsurvey.entity.PartyVotes;

@Repository
public interface PartyVotesRepository extends JpaRepository<PartyVotes, Integer> {
	
	
	@Query(nativeQuery = true, value = "SELECT COUNT(*) AS partyTotalVotes, partyid AS partyID FROM partyvotes WHERE stateid= 'S01' GROUP BY partyid ORDER BY partyTotalVotes DESC")
	public List<Object[]> findPartyVotesResults(String stateID);
	
}
