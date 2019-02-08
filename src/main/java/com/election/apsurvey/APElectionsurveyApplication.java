package com.election.apsurvey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class APElectionsurveyApplication {

	public static void main(String[] args) {
		SpringApplication.run(APElectionsurveyApplication.class, args);
	}
}
