package org.config.spring.hibernate.dao.generic;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GenericDaoImpl<T, ID extends Serializable>  implements GenericDao<T, ID> {

	@Autowired
	private SessionFactory sessionFactory;

	private Class<T> clazz;
		
	public Class<T> getClazz() {
		return clazz;
	}


	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	@SuppressWarnings("rawtypes")
	private Class domainClass;

    @SuppressWarnings({ "rawtypes" })
	public GenericDaoImpl() {
    	//ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
    	if (getClass()==null){
    		this.domainClass = (Class) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    		setClazz(this.domainClass);
    	}       
        System.out.print("Class Yang Sedang Aktif >>> " + "\t" + domainClass + "\t" );
        
	}

	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> getAll() {
		Criteria crit = getSessionFactory()
				.getCurrentSession()
				.createCriteria(getClazz());		
		//Supaya tidak terjadi Redundansi data
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);		
		return crit.list();
	}

	public void saveOrUpdate(T domain) {
		getSessionFactory().getCurrentSession().saveOrUpdate(domain);
	}
	public void saveOrUpdate(List<T> domains) {
		for (T domain: domains){
			getSessionFactory().getCurrentSession().saveOrUpdate(domain);
		}
	}

	public void delete(T domain) {
		getSessionFactory().getCurrentSession().delete(domain);		
	}

	public void delete(List<T> domains) {
		for (T domain: domains){
			getSessionFactory().getCurrentSession().delete(domain);
		}
	}
	public void save(T domain) {
		getSessionFactory().getCurrentSession().save(domain);
	}

	public void update(T domain) {
		getSessionFactory().getCurrentSession().update(domain);
	}

	public List<T> findAll() {
		return this.getAll();
	}

    @SuppressWarnings("unchecked")
	public T findById(ID id) {
		T result = (T) getSessionFactory().getCurrentSession().load(getDomainClass(), id);  
        return result;
	}
	@SuppressWarnings("unchecked")
	public List<T> findByExample(T exampleInstance) {
		Criteria crit = getSessionFactory().getCurrentSession().createCriteria(getDomainClass());
		Example example = Example.create(exampleInstance);
		crit.add(example);
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}
	public List<T> findByExample(T exampleInstance, String... excludeProperty) {
		Criteria crit = getSessionFactory().getCurrentSession().createCriteria(getDomainClass());
		Example example = Example.create(exampleInstance);
		for (String exclude: excludeProperty){
			example.excludeProperty(exclude);
		}
		crit.add(example);		
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return null;
	}
	public Long count() {
		Long result = (long) this.getAll().size();
		return result;
	}

	public Long countByExample(T exampleInstance) {
		Long result = (long) this.findByExample(exampleInstance).size();
		return result;
	}
	public Long countByExample(T exampleInstance, String... excludeProperty) {
		Long result = (long) this.findByExample(exampleInstance, excludeProperty).size();
		return result;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("rawtypes")
	public Class getDomainClass() {
		return domainClass;
	}

	@SuppressWarnings("rawtypes")
	public void setDomainClass(Class domainClass) {
		this.domainClass = domainClass;
	}



}
