package com.election.apsurvey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.election.apsurvey.entity.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer>{

}
