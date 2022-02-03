package com.example.demo.car_project.repository;


import com.example.demo.car_project.model.Engine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EngineRepository extends JpaRepository<Engine,Long> {

    @Query("SELECT e from Engine e WHERE e.engineNumber=?1" )
    Optional<Engine> findEngineByEngineNumber (String number);

}
