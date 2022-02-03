package com.example.demo.car_project.repository;

import com.example.demo.car_project.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    @Query("SELECT o from Owner o WHERE o.firstName=?1" )
    Optional<Owner> findOwnerByName (String name);
}
