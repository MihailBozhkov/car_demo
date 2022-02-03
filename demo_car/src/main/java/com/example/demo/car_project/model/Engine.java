package com.example.demo.car_project.model;


import javax.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"engine_number"}))
public class Engine {

    @Id
    @SequenceGenerator(
            name="engine_sequence",
            sequenceName = "engine_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "engine_sequence"
    )
    private Long id;

    @Column(name = "engine_number")
    private String engineNumber;

    private Integer volume;
    private Integer horsePower;

    public Engine() {
    }

    public Engine(String engineNumber,Integer volume, Integer horsePower) {
        this.engineNumber = engineNumber;
        this.volume = volume;
        this.horsePower = horsePower;
    }

    public Engine(Long id, String engineNumber, Integer volume, Integer horsePower) {
        this.id = id;
        this.engineNumber = engineNumber;
        this.volume = volume;
        this.horsePower = horsePower;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "id=" + id +
                ", volume=" + volume +
                ", horsePower=" + horsePower +
                '}';
    }
}
