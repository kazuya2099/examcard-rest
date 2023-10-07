package com.examcard.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * The primary key class for the EMPLOYEE_ROLE database table.
 * 
 */
@Embeddable
public class EmployeeRolePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="EMP_ID")
	private String empId;

	@Column(name="DEP_ID")
	private String depId;

	public EmployeeRolePK() {
	}
	public String getEmpId() {
		return this.empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getDepId() {
		return this.depId;
	}
	public void setDepId(String depId) {
		this.depId = depId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EmployeeRolePK)) {
			return false;
		}
		EmployeeRolePK castOther = (EmployeeRolePK)other;
		return 
			this.empId.equals(castOther.empId)
			&& this.depId.equals(castOther.depId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.empId.hashCode();
		hash = hash * prime + this.depId.hashCode();
		
		return hash;
	}
}