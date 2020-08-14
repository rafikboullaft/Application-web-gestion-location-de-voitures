package com.car.mvc.controllers;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.car.mvc.entites.Historique;
import com.car.mvc.entites.Voiture;
import com.car.mvc.sevices.IHistoriqueService;
import com.car.mvc.sevices.IVoitureService;

@Controller
@RequestMapping(value="/dashboard")

public class HistoriqueController {
	@Autowired
	IHistoriqueService historiqueService;
	@Autowired
	IVoitureService voitureService;

	
	
	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model) {
		
		//les revenues
		
		
		  float dataofchartarea[]=new float[13];
		  
		  for (int j=1;j<13;j++) {
		  dataofchartarea[j-1]=historiqueService.getPrixDumois(j); }
		  
		  System.out.println("le prix du mois 4 est : -------------------------------");
		  //voitures resever 
		  int a=voitureService.nombredevoiture(); 
		  int b=voitureService.nombredevoitureresrve();
		 
		  
		  
		  //vidange System.out.println("nombre de voitures pour vidange"+voitureService.vidange().length);
		  
		  //////////////////////////////////////////////////
		
		  model.addAttribute("dataofchartarea",dataofchartarea);
		  model.addAttribute("v_reserver", b); model.addAttribute("v_nonreserver",a-b);
		 
		  model.addAttribute("vidange", voitureService.vidange());
		  model.addAttribute("vidangeNames", voitureService.vidangeNames());
		  System.out.println("le prix du mois 4 est : -------------------------------"
		  );
		 
		 
		return "dashboard/dashboard";
	}
	@RequestMapping(value="/Alert",method = RequestMethod.GET)
	public String kilometrage_vidange(Model model) {
		model.addAttribute("vidange", voitureService.kilometrage());
		model.addAttribute("vidangeNames", voitureService.vidangeNames());
		return "dashboard/Alert";
		
	}
	
	@RequestMapping(value="/tableAV",method = RequestMethod.GET)
	public String assurance_visete(Model modelMapping){
		//assurances 
		List<Voiture> l_assurrance=voitureService.assuranceNow();
		List<Voiture> visiteTech=voitureService.visiteTech();
		modelMapping.addAttribute("l_assurrance", l_assurrance);
		modelMapping.addAttribute("visiteTech",visiteTech);
		return "dashboard/tableAV";
		
	}
	@RequestMapping(value="/vidange",method = RequestMethod.GET)
	public String faire_vidange(Model modelMapping){
		//assurances 
		List<Voiture> vidangeAction=voitureService.vidangeAction();
		
		
		modelMapping.addAttribute("vidangeAction",vidangeAction);
		return "dashboard/vidange";
		
	}
	@RequestMapping(value="/modifierKm/{id}")
	public String modifierVoiture(Model model,@PathVariable int id) 
	{ if(id!=0)
		{
		 Voiture voiture=voitureService.getById(id);
		 if(voiture!=null)
		 {
			 model.addAttribute("voiture",voiture); 
		 }	
		}
		
		return  "dashboard/modifierKm";
	}
	@RequestMapping(value="/modifierAV/{id}")
	public String modifierAV(Model model,@PathVariable int id) 
	{ if(id!=0)
		{
		 Voiture voiture=voitureService.getById(id);
		 if(voiture!=null)
		 {
			 model.addAttribute("voiture",voiture); 
		 }	
		}
		
		return  "dashboard/modifierAV";
	}
	


}
