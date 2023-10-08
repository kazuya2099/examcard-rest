package com.examcard.controller.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.examcard.dto.customer.sales.ApplicationDto;
import com.examcard.service.application.ApplicationDetail01Service;

@RestController
@RequestMapping(value = "/application/detail01")
public class ApplicationDetail01Controller {

	@Autowired
	private ApplicationDetail01Service applicationDetail01Service;
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ApplicationDto detailCustomer(@PathVariable("id") String id) {
		ApplicationDto applicationDto = applicationDetail01Service.getApplication(id);
		return applicationDto;
	}
}
