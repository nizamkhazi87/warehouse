package com.assignment.warehouse.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.assignment.warehouse.domain.ProductResponse;
import com.assignment.warehouse.domain.ProductResponseDTO;
import com.assignment.warehouse.domain.Products;
import com.assignment.warehouse.entity.InventoryEntity;
import com.assignment.warehouse.exception.WarehouseException;
import com.assignment.warehouse.mapper.ProductMapper;
import com.assignment.warehouse.repository.InventoryRepository;
import com.assignment.warehouse.repository.ProductRepository;
import com.assignment.warehouse.util.WarehouseUtil;

@Service
public class ProductService {

	@Autowired
	WarehouseUtil warehouseUtil;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	InventoryRepository inventoryRepository;

	public Products loadProduct() {

		Products products = warehouseUtil.convertJsonToObject("products.json", Products.class);
		
		return ProductMapper.apply(productRepository.saveAll(ProductMapper.apply(products)));
	}

	public List<ProductResponse> fetchAllProduct() {

		List<Tuple> products = productRepository.fetchProducts();

		List<ProductResponse> ListOfProduct = new ArrayList<>();
		if(products.size()>0) {
		Map<String, List<ProductResponseDTO>> productResponsedto = products.stream()
				.map(t -> new ProductResponseDTO(t.get(0, String.class), t.get(1, String.class), t.get(2, String.class),
						t.get(3, Integer.class).toString(), t.get(4, Integer.class).toString(), t.get(5, Integer.class),
						t.get(6, String.class)))
				.collect(Collectors.groupingBy(ProductResponseDTO::getProduct_id, Collectors.toList()));

		
		for (Map.Entry<String, List<ProductResponseDTO>> entry : productResponsedto.entrySet()) {

			ProductResponse productResponse = new ProductResponse();
			productResponse.setProduct_id(entry.getKey());

			List<ProductResponseDTO> product = entry.getValue();

			ProductResponseDTO productResponseDTO = product.stream()
					.min(Comparator.comparing(ProductResponseDTO::getAverage)).get();

			productResponse.setProduct_name(productResponseDTO.getProduct_name());
			productResponse.setStock(productResponseDTO.getAverage().toString());
			if (productResponseDTO.getAverage() > 0) {
				productResponse.setAvilable("YES");
			} else {
				productResponse.setAvilable("NO");
			}

			ListOfProduct.add(productResponse);

		}}else {
			throw new WarehouseException("NO_CONTENT", "Product Not Availbele");
		}
		

		return ListOfProduct;
	}

	public HttpStatus selltProduct(String productId) {
		List<Tuple> productResponse = productRepository.fetchProductFromProductId(productId);

		List<ProductResponseDTO> converToproductdto = productResponse.stream()
				.map(t -> new ProductResponseDTO(t.get(0, String.class), t.get(1, String.class), t.get(2, String.class),
						t.get(3, Integer.class).toString(), t.get(4, Integer.class).toString(), t.get(5, Integer.class),
						t.get(6, String.class)))
				.collect(Collectors.toList());

		ProductResponseDTO leastArticle = converToproductdto.stream().min(Comparator.comparing(ProductResponseDTO::getAverage)).get();

		if (leastArticle.getAverage() <= 0) {
			throw new WarehouseException("NOT_FOUND", "Product Not Availbele");
		} else {
			List<InventoryEntity> inventories = new ArrayList<>();
			converToproductdto.forEach(li -> {
				Integer calculateStock = Integer.parseInt(li.getStock()) - Integer.parseInt(li.getAmount_of());
				InventoryEntity inventoryEntity = new InventoryEntity();
				inventoryEntity.setArt_id(li.getArt_id());
				inventoryEntity.setStock(calculateStock);
				inventoryEntity.setName(li.getInventory_name());
				inventories.add(inventoryEntity);
			});

			inventoryRepository.saveAll(inventories);
		}

		return HttpStatus.CREATED;

	}

}
