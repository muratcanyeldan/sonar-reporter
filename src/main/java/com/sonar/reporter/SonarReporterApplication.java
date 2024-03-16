package com.sonar.reporter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SonarReporterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SonarReporterApplication.class, args);
    }

}
