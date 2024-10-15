package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;

@SpringBootApplication(scanBasePackages = "com.app")
@EnableAerospikeRepositories(basePackages = "com.app.repository")
public class DeviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeviceApplication.class, args);
	}

}
