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

import com.kanak.entity.Product;
import com.kanak.helper.ProductReqDto;
import com.kanak.helper.ProductResponseDto;
import com.kanak.service.ProductService;

@RestController
@RequestMapping("product/v1/")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("create-product")
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}
	
	@GetMapping("list-products")
	public ProductResponseDto listAllProducts() {
		List<Product> results = productService.listAllProducts();
		return new ProductResponseDto("200 OK", "Successful", results);
	}
	
	@GetMapping("product-id")
	public Product findProductById(@RequestBody ProductReqDto req) {
		return productService.findProductById(req.getProductId());
	}
	
	@PutMapping("update-product-id")
	public Product updateProductById(@RequestBody Product product) {
		return productService.updateProductById(product);
	}
	
	@DeleteMapping("delete-product-id")
	public String deleteProductById(@RequestBody ProductReqDto req) {
		return productService.deleteProductById(req.getProductId());
	}
}
