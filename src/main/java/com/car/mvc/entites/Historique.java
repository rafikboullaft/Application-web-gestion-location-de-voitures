package com.car.mvc.entites;

import java.io.Serializable;

import java.sql.Date;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Table;

import com.car.mvc.sevices.IHistoriqueService;

@Entity
@Table(name="Historique")
public class Historique implements Serializable{

	@Id
	@GeneratedValue
	int id;
	int idClient;
	int idVoiture;
	Date date_sortie;
	Date date_entrie;
	float prix;
	
	
	public Historique(int id, int idClient, int idVoiture, Date date_sortie, Date date_entrie, float prix) {
		super();
		this.id = id;
		this.idClient = idClient;
		this.idVoiture = idVoiture;
		this.date_sortie = date_sortie;
		this.date_entrie = date_entrie;
		this.prix = prix;
	}
	public Historique() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public int getIdVoiture() {
		return idVoiture;
	}
	public void setIdVoiture(int idVoiture) {
		this.idVoiture = idVoiture;
	}
	public Date getDate_sortie() {
		return date_sortie;
	}
	public void setDate_sortie(Date date_sortie) {
		this.date_sortie = date_sortie;
	}
	public Date getDate_entrie() {
		return date_entrie;
	}
	public void setDate_entrie(Date date_entrie) {
		this.date_entrie = date_entrie;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	
//	@PersistenceContext
//	EntityManager em;
//	public List<Historique> selectAllHistorique(){
//		Query query=em.createQuery("select t from Historique t");
//		return query.getResultList();
//	};
//	public float prixDumois(int mois){
//		List<Historique> historique= selectAllHistorique();
//		Iterator<Historique> iter = historique.iterator();
//		float prixtotale=0;
//		float monprix=0;
//		
//	
//	    while (iter.hasNext() )
//	   {
//	    	Historique h=(Historique)iter.next();
//	    	
//	    	Calendar calendar = Calendar.getInstance();
//	    	calendar.setTime(h.getDate_sortie());
//	    	int moissortie=calendar.get(Calendar.MONTH);
//	    	if(mois==moissortie) {
//	    		
//	    		Calendar calendar2 = Calendar.getInstance();
//		    	calendar2.setTime(h.getDate_sortie());
//	    		int moisEntre=calendar2.get(Calendar.DATE);
//	    		if(moisEntre==moissortie) {
//	    			int dayEntree=calendar.get(Calendar.DAY_OF_MONTH);
//	    			int daySortie=calendar2.get(Calendar.DAY_OF_MONTH);
//	    			monprix=dayEntree-daySortie;
//	    			
//	    		}
//	    		/// traitement a faire
//	    		else {
//	    			monprix=0;
//	    		}
//	    		
//	    		prixtotale+=(h.getPrix()*monprix);
//	    	}	
//	    }
//	    return prixtotale;
//		
//	}
	
}
