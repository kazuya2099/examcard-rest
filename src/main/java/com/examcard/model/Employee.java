package com.examcard.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


/**
 * The persistent class for the EMPLOYEE database table.
 * 
 */
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Temporal(TemporalType.DATE)
	@Column(name="LOGIN_LAST_DATE")
	private Date loginLastDate;

	@Column(name="LOGIN_PASSWORD")
	private String loginPassword;

	private String mei;

	@Column(name="MEI_KANA")
	private String meiKana;

	private String sei;

	@Column(name="SEI_KANA")
	private String seiKana;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="DEP_ID")
	private Department department;

	public Employee() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getLoginLastDate() {
		return this.loginLastDate;
	}

	public void setLoginLastDate(Date loginLastDate) {
		this.loginLastDate = loginLastDate;
	}

	public String getLoginPassword() {
		return this.loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
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

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}