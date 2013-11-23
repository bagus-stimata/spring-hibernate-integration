package org.config.spring.hibernate.service.impl;

import java.io.Serializable;
import java.util.List;

import org.config.spring.hibernate.dao.generic.GenericDao;
import org.config.spring.hibernate.model.Product;
import org.config.spring.hibernate.service.ProductGenericServiceInject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductGenericServiceInjectImpl implements ProductGenericServiceInject{

	@Autowired
	private GenericDao<Product, Serializable> genericDao;
	
	@Transactional
	public List<Product> getAllBos() {
		return getGenericDao().getAll();
	}
	@Transactional
	public void saveOrUpdate(Product domain) {
		getGenericDao().saveOrUpdate(domain);
	}
	@Transactional
	public void delete(Product domain) {
		getGenericDao().delete(domain);
	}
	public GenericDao<Product, Serializable> getGenericDao() {
		return genericDao;
	}
	public void setGenericDao(GenericDao<Product, Serializable> genericDao) {
		this.genericDao = genericDao;
	}
	

}
