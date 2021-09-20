package com.assignment.warehouse.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="article")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleEntity implements Serializable  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "article_id")
	private String article_id;
	
	@Column(name = "art_id")
	private String art_id;
	
	@Column(name = "amount_of")
	private Integer amount_of;
	
    
	

  

}