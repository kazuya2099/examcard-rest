package com.examcard.service.common;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examcard.component.common.CodeList;
import com.examcard.dto.customer.sales.ApplicationDto;
import com.examcard.model.MCustomerApl;
import com.examcard.repository.common.MCustomerAplRepository;

@Service
@Transactional
public class ApplicationCommonService {

	@Autowired
	private CodeList codeList;
	
	@Autowired
	private MCustomerAplRepository mCustomerAplRepository;
	
	public ApplicationDto getApplication(String id) {
		Optional<MCustomerApl> opt = mCustomerAplRepository.findById(id);
		MCustomerApl mCustomerApl = opt.orElse(new MCustomerApl());
		ApplicationDto applicationDto = new ApplicationDto();
		BeanUtils.copyProperties(mCustomerApl, applicationDto);
		codeList.setCodeName(applicationDto);
		return applicationDto;
	}
}
