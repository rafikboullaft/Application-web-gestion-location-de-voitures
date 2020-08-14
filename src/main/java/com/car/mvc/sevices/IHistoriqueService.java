package com.car.mvc.sevices;

import java.util.List;

import com.car.mvc.entites.Historique;

public interface IHistoriqueService {

	public Historique save(Historique entity);
	public Historique upadate(Historique entity);
	public List<Historique> selectAll();
	public Historique getById(int id);
	public Historique finOne(String paramName,String paraVale);
	public void remove(int id);
	float getPrixDumois(int mois);
	float monprixtemp();
	
}
