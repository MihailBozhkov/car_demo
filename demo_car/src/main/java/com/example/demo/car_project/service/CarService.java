package com.example.demo.car_project.service;

import com.example.demo.car_project.model.Car;
import com.example.demo.car_project.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCars(){
        return carRepository.findAll();
    }

    public Optional<Car>getCar(String number) { return carRepository.findCarByNumber(number);}

    public void addCar(Car car){
       Optional<Car>carByNumber = carRepository.
               findCarByNumber(car.getNumber());
       if(carByNumber.isPresent()){
           throw new IllegalStateException("number taken");
       }
       carRepository.save(car);
    }
}
