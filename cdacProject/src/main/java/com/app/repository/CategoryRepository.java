package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Categories;

public interface CategoryRepository extends JpaRepository<Categories, Long>{

}
