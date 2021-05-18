package com.przemke.demo.service;

import com.przemke.demo.entity.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    Product getProduct(int productId);
    List<Product> getProducts();
    void deleteProduct(int productId);
}
