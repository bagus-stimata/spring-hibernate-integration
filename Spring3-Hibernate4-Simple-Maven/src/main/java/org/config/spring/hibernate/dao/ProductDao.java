package org.config.spring.hibernate.dao;

import java.util.List;

import org.config.spring.hibernate.model.Product;

public interface ProductDao {

	void insert(Product product);	  
	Product getById(String id);	  
	Product getByName(String name);	  
	List<Product> getAll();
	void saveOrUpdate(Product product);
	void delete(Product product);

}
