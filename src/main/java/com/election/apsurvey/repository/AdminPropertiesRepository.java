package com.election.apsurvey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.election.apsurvey.entity.AdminProperties;

@Repository
public interface AdminPropertiesRepository extends JpaRepository<AdminProperties, Integer>{

	@Transactional
    @Modifying
    @Query(value = "UPDATE adminproperties u set paramValue =:paramValue where u.paramName = :paramName", nativeQuery = true)
    public void updateAdminProperties(@Param("paramName") String paramName, @Param("paramValue") String paramValue);
}
