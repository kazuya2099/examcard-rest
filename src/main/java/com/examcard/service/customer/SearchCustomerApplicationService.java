package com.examcard.service.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.examcard.component.common.CodeList;
import com.examcard.dto.customer.sales.ApplicationDto;
import com.examcard.dto.customer.sales.SearchDto;
import com.examcard.dto.customer.sales.SearchResultDto;
import com.examcard.exception.BusinessException;
import com.examcard.model.MCustomerApl;
import com.examcard.repository.application.CustomerApplicationSearchParam;
import com.examcard.repository.common.MCustomerAplRepository;

@Service
public class SearchCustomerApplicationService {

	@Autowired
	private CodeList codeList;
	
	@Autowired
	private MCustomerAplRepository mCustomerAplRepository;
	
	@Autowired
	private MessageSource messageSource;

	@Value("${rows.per.page}")
	private int ROWS_PER_PAGE;

	@Value("${pagenation.size}")
	private int PAGENATION_SIZE;

	@Value("${customer.application.search.max.count}")
	private int SEARCH_MAX_COUNT;

	public SearchResultDto search(SearchDto searchDto) {
		long searchCount = count(searchDto);
		int pageNo = (searchDto.getPageNo() == null || searchDto.getPageNo() < 1) ? 1 : 
			searchDto.getPageNo();
		int pageCount = (int) searchCount / ROWS_PER_PAGE;
		searchDto.setPageNo(pageNo);
		searchDto.setPageCount(pageCount);
		
		if (searchCount > SEARCH_MAX_COUNT) {
			throw new BusinessException(messageSource.getMessage(
					"business.error.search.max.count", new String[] {String.valueOf(SEARCH_MAX_COUNT)}, null));
		}
		
		CustomerApplicationSearchParam customerApplicationSearchParam = new CustomerApplicationSearchParam();
		BeanUtils.copyProperties(searchDto, customerApplicationSearchParam);
		customerApplicationSearchParam.setStart((pageNo - 1) * PAGENATION_SIZE);
		customerApplicationSearchParam.setEnd(PAGENATION_SIZE);
		List<MCustomerApl> mCustomerAplList = mCustomerAplRepository.findByCriteria(customerApplicationSearchParam);
		List<ApplicationDto> customerApplicationDtoList = new ArrayList<>();
		mCustomerAplList.stream().map(mCustomerApl -> {
			ApplicationDto applicationDto = new ApplicationDto();
			BeanUtils.copyProperties(mCustomerApl, applicationDto);
			codeList.setCodeName(applicationDto);
			return applicationDto;
		}).collect(Collectors.toList());
		SearchResultDto searchResultDto = new SearchResultDto();
		searchResultDto.setSearchCount(searchCount);
		searchResultDto.setCustomerApplicationDtoList(customerApplicationDtoList);
		return searchResultDto;
	}

	private long count(SearchDto searchDto) {
		CustomerApplicationSearchParam customerApplicationSearchParam = new CustomerApplicationSearchParam();
		BeanUtils.copyProperties(searchDto, customerApplicationSearchParam);
		List<MCustomerApl> mCustomerAplList = mCustomerAplRepository.findByCriteria(customerApplicationSearchParam);
		return mCustomerAplList == null ? 0 : mCustomerAplList.size();
	}
}
