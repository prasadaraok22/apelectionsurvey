package com.election.apsurvey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.election.apsurvey.entity.AssemblyConstituencyVotes;

@Repository
public interface AssemblyConstituencyVotesRepository extends JpaRepository<AssemblyConstituencyVotes, Integer> {
	
}
