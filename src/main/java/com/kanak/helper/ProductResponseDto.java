package com.kanak.helper;

import java.util.List;

import com.kanak.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {

	private String status;
	private String message;
	private List<Product> product;
}
