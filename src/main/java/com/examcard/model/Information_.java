package com.examcard.model;

import java.util.Date;

import javax.annotation.processing.Generated;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2023-09-27T01:16:02.379+0900")
@StaticMetamodel(Information.class)
public class Information_ {
	public static volatile SingularAttribute<Information, String> id;
	public static volatile SingularAttribute<Information, Date> endDate;
	public static volatile SingularAttribute<Information, String> message;
	public static volatile SingularAttribute<Information, Date> startDate;
}
