package com.example.productsmanagement.model;

public class Product {
    private Integer id;
    private String name;
    private String description;
    private String brand;
    private Float price;

    public Product() {
    }

    public Product(Integer id, String name,  String description, String brand, Float price) {
        this.id = id;
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
