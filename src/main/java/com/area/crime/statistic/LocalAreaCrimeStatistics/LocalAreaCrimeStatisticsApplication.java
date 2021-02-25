package com.area.crime.statistic.LocalAreaCrimeStatistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

@SpringBootConfiguration
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("/src")
public class LocalAreaCrimeStatisticsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocalAreaCrimeStatisticsApplication.class, args);
	}

}
