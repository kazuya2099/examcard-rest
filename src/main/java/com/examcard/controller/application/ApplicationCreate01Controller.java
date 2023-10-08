package com.examcard.controller.application;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examcard.component.common.MessageHelper;
import com.examcard.dto.customer.sales.ApplicationDto;
import com.examcard.exception.SystemException;
import com.examcard.form.application.ApplicationCreate01Form;
import com.examcard.service.application.ApplicationCreate01Service;

/**
 * 顧客審査申請新規作成　入力画面
 *
 * @author mhama
 */
@Controller
@RequestMapping(value = "/application/create01")
public class ApplicationCreate01Controller {

	@Autowired
	private ApplicationCreate01Service applicationCreate01Service;
	
	@Autowired
	private MessageHelper message;
	
	@PostMapping(value = {"/insert"})
	public String insert(@Validated ApplicationCreate01Form applicationCreate01Form, BindingResult result) {
		if (result.hasErrors()) {
			throw new SystemException("400", message.getMessage("system.error"));
		}
		ApplicationDto applicationDto = new ApplicationDto();
		BeanUtils.copyProperties(applicationCreate01Form, applicationDto);
		applicationCreate01Service.insert(applicationDto);
		return "redirect:/application/create01/complete";
	}

	@PutMapping(value = "/update")
	public String update(ApplicationCreate01Form applicationCreate01Form) {
		ApplicationDto applicationDto = new ApplicationDto();
		BeanUtils.copyProperties(applicationCreate01Form, applicationDto);
		applicationCreate01Service.update(applicationDto);
		return "application/create01/complete";
	}
}
