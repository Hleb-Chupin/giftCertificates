package com.chupin.configuration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.chupin")
@PropertySource(value = "classpath:db.properties")
@EnableTransactionManagement
public class HibernateConfiguration {

    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String userName;
    @Value("${db.password}")
    private String password;
    @Value("${db.driver}")
    private String driver;
    @Value("${db.showSQL}")
    private String showSQL;
    @Value("${db.dialect}")
    private String dialect;


    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.show_sql", showSQL);
        return properties;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driver);
        dataSource.setInitialSize(5);
        return dataSource();
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        sessionFactoryBean.setPackagesToScan("com.chupin");
        return sessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager hibernateTransactionManager (){
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactoryBean().getObject());
        return hibernateTransactionManager;
    }

}
