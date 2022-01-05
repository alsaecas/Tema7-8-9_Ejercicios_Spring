package com.alsaecas.Tema789_Ejercicios_Spring.entities;


import javax.persistence.*;


@Entity
@Table(name = "laptops")
public class Laptop {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private Integer ram;
    private Float herzs;
    private Double price;
    private Boolean touch;


    //constructores

    public Laptop() {
    }

    public Laptop(Long id, String brand, String model, Integer ram, Float herzs, Double price, Boolean touch) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.herzs = herzs;
        this.price = price;
        this.touch = touch;
    }
    //getter setter


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

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Float getHerzs() {
        return herzs;
    }

    public void setHerzs(Float herzs) {
        this.herzs = herzs;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getTouch() {
        return touch;
    }

    public void setTouch(Boolean touch) {
        this.touch = touch;
    }
}
