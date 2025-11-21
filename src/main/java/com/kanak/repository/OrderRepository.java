package com.kanak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanak.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
