package com.examcard.repository.application;

import java.util.List;

import com.examcard.model.MCustomerApl;

public interface CustomerApplicationRepository {
	public List<MCustomerApl> findByCriteria(CustomerApplicationSearchParam searchParam);
}
