package org.config.spring.hibernate.dao.impl;

import java.io.Serializable;

import org.config.spring.hibernate.dao.CustomerGenericDao;
import org.config.spring.hibernate.dao.generic.GenericDaoImpl;
import org.config.spring.hibernate.model.Customer;
import org.springframework.stereotype.Service;

@Service //Harus ditambahkan service untuk dikenal sebagai Bean
public class CustomerGenericDaoImpl extends GenericDaoImpl<Customer, Serializable> implements CustomerGenericDao{

}
