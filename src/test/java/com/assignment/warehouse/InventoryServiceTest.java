
package com.assignment.warehouse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.assignment.warehouse.domain.Inventory;
import com.assignment.warehouse.entity.InventoryEntity;
import com.assignment.warehouse.repository.InventoryRepository;
import com.assignment.warehouse.service.InventoryService;
import com.assignment.warehouse.util.StubsFactory;

@SpringBootTest
public class InventoryServiceTest {

	@Mock
	private InventoryRepository inventoryRepository;

	@InjectMocks
	private InventoryService inventoryService;

	@Before
	public void setUp() throws Exception {

		Inventory entities = new Inventory();

		List<Inventory> list = new ArrayList<>();
		list.add(entities);

	}

	@Test
	public void testLoadInventoryFromFile() {
		List<InventoryEntity> list = StubsFactory.geInventriesResponse();
		Mockito.when(inventoryRepository.saveAll(list)).thenReturn(StubsFactory.geInventriesResponse());
		assertEquals(list.size(), 2);

	}
}
