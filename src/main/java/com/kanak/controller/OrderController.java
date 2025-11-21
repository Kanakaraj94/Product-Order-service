package com.kanak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kanak.entity.Order;
import com.kanak.helper.OrderReqDto;
import com.kanak.service.OrderServcie;

@RestController
@RequestMapping("/order/v1/")
public class OrderController {
	
	@Autowired
	private OrderServcie orderService;
	
	@PostMapping("create-order")
	public Order createOrder(@RequestBody Order order) {
		return orderService.createOrder(order);
	}
		
	@GetMapping("list-orders")
	public List<Order> listOrders(){
		return orderService.listAllOrders();
	}
	
	@GetMapping("order-id")
	public Order getOrderById(@RequestBody OrderReqDto req) {
		return orderService.getOrderById(req.getOrderId());
	}
	
	@PutMapping("update-order-id")
	public Order updateOrderById(@RequestBody OrderReqDto req) {
		return orderService.updateOrderById(req);
	}

	@DeleteMapping("delete-order-id")
	public String deleteOrderById(@RequestBody OrderReqDto req) {
		orderService.deleteOrderById(req.getOrderId());
		return "Order deleted successfully for ID : "+req.getOrderId();
	}
	
}
