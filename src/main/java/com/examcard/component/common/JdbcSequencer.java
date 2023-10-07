package com.examcard.component.common;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

public class JdbcSequencer<T> implements Sequencer<T>, InitializingBean {

	private JdbcTemplate jdbcTemplate;
	private String nextValueQuery;
	private String currentValueQuery;
	private Class<T> sequenceClass;

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(jdbcTemplate, "jdbcTemplate must not be null");
		Assert.hasLength(nextValueQuery, "nextValueQuery must not be empty");
		Assert.hasLength(currentValueQuery, "currentValueQuery must not be empty");
		Assert.notNull(sequenceClass, "sequenceClass must not be null");
	}

	@Override
	public T getNext() {
		T seq = jdbcTemplate.queryForObject(nextValueQuery, sequenceClass);
		return seq;
	}

	@Override
	public T getCurrent() {
		T seq = jdbcTemplate.queryForObject(currentValueQuery, sequenceClass);
		return seq;
	}
	
	public void setNextValueQuery(String nextValueQuery) {
		this.nextValueQuery = nextValueQuery;
	}
	
	public void setCurrentValueQuery(String currentValueQuery) {
		this.currentValueQuery = currentValueQuery;
	}
	
	public void setSequenceClass(Class<T> sequenceClass) {
		this.sequenceClass = sequenceClass;
	}
	
	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
}
