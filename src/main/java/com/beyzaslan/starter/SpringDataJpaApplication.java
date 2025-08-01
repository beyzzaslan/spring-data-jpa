package com.beyzaslan.starter;

import com.beyzaslan.configuration.GlobalProperties;
import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.beyzaslan"})
@SpringBootApplication
@ComponentScan(basePackages = {"com.beyzaslan"})
@EnableJpaRepositories(basePackages = {"com.beyzaslan"})
@PropertySource(value = "classpath:app.properties")

@EnableConfigurationProperties(value = GlobalProperties.class)

public class SpringDataJpaApplication {
    public static void main(String[] args) {

        SpringApplication.run(SpringDataJpaApplication.class, args);

    }
}







































