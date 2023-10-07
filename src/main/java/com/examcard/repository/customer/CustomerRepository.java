package com.examcard.repository.customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examcard.model.MCustomerApl;

public interface CustomerRepository extends JpaRepository<MCustomerApl, String> {
	@Query(value = "SELECT m FROM MCustomerApl m WHERE m.companyZip1 = :searchParam")
	public List<MCustomerApl> findByZip1(@Param("searchParam") MCustomerApl customer);
}
