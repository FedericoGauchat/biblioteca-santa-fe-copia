package com.gob.biblioteca_santa_fe.configuration;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
    
    @Bean("mysqlProperties")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSourceProperties getMysqlProperties(){
        return new DataSourceProperties();
    }

    @Bean("mysqlDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource getMysqlDatasource(){
        return getMysqlProperties().initializeDataSourceBuilder().build();
    }
// ----------------------------------------------------------------------------------------------------
    @Bean("postgresSqlProperties")
    @ConfigurationProperties(prefix = "spring.datasource.postgresql")
    public DataSourceProperties getPostgresSqlProperties(){
        return new DataSourceProperties();
    }

    @Bean("postgresSqlDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.postgresql")
    public DataSource getPostgresSqlDatasource(){
        DataSourceProperties postgresSqlProps = getPostgresSqlProperties();
        return postgresSqlProps.initializeDataSourceBuilder().build();
    }
}
