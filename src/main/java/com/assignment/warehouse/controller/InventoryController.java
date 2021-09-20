package com.assignment.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.warehouse.entity.InventoryEntity;
import com.assignment.warehouse.service.InventoryService;

@RestController
public class InventoryController {

	@Autowired
	InventoryService  inventoryService;
	
	@GetMapping("load/inventory/")
	public ResponseEntity<List<InventoryEntity>> loadInventory() {
       return ResponseEntity.status(HttpStatus.CREATED).body(inventoryService.loadInventory());
	}
	
}
