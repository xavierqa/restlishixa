package com.shixa.impl.db;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.shixa.formats.User;

public class JedisTest {

	private static Logger LOG = Logger.getLogger(JedisTest.class);
	
	private User createUser(){
		 long id = 12;
		 
		 User user = new User();
		 user.setEmail("xavier@co.com");
		 //user.setEmail("");
		 user.setPassword("1ss34567");
		 user.setUsername("xavier");
		// user.setId(id);
		 return user;
	 }
	
	@Test
	public void connectDB(){
		DataBaseConnector db = new DataBaseConnectorImpl();
		User user = createUser();
		db.createUser(user);
	}
}
