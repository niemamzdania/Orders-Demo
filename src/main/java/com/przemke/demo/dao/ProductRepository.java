package com.przemke.demo.dao;

import com.przemke.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findProductById(int id);

    @Override
    boolean existsById(Integer integer);
}
