package com.examcard.service.application;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examcard.component.common.JdbcSequencer;
import com.examcard.constant.ApplicationStatus;
import com.examcard.dto.customer.sales.ApplicationDto;
import com.examcard.model.MCustomerApl;
import com.examcard.repository.common.MCustomerAplRepository;
import com.examcard.util.common.OperationDateUtil;

@Service
@Transactional
public class ApplicationCreate01Service {

	@Autowired
	private MCustomerAplRepository mCustomerAplRepository;
	
	@Autowired
	private JdbcSequencer<String> mCustomerAplIdSequencer;
	
	public void insert(ApplicationDto customerApplicationDto) {
		MCustomerApl mCustomerApl = new MCustomerApl();
		BeanUtils.copyProperties(customerApplicationDto, mCustomerApl);
//		UserDto userDto = AuthenticationUtil.getUserDto();
		mCustomerApl.setId(mCustomerAplIdSequencer.getNext());
		mCustomerApl.setUpdateDate(OperationDateUtil.getDate());
		mCustomerApl.setAplStatus(ApplicationStatus.APPLICATION.getCode());
		mCustomerApl.setDelFlg("0");
		mCustomerApl.setRegDate(OperationDateUtil.getDate());
		mCustomerAplRepository.save(mCustomerApl);
	}
	
	public void update(ApplicationDto customerApplicationDto) {
		MCustomerApl mCustomerApl = new MCustomerApl();
		BeanUtils.copyProperties(customerApplicationDto, mCustomerApl);
//		UserDto userDto = AuthenticationUtil.getUserDto();
		mCustomerApl.setId(customerApplicationDto.getId());
		mCustomerApl.setUpdateDate(OperationDateUtil.getDate());
		mCustomerAplRepository.save(mCustomerApl);
	}
}
