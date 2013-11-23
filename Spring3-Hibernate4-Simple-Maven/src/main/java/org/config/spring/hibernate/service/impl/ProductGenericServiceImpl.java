package org.config.spring.hibernate.service.impl;

import java.io.Serializable;

import org.config.spring.hibernate.model.Product;
import org.config.spring.hibernate.service.ProductGenericService;
import org.config.spring.hibernate.service.generic.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProductGenericServiceImpl extends GenericServiceImpl<Product, Serializable> implements ProductGenericService{

}
