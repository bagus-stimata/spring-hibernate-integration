package org.config.spring.hibernate.dao.impl;

import java.util.List;

import org.config.spring.hibernate.dao.ProductDao;
import org.config.spring.hibernate.model.Product;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public Product getById(String id) {
		Criteria crit = getSessionFactory().getCurrentSession()
				.createCriteria(Product.class);
		crit.add(Restrictions.like("idProduct", id, MatchMode.ANYWHERE));
		return (Product) crit.list().get(0);
	}

	public Product getByName(String name) {
		Criteria crit = getSessionFactory().getCurrentSession()
				.createCriteria(Product.class);
		crit.add(Restrictions.like("description", name, MatchMode.ANYWHERE));
		return (Product) crit.list().get(0);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Product> getAll() {
		Criteria crit = getSessionFactory().getCurrentSession()
				.createCriteria(Product.class);		
		return crit.list();
	}

	public void insert(Product product) {
		getSessionFactory().getCurrentSession().save(product);
	}

	public void saveOrUpdate(Product product) {
		getSessionFactory().getCurrentSession().saveOrUpdate(product);
	}

	public void delete(Product product) {
		getSessionFactory().getCurrentSession().delete(product);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
