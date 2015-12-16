package com.mathhelper.math.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mathhelper.math.persistence.PlayerDAO;
import com.mathhelper.math.persistence.PlayerDAOImpl;

 
@Configuration
@ComponentScan(basePackages="com.mathhelper.math")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{
 
    @Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
     
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
 
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/theMathHelper");
        dataSource.setUsername("root");
        dataSource.setPassword("linda");
         
        return dataSource;
    }
     
    @Bean
    public PlayerDAO getPlayerDAO() {
        return new PlayerDAOImpl(getDataSource());
    }
    @Bean
    public DataSource getTestDataSource() {
        DataSource bean = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql")
                .build();
         
        return bean;
    }
     
    @Bean
    public PlayerDAO getTestPlayerDAO() {
        return new PlayerDAOImpl(getTestDataSource());
    }
}