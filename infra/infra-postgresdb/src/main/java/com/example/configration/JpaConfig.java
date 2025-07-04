package com.example.configration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = {"com.example.paymentservice.application.payment.repository", "com.example.paymentservice.outbox.repository"})
@EntityScan(basePackages = {"com.example.paymentservice.application.payment.entity", "com.example.paymentservice.outbox.entity"})
public class JpaConfig {

}

