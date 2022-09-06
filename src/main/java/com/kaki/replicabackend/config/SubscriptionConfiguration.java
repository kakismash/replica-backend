package com.kaki.replicabackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import io.r2dbc.spi.ConnectionFactory;

import org.mariadb.r2dbc.MariadbConnectionConfiguration;
import org.mariadb.r2dbc.MariadbConnectionFactory;

@Configuration
@EnableR2dbcRepositories
public class SubscriptionConfiguration extends AbstractR2dbcConfiguration {

    @Bean
    @Primary
    @Override
    public ConnectionFactory connectionFactory() {
        MariadbConnectionConfiguration conf = MariadbConnectionConfiguration.builder()
                .host("localhost")
                .port(4406)
                .username("root")
                .password("root")
                .database("replica")
                .build();
        MariadbConnectionFactory factory = new MariadbConnectionFactory(conf);
        return factory;
    }

}