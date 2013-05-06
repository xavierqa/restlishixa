package com.shixa.impl.db;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.shixa.formats.Communication.Use_twitter;
import com.shixa.formats.User;

public class JedisTest {

	private static Logger LOG = Logger.getLogger(JedisTest.class);
	
	private User createUser(){
		 //long id = 12;
		 
		 User user = new User();
		 user.setEmail("xavier@c1o2341112234345.com");
		 //user.setEmail("");
		 user.setPassword("1ss34567");
		 user.setUsername("xavier");
		 user.setGender("Male");
		 user.setPhoto_profile("");
		 user.setCountry("USA");
		 user.setCity("SF");
		 user.setNeighborhood("Miraloma");
		 user.setLatitud(123.4);
		 user.setLongitud(11.1);
		 user.setContactme(true);
		 user.setUse_email(false);
		 Use_twitter U_twitter = new Use_twitter();
		 U_twitter.setString("@xavier");
		 U_twitter.setBoolean(true);
		 user.setUse_twitter(U_twitter);
		 user.setVoice(false);
		 user.setSms(false);
		 
		// user.setId(id);
		 return user;
	 }
	
	@Test
	public void connectDB(){
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

	/*@Test
	public void getTest(){
		DataBaseConnector db = new DataBaseConnectorImpl();
		String id = "1111";
		User _user = db.getUser(id);
		Assert.assertNotNull(_user);
	}*/
}
