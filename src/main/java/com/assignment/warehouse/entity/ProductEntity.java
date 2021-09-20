package com.assignment.warehouse.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "product_id")
	private String product_id;
	
	@OneToMany(targetEntity = ArticleEntity.class,  cascade = CascadeType.ALL)
	@JoinColumn(name="product_pk",referencedColumnName = "product_id")
	List<ArticleEntity> contain_articles;
	
	@Column(name = "name")
	private String name;
	
	
	
}
