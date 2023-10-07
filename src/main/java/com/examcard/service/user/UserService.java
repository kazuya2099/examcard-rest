package com.examcard.service.user;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examcard.dto.common.UserDto;
import com.examcard.model.Employee;
import com.examcard.repository.common.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserDto getUser(String id) {
		Optional<Employee> employee = userRepository.findById(id);
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(employee, userDto);
		return userDto;
	}
}
