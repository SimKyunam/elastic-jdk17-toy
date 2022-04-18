package com.mile.elasticjdk17toy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@Configuration
@EnableJpaRepositories(basePackages = "com.mile.elasticjdk17toy.repository.rdb")
@ComponentScan(basePackages = "com.mile.elasticjdk17toy.service.rdb")
public class JpaConfig {
}
