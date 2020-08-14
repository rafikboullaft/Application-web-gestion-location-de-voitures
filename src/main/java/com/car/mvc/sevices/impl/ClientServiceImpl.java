package com.car.mvc.sevices.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.car.mvc.dao.IClientDao;
import com.car.mvc.entites.Client;
import com.car.mvc.sevices.IClientService;
@Transactional
public class ClientServiceImpl implements IClientService{
	private IClientDao dao1;
	

	public void setDao1(IClientDao dao1) {
		this.dao1 = dao1;
	}

		@Override
		public Client save(Client entity) {
			
			return dao1.save(entity);
		}

		@Override
		public Client upadate(Client entity) {
			
			return dao1.upadate(entity);
		}

		@Override
		public List<Client> selectAll() {
			
			return dao1.selectAll();
		}

		@Override
		public Client getById(int id) {
			
			return dao1.getById(id);
		}

		@Override
		public Client finOne(String paramName, String paraVale) {
		
			return dao1.finOne(paramName, paraVale);
		}

		@Override
		public void remove(int id) {
			dao1.remove(id);
			
		}

}
