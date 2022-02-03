package com.example.demo.car_project.repository;

import com.example.demo.car_project.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

    @Query("SELECT c from Car c WHERE c.number=?1" )
    Optional<Car> findCarByNumber (String number);

}
