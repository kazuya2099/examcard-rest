package com.examcard.repository.common;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examcard.model.MCustomerApl;
import com.examcard.repository.application.CustomerApplicationRepository;

public interface MCustomerAplRepository extends JpaRepository<MCustomerApl, String>, CustomerApplicationRepository {
}
