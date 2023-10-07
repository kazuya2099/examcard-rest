package com.examcard.controller.top;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examcard.component.authentication.UserDetailsImpl;
import com.examcard.dto.common.UserDto;
import com.examcard.dto.top.TopDto;
import com.examcard.service.top.TopService;

@Controller
@RequestMapping(value = "/top")
public class TopController {

	@Autowired
	private TopService topService;
	
	@GetMapping(value = {"", "/"})
	public String index(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, Model model) {
		UserDto userDto = userDetailsImpl.getUserDto();
		TopDto topDto = topService.getTopData();
		model.addAttribute("userDto", userDto);
		topDto.setSei(userDto.getSei());
		topDto.setMei(userDto.getMei());
		model.addAttribute("topDto", topDto);
		return "top/index";
	}
}