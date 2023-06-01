package com.example.giohang.service;

import com.example.giohang.model.Products;

import java.util.Map;

public interface ICartService {
    boolean checkItemInCart(Products products, Map<Products, Integer> productList);

    Map.Entry<Products, Integer> productIntegerEntry(Products products, Map<Products, Integer> productList);

    double countTotalPayment(Map<Products, Integer> list);

    void addProduct(Products products, Map<Products, Integer> productList);

    void removeProduct(Products products, Map<Products, Integer> productList);
}
