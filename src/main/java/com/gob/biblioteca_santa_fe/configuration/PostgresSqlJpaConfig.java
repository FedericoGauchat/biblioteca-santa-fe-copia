package com.gob.biblioteca_santa_fe.configuration;

import java.beans.BeanProperty;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;


@Configuration
@EnableJpaRepositories(
    basePackages = "com.gob.biblioteca_santa_fe.repository.postgres",
    entityManagerFactoryRef = "postgresSqlEMF",
    transactionManagerRef = "posrtgresSqlTrxManager",
    repositoryImplementationPostfix = "PostgresImpl")

@EnableTransactionManagement
public class PostgresSqlJpaConfig {
    
    @Bean("postgresSqlEMF")
    public LocalContainerEntityManagerFactoryBean postgreSqlEntityManagerFactory(@Qualifier("postgresSqlDatasource") DataSource postgresSqlDS, EntityManagerFactoryBuilder builder){
        Map<String, String> additionalProps = new HashMap<>();
        additionalProps.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        
        return builder.dataSource((postgresSqlDS))
        .persistenceUnit("postgreSql")
        .properties(additionalProps)
        .packages("com.gob.biblioteca_santa_fe.repository.postgres", "com.gob.biblioteca_santa_fe.model")
        .build();
    }

    @Bean("posrtgresSqlTrxManager")
    public JpaTransactionManager getPostgreSqlTransactionManager(@Qualifier("postgresSqlEMF") LocalContainerEntityManagerFactoryBean postgresSqlEMF){
        return new JpaTransactionManager(Objects.requireNonNull(postgresSqlEMF.getObject()));

    }

    @Bean("postgresNamedParameterJdbcTemplate")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(@Qualifier("postgresSqlDatasource") DataSource dataSource) {
    return new NamedParameterJdbcTemplate(dataSource);
}
}
