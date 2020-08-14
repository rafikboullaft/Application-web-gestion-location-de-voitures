package com.car.mvc.sevices;

import java.util.List;

import com.car.mvc.entites.Voiture;

public interface IVoitureService {

	public Voiture save(Voiture entity);
	public Voiture upadate(Voiture entity);
	public List<Voiture> selectAll();
	public Voiture getById(int id);
	public Voiture finOne(String paramName,String paraVale);
	public void remove(int id);
	public List<Voiture> VoituresReserveesDuMois(String Mois);
	public int nombredevoiture();
	public int nombredevoitureresrve();
	public List<Voiture> assuranceNow();
	public double[] vidange();
	public String[] vidangeNames();
	public List<Voiture> visiteTech();
	public List<Voiture> vidangeAction();
	public double[] kilometrage();
}
