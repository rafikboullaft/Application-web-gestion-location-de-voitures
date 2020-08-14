package com.car.mvc.sevices.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.transaction.annotation.Transactional;

import com.car.mvc.dao.IVoitureDao;
import com.car.mvc.entites.Voiture;
import com.car.mvc.sevices.IVoitureService;
@Transactional
public class VoitureServiceImpl implements IVoitureService{
   private IVoitureDao dao;
   
	

public void setDao(IVoitureDao dao) {
	this.dao = dao;
}

	@Override
	public Voiture save(Voiture entity) {
		
		return dao.save(entity);
	}

	@Override
	public Voiture upadate(Voiture entity) {
		
		return dao.upadate(entity);
	}

	@Override
	public List<Voiture> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public Voiture getById(int id) {
		
		return dao.getById(id);
	}

	@Override
	public Voiture finOne(String paramName, String paraVale) {
	
		return dao.finOne(paramName, paraVale);
	}

	@Override
	public void remove(int id) {
		dao.remove(id);
		
	}

	@Override
	public List<Voiture> VoituresReserveesDuMois(String Mois) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nombredevoiture() {
		
		return selectAll().size();
	}

	@Override
	public int nombredevoitureresrve() {
		int nvr=0;
		List<Voiture> v=selectAll();
		ListIterator<Voiture> it = v.listIterator();
		while(it.hasNext()){
			Voiture v1 = it.next();
			if (v1.isReserver()) {
				nvr++;
			}
		}
		return nvr;
	}

	@Override
	public List<Voiture> assuranceNow() {
		List<Voiture> insuracneNow= new ArrayList<Voiture>();
		int thismonth = Calendar.getInstance().get(Calendar.MONTH)+1;
		int thisyear = Calendar.getInstance().get(Calendar.YEAR);
		System.out.println("this month: "+thismonth+"-----this year: "+thisyear);
		List<Voiture> v=selectAll();
		ListIterator<Voiture> it = v.listIterator();
		while(it.hasNext()) {
			Voiture v1=it.next();
			Calendar calendar = Calendar.getInstance();
	    	calendar.setTime(v1.getAssurance());
	    	int lasInsurance =calendar.get(Calendar.MONTH)+1;
	    	System.out.println("last insurace"+lasInsurance);
	    	int yearInsurance=calendar.get(Calendar.YEAR);
	    	int typeInsurance=3;
	    	if(thisyear== yearInsurance) {
	    		System.out.println("ouiii c'est le meme annee ");
	    		int laduree=thismonth-lasInsurance;
	    		System.out.println("la duree: "+laduree);
		    	if (laduree==typeInsurance|| laduree>typeInsurance) {
		    		insuracneNow.add(v1);
		    	}
	    	}
	    	else {
	    		System.out.println("non ce n'est pas le meme annee");
	    		int laduree=thismonth+(13-lasInsurance);
	    		if (laduree==typeInsurance || laduree>typeInsurance) {
		    		insuracneNow.add(v1);
		    	}
	    		
	    	}
	    	
	    	
			
		}
		return insuracneNow;
	}

	@Override
	public double[] vidange() {
		int sizeV=selectAll().size();
		double typeVidange=40000;
		double vidange[] =new double[sizeV];
		
		int i=0;
		List<Voiture> v=selectAll();
		Iterator<Voiture> it=v.iterator();
		
		while(it.hasNext()) {
			Voiture v1=it.next();
			if((v1.getKilometrage()-1000)>typeVidange) {
				vidange[i]=v1.getKilometrage();
				i++;
			}
		}
		return vidange;
	}
	@Override
	public double[] kilometrage() {
		int sizeV=selectAll().size();
		
		double vidange[] =new double[sizeV];
		
		int i=0;
		List<Voiture> v=selectAll();
		Iterator<Voiture> it=v.iterator();
		
		while(it.hasNext()) {
			Voiture v1=it.next();
			vidange[i]=v1.getKilometrage();
			i++;
		}
		return vidange;
	}
	@Override
	public String[] vidangeNames() {
		int sizeV=selectAll().size();
		
		String vidange[]=new String[sizeV];
		int i=0;
		List<Voiture> v=selectAll();
		Iterator<Voiture> it=v.iterator();
		
		while(it.hasNext()) {
			Voiture v1=it.next();
			vidange[i]=v1.getMarque()+"("+v1.getModele()+")";
			i++;
			
		}
		return vidange;
	}
	@Override
	public List<Voiture> vidangeAction() {
		double typeVidange=40000;
		List<Voiture> myv= new ArrayList<Voiture>();

		List<Voiture> v=selectAll();
		Iterator<Voiture> it=v.iterator();
		
		while(it.hasNext()) {
			Voiture v1=it.next();
			if((v1.getKilometrage()-1000)>typeVidange) {
				myv.add(v1);
				
			}
		}
		return myv;
	}

	@Override
	public List<Voiture> visiteTech() {
		List<Voiture> visiteNow= new ArrayList<Voiture>();
		int thismonth = Calendar.getInstance().get(Calendar.MONTH)+1;
		int thisyear = Calendar.getInstance().get(Calendar.YEAR);
		List<Voiture> v=selectAll();
		ListIterator<Voiture> it = v.listIterator();
		while(it.hasNext()) {
			Voiture v1=it.next();
			int model=v1.getModele();
			Calendar calendar = Calendar.getInstance();
	    	calendar.setTime(v1.getVisite());
	    	int lasVisite =calendar.get(Calendar.MONTH)+1;
	    	int yearVisite=calendar.get(Calendar.YEAR);
	    	if(thisyear-model>=5){
	    		if(yearVisite!=thisyear) {
	    			int duree=thismonth+(12-lasVisite);
	    			if(duree>=12){
	    				visiteNow.add(v1);
	    			}
	    		}
	    	}
			
			
		}
		return visiteNow;
	}

}
