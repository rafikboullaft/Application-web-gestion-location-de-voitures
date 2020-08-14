package com.car.mvc.dao;

import java.util.List;

public interface IGenericDao<E> {
	
	
	public E save(E entity);
	public E upadate(E entity);
	public List<E> selectAll();
	
	public E getById(int id);
	public E finOne(String paramName,String paraVale);
	public void remove(int id);
	

}
