package com.assignment.warehouse.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
	
	
	
	private String product_id;
	
	private String product_name;
	
	private String avilable;
	
	private String stock;
	
	

}
