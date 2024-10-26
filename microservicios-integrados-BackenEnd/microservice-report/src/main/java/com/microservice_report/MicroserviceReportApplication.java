package com.microservice_report;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceReportApplication.class, args);
	}

	/*@Bean
	CommandLineRunner init(){
		return args -> {

		};
	}*/

}
