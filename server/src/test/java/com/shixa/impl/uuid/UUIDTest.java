package com.shixa.impl.uuid;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.shixa.formats.User;
import com.shixa.impl.util.UUIDGenerator;
import com.shixa.impl.util.UUIDGeneratorImpl;

public class UUIDTest {

	private static Logger LOG = Logger.getLogger(UUIDTest.class);
	
	 private User createUser(){
		 String id = "12";
		 
		 User user = new User();
		 user.setEmail("xavier@co.com");
		 //user.setEmail("");
		 user.setPassword("1ss34567");
		 user.setUsername("xavier");
		 user.setId(id);
		 return user;
	 }
	 
	 @Test
	 public void UUIDTest(){
		 LOG.info("Test");
		 UUIDGenerator uuid = new UUIDGeneratorImpl();
		 User user = createUser();
		 String id = uuid.createUUID(user);
		 LOG.info("ID:"+ id);
		 Assert.assertNotNull(id);
	 }
	
}
