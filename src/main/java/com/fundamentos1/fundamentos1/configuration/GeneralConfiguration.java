package com.fundamentos1.fundamentos1.configuration;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;

@Configuration


public class GeneralConfiguration {



    @Bean

    public DataSource getDataSource(){

            DataSourceBuilder dataSourceBuilder= DataSourceBuilder.create();
            dataSourceBuilder.driverClassName("org.h2.Driver");
            dataSourceBuilder.url("jdbc:h2:mem:testdb");
            dataSourceBuilder.username("SA");
            dataSourceBuilder.password("");
            return dataSourceBuilder.build();


        }


}
