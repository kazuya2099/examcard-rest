package com.examcard.repository.application;

import lombok.Data;

@Data
public class CustomerApplicationSearchParam {
	private String sei;
	private String mei;
	private String meiKana;
	private String seiKana;
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
	private String setaiFamily;
	private String setaiCount;
	private String setaiStatus;
	private String setaiYear;
	private String setaiLoan;
	private Long income;
	private Long savings;
	private String employmentStatus;
	private String companyName;
	private String companyZip1;
	private String companyZip2;
	private String companyAddressPrefecture;
	private String companyAddressCity;
	private String companyAddressOoaza;
	private String companyAddressAza;
	private String companyAddressOther;
	private String companyTel1;
	private String companyTel2;
	private String companyTel3;
	private String companyDepartment;
	private String companyIndustryType;
	private String companyWorkYears;
	private String applicationStatus;
	private String applicationComment;
	private Integer start;
	private Integer end;
}
