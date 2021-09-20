package com.assignment.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.warehouse.domain.ProductResponse;
import com.assignment.warehouse.domain.Products;
import com.assignment.warehouse.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("load/product/")
	public ResponseEntity<Products> loadProduct() {
		
       return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.loadProduct());
	}
	
	@GetMapping("products/")
	public ResponseEntity<List<ProductResponse>> fetchAllProduct() {
        
       return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.fetchAllProduct());
	}
	
	@PostMapping("products/{id}/sell")
	public ResponseEntity<HttpStatus> sellProduct(@PathVariable("id") String id) {
        
       return  ResponseEntity.status(HttpStatus.CREATED).body(productService.selltProduct(id));
	}
	
}
