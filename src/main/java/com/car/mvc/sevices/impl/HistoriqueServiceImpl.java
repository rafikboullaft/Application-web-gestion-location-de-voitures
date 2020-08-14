package com.car.mvc.sevices.impl;

import java.util.Calendar;

import java.util.Iterator;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.car.mvc.dao.IHistoriqueDao;

import com.car.mvc.entites.Historique;
import com.car.mvc.sevices.IHistoriqueService;

@Transactional
public class HistoriqueServiceImpl implements IHistoriqueService{
	private IHistoriqueDao dao3;
	public void setDao3(IHistoriqueDao dao3) {
		this.dao3 = dao3;
	}
	@Override
	public Historique save(Historique entity) {
		 
		return dao3.save(entity);
	}

	@Override
	public Historique upadate(Historique entity) {
		 
		return dao3.upadate(entity);
	}

	@Override
	public List<Historique> selectAll() {
		System.out.println("-------------- la function select all-----------------");
		System.out.println(dao3.selectAll());
		return dao3.selectAll();
	}

	@Override
	public Historique getById(int id) {
		 
		return dao3.getById(id);
	}

	@Override
	public Historique finOne(String paramName, String paraVale) {
		 
		return dao3.finOne(paramName, paraVale);
	}

	@Override
	public void remove(int id) {
		dao3.remove(id);
		
	}
	@Override
	public float monprixtemp() {
		return 213764;
	}
	
	
	@Override
	public float getPrixDumois(int mois){
		System.out.println("la function get prix: -------------------------------");
		List<Historique> historique=selectAll();
		Iterator<Historique> iter = historique.iterator();
		float prixtotale=0;
		//float monprix=0;
		int nbJours=0;
		
	
	    while (iter.hasNext() )
	   {
	    	System.out.println("---------------la boucle while----------------");
	    	Historique h=(Historique)iter.next();
	    	
	    	Calendar calendar = Calendar.getInstance();
	    	calendar.setTime(h.getDate_sortie());
	    	int moisentrie=calendar.get(Calendar.MONTH)+1;
	    	
	    	System.out.println("-----------------moissortie--------------");
	    	System.out.println(moisentrie);
	    	if(mois==moisentrie) {
	    		System.out.println("---------------ouii cette mois exist----------------");
	    		
	    		Calendar calendar2 = Calendar.getInstance();
		    	calendar2.setTime(h.getDate_entrie());
	    		int moisSortie=calendar2.get(Calendar.DATE)+1;
	    		
	    		int dayEntree=calendar.get(Calendar.DAY_OF_MONTH);
    			int daySortie=calendar2.get(Calendar.DAY_OF_MONTH);
	    		if(moisSortie==moisentrie) {
	    			
	    			nbJours=daySortie-dayEntree;
	    			System.out.println("nombre de jours est :"+nbJours);
	    			
	    		}
	    		
	    		else {
	    			System.out.println("--------------non ce n'est pas le meme mois-----------------");
	    			int nbmois=moisSortie-moisentrie;
	    			
	    			if (moisentrie%2==0) {
	    				nbJours=30*nbmois+daySortie-dayEntree;
	    			}
	    			else {
	    				nbJours=31*nbmois+daySortie-dayEntree;
	    			}
	    			
	    		}
	    		
	    		prixtotale+=(h.getPrix()*nbJours);
	    	}	
	    }
	    System.out.println("--------------le prix totaale-----------------"+ prixtotale);
	    return prixtotale;
		
	}
	

	
	/*
	 * public float prixDumois(int mois) {
	 * 
	 * float monprix=0; Iterator iter = selectAll().iterator(); while
	 * (iter.hasNext()) { monprix+=(Historique)iter.next(); } return monprix;
	 * 
	 * }
	 */

}
