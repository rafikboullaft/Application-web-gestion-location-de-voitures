package com.car.mvc;

import com.car.mvc.dao.impl.FlickrDaoImpl;

public class Test {

	public static void main(String[] args) {
		FlickrDaoImpl flickr=new FlickrDaoImpl();
		flickr.auth();
		

	}

}
