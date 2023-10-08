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
		Optional<Employee> optional = userRepository.findById(id);
		UserDto userDto = new UserDto();
		if (optional.isPresent()) {
			Employee employee = optional.get();
			BeanUtils.copyProperties(employee, userDto);
			userDto.setDepId(employee.getDepartment().getId());
			userDto.setDepName(employee.getDepartment().getDepName());
		}
		return userDto;
	}
}
