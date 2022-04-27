package com.example.meu_jwt.repository;

import com.example.meu_jwt.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> getProductByDescription(String description);
}
