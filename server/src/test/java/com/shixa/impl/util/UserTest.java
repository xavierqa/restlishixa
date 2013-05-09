package com.shixa.impl.util;

import com.shixa.formats.User;

public class UserTest {

	
	private User user; 
	
	public UserTest() {
		this.user = new User();
	}
	
	public User createUser(){
		 //long id = 12;
		 
		 
		 user.setEmail("xavier1@c1o2341112234345.com");
		 //Profile
		 user.setPassword("1ss34567");
		 user.setUsername("xavier");
		 user.setGender("Male");
		 user.setPhoto_profile("");
		 //geolocation
		 user.setCountry("USA");
		 user.setCity("SF");
		 user.setNeighborhood("Miraloma");
		 user.setLatitud(123.4);
		 user.setLongitud(11.1);
		 //communications
		 user.setContactme(true);
		 user.setUse_email(false);
		 user.setTwitter("@xavier");
		 user.setUse_twitter(true);
	
		 user.setVoice(false);
		 user.setSms(false);
		 
		// user.setId(id);
		 return user;
	 }

	public String getId(){
		return this.user.getId();
	}
	
	public void setID(String id){
		this.user.setId(id);
	}
	
	public User getuser(){
		return this.user;
	}
}
