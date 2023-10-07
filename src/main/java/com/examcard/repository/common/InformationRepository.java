package com.examcard.repository.common;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examcard.model.Information;

public interface InformationRepository extends JpaRepository<Information, String> {
	@Query(value = "SELECT i FROM Information i WHERE i.startDate < :systemDate and i.endDate > :systemDate")
	List<Information> selectByDate(@Param("systemDate") Date systemDate);
}
