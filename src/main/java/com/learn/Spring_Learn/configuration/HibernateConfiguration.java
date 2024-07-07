package com.learn.Spring_Learn.configuration;

import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfiguration {
    @Bean
    public PhysicalNamingStrategy getPhysicalNamingStrategy() {
        return new PhysicalNamingStrategyStandardImpl();
    }
}