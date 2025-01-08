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
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.gob.biblioteca_santa_fe.repository.mysql",
    entityManagerFactoryRef = "mysqlEMF",
    transactionManagerRef = "mysqlTrxManager",
    repositoryImplementationPostfix = "MysqlImpl")

@EnableTransactionManagement
public class MysqlJpaConfig {

    @Bean
    public EntityManagerFactoryBuilder getEntityManagerFactoryBuilder(){
        return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(),null);
    }
    @Bean("mysqlEMF")
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(@Qualifier("mysqlDatasource") DataSource mysqlDS, EntityManagerFactoryBuilder builder){
        Map<String, String> additionalProps = new HashMap<>();
        additionalProps.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        
        return builder.dataSource((mysqlDS))
        .persistenceUnit("mysql")
        .properties(additionalProps)
        .packages("com.gob.biblioteca_santa_fe.repository.mysql", "com.gob.biblioteca_santa_fe.model")
        .build();
    }

    @Bean("mysqlTrxManager")
    public JpaTransactionManager getMysqlTransactionManager(@Qualifier("mysqlEMF") LocalContainerEntityManagerFactoryBean mysqlEMF){
        return new JpaTransactionManager(Objects.requireNonNull(mysqlEMF.getObject()));

    }

}
