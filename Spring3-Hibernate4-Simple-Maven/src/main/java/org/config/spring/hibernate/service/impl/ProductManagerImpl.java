package org.config.spring.hibernate.service.impl;

import java.util.List;

import org.config.spring.hibernate.dao.ProductDao;
import org.config.spring.hibernate.model.Product;
import org.config.spring.hibernate.service.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//Anntotation @Service berfungsi agar Class Ini dianggap sebagai Bean
@Service
public class ProductManagerImpl implements ProductManager{
	@Autowired
	private ProductDao productDao;
	
	@Transactional
	public void insert(Product product) {
		productDao.insert(product);
	}
	@Transactional
	public Product getById(String id) {
		return productDao.getById(id);
	}

	@Transactional
	public Product getByName(String name) {
		return productDao.getByName(name);
	}

	@Transactional
	public List<Product> getAll() {
		return productDao.getAll();
	}
	@Transactional
	public void saveOrUpdate(Product product) {
		productDao.saveOrUpdate(product);
	}
	@Transactional
	public void delete(Product product) {
		productDao.delete(product);
	}

}
