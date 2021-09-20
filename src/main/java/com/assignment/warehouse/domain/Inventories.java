package com.assignment.warehouse.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Inventories {
	
	List<Inventory> inventory;
	
}
