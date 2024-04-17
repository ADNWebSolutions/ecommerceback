package com.ADN.ecommerce.configuration;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
public class AppConfig {

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("Leon");
        dataSource.setPassword("yoProgramo");
        dataSource.setUrl("jdbc:mysql://localhost:3306/e_commerce");        
        return dataSource;
        
    }
}
