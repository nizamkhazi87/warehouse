
package com.assignment.warehouse.util;

import java.util.ArrayList;
import java.util.List;

import com.assignment.warehouse.entity.InventoryEntity;

public final class StubsFactory {

	private StubsFactory() {
	}

	public static List<InventoryEntity> geInventriesResponse() {
		
		InventoryEntity entity=new InventoryEntity();
		entity.setArt_id("1");
		entity.setName("leg");
		entity.setStock(3);
		InventoryEntity entity1=new InventoryEntity();
		entity.setArt_id("2");
		entity.setName("screw");
		entity.setStock(4);
		
		List<InventoryEntity> entities=new ArrayList<>();
		entities.add(entity);
		entities.add(entity1);
		return entities;
	}

	
}
