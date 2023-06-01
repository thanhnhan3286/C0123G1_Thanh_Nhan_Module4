package com.example.giohang.service.impl;

import com.example.giohang.model.Products;
import com.example.giohang.repository.IProductsRepository;
import com.example.giohang.service.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService implements IProductsService {
    @Autowired
    private IProductsRepository productsRepository;
    @Override
    public List<Products> findAll() {
        return productsRepository.findAll();
    }

    @Override
    public Products findById(int id) {
        return productsRepository.findById(id).get();
    }
}
