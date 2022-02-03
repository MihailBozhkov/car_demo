package com.example.demo.car_project.service;

import com.example.demo.car_project.model.Engine;
import com.example.demo.car_project.repository.EngineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EngineService {

    private  final EngineRepository engineRepository;

    @Autowired
    public EngineService(EngineRepository engineRepository) {this.engineRepository = engineRepository;}

    public List<Engine> getEngines(){
        return engineRepository.findAll();
    }

    public Optional<Engine> getEngine(String engineNumber) { return engineRepository.findEngineByEngineNumber(engineNumber);}

    public void addEngine(Engine engine){
        Optional<Engine> engineByNumber = engineRepository.
                findEngineByEngineNumber(engine.getEngineNumber());
        if(engineByNumber.isPresent()){
            throw new IllegalStateException("engine number taken");
        }
        engineRepository.save(engine);
    }


}
