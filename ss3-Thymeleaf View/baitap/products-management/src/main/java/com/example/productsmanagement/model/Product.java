package com.example.productsmanagement.model;


import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(columnDefinition = "VARCHAR(30)")
    private String brand;
    @Column(nullable = false)
    private Float price;

    public Product() {
    }

    public Product(Integer id, String name, String description, String brand, Float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.price = price;
    }

    public Product(String name, String description, String brand, Float price) {
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
