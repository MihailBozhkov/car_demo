package com.example.demo.car_project.controller;


import com.example.demo.car_project.model.Owner;
import com.example.demo.car_project.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/owner")
public class OwnerController {
    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/all")
    public List<Owner> getAllOwners(){
        return  ownerService.getOwners();
    }

    @GetMapping("/{name}")
    public Optional<Owner> getOwner(@PathVariable String name) { return ownerService.getOwner(name); }

    @PostMapping("/add")
    public void addNewCar(@RequestBody Owner owner){
        ownerService.addOwner(owner);

    }
}

