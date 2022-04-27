package com.example.meu_jwt.service;

import com.example.meu_jwt.model.Product;
import com.example.meu_jwt.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductByDescription(String description) {
        return productRepository.getProductByDescription(description).orElseThrow();
    }
}
