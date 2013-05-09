package com.shixa.impl.json;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.linkedin.restli.server.CreateResponse;

import com.shixa.formats.user.User;
import com.shixa.impl.util.JsonGenerator;
import com.shixa.impl.util.JsonGeneratorImpl;

public class JsonGeneratorTest {
	
	private static Logger LOG = Logger.getLogger(JsonGeneratorTest.class);

	 private User createUser(){
		 String id = "12";
		 
		 User user = new User();
		 user.setEmail("xavier@gmail.com");
		 user.setPassword("1234567");
		 user.setUsername("xavierqa");
		 user.setId(id);
		 return user;
	 }
	
	@Test
	public void serializeDeserializeTest(){
		JsonGenerator _json = new JsonGeneratorImpl();
		User user = createUser();
		String _response = _json.serializeJson(user);
		Assert.assertNotNull(_response);
		LOG.info(_response);
		User olduser= _json.deserializeJson(_response);
		LOG.info(olduser);
		Assert.assertNotNull(olduser);
		Assert.assertNotNull(olduser.getEmail());
		LOG.info(olduser.getEmail());
	}
}
