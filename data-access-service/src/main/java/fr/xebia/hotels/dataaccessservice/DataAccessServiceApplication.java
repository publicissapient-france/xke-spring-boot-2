package fr.xebia.hotels.dataaccessservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DataAccessServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataAccessServiceApplication.class, args);
    }

}

