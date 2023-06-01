package com.example.giohang.service.impl;

import com.example.giohang.model.Products;
import com.example.giohang.repository.IProductsRepository;
import com.example.giohang.service.ICartService;
import com.example.giohang.service.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class CartService implements ICartService {
    public boolean checkExist(Products products, Map<Products, Integer> productIntegerMap) {
        for (Map.Entry<Products, Integer> e :
                productIntegerMap.entrySet()) {
            if (e.getKey().getId().equals(products.getId())) {
                return true;
            }
        }
        return false;
    }

    public Map.Entry<Products, Integer> productIntegerEntry(Products products, Map<Products, Integer> productIntegerMap) {
        for (Map.Entry<Products, Integer> f : productIntegerMap.entrySet()) {
            if (f.getKey().getId().equals(products.getId())) {
                return f;
            }
        }
        return null;
    }
    @Override
    public double getTotal(Map<Products, Integer> list) {
        double sum = 0;
        for (Map.Entry<Products, Integer> e :
                list.entrySet()) {
            sum = sum + e.getKey().getPrice() * e.getValue();
        }
        return sum;
    }
//    private Map<Products,Integer> products = new HashMap<>();
//
//
//    public Map<Products,Integer> getProducts() {
//        return products;
//    }
//
//    private boolean checkItemInCart(Products product){
//        for (Map.Entry<Products, Integer> entry : products.entrySet()) {
//            if(entry.getKey().getId().equals(product.getId())){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private Map.Entry<Products, Integer> selectItemInCart(Products product){
//        for (Map.Entry<Products, Integer> entry : products.entrySet()) {
//            if(entry.getKey().getId().equals(product.getId())){
//                return entry;
//            }
//        }
//        return null;
//    }
//
//    public void addProduct(Products product){
//        if (!checkItemInCart(product)){
//            products.put(product,1);
//        } else {
//            Map.Entry<Products, Integer> itemEntry = selectItemInCart(product);
//            Integer newQuantity = itemEntry.getValue() + 1;
//            products.replace(itemEntry.getKey(),newQuantity);
//        }
//    }
//
//    public Integer countProductQuantity(){
//        Integer productQuantity = 0;
//        for (Map.Entry<Products, Integer> entry : products.entrySet()) {
//            productQuantity += entry.getValue();
//        }
//        return productQuantity;
//    }
//
//    public Integer countItemQuantity(){
//        return products.size();
//    }
//
//    public Float countTotalPayment(){
//        float payment = 0;
//        for (Map.Entry<Products, Integer> entry : products.entrySet()) {
//            payment += entry.getKey().getPrice() * (float) entry.getValue();
//        }
//        return payment;
//    }
}
