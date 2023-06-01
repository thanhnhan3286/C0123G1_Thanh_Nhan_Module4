package com.example.giohang.service;

import com.example.giohang.model.Products;

import java.util.List;

public interface IProductsService {
    List<Products> findAll();

    Products findById(int id);
}
