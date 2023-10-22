package com.examcard.model;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;


/**
 * The persistent class for the INFORMATION database table.
 * 
 */
@Data
@Entity
@NamedQuery(name="Information.findAll", query="SELECT i FROM Information i")
@Where(clause = "DEL_FLG = '0'")
public class Information implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	private String message;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date startDate;

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