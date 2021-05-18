package com.przemke.demo.service;

import com.przemke.demo.dao.ProductRepository;
import com.przemke.demo.entity.Product;
import com.przemke.demo.exceptionhandling.CustomNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProduct(int productId) {
        if(!productRepository.existsById(productId))
            throw new CustomNotFoundException("Product with id=" + productId + " not found");
        return productRepository.getOne(productId);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(int productId) {
        productRepository.deleteById(productId);
    }
}
