package com.election.apsurvey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.election.apsurvey.entity.AssemblyConstituencyVotes;

@Repository
public interface AssemblyConstituencyVotesRepository extends JpaRepository<AssemblyConstituencyVotes, Integer> {
	
	
	@Query(nativeQuery = true, value = "SELECT COUNT(*) AS partyTotalVotes, partyid AS partyID FROM assemblyconstituencyvotes WHERE stateid= ?1 GROUP BY partyid ORDER BY partyTotalVotes DESC")
	public List<Object[]> findVotesResults(String stateID);
	
}
