package com.examcard.service.customer;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examcard.component.authentication.AuthenticationUtil;
import com.examcard.dto.common.UserDto;
import com.examcard.dto.customer.sales.ApplicationDto;
import com.examcard.model.MCustomerApl;
import com.examcard.repository.common.MCustomerAplRepository;
import com.examcard.service.common.ApplicationCommonService;
import com.examcard.util.common.OperationDateUtil;

@Service
@Transactional
public class EditCustomerApplicationService {

	@Autowired
	private ApplicationCommonService applicationCommonService;
	
	@Autowired
	private MCustomerAplRepository mCustomerAplRepository;

	public void update(ApplicationDto applicationDto) {
		MCustomerApl mCustomerApl = new MCustomerApl();
		BeanUtils.copyProperties(applicationDto, mCustomerApl);
		UserDto userDto = AuthenticationUtil.getUserDto();
		mCustomerApl.setUpdateDate(OperationDateUtil.getDate());
		mCustomerAplRepository.save(mCustomerApl);
	}
	
	public ApplicationDto getCustomerApplication(String id) {
		return applicationCommonService.getApplication(id);
	}
}
