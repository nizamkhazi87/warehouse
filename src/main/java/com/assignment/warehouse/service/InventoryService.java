package com.assignment.warehouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.warehouse.domain.Inventories;
import com.assignment.warehouse.entity.InventoryEntity;
import com.assignment.warehouse.mapper.InventoryMapper;
import com.assignment.warehouse.repository.InventoryRepository;
import com.assignment.warehouse.util.WarehouseUtil;

@Service
public class InventoryService {

	@Autowired
	WarehouseUtil warehouseUtil;

	@Autowired
	InventoryRepository inventoryRepository;

	public List<InventoryEntity> loadInventory() {
		
		Inventories inventory = warehouseUtil.convertJsonToObject("inventory.json", Inventories.class);
		
		return inventoryRepository.saveAll(InventoryMapper.apply(inventory));
	}

}
