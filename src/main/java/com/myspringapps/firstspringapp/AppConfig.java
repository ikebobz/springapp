package com.myspringapps.firstspringapp;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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
      builder.url("jdbc:postgresql://localhost:5432/exam");
      return builder.build();
  }
    
}
