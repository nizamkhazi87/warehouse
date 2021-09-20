package com.assignment.warehouse.repository;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assignment.warehouse.entity.ProductEntity;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
	
	String query1="select distinct  product.product_id,product.name as product_name, inventory.name as inventory_name, "
			+ "inventory.stock,article.amount_of,inventory.stock/article.amount_of as average ,inventory.art_id from product \n"
			+ "INNER JOIN article\n"
			+ "ON product.product_id = article.product_pk\n"
			+ "INNER JOIN inventory on article.art_id=inventory.art_id"; 
	
	String query2="select distinct  product.product_id,product.name as product_name, inventory.name as inventory_name, "
			+ "inventory.stock,article.amount_of,inventory.stock/article.amount_of as average ,inventory.art_id from product \n"
			+ "INNER JOIN article\n"
			+ "ON product.product_id = article.product_pk\n"
			+ "INNER JOIN inventory on article.art_id=inventory.art_id where  product.product_id=:id"; 
	
	@Query(value = query1, nativeQuery = true)
    List<Tuple> fetchProducts();
	
	@Query(value = query2, nativeQuery = true)
    List<Tuple> fetchProductFromProductId(String id);
	

}
