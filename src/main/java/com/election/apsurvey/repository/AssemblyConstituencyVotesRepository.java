package com.election.apsurvey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.election.apsurvey.entity.AssemblyConstituencyVotes;

@Repository
public interface AssemblyConstituencyVotesRepository extends JpaRepository<AssemblyConstituencyVotes, Integer> {
	
	
	@Query(nativeQuery = true, value = "SELECT COUNT(*) AS partyTotalVotes, acv1.partyid AS partyID, ac1.constituencyname FROM assemblyconstituencyvotes acv1 INNER JOIN assemblyconstituency ac1 ON acv1.constituencycode = ac1.constituencycode and \r\n" + 
			"acv1.districtcode = ac1.districtcode and  acv1.stateid = ac1.stateid\r\n" + 
			"WHERE acv1.stateid=:stateID and acv1.districtcode=:districtCode GROUP BY partyid, ac1.constituencyname ORDER BY partyTotalVotes DESC")
	public List<Object[]> findAssemblyConstituencyVotesResults(@Param("stateID") String stateID, @Param("districtCode") String districtCode);
	
}
