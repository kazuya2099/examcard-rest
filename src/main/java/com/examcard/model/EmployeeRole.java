package com.examcard.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the EMPLOYEE_ROLE database table.
 * 
 */
@Entity
@Table(name="EMPLOYEE_ROLE")
@NamedQuery(name="EmployeeRole.findAll", query="SELECT e FROM EmployeeRole e")
public class EmployeeRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmployeeRolePK id;

	@Column(name="ROLE_ID")
	private String roleId;

	public EmployeeRole() {
	}

	public EmployeeRolePK getId() {
		return this.id;
	}

	public void setId(EmployeeRolePK id) {
		this.id = id;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}