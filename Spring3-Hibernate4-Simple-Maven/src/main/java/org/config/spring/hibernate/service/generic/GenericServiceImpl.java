package org.config.spring.hibernate.service.generic;

import java.io.Serializable;
import java.util.List;

import org.config.spring.hibernate.dao.generic.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {
	@Autowired
	private GenericDao<T, ID> genericDao;
	
	@Transactional
	public List<T> getAll() {
		return getGenericDao().getAll();
	}
	@Transactional
	public void save(T domain) {
		getGenericDao().save(domain);
	}
	@Transactional
	public void update(T domain) {
		getGenericDao().update(domain);
	}
	@Transactional
	public void saveOrUpdate(T domain) {
		getGenericDao().saveOrUpdate(domain);
	}
	@Transactional
	public void saveOrUpdate(List<T> domains) {
		getGenericDao().saveOrUpdate(domains);
	}
	@Transactional
	public void delete(T domain) {
		getGenericDao().delete(domain);
	}
	@Transactional
	public void delete(List<T> domains) {
		getGenericDao().delete(domains);
	}
	@Transactional
	public List<T> findAll() {
		return getGenericDao().findAll();
	}
	@Transactional
	public T findById(ID id) {
		return getGenericDao().findById(id);
	}
	@Transactional
	public List<T> findByExample(T exampleInstance, String... excludeProperty) {
		return getGenericDao().findByExample(exampleInstance, excludeProperty);
	}
	@Transactional
	public List<T> findByExample(T exampleInstance) {
		return getGenericDao().findByExample(exampleInstance);
	}
	@Transactional
	public Long count() {
		return getGenericDao().count();
	}
	@Transactional
	public Long countByExample(T exampleInstance, String... excludeProperty) {
		return getGenericDao().countByExample(exampleInstance, excludeProperty);
	}
	@Transactional
	public Long countByExample(T exampleInstance) {
		return getGenericDao().countByExample(exampleInstance);
	}
	
	//** Getter and Setter here
	public GenericDao<T, ID> getGenericDao() {
		return genericDao;
	}
	public void setGenericDao(GenericDao<T, ID> genericDao) {
		this.genericDao = genericDao;
	}
	
	
}
