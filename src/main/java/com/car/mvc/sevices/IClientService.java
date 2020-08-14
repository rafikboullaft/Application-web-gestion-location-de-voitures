package com.car.mvc.sevices;

import java.util.List;

import com.car.mvc.entites.Client;

public interface IClientService {
	public Client save(Client entity);
	public Client upadate(Client entity);
	public List<Client> selectAll();
	public Client getById(int id);
	public Client finOne(String paramName,String paraVale);
	public void remove(int id);
}
