package com.examcard.dto.common;

import java.util.List;

import lombok.Data;

@Data
public class UserDto {

	private String id;
	private String sei;
	private String mei;
	private String seiKana;
	private String meiKana;
	private String zip1;
	private String zip2;
	private String addressPrefecture;
	private String addressCity;
	private String addressOoaza;
	private String addressAza;
	private String addressOther;
	private String tel1;
	private String tel2;
	private String tel3;
	private String mobileTel1;
	private String mobileTel2;
	private String mobileTel3;
	private String email;
	private String password;
	private String joinDate;
	private String role;
	private String departmentId;
	private String departmentName;
	private List<String> roleList;
}
