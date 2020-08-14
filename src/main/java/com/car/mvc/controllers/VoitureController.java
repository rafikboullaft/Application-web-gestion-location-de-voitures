package com.car.mvc.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.car.mvc.entites.Admin;
import com.car.mvc.entites.Client;
import com.car.mvc.entites.Historique;
import com.car.mvc.entites.Reservation;
import com.car.mvc.entites.Voiture;
import com.car.mvc.sevices.IClientService;
import com.car.mvc.sevices.IHistoriqueService;
import com.car.mvc.sevices.IReservationService;
import com.car.mvc.sevices.IVoitureService;
@Controller
@RequestMapping(value="/voiture")
public class VoitureController {
	@Autowired
	 IVoitureService voitureService;
	@Autowired
	 IClientService clientService;
	@Autowired
	 IReservationService reservationService;
	@Autowired
	IHistoriqueService historiqueService;
	//***********************************************************************
	@RequestMapping(value="/")
	  public String voiture(Model model)
	  {
		List<Voiture> voitures=voitureService.selectAll();
		if(voitures==null)
		{
			voitures=new ArrayList<Voiture>();
		}
		model.addAttribute("voitures",voitures);
		
		return "voiture/voiture";  
	  }
	//***********************************************************************
	
	@RequestMapping(value="/connection")
	public String connection(Model model,Admin admin)
	{
        String ret="";
       
       String email=admin.getEmail();
       String password=admin.getPassword();
  
		 if(admin!=null)
		 {
			 System.out.print(email);
			  
			if(email.equals("GI2@gmail.com") && password.equals("GI2"))
			{
				
				  System.out.print(admin.getEmail());
			ret="redirect:/voiture/";
			}
			else
				ret= "redirect:/"; 
			
		 }
		 else
		 {
			ret="redirect:/"; 
		 }
		 
		 return ret;
	}
	
	//**********************************************************************
		@RequestMapping(value="/VoituresResevees/")
		  public String voitureRserver(Model model)
		  {
			
			List<Voiture> voitures=new ArrayList<Voiture>();
			List<Voiture> v=voitureService.selectAll();
			if(v==null)
			{
				v=new ArrayList<Voiture>();
			}
			else
			{
				 ListIterator<Voiture> it = v.listIterator();
			      while(it.hasNext()){
			    	  Voiture v1=(Voiture)it.next();
			        if(v1.isReserver())
			        {
			        	
			        	voitures.add(v1);
			        }
			      }
			}
			model.addAttribute("voitures",voitures);
			
			return "voiture/voitureReserver";  
		  }
	//*************************************
	@RequestMapping(value="/nouveau",method=RequestMethod.GET)
	public String ajouterVoiture(Model model)
	{
		Voiture voiture=new Voiture();
		model.addAttribute("voiture",voiture);
		
		return "voiture/ajouterVoiture";
	}
	//***********************************************************************
	@RequestMapping(value="/enregistrer")
	public String enregistrerVoiture(Model model,Voiture voiture,MultipartFile file)
	{

		 if(voiture!=null)
		 {
			if( file!=null && !file.isEmpty())
			{
				 System.out.println("bien passe");
				String url=file.getOriginalFilename();
				voiture.setImage(url);
				
			}
			if(voiture.getId()!=0)
			{
				voitureService.upadate(voiture);	
			}else
			{
			    voitureService.save(voiture);
			}
		 }
		
		return "redirect:/voiture/";
	}
	//***********************************************************************
	@RequestMapping(value="/modifier/{id}")
	public String modigierVoiture(Model model,@PathVariable int id) 
	{ if(id!=0)
		{
		 Voiture voiture=voitureService.getById(id);
		 if(voiture!=null)
		 {
			 model.addAttribute("voiture",voiture); 
		 }	
		}
		
		return  "voiture/ajouterVoiture";
	}
	//***********************************************************************
	@RequestMapping(value="/supprimer/{id}")
	public String supprimerVoiture(Model model,@PathVariable int id) 
	{
       
		if(id!=0)
		{
		voitureService.remove(id);;
		
		}
		return "redirect:/voiture/";
	}
	//***********************************************************************
	@RequestMapping(value="/reserver/{id}")
	public String ReserverVoiture(Model model,Model model1,Model model2,@PathVariable int id) 
	{
	List<Client> clients=clientService.selectAll();
		if(id!=0)
		{
			Voiture voiture=voitureService.getById(id);
			 if(voiture!=null)
			 { 
				List<Voiture> voitures=new ArrayList<Voiture>();
				voitures.add(voiture);
			    Reservation reservation=new Reservation();
			    //Historique historique = new Historique();
			    model.addAttribute("voitures",voitures); 
				model1.addAttribute("clients",clients); 
				model2.addAttribute("reservation",reservation);
				//model3.addAttribute("historique",historique);
			 }
		
		}
		return  "voiture/ajouterReservation";
	}
	//***********************************************************************
	@RequestMapping(value="/enregisterReservation")
	public String enregistrerReservation(Model model,Reservation reservation,MultipartFile file)
	{

		 if(reservation!=null)
		 {
			 
			 Historique h1 = new Historique();
			 h1.setDate_entrie(reservation.getDate_entrie());
			 h1.setDate_sortie(reservation.getDate_sortie());
			 h1.setIdClient(reservation.getIdClient());
			 h1.setIdClient(reservation.getIdVoiture());
			 Voiture v=voitureService.getById(reservation.getIdVoiture());
			 //set disponibe to reservet
			 v.setReserver(true);
			 h1.setPrix(v.getPrix());
			
			if(reservation.getId()!=0)
			{
				reservationService.upadate(reservation);
				voitureService.upadate(v);
				historiqueService.upadate(h1);
			}else
			{
				
				reservationService.save(reservation);
				historiqueService.save(h1);
				voitureService.upadate(v);
			}
		 }
		
		return "redirect:/reservation/";
	}
	//***********************************************************************
}
