package com.examcard.service.authentication;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.examcard.component.authentication.UserDetailsImpl;
import com.examcard.dto.common.UserDto;
import com.examcard.model.Employee;
import com.examcard.model.EmployeeRole;
import com.examcard.repository.common.EmployeeRoleRepository;
import com.examcard.repository.common.UserRepository;

/**
 * DIコンテナに登録すると自動検出してくれるので紐づけ設定不要.
 * @author mhama
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private static final String ROLE_PREFIX = "ROLE_";

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EmployeeRoleRepository employeeRoleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Employee> opt = userRepository.findById(username);
		if (opt.isEmpty()) {
			throw new UsernameNotFoundException(username + " is not exists!");
		}
		Employee employee = opt.get();
		List<EmployeeRole> employeeRoleList = employeeRoleRepository.findByIdEmpId(employee.getId());
		List<GrantedAuthority> authorities = employeeRoleList.stream().map(e -> {return new SimpleGrantedAuthority(ROLE_PREFIX + e.getRoleId());}).collect(Collectors.toList());
		UserDetailsImpl userDetailsImpl = new UserDetailsImpl(employee.getId(), employee.getLoginPassword(), authorities);
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(employee, userDto);
		userDto.setRoleList(authorities.stream().map(e -> e.toString()).collect(Collectors.toList()));
		userDto.setDepartmentId(employee.getDepartment().getId());
		userDto.setDepartmentName(employee.getDepartment().getDepName());
		userDetailsImpl.setUserDto(userDto);
		return userDetailsImpl;
	}
}
