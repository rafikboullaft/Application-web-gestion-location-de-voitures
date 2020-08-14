package com.car.mvc.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.car.mvc.entites.Client;
import com.car.mvc.entites.Reservation;
import com.car.mvc.entites.Voiture;
import com.car.mvc.sevices.IClientService;
import com.car.mvc.sevices.IReservationService;
import com.car.mvc.sevices.IVoitureService;



@Controller
@RequestMapping(value="/reservation")
public class ReservationController {
	@Autowired
	 IReservationService reservationService;
	@Autowired
	 IVoitureService voitureService;
	@Autowired
	 IClientService clientService;
	@RequestMapping(value="/")
	  public String voiture(Model model,Model model1,Model model2)
	  {
		List<Reservation> reservations=reservationService.selectAll();
		if(reservations==null)
		{
			reservations=new ArrayList<Reservation>();
		}
		else
		{
		    List<Voiture> voitures=new ArrayList<Voiture>();
			List<Client> clients=new ArrayList<Client>();
			ListIterator<Reservation> it = reservations.listIterator();
		       while(it.hasNext())
		       {
		    	  Reservation R=(Reservation)it.next();
		    	  voitures.add(voitureService.getById(R.getIdVoiture()));
		    	  clients.add(clientService.getById(R.getIdClient()));
		      }
		       model1.addAttribute("clients",clients);
		       model2.addAttribute("voitures",voitures);
		}
		model.addAttribute("reservations",reservations);
		return "reservation/reservation";  
	  }
	//***************************************************
	@RequestMapping(value="/today")
	  public String today(Model model,Model model1,Model model2)
	  {
		List<Reservation> reservations=reservationService.selectToday();
		
		if(reservations==null)
		{
			reservations=new ArrayList<Reservation>();
		}
		else
		{
		    List<Voiture> voitures=new ArrayList<Voiture>();
			List<Client> clients=new ArrayList<Client>();
			ListIterator<Reservation> it = reservations.listIterator();
		       while(it.hasNext())
		       {
		    	  
		    	  Reservation R=(Reservation)it.next();
		    	  voitures.add(voitureService.getById(R.getIdVoiture()));
			      clients.add(clientService.getById(R.getIdClient()));
		    	  
		    	  
		      }
		       model1.addAttribute("clients",clients);
		       model2.addAttribute("voitures",voitures);
		}
		model.addAttribute("reservations",reservations);
		return "reservation/today";  
	  }
	//***************************************************
		@RequestMapping(value="/supprimer/{id}")
		public String supprimerClient(Model model,@PathVariable int id) 
		{
	       
			if(id!=0)
			{
				reservationService.remove(id);;
			}
			return "redirect:/reservation/";
		}
		
		//***************************************************
			@RequestMapping(value="/imprimer/{id}")
				public String imprimerContrat(Model model,Model model1,Model model2,@PathVariable int id) 
				{
					if(id!=0)
					{
						Reservation r=reservationService.getById(id);
						List<Reservation> reservations=new ArrayList<Reservation>();
						reservations.add(r);
						  model.addAttribute("reservations",reservations);
						  
						Voiture v=voitureService.getById(r.getIdVoiture());
						List<Voiture> voitures=new ArrayList<Voiture>();
						voitures.add(v);
						  model1.addAttribute("voitures",voitures);
						  
						Client c=clientService.getById(r.getIdClient());
						List<Client> clients=new ArrayList<Client>();
						clients.add(c);
						  model2.addAttribute("clients",clients);
					     
					}
					return "/reservation/contrat";
				}

}
