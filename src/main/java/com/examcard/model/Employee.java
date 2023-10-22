package com.examcard.model;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;


/**
 * The persistent class for the EMPLOYEE database table.
 * 
 */
@Data
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
@Where(clause = "DEL_FLG = '0'")
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

	@Temporal(TemporalType.DATE)
	@Column(name="REG_DATE")
	private Date regDate;

	@Temporal(TemporalType.DATE)
	@Column(name="UPDATE_DATE")
	private Date updateDate;

	@Temporal(TemporalType.DATE)
	@Column(name="DEL_DATE")
	private Date delDate;

	@Column(name="DEL_FLG")
	private String delFlg;
}