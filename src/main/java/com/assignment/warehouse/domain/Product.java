
package com.assignment.warehouse.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {


	private String product_id;
	
	List<Article> contain_articles;
	

	private String name;

}
