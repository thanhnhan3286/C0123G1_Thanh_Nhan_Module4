package com.example.giohang.service.impl;

import com.example.giohang.model.Products;
import com.example.giohang.service.ICartService;
import org.springframework.stereotype.Service;


import java.util.Map;
@Service
public class CartService implements ICartService {
    @Override
    public boolean checkItemInCart(Products products, Map<Products, Integer> productIntegerMap) {
        for (Map.Entry<Products, Integer> e : productIntegerMap.entrySet()) {
            if (e.getKey().getId().equals(products.getId())) {
                return true;
            }
        }
        return false;
    }
    @Override
    public Map.Entry<Products, Integer> productIntegerEntry(Products products, Map<Products, Integer> productIntegerMap) {
        for (Map.Entry<Products, Integer> p : productIntegerMap.entrySet()) {
            if (p.getKey().getId().equals(products.getId())) {
                return p;
            }
        }
        return null;
    }
    @Override
    public double countTotalPayment(Map<Products, Integer> list) {
        int sum = 0;
        for (Map.Entry<Products, Integer> e : list.entrySet()) {
            sum = sum + e.getKey().getPrice() * e.getValue();
        }
        return sum;
    }

    @Override
    public void addProduct(Products products, Map<Products, Integer> productList) {
        Integer quantity;
        if (checkItemInCart(products, productList)) {
            Map.Entry<Products,Integer> m = productIntegerEntry(products,productList);
            quantity = m.getValue() + 1;
            productList.replace(m.getKey(),quantity);
        } else {
            productList.put(products, 1);
        }
    }

    @Override
    public void removeProduct(Products products, Map<Products, Integer> productList) {
        Integer quantity;
        if (checkItemInCart(products, productList)) {
            Map.Entry<Products,Integer> m = productIntegerEntry(products,productList);
            quantity = m.getValue() - 1;
            productList.replace(m.getKey(),quantity);
            if (m.getValue()==0){
                productList.remove(m.getKey());
            }
        } else {
            productList.put(products, 1);
        }
    }
}
