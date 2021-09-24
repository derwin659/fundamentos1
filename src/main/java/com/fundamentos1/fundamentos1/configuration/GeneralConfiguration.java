package com.fundamentos1.fundamentos1.configuration;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:connections.properties")

public class GeneralConfiguration {



   /*    @Bean

    public DataSource getDataSource(){

            DataSourceBuilder dataSourceBuilder=DataSourceBuilder.create();
            dataSourceBuilder.driverClassName(driver);
            dataSourceBuilder.url(jdbcUrl);
            dataSourceBuilder.username(username);
            dataSourceBuilder.password(password);
            return dataSourceBuilder.build();


        }*/


}
