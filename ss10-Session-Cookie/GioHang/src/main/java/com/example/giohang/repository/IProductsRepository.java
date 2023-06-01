package com.example.giohang.repository;

import com.example.giohang.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductsRepository extends JpaRepository<Products,Integer> {
}
