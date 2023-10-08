package com.examcard.controller.top;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.examcard.dto.common.UserDto;
import com.examcard.dto.top.TopDto;
import com.examcard.service.top.TopService;
import com.examcard.service.user.UserService;

@RestController
@RequestMapping(value = "/top")
public class TopController {

	@Autowired
	private TopService topService;

	@Autowired
	private UserService userService;
	
	@GetMapping(value = {"/{userId}"})
	@ResponseStatus(HttpStatus.OK)
	public TopDto index(@PathVariable("userId") String userId) {
		UserDto userDto = userService.getUser(userId);
		TopDto topDto = topService.getTopData();
		topDto.setUserDto(userDto);
		return topDto;
	}
}