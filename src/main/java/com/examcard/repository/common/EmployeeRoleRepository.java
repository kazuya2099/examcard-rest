package com.examcard.repository.common;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.examcard.model.EmployeeRole;

public interface EmployeeRoleRepository extends JpaRepository<EmployeeRole, String> {
	List<EmployeeRole> findByIdEmpId(@Param("empId") String empId);
}
