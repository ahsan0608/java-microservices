package com.ahsan.spam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpamApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpamApplication.class,args);
    }
}
