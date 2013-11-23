package org.config.spring.hibernate.dao.impl;

import java.util.List;

import org.config.spring.hibernate.dao.Product2Dao;
import org.config.spring.hibernate.model.Product;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

//@Service
public class Product2DaoImpl implements Product2Dao {
	
	//@Autowired
	private SessionFactory sessionFactory;

	public Product getById(String id) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Product.class);
		crit.add(Restrictions.like("idProduct", id, MatchMode.ANYWHERE));
		return (Product) crit.list().get(0);
	}

	public Product getByName(String name) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Product.class);
		crit.add(Restrictions.like("description", name, MatchMode.ANYWHERE));
		return (Product) crit.list().get(0);
	}
	
	 @SuppressWarnings("unchecked")
	public List<Product> getAll() {
		Criteria crit = sessionFactory
				.getCurrentSession()
				.createCriteria(Product.class);		
		return crit.list();
	}

	public void insert(Product product) {
		sessionFactory.getCurrentSession().save(product);
	}

}
