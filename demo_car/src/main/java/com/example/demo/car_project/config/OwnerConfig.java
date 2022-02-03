package com.example.demo.car_project.config;

import com.example.demo.car_project.model.Owner;
import com.example.demo.car_project.repository.OwnerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.util.List;

@Configuration
public class OwnerConfig {

    @Bean
    CommandLineRunner commandLineRunnerOwner(OwnerRepository repository) {
        return args -> {
            Owner ivan = new Owner(
                    "Ivan",
                    "Petrov",
                    new Date(91,7,6));

            Owner petar = new Owner(
                    "Petar",
                    "Ivanov",
                    new Date(90,4,6));

            repository.saveAll( List.of(ivan,petar));

        };
    }

}
