package com.assignment.warehouse.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {
	
	
	private String product_id;
	
	private String product_name;
	
	private String inventory_name;
	
	private String stock;
	
	private String amount_of;
	
	private Integer average;
	
	private String art_id;
	

}
