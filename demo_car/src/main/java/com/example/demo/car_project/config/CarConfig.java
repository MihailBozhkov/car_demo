package com.example.demo.car_project.config;

import com.example.demo.car_project.model.Car;
import com.example.demo.car_project.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CarConfig {

    @Bean
    CommandLineRunner commandLineRunnerCar(CarRepository repository) {
        return args -> {
            Car bmw = new Car(
                    "BMW",
                    "M5",
                    2019,
                    "7777");

            Car mercedes = new Car(
                    "Mercedes",
                    "S63",
                    2021,
                    "5555");

            repository.saveAll( List.of(bmw,mercedes));

        };
    }

}
