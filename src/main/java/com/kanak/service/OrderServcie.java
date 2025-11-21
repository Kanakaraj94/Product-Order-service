package com.kanak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kanak.entity.Order;
import com.kanak.exception.OrderNotFoundException;
import com.kanak.helper.OrderReqDto;
import com.kanak.repository.OrderRepository;

@Service
public class OrderServcie {

	@Autowired
	private OrderRepository orderRepository;

	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}
	
	public List<Order> listAllOrders() {
		return orderRepository.findAll();
	}

	public Order getOrderById(long orderId) {
		return orderRepository.findById(orderId)
				.orElseThrow(()->new OrderNotFoundException("Order not found for ID: "+orderId));
	}

	public Order updateOrderById(OrderReqDto req) {
		Order order = orderRepository.findById(req.getOrderId()).orElseThrow();
		order.setOrderId(req.getOrderId());
		order.setOrderName(req.getOrderName());
		order.setOrderQty(req.getOrderQty());
		return orderRepository.save(order);
	}
	
	public void deleteOrderById(long orderId) {
		orderRepository.deleteById(orderId);
	}



	
}
