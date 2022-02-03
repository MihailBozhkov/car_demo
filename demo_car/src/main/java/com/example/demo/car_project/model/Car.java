package com.example.demo.car_project.model;


import javax.persistence.*;


@Entity
@Table
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    private String brand;
    private String model;
    private Integer year;
    private String number;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Engine.class)
    @JoinColumn(name = "engine_id")
    private Engine engine;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, targetEntity = Owner.class)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Owner owner;

    public Car() {
    }

    public Car(Long id, String brand, String model, Integer year, String number) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.number = number;
    }

    public Car(String brand, String model, Integer year, String number) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.number = number;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", number='" + number + '\'' +
                '}';
    }
}
