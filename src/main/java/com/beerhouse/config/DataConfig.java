package com.beerhouse.config;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfig {
	
	/*
	 * @Bean public DataSource dataSource() {
	 * 
	 * DriverManagerDataSource dataSource = new DriverManagerDataSource();
	 * 
	 * dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	 * dataSource.setUrl("jdbc:mysql://localhost:3306/craftbeer");
	 * dataSource.setUsername("root"); dataSource.setPassword("phlengm22");
	 * 
	 * return dataSource; }
	 * 
	 * @Bean public JpaVendorAdapter jpaVendorAdapter() {
	 * 
	 * HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	 * vendorAdapter.setDatabase(Database.MYSQL); vendorAdapter.setShowSql(true);
	 * vendorAdapter.setGenerateDdl(false);
	 * vendorAdapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
	 * vendorAdapter.setPrepareConnection(true);
	 * 
	 * return vendorAdapter; }
	 */
}
