package com.examcard;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.examcard.component.common.JdbcSequencer;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.examcard.repository")
//@MapperScan("com.examcard.repository")
public class DatasourceConfig {

	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(oracle.jdbc.driver.OracleDriver.class.getName());
		driverManagerDataSource.setUrl("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=DESKTOP-ITP21F1)(PORT=1521))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=EXAMCARD)))");
		driverManagerDataSource.setUsername("EXAMCARD");
		driverManagerDataSource.setPassword("password");
		return driverManagerDataSource;
	}
	
	@Bean
	HibernateJpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setDatabase(Database.ORACLE);
		return hibernateJpaVendorAdapter;
	}
	
	@Bean
	JdbcSequencer<String> mCustomerAplIdSequencer() {
		JdbcSequencer<String> jdbcSequencer = new JdbcSequencer<>();
		jdbcSequencer.setJdbcTemplate(dataSource());
		jdbcSequencer.setSequenceClass(String.class);
		jdbcSequencer.setCurrentValueQuery("SELECT TO_CHAR(M_CUSTOMER_APL_SEQ.CURRVAL,'FM0000000') FROM DUAL");
		jdbcSequencer.setNextValueQuery("SELECT TO_CHAR(M_CUSTOMER_APL_SEQ.NEXTVAL,'FM0000000') FROM DUAL");
		return jdbcSequencer;
	}
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPackagesToScan("com.examcard.model");
		factoryBean.setDataSource(dataSource());
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		
		Map<String, String> jpaPropertyMap = new HashMap<>();
		jpaPropertyMap.put("hibernate.connection.charSet", "UTF-8");
		jpaPropertyMap.put("hibernate.format_sql", "true");
		jpaPropertyMap.put("hibernate.show_sql", "true");
		jpaPropertyMap.put("hibernate.use_sql_comments", "true");
		jpaPropertyMap.put("hibernate.jdbc.batch_size", "30");
		jpaPropertyMap.put("hibernate.jdbc.fetch_size", "100");
		jpaPropertyMap.put("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");
		jpaPropertyMap.put("hibernate.transaction.jta.platform", "org.hibernate.service.jta.platform.internal.WeblogicJtaPlatform");
		factoryBean.setJpaPropertyMap(jpaPropertyMap);
		
		return factoryBean;
	}

	@Bean
	JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

//	@Bean
//	JdbcTemplate jdbcTemplate() {
//		return new JdbcTemplate(dataSource());
//	}
//
//	@Bean
//	SqlSessionFactoryBean sessionFactory() throws IOException {
//		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//		bean.setDataSource(dataSource());
//		bean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
//		bean.setMapperLocations(resolver.getResources("classpath:sql/**/*.xml"));
//		return bean;
//	}
//
//	@Bean
//	SqlSessionTemplate sqlSession() {
//		SqlSessionTemplate bean = null;
//		try {
//			bean = new SqlSessionTemplate(sessionFactory().getObject());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return bean;
//	}
}
