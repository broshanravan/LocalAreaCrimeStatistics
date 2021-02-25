package com.area.crime.statistic.LocalAreaCrimeStatistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("src.main")
public class LocalAreaCrimeStatisticsApplication {

	public static void main(String[] args) {

		SpringApplication.run(LocalAreaCrimeStatisticsApplication.class, args);
	}

}
