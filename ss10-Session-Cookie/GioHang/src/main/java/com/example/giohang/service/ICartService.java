package com.example.giohang.service;

import com.example.giohang.model.Products;

import java.util.Map;

public interface ICartService {
    boolean checkExist(Products flower, Map<Products, Integer> productList);

    Map.Entry<Products, Integer> productIntegerEntry(Products flower, Map<Products, Integer> productList);

    double getTotal(Map<Products, Integer> list);
}
