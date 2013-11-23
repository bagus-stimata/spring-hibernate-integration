package org.config.spring.hibernate.service;

import java.util.List;

import org.config.spring.hibernate.model.Product;

public interface ProductManager {
	void insert(Product product);	  
	Product getById(String id);	  
	Product getByName(String name);	  
	List<Product> getAll();
	void saveOrUpdate(Product product);
	void delete(Product product);

}
