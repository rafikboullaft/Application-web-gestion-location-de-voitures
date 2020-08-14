package com.car.mvc.dao.impl;

import java.io.InputStream;

import org.scribe.model.Token;
import org.scribe.model.Verifier;

import javax.swing.JOptionPane;
import com.car.mvc.dao.IFlickrDao;
import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.AuthInterface;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;



public class FlickrDaoImpl implements IFlickrDao{
	private Flickr flickr;
	private UploadMetaData uploadMetaData= new UploadMetaData();
	private String apiKey= "2883dda9d083a38aa560e9993b3307e0";
	private String sharedSecret = "85e8e8564262e704";
	
	private void connect() {
		System.out.println("inside connect methode ");
		flickr = new Flickr(apiKey,sharedSecret,new REST());
		Auth auth = new Auth();
		auth.setPermission(Permission.READ);
		auth.setToken("");
		auth.setTokenSecret("");
		System.out.println("---------------------auth connect"+ auth);
		RequestContext requestContext=RequestContext.getRequestContext();
		requestContext.setAuth(auth);
		flickr.setAuth(auth);
	
	}
	public String savePhoto(InputStream photo, String title) throws Exception{
		connect();
		uploadMetaData.setTitle(title);
		String photoId = flickr.getUploader().upload(photo, uploadMetaData);
		
		return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
	}
	public void auth() {
		System.out.println("start -------------------------");
		
		flickr = new Flickr(apiKey,sharedSecret,new REST());
		System.out.println("flick_--------"+flickr);
		AuthInterface authInterface = flickr.getAuthInterface();
		System.out.println("authInterface"+ authInterface);
		Token token = authInterface.getRequestToken();
		System.out.println("token: "+ token);
		  String url = authInterface.getAuthorizationUrl(token, Permission.DELETE);
		  System.out.println("l url "+url);
		  String tokenKey = JOptionPane.showInputDialog(null); Token requestToken =
		  authInterface.getAccessToken(token, new Verifier(tokenKey));
		  Auth auth = null;
		 
		try {
			auth = authInterface.checkToken(requestToken);
			System.out.println("auth...:"+ auth);
			
		}catch(FlickrException e){
			e.printStackTrace();
			
		}
		System.out.println("Token...1:"+ requestToken.getToken());
		System.out.println("SECRET...1:"+ requestToken.getSecret());
		System.out.println("NSEAD...1:"+ auth.getUser().getId());
		System.out.println("realname...1:"+ auth.getUser().getRealName());
		System.out.println("username...1:"+ auth.getUser().getUsername());
		
	}

}
