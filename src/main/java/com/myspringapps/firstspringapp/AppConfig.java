package com.myspringapps.firstspringapp;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@ComponentScan
@Configuration
public class AppConfig {

    public AppConfig()
    {

    }

  @Bean
  public DataSource getDataSource()
  {
      DataSourceBuilder builder = DataSourceBuilder.create();
      builder.username("postgres");
      builder.password("");
      builder.url("jdbc:postgresql://localhost:5432/minierp");
      return builder.build();
  }

  /*@Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(dataSource);
    //em.setPackagesToScan(new String[] { "packages.to.scan" });

    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);

    Properties properties = new Properties();
    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    properties.setProperty("hibernate.hbm2ddl.auto", "update");
    em.setJpaProperties(properties);

    return em;
  }*/

    
}
