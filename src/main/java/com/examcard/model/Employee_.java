package com.examcard.model;

import java.util.Date;
import java.util.List;

import javax.annotation.processing.Generated;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2023-09-27T01:16:02.376+0900")
@StaticMetamodel(Employee.class)
public class Employee_ {
	public static volatile SingularAttribute<Employee, String> id;
	public static volatile SingularAttribute<Employee, String> depId;
	public static volatile SingularAttribute<Employee, Date> loginLastDate;
	public static volatile SingularAttribute<Employee, String> loginPassword;
	public static volatile SingularAttribute<Employee, String> mei;
	public static volatile SingularAttribute<Employee, String> meiKana;
	public static volatile SingularAttribute<Employee, String> sei;
	public static volatile SingularAttribute<Employee, String> seiKana;
	public static volatile SingularAttribute<Employee, List<EmployeeRole>> employeeRoleList;
}
