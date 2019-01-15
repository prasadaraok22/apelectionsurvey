package com.election.apsurvey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.cache.annotation.Cacheable;

import com.election.apsurvey.entity.AssemblyConstituency;

@Repository
public interface AssemblyConstituencyRepository extends JpaRepository<AssemblyConstituency, Integer> {
	
	@Cacheable("assemblyConstituency")
	List<AssemblyConstituency> findByStateIDAndDistrictCode(String stateid, String districtcode);


}
