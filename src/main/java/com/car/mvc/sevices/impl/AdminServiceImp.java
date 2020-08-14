package com.car.mvc.sevices.impl;

import com.car.mvc.dao.IAdminDao;
import com.car.mvc.sevices.IAdminService;

public class AdminServiceImp implements IAdminService{
	IAdminDao dao4;

	public void setDao4(IAdminDao dao4) {
		this.dao4 = dao4;
	}

}
