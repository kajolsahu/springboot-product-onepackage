package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
