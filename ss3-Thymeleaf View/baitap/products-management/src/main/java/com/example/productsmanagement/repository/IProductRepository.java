package com.example.productsmanagement.repository;

import com.example.productsmanagement.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getList();

    void add(Product product);

    void update(Product product);

    void delete(int id);

    List<Product> findByName(String name);
}
