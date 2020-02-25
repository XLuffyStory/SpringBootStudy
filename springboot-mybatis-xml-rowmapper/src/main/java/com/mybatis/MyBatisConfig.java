package com.mybatis;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value = "com.mybatis.mapper", sqlSessionFactoryRef = "sqlSessionFactoryBean")
public class MyBatisConfig {

    @Autowired
    DataSource ds;

    @Bean
    SqlSessionFactory sqlSessionFactoryBean() throws Exception {
	SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
	factoryBean.setDataSource(ds);
	return factoryBean.getObject();
    }

    @Bean
    SqlSessionTemplate sqlSessionTemplate() throws Exception {
	return new SqlSessionTemplate(sqlSessionFactoryBean());
    }

}
