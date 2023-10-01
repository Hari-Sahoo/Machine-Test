package com.example.reporitories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
