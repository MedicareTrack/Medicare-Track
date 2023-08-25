package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Carts;

public interface CartsRepository extends JpaRepository<Carts, Long> {

}
