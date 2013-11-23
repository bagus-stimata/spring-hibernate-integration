package org.config.spring.hibernate.service.impl;

import java.io.Serializable;

import org.config.spring.hibernate.model.Customer;
import org.config.spring.hibernate.service.CustomerGenericService;
import org.config.spring.hibernate.service.generic.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CustomerGenericServiceImpl extends GenericServiceImpl<Customer, Serializable> implements CustomerGenericService{

}
