package com.example.demo.car_project.config;

import com.example.demo.car_project.model.Engine;
import com.example.demo.car_project.repository.EngineRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EngineConfig {

    @Bean
    CommandLineRunner commandLineRunnerEngine(EngineRepository repository) {
        return args -> {
            Engine vEight = new Engine(
                    "1234",
                    5,
                    500
            );

            Engine vTwelve = new Engine(
                    "1010",
                    6,
                    700
            );

            repository.saveAll( List.of(vEight,vTwelve));

        };
    }

}
