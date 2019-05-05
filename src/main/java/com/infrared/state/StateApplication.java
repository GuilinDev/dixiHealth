package com.infrared.state;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.infrared.state")
@EnableJpaRepositories(basePackages = {"com.infrared.state.repository"})
@EntityScan(basePackages = {"com.infrared.state.entity"})
public class StateApplication {

    public static void main(String[] args) {
        SpringApplication.run(StateApplication.class, args);
    }

}
