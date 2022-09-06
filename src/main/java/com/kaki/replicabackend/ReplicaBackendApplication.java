package com.kaki.replicabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class ReplicaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReplicaBackendApplication.class, args);
	}

}
