package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {

}
