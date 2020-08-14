package com.car.mvc.sevices;

import java.util.List;

import com.car.mvc.entites.Reservation;

public interface IReservationService {
	public Reservation save(Reservation entity);
	public Reservation upadate(Reservation entity);
	public List<Reservation> selectAll();
	public Reservation getById(int id);
	public Reservation finOne(String paramName,String paraVale);
	public void remove(int id);
	public List<Reservation> selectToday();
}
