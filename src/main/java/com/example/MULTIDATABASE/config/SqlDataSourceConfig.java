package com.example.MULTIDATABASE.config;

import javax.sql.DataSource;

import com.example.MULTIDATABASE.model.City;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.MULTIDATABASE.repository.Sql",
        entityManagerFactoryRef = "sqlEntityManagerFactory",
        transactionManagerRef= "sqlTransactionManager")
public class SqlDataSourceConfig {
    @Bean
    @ConfigurationProperties("spring.second-datasource")
    public DataSourceProperties sqlDataSourceProperties() {
        return new DataSourceProperties();
    }
    @Bean
    @ConfigurationProperties("spring.second-datasource.configuration")
    public DataSource sqlDataSource() {
        return sqlDataSourceProperties().initializeDataSourceBuilder()
            .type(HikariDataSource.class).build();
    }

    @Bean(name = "sqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean sqlEntityManagerFactory(
           EntityManagerFactoryBuilder builder) {
       return builder
               .dataSource(sqlDataSource())
               .packages(City.class)
               .build();
   }

    @Bean
    public PlatformTransactionManager sqlTransactionManager(
            final @Qualifier("sqlEntityManagerFactory") LocalContainerEntityManagerFactoryBean sqlEntityManagerFactory) {
        return new JpaTransactionManager(sqlEntityManagerFactory.getObject());
    }
}
