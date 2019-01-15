package com.election.apsurvey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.election.apsurvey.entity.PartyVotes;

@Repository
public interface PartyVotesRepository extends JpaRepository<PartyVotes, Integer> {
	
}
