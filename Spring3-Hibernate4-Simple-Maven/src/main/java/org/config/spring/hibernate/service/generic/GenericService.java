package org.config.spring.hibernate.service.generic;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T, ID extends Serializable> {
    public List<T> getAll();
    public void save(final T domain);
    public void update(final T domain);
	public void saveOrUpdate(final T domain); 
	public void saveOrUpdate(final List<T> domains); 	
	public void delete(final T domain);
	public void delete(final List<T> domains);
	public List<T> findAll();
	public T findById(final ID id);
	public List<T> findByExample(final T exampleInstance, String... excludeProperty);
    public List<T> findByExample(final T exampleInstance);
    public Long count();
	public Long countByExample(final T exampleInstance, String... excludeProperty);
    public Long countByExample(final T exampleInstance);

}
