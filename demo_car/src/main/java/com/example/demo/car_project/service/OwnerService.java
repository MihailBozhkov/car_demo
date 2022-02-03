package com.example.demo.car_project.service;


import com.example.demo.car_project.model.Owner;
import com.example.demo.car_project.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public List<Owner> getOwners(){
        return ownerRepository.findAll();
    }

    public Optional<Owner> getOwner(String name) { return ownerRepository.findOwnerByName(name); }

    public void addOwner(Owner owner){
        Optional<Owner> ownerByNumber = ownerRepository.
                findOwnerByName(owner.getFirstName());
        if(ownerByNumber.isPresent()){
            throw new IllegalStateException("number taken");
        }
        ownerRepository.save(owner);
    }
}
