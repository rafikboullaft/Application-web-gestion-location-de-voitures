package com.car.mvc.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.car.mvc.dao.IGenericDao;
@SuppressWarnings("unchecked")
public class IGenericDaoImpl<E> implements IGenericDao<E> {
	@PersistenceContext
	EntityManager em;

	private Class<E> type;
	
	
	public IGenericDaoImpl()
	{
		Type t=getClass().getGenericSuperclass();
		ParameterizedType pt=(ParameterizedType)t;
		type=(Class<E>)pt.getActualTypeArguments()[0];
	}
	
	@Override
	public E save(E entity) {
		em.persist(entity);
		return (E) entity;
	}

	@Override
	public E upadate(E entity) {
		em.merge(entity);
		return (E) em.merge(entity);
	}

	@Override
	public List<E> selectAll() {
		Query query=em.createQuery("select t from "+type.getSimpleName()+" t");
		return query.getResultList();
	}

	@Override
	public E getById(int id) {
		
		return em.find(type, id);
	}

	@Override
	public void remove(int id) {
	E tab=em.getReference(type, id);
	em.remove(tab);
		
	}


	@Override
	public E finOne(String paramName, String paramValue) {
		Query query=em.createQuery("select t from "+type.getSimpleName()+" t where "+ paramName + " =:x");
		query.setParameter(paramName,paramValue);
		return (E) (query.getResultList().size()>0 ? query.getResultList().get(0):null);
		
	}

	


	

}
