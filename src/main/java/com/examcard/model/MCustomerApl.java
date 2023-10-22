package com.examcard.model;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


/**
 * The persistent class for the M_CUSTOMER_APL database table.
 * 
 */
@Entity
@Table(name="M_CUSTOMER_APL")
@NamedQuery(name="MCustomerApl.findAll", query="SELECT m FROM MCustomerApl m")
@Where(clause = "DEL_FLG = '0'")
public class MCustomerApl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="ADDRESS_AZA")
	private String addressAza;

	@Column(name="ADDRESS_CITY")
	private String addressCity;

	@Column(name="ADDRESS_OOAZA")
	private String addressOoaza;

	@Column(name="ADDRESS_OTHER")
	private String addressOther;

	@Column(name="ADDRESS_PREFECTURE")
	private String addressPrefecture;

	@Column(name="APL_COMMENT")
	private String aplComment;

	@Column(name="APL_STATUS")
	private String aplStatus;

	@Column(name="COMPANY_ADDRESS_AZA")
	private String companyAddressAza;

	@Column(name="COMPANY_ADDRESS_CITY")
	private String companyAddressCity;

	@Column(name="COMPANY_ADDRESS_OOAZA")
	private String companyAddressOoaza;

	@Column(name="COMPANY_ADDRESS_OTHER")
	private String companyAddressOther;

	@Column(name="COMPANY_ADDRESS_PREFECTURE")
	private String companyAddressPrefecture;

	@Column(name="COMPANY_DEPARTMENT")
	private String companyDepartment;

	@Column(name="COMPANY_INDUSTRY_TYPE")
	private String companyIndustryType;

	@Column(name="COMPANY_NAME")
	private String companyName;

	@Column(name="COMPANY_TEL1")
	private String companyTel1;

	@Column(name="COMPANY_TEL2")
	private String companyTel2;

	@Column(name="COMPANY_TEL3")
	private String companyTel3;

	@Column(name="COMPANY_WORK_YEARS")
	private String companyWorkYears;

	@Column(name="COMPANY_ZIP1")
	private String companyZip1;

	@Column(name="COMPANY_ZIP2")
	private String companyZip2;

	@Temporal(TemporalType.DATE)
	@Column(name="DEL_DATE")
	private Date delDate;

	@Column(name="DEL_FLG")
	private String delFlg;

	private String email;

	@Column(name="EMPLOYMENT_STATUS")
	private String employmentStatus;

	private String income;

	private String mei;

	@Column(name="MEI_KANA")
	private String meiKana;

	@Column(name="MOBILE_TEL1")
	private String mobileTel1;

	@Column(name="MOBILE_TEL2")
	private String mobileTel2;

	@Column(name="MOBILE_TEL3")
	private String mobileTel3;

	@Temporal(TemporalType.DATE)
	@Column(name="REG_DATE")
	private Date regDate;

	private String savings;

	private String sei;

	@Column(name="SEI_KANA")
	private String seiKana;

	@Column(name="SETAI_COUNT")
	private String setaiCount;

	@Column(name="SETAI_FAMILY")
	private String setaiFamily;

	@Column(name="SETAI_LOAN")
	private String setaiLoan;

	@Column(name="SETAI_STATUS")
	private String setaiStatus;

	@Column(name="SETAI_YEAR")
	private String setaiYear;

	private String tel1;

	private String tel2;

	private String tel3;

	@Temporal(TemporalType.DATE)
	@Column(name="UPDATE_DATE")
	private Date updateDate;

	private String zip1;

	private String zip2;

	public MCustomerApl() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddressAza() {
		return this.addressAza;
	}

	public void setAddressAza(String addressAza) {
		this.addressAza = addressAza;
	}

	public String getAddressCity() {
		return this.addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressOoaza() {
		return this.addressOoaza;
	}

	public void setAddressOoaza(String addressOoaza) {
		this.addressOoaza = addressOoaza;
	}

	public String getAddressOther() {
		return this.addressOther;
	}

	public void setAddressOther(String addressOther) {
		this.addressOther = addressOther;
	}

	public String getAddressPrefecture() {
		return this.addressPrefecture;
	}

	public void setAddressPrefecture(String addressPrefecture) {
		this.addressPrefecture = addressPrefecture;
	}

	public String getAplComment() {
		return this.aplComment;
	}

	public void setAplComment(String aplComment) {
		this.aplComment = aplComment;
	}

	public String getAplStatus() {
		return this.aplStatus;
	}

	public void setAplStatus(String aplStatus) {
		this.aplStatus = aplStatus;
	}

	public String getCompanyAddressAza() {
		return this.companyAddressAza;
	}

	public void setCompanyAddressAza(String companyAddressAza) {
		this.companyAddressAza = companyAddressAza;
	}

	public String getCompanyAddressCity() {
		return this.companyAddressCity;
	}

	public void setCompanyAddressCity(String companyAddressCity) {
		this.companyAddressCity = companyAddressCity;
	}

	public String getCompanyAddressOoaza() {
		return this.companyAddressOoaza;
	}

	public void setCompanyAddressOoaza(String companyAddressOoaza) {
		this.companyAddressOoaza = companyAddressOoaza;
	}

	public String getCompanyAddressOther() {
		return this.companyAddressOther;
	}

	public void setCompanyAddressOther(String companyAddressOther) {
		this.companyAddressOther = companyAddressOther;
	}

	public String getCompanyAddressPrefecture() {
		return this.companyAddressPrefecture;
	}

	public void setCompanyAddressPrefecture(String companyAddressPrefecture) {
		this.companyAddressPrefecture = companyAddressPrefecture;
	}

	public String getCompanyDepartment() {
		return this.companyDepartment;
	}

	public void setCompanyDepartment(String companyDepartment) {
		this.companyDepartment = companyDepartment;
	}

	public String getCompanyIndustryType() {
		return this.companyIndustryType;
	}

	public void setCompanyIndustryType(String companyIndustryType) {
		this.companyIndustryType = companyIndustryType;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyTel1() {
		return this.companyTel1;
	}

	public void setCompanyTel1(String companyTel1) {
		this.companyTel1 = companyTel1;
	}

	public String getCompanyTel2() {
		return this.companyTel2;
	}

	public void setCompanyTel2(String companyTel2) {
		this.companyTel2 = companyTel2;
	}

	public String getCompanyTel3() {
		return this.companyTel3;
	}

	public void setCompanyTel3(String companyTel3) {
		this.companyTel3 = companyTel3;
	}

	public String getCompanyWorkYears() {
		return this.companyWorkYears;
	}

	public void setCompanyWorkYears(String companyWorkYears) {
		this.companyWorkYears = companyWorkYears;
	}

	public String getCompanyZip1() {
		return this.companyZip1;
	}

	public void setCompanyZip1(String companyZip1) {
		this.companyZip1 = companyZip1;
	}

	public String getCompanyZip2() {
		return this.companyZip2;
	}

	public void setCompanyZip2(String companyZip2) {
		this.companyZip2 = companyZip2;
	}

	public Date getDelDate() {
		return this.delDate;
	}

	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}

	public String getDelFlg() {
		return this.delFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmploymentStatus() {
		return this.employmentStatus;
	}

	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	public String getIncome() {
		return this.income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public String getMei() {
		return this.mei;
	}

	public void setMei(String mei) {
		this.mei = mei;
	}

	public String getMeiKana() {
		return this.meiKana;
	}

	public void setMeiKana(String meiKana) {
		this.meiKana = meiKana;
	}

	public String getMobileTel1() {
		return this.mobileTel1;
	}

	public void setMobileTel1(String mobileTel1) {
		this.mobileTel1 = mobileTel1;
	}

	public String getMobileTel2() {
		return this.mobileTel2;
	}

	public void setMobileTel2(String mobileTel2) {
		this.mobileTel2 = mobileTel2;
	}

	public String getMobileTel3() {
		return this.mobileTel3;
	}

	public void setMobileTel3(String mobileTel3) {
		this.mobileTel3 = mobileTel3;
	}

	public Date getRegDate() {
		return this.regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getSavings() {
		return this.savings;
	}

	public void setSavings(String savings) {
		this.savings = savings;
	}

	public String getSei() {
		return this.sei;
	}

	public void setSei(String sei) {
		this.sei = sei;
	}

	public String getSeiKana() {
		return this.seiKana;
	}

	public void setSeiKana(String seiKana) {
		this.seiKana = seiKana;
	}

	public String getSetaiCount() {
		return this.setaiCount;
	}

	public void setSetaiCount(String setaiCount) {
		this.setaiCount = setaiCount;
	}

	public String getSetaiFamily() {
		return this.setaiFamily;
	}

	public void setSetaiFamily(String setaiFamily) {
		this.setaiFamily = setaiFamily;
	}

	public String getSetaiLoan() {
		return this.setaiLoan;
	}

	public void setSetaiLoan(String setaiLoan) {
		this.setaiLoan = setaiLoan;
	}

	public String getSetaiStatus() {
		return this.setaiStatus;
	}

	public void setSetaiStatus(String setaiStatus) {
		this.setaiStatus = setaiStatus;
	}

	public String getSetaiYear() {
		return this.setaiYear;
	}

	public void setSetaiYear(String setaiYear) {
		this.setaiYear = setaiYear;
	}

	public String getTel1() {
		return this.tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return this.tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getTel3() {
		return this.tel3;
	}

	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getZip1() {
		return this.zip1;
	}

	public void setZip1(String zip1) {
		this.zip1 = zip1;
	}

	public String getZip2() {
		return this.zip2;
	}

	public void setZip2(String zip2) {
		this.zip2 = zip2;
	}

}