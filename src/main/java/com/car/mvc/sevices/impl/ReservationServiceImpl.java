package com.car.mvc.sevices.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ListIterator;

import org.springframework.transaction.annotation.Transactional;

import com.car.mvc.dao.IReservationDao;
import com.car.mvc.entites.Client;
import com.car.mvc.entites.Reservation;
import com.car.mvc.entites.Voiture;
import com.car.mvc.sevices.IClientService;
import com.car.mvc.sevices.IReservationService;
@Transactional
public class ReservationServiceImpl  implements IReservationService{
private IReservationDao dao2;
	

	public void setDao2(IReservationDao dao1) {
		this.dao2 = dao1;
	}

		@Override
		public Reservation save(Reservation entity) {
			
			return dao2.save(entity);
		}

		@Override
		public Reservation upadate(Reservation entity) {
			
			return dao2.upadate(entity);
		}

		@Override
		public List<Reservation> selectAll() {
			
			return dao2.selectAll();
		}

		@Override
		public Reservation getById(int id) {
			
			return dao2.getById(id);
		}

		@Override
		public Reservation finOne(String paramName, String paraVale) {
		
			return dao2.finOne(paramName, paraVale);
		}

		@Override
		public void remove(int id) {
			dao2.remove(id);
			
		}
		@Override
		public List<Reservation> selectToday() {
			List<Reservation> reservations=selectAll();
			List<Reservation> reservationstoday=new ArrayList<Reservation>();
			Calendar Mydate=Calendar.getInstance();
			
			int thismonth = Mydate.get(Calendar.MONTH)+1;
			int thisyear = Mydate.get(Calendar.YEAR);
			int thisday = Mydate.get(Calendar.DAY_OF_MONTH);
			System.out.println(Mydate);
			if(reservations==null)
			{
				reservations=new ArrayList<Reservation>();
			}
			else
			{
			    
				ListIterator<Reservation> it = reservations.listIterator();
			       while(it.hasNext())
			       {
			    	  
			    	  Reservation R=(Reservation)it.next();
			    	  // CONDITION SUR LA DATE
			    	  Calendar dateEntie=Calendar.getInstance();
			    	  dateEntie.setTime(R.getDate_entrie());
			    	  int yearentrie = dateEntie.get(Calendar.YEAR);
			    	  int montheentrie = dateEntie.get(Calendar.MONTH)+1;
			    	  int dayentrie = dateEntie.get(Calendar.DAY_OF_MONTH);
			    	  //
			    	  if(thisyear==yearentrie && thismonth==montheentrie && thisday==dayentrie) {
			    		  System.out.println("ouiii c'est today ");
			    		  reservationstoday.add(R);
				    	  
			    	  }
			    	  System.out.println("Nooo c'est n.est pas today ");
			    	  
			      }
			      
			}
			
			return reservationstoday; 
			
		}


}
