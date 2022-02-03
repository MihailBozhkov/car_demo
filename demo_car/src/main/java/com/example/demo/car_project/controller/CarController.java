package com.example.demo.car_project.controller;

import com.example.demo.car_project.model.Car;
import com.example.demo.car_project.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/car")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/all")
    public List<Car> getAllCars(){
      return  carService.getCars();
    }

    @GetMapping("/{number}")
    public Optional<Car> getCarByNumber(@PathVariable String number) { return carService.getCar(number);}

    @PostMapping("/add")
    public void addNewCar(@RequestBody Car car){
        carService.addCar(car);

    }
}
