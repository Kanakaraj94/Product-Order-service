package com.kanak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kanak.entity.Product;
import com.kanak.exception.ProductNotFoundException;
import com.kanak.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public List<Product> listAllProducts() {
		return productRepository.findAll();
	}

	public Product findProductById(long productId) {
		return productRepository.findById(productId)
				.orElseThrow(()->new ProductNotFoundException("Product not found for ID: "+productId));
	}

	public Product updateProductById(Product product) {
		Product results = productRepository.findById(product.getProductId()).orElseThrow();
		results.setProductId(product.getProductId());
		results.setProductName(product.getProductName());
		results.setProductPrice(product.getProductPrice());
		return productRepository.save(results);
	}

	public String deleteProductById(long productId) {
		Product results = productRepository.findById(productId).orElseThrow();
		productRepository.deleteById(results.getProductId());
		return "Product deleted for ID : "+results.getProductId();
	}
}
