package com.shixa.impl.db;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.shixa.formats.User;

public class JedisTest {

	private static Logger LOG = Logger.getLogger(JedisTest.class);
	
	private User createUser(){
		 //long id = 12;
		 
		 User user = new User();
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
	
	@Test
	public void createTest(){
//		String id = "d5f1c2c1-7b60-3e04-9df6-25696bcd8a7f";
		DataBaseConnector db = new DataBaseConnectorImpl();
		User user = createUser();
		String id = db.createUser(user);
		LOG.info("ID:"+id);
		Assert.assertNotNull(id);
//		User _user = db.getUser(id);
//		Assert.assertEquals(user, _user);
//		Assert.assertNotNull(_user);
//		LOG.info(_user.toString());
	}

	@Test
	public void getTest(){
		DataBaseConnector db = new DataBaseConnectorImpl();
		String id = "5f374b9a-3157-33cf-b49f-155ec6be5b37";
		User _user = db.getUser(id);
		Assert.assertNotNull(_user);
	}
}
