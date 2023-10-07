package com.examcard.service.application;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examcard.component.common.CodeList;
import com.examcard.component.common.MessageHelper;
import com.examcard.dto.application.ApplicationSearch02InputDto;
import com.examcard.dto.application.ApplicationSearch02OutputDto;
import com.examcard.dto.customer.sales.ApplicationDto;
import com.examcard.exception.BusinessException;
import com.examcard.model.MCustomerApl;
import com.examcard.repository.application.CustomerApplicationSearchParam;
import com.examcard.repository.common.MCustomerAplRepository;

@Service
@Transactional
public class ApplicationSearch02Service {

	@Autowired
	private CodeList codeList;
	
	@Autowired
	private MCustomerAplRepository mCustomerAplRepository;
	
	@Autowired
	private MessageHelper messageHelper;

	@Value("${rows.per.page}")
	private int ROWS_PER_PAGE;

	@Value("${pagenation.size}")
	private int PAGENATION_SIZE;

	@Value("${customer.application.search.max.count}")
	private int SEARCH_MAX_COUNT;

	public ApplicationSearch02OutputDto search(ApplicationSearch02InputDto inputDto) {
		long searchCount = count(inputDto);
		int pageNo = (inputDto.getPageNo() == null || inputDto.getPageNo() < 1) ? 1 : inputDto.getPageNo();
		int pageCount = (int) searchCount / ROWS_PER_PAGE;
		
		if (searchCount > SEARCH_MAX_COUNT) {
			throw new BusinessException(messageHelper.getMessage(
					"business.error.search.max.count", new String[] {String.valueOf(SEARCH_MAX_COUNT)}));
		}
		
		CustomerApplicationSearchParam searchParam = new CustomerApplicationSearchParam();
		BeanUtils.copyProperties(inputDto, searchParam);
		searchParam.setStart((pageNo - 1) * PAGENATION_SIZE);
		searchParam.setEnd(PAGENATION_SIZE);
		List<MCustomerApl> customerApplications = mCustomerAplRepository.findByCriteria(searchParam);
		List<ApplicationDto> customerApplicationDtoList = customerApplications.stream().map(customerApplication -> {
			ApplicationDto applicationDto = new ApplicationDto();
			BeanUtils.copyProperties(customerApplication, applicationDto);
			codeList.setCodeName(applicationDto);
			return applicationDto;
		}).collect(Collectors.toList());
			
		ApplicationSearch02OutputDto outputDto = new ApplicationSearch02OutputDto();
		outputDto.setPageNo(pageNo);
		outputDto.setPageCount(pageCount);
		outputDto.setPageSize(PAGENATION_SIZE);
		outputDto.setSearchCount(searchCount);
		outputDto.setCustomerApplicationDtoList(customerApplicationDtoList);
		return outputDto;
	}

	private long count(ApplicationSearch02InputDto inputDto) {
		CustomerApplicationSearchParam customerApplicationSearchParam = new CustomerApplicationSearchParam();
		BeanUtils.copyProperties(inputDto, customerApplicationSearchParam);
		List<MCustomerApl> mCustomerAplList = mCustomerAplRepository.findByCriteria(customerApplicationSearchParam);
		return mCustomerAplList == null ? 0 : mCustomerAplList.size();
	}
}
