package com.assignment.warehouse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="inventory")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class InventoryEntity {

    @Id
    @Column(name = "art_id")
    private String art_id;
    
    @Column(name = "name")
    private String name;
    @Column(name = "stock")
    private Integer stock;
    
    
   
   



	


	

	
	
    	

  

}