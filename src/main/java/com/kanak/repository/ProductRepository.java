package com.kanak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanak.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
