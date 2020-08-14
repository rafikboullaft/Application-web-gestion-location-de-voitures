package com.car.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.car.mvc.entites.Client;
import com.car.mvc.entites.Historique;
import com.car.mvc.entites.Voiture;
import com.car.mvc.sevices.IClientService;
import com.car.mvc.sevices.IVoitureService;

@Controller
@RequestMapping(value="/client")
public class ClientController {
	@Autowired
	 IClientService clienteService;
	@RequestMapping(value="/")
	  public String voiture(Model model)
	  {
		List<Client> clients=clienteService.selectAll();
		if(clients==null)
		{
			clients=new ArrayList<Client>();
		}
		model.addAttribute("clients",clients);
		return "client/client";  
	  }
	//***************************************************
	@RequestMapping(value="/supprimer/{id}")
	public String supprimerClient(Model model,@PathVariable int id) 
	{
       
		if(id!=0)
		{
		  clienteService.remove(id);;
		}
		return "redirect:/client/";
	}
	
	//*************************************
		@RequestMapping(value="/nouveau",method=RequestMethod.GET)
		public String ajouterVoiture(Model model)
		{
			Client client=new Client();
			model.addAttribute("client",client);
			
			return "client/ajouterClient";
		}
		//***********************************************************************
		@RequestMapping(value="/enregistrer")
		public String enregistrerVoiture(Model model,Client client,MultipartFile file)
		{

			 if(client!=null)
			 {
				
				if(client.getId()!=0)
				{
					clienteService.upadate(client);	
				}else
				{
					clienteService.save(client);
				}
			 }
			
			return "redirect:/client/";
		}
		//***********************************************************************
		@RequestMapping(value="/modifier/{id}")
		public String modigierVoiture(Model model,@PathVariable int id) 
		{ if(id!=0)
			{
			Client client=clienteService.getById(id);
			 if(client!=null)
			 {
				 model.addAttribute("client",client); 
			 }	
			}
			
			return  "client/ajouterClient";
		}
		//***********************************************************************
				@RequestMapping(value="/reserverVoiture/{id}")
				public String ReserverVoiture(Model model,@PathVariable int id) 
				{ if(id!=0)
					{
					
					Client client=clienteService.getById(id);
					 if(client!=null)
					 {
						 model.addAttribute("client",client); 
					 }	
					}
					
				return "redirect:/voiture/";
				
				}

}