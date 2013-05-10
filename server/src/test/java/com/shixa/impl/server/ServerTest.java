package com.shixa.impl.server;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.linkedin.restli.internal.server.model.ResourceModel;
import com.linkedin.restli.internal.server.model.RestLiAnnotationReader;
import com.linkedin.restli.server.CreateResponse;

import com.linkedin.restli.server.mock.SimpleBeanProvider;
import com.linkedin.restli.server.resources.InjectResourceFactory;

import com.shixa.formats.user.User;
import com.shixa.impl.UserResources;
import com.shixa.impl.db.UserDBConnector;
import com.shixa.impl.db.UserDBConnectorImpl;



public class ServerTest {

	private Logger LOG = Logger.getLogger(ServerTest.class);
	
	private UserResources _userResource;
	
	 private static Map<String, ResourceModel> buildResourceModels(Class<?>... rootResourceClasses)
	  {
	    final Map<String, ResourceModel> map = new HashMap<String, ResourceModel>();
	    for (Class<?> rootResourceClass : rootResourceClasses)
	    {
	      final ResourceModel model = RestLiAnnotationReader.processResource(rootResourceClass);
	      map.put("/" + model.getName(), model);
	    }

	    return map;
	  }

	 
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
	 /*
	 private Long createUser(){
		 Long id = 0l;
		 
		 User user = new User();
		 user.setEmail("xavier@gmail.com");
		 user.setPassword("1234567");
		 user.setUsername("xavierqa");
		 
		 CreateResponse cResp = _userResource.create(user);
		 Assert.assertTrue(cResp.hasId());
		 return (Long) cResp.getId();

	 }
*/
	 @BeforeMethod
	 public void Initresource(){
		 LOG.info("THis is a test");
		 SimpleBeanProvider beanProvider = new SimpleBeanProvider();
		 final UserDBConnector _db = new UserDBConnectorImpl();
		 beanProvider.add("userDB", _db);
		 final InjectResourceFactory factory = new InjectResourceFactory(beanProvider);
		 final Map<String, ResourceModel> pathRootResourceMap = buildResourceModels(UserResources.class);
		 factory.setRootResources(pathRootResourceMap);
		 _userResource = factory.create(UserResources.class);
		  Assert.assertNotNull(_userResource);
		 Assert.assertNotNull(_userResource.getDataBase());
		 
		 
	 }
	 
	 
	 @Test
	 public void createUserTest(){
		 
		 
		 User user = createUser();
		 CreateResponse cResp = _userResource.create(user);
		 LOG.info(cResp.getId());
		 Assert.assertTrue(cResp.hasId());
		 cResp = _userResource.create(user);
		 LOG.info(cResp.getId());
		 Assert.assertTrue(cResp.hasId());

		 
	 }

	 

	/* @Test
	 public void getUserTest(){
		 String id = "5f374b9a-3157-33cf-b49f-155ec6be5b37";
		 User user = _userResource.get(id);
		 User _user = createUser();
		 _user.setId(id);
		 LOG.info(user);
		 Assert.assertEquals(user, _user);
	 }

	 
	 @Test
	 public void updateUserTest(){
		 String id = "5f374b9a-3157-33cf-b49f-155ec6be5b37";
		 User _user = createUser();
		 _user.setId(id);
		 _user.setCity("Cuenca");
		 UpdateResponse response = _userResource.update(id, _user);
		 LOG.info(response.getStatus().getCode());
		 Assert.assertNotNull(response);
		 
		
	 }
	 
	 @Test
	 public void deleteUserTest(){
		 String id = "5f374b9a-3157-33cf-b49f-155ec6be5b37";
		 UpdateResponse response = _userResource.delete(id);
		 LOG.info(response.getStatus().getCode());
		 Assert.assertNotNull(response);
		 
		
	 }*/
}
