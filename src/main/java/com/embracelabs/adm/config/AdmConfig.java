package com.embracelabs.adm.config;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "com.embracelabs.adm.dao", sqlSessionFactoryRef = "admSqlSessionFactory")
public class AdmConfig {
    @Bean(name = "admDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource admDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "admSqlSessionFactory")
    public SqlSessionFactory admSqlSessionFactory(@Qualifier("admDataSource") DataSource admDataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(admDataSource);
        factoryBean.setMapperLocations(applicationContext.getResources("classpath*:/AdmSql/*.xml"));
        return factoryBean.getObject();
    }

    @Bean(name = "admSqlSession")
    public SqlSessionTemplate admSqlSession(@Qualifier("admSqlSessionFactory") SqlSessionFactory admSqlSessionFactory) {
        return new SqlSessionTemplate(admSqlSessionFactory);
    }

    @Bean(name = "admTransactionManager")
    public DataSourceTransactionManager admTransactionManager(@Qualifier("admDataSource") DataSource admDataSource) {
        return new DataSourceTransactionManager(admDataSource);
    }


}
