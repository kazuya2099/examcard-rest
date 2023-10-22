package com.examcard.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;


/**
 * The persistent class for the DEPARTMENT database table.
 * 
 */
@Data
@Entity
@NamedQuery(name="Department.findAll", query="SELECT d FROM Department d")
@Where(clause = "DEL_FLG = '0'")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="DEP_NAME")
	private String depName;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="department")
	private List<Employee> employees;

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