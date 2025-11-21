package com.kanak.helper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderReqDto {

	private long orderId;
	private String orderName;
	private String orderQty;
}
