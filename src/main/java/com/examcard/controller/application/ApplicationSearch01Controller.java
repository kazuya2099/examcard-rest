package com.examcard.controller.application;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.examcard.component.common.CodeList;
import com.examcard.constant.CodeMapKey;
import com.examcard.dto.application.ApplicationSearch01InputDto;
import com.examcard.dto.application.ApplicationSearch01OutputDto;
import com.examcard.form.application.ApplicationSearch01Form;
import com.examcard.service.application.ApplicationSearch01Service;

/**
 * 顧客審査申請検索
 *
 * @author mhama
 */
@RestController
@RequestMapping(value = "/application/search01")
public class ApplicationSearch01Controller {

	@Autowired
	private CodeList codeList;
	
	@Autowired
	private ApplicationSearch01Service applicationSearch01Service;
	
	@GetMapping(value = "/search")
	@ResponseStatus(HttpStatus.OK)
	public ApplicationSearch01OutputDto search(@ModelAttribute @Validated ApplicationSearch01Form form, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			ApplicationSearch01OutputDto outputDto = new ApplicationSearch01OutputDto();
			outputDto.setApplicationStatus(codeList.getCodeMap(CodeMapKey.APPLICATION_STATUS));
			return outputDto;
		}

		ApplicationSearch01InputDto inputDto = new ApplicationSearch01InputDto();
		BeanUtils.copyProperties(inputDto, form);
		
		ApplicationSearch01OutputDto outputDto = applicationSearch01Service.search(inputDto);
		outputDto.setApplicationStatus(codeList.getCodeMap(CodeMapKey.APPLICATION_STATUS));
		
		return outputDto;
	}
}
