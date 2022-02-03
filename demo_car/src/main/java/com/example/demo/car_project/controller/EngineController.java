package com.example.demo.car_project.controller;

import com.example.demo.car_project.model.Engine;
import com.example.demo.car_project.service.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/engine")
public class EngineController {
    private final EngineService engineService;

    @Autowired
    public EngineController(EngineService engineService) {
        this.engineService = engineService;
    }

    @GetMapping("/all")
    public List<Engine> getAllEngines(){
        return  engineService.getEngines();
    }

    @GetMapping("/{engineNumber}")
    public Optional<Engine> getEngine(@PathVariable String engineNumber) {return engineService.getEngine(engineNumber);}


    @PostMapping("/add")
    public void addNewCar(@RequestBody Engine engine){
        engineService.addEngine(engine);

    }
}
