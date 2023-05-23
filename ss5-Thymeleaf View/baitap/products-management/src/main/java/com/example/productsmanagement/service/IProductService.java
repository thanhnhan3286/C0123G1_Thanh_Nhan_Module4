package com.example.productsmanagement.service;

import com.example.productsmanagement.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getList();

    void add(Product product);

    Product findById(int id);

    void update(Product product);

    void delete(int id);

    List<Product> findByName(String name);
}
