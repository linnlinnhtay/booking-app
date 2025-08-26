package com.lin.booking.dao.common;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class GenericDAO<T, Key extends Serializable> {

	@Autowired
	private SessionFactory sessionFactory;

	protected Class<T> daoType;

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		daoType = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public T get(Key id) {
		return (T) getCurrentSession().get(daoType, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return getCurrentSession().createCriteria(daoType).list();
	}

	public Long saveWithId(T entity) {
		return (Long) getCurrentSession().save(entity);
	}

	public void save(T entity) {
		getCurrentSession().save(entity);
	}

	public void saveOrUpdate(T entity) {
		getCurrentSession().saveOrUpdate(entity);
	}

	public void update(T entity) {
		getCurrentSession().update(entity);
	}

	public void merge(T entity) {
		getCurrentSession().merge(entity);
	}

	public void deleteById(long uniqueId) {
		getCurrentSession().delete(uniqueId);
	}

	public void delete(T entity) {
		getCurrentSession().delete(entity);
	}

	public void addAll(Collection<T> entityList) {
		for (T entity : entityList) {
			getCurrentSession().save(entity);
		}
	}

	public void saveOrUpdateAll(Collection<T> entityList) {
		for (T entity : entityList) {
			getCurrentSession().saveOrUpdate(entity);
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> hqlExecuteQuery(String queryString, Map<String, Object> singleValueParamMap,
			Map<String, Object[]> listValueParamMap) {
		Query query = getCurrentSession().createQuery(queryString);

		if (singleValueParamMap != null) {
			for (String key : singleValueParamMap.keySet()) {
				query.setParameter(key, singleValueParamMap.get(key));
			}
		}

		if (listValueParamMap != null) {
			for (String key : listValueParamMap.keySet()) {
				query.setParameterList(key, listValueParamMap.get(key));
			}
		}

		return query.list();
	}

	public int hqlExecuteUpdate(String queryString, Map<String, Object> singleValueParamMap,
			Map<String, Object[]> listValueParamMap) {
		Query query = getCurrentSession().createQuery(queryString);

		if (singleValueParamMap != null) {
			for (String key : singleValueParamMap.keySet()) {
				query.setParameter(key, singleValueParamMap.get(key));
			}
		}

		if (listValueParamMap != null) {
			for (String key : listValueParamMap.keySet()) {
				query.setParameterList(key, listValueParamMap.get(key));
			}
		}

		return query.executeUpdate();
	}

}
