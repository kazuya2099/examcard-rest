package com.examcard.repository.common;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examcard.model.Employee;

public interface UserRepository extends JpaRepository<Employee, String> {
}
