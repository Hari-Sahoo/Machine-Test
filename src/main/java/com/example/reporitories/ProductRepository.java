package com.example.reporitories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
