package com.studying.MyProject.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@ComponentScan("com.studying.MyProject.configuration")
@EnableWebMvc
@EnableTransactionManagement
public class MyConfig {
    @Bean
    public DataSource dataSorce(){
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try{
            ds.setDriverClass("org.postgresql.Driver");
            ds.setJdbcUrl("jdbc:postgresql://localhost:5432/IntershipDemo?useSSL=false&serverTimezone=UTC");
            ds.setUser("bestuser");
            ds.setPassword("bestuser");
        }
        catch(PropertyVetoException e){
            throw new RuntimeException(e);
        }
        return ds;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSorce());
        sessionFactory.setPackagesToScan("com.studying.MyProject.entity");
        Properties props = new Properties();
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        props.setProperty("hibernate.show_sql", "true");
        sessionFactory.setHibernateProperties(props);
        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

}
