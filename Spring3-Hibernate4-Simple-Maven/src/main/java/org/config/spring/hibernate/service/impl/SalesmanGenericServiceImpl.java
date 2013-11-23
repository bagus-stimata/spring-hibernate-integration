package org.config.spring.hibernate.service.impl;

import java.io.Serializable;

import org.config.spring.hibernate.model.Salesman;
import org.config.spring.hibernate.service.SalesmanGenericService;
import org.config.spring.hibernate.service.generic.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SalesmanGenericServiceImpl extends GenericServiceImpl<Salesman, Serializable> implements SalesmanGenericService{

}
