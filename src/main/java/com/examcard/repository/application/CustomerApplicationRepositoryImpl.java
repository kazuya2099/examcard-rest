package com.examcard.repository.application;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.examcard.model.MCustomerApl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class CustomerApplicationRepositoryImpl implements CustomerApplicationRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<MCustomerApl> findByCriteria(CustomerApplicationSearchParam searchParam) {
		Map<String, Object> bindParameters = new HashMap<String, Object>();
		StringBuilder queryString = new StringBuilder();
		queryString.append("SELECT m FROM MCustomerApl m WHERE 1=1");
		if (searchParam.getSei() != null) {
			queryString.append(" AND sei = :sei");
			bindParameters.put("sei", searchParam.getSei());
		}
		if (searchParam.getMei() != null) {
			queryString.append(" AND mei = :mei");
			bindParameters.put("mei", searchParam.getMei());
		}
		if (searchParam.getSeiKana() != null) {
			queryString.append(" AND seiKana = :seiKana");
			bindParameters.put("seiKana", searchParam.getSeiKana());
		}
		if (searchParam.getMeiKana() != null) {
			queryString.append(" AND meiKana = :meiKana");
			bindParameters.put("meiKana", searchParam.getMeiKana());
		}
		if (searchParam.getZip1() != null) {
			queryString.append(" AND zip1 = :zip1");
			bindParameters.put("zip1", searchParam.getZip1());
		}
		if (searchParam.getZip2() != null) {
			queryString.append(" AND zip2 = :zip2");
			bindParameters.put("zip2", searchParam.getZip2());
		}
		if (searchParam.getEmail() != null) {
			queryString.append(" AND email = :email");
			bindParameters.put("email", searchParam.getEmail());
		}
		if (searchParam.getApplicationStatus() != null) {
			queryString.append(" AND applicationStatus = :applicationStatus");
			bindParameters.put("applicationStatus", searchParam.getApplicationStatus());
		}
		if (searchParam.getTel1() != null) {
			queryString.append(" AND tel1 = :tel1");
			bindParameters.put("tel1", searchParam.getTel1());
		}
		if (searchParam.getTel2() != null) {
			queryString.append(" AND tel2 = :tel2");
			bindParameters.put("tel2", searchParam.getTel2());
		}
		if (searchParam.getTel3() != null) {
			queryString.append(" AND tel3 = :tel3");
			bindParameters.put("tel3", searchParam.getTel3());
		}
		TypedQuery<MCustomerApl> findQuery = entityManager.createQuery(queryString.toString(), MCustomerApl.class);
		for (Map.Entry<String, Object> bindParameter : bindParameters.entrySet()) {
			findQuery.setParameter(bindParameter.getKey(), bindParameter.getValue());
		}
		return findQuery.getResultList();
	}

	@Override
	public String getSequence() {
		TypedQuery<String> findQuery = entityManager.createQuery("SELECT TO_CHAR(M_CUSTOMER_APL_SEQ.NEXTVAL,'0000000') FROM DUAL", String.class);
		return findQuery.getSingleResult();
	}
}
