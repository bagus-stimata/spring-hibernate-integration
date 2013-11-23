package org.config.spring.hibernate.service;

import java.util.List;

import org.config.spring.hibernate.model.Product;

public interface ProductGenericServiceInject {
    public List<Product> getAllBos();
	public void saveOrUpdate(final Product domain); 
	public void delete(final Product domain);

}
