package com.assignment.warehouse.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.assignment.warehouse.domain.Inventories;
import com.assignment.warehouse.domain.Inventory;
import com.assignment.warehouse.entity.InventoryEntity;

public class InventoryMapper {
	


public static List<InventoryEntity> apply(Inventories inventory) {
	return inventory.getInventory().stream().map(InventoryMapper::applyInventory).collect(Collectors.toList());
}

private static InventoryEntity applyInventory(Inventory inventory) {
	return InventoryEntity.builder().art_id(inventory.getArt_id()).name(inventory.getName())
			.stock(inventory.getStock()).build();
}}