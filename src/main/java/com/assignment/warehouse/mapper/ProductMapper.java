package com.assignment.warehouse.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.assignment.warehouse.domain.Article;
import com.assignment.warehouse.domain.Product;
import com.assignment.warehouse.domain.Products;
import com.assignment.warehouse.entity.ArticleEntity;
import com.assignment.warehouse.entity.ProductEntity;

public class ProductMapper {

	public static List<ProductEntity> apply(Products produtcs) {

		return produtcs.getProducts().stream().map(ProductMapper::applyProduct).collect(Collectors.toList());

	}

	private static ProductEntity applyProduct(Product product) {
		return ProductEntity.builder().name(product.getName()).contain_articles(
				product.getContain_articles().stream().map(ProductMapper::applyArticle).collect(Collectors.toList()))
				.build();
	}

	private static ArticleEntity applyArticle(Article article) {
		return ArticleEntity.builder().amount_of(article.getAmount_of()).art_id(article.getArt_id()).build();
	}

	public static Products apply(List<ProductEntity> produtcs) {

		Products products = new Products();

		List<Product> list = new ArrayList<>();

		produtcs.forEach(it -> {
			Product product = new Product();
			product.setProduct_id(it.getProduct_id());
			product.setName(it.getName());
			product.setContain_articles(applyArticleEntity(it.getContain_articles()));

			list.add(product);
		});

		products.setProducts(list);
		return products;

	}

	private static List<Article> applyArticleEntity(List<ArticleEntity> articleEntity) {

		List<Article> list = new ArrayList<>();
		articleEntity.forEach(articles -> {
			Article article = new Article();
			article.setAmount_of(articles.getAmount_of());
			article.setArt_id(articles.getArt_id());
			list.add(article);
		});

		return list;
	}

	
}