package com.example.meu_jwt.controller;

import com.example.meu_jwt.model.Product;
import com.example.meu_jwt.repository.ProductRepository;
import com.example.meu_jwt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("description")
    public Product getProductByDescription(@RequestParam String description) {
        return productService.getProductByDescription(description);
    }
}
