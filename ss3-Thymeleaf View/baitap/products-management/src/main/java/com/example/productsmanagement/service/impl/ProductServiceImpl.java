package com.example.productsmanagement.service.impl;

import com.example.productsmanagement.model.Product;
import com.example.productsmanagement.repository.IProductRepository;
import com.example.productsmanagement.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> getList() {
        return productRepository.getList();
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public Product findById(int id) {
        List<Product> productList = productRepository.getList();
        Product product = null;
        for (Product p : productList) {
            if (p.getId().equals(id)) {
                product = p;
                break;
            }
        }
        return product;
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
//        List<Product> productList = productRepository.getList();
//        for (Product p : productList) {
//            if (p.getId().equals(product.getId())) {
//                p.setName(product.getName());
//                p.setBrand(product.getBrand());
//                p.setDescription(product.getDescription());
//                p.setPrice(product.getPrice());
//            }
//        }
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }
}
