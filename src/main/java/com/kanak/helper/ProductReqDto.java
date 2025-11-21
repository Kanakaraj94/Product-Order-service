package com.kanak.helper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductReqDto {

	private long productId;
	private String productName;
	private double productPrice;
}
