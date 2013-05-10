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

import com.shixa.formats.authentication.ShixaAuth;
import com.shixa.formats.user.User;

import com.shixa.impl.AuthenticationResources;

import com.shixa.impl.db.UserDBConnector;
import com.shixa.impl.db.UserDBConnectorImpl;

public class AuthenticationTest {

	
	private Logger LOG = Logger.getLogger(AuthenticationTest.class);
	
	private AuthenticationResources _authenticationResource;
	
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
	 
	 @BeforeMethod
	 public void Initresource(){
		 LOG.info("THis is a test");
		 SimpleBeanProvider beanProvider = new SimpleBeanProvider();
		 final UserDBConnector _db = new UserDBConnectorImpl();
		 beanProvider.add("userDB", _db);
		 final InjectResourceFactory factory = new InjectResourceFactory(beanProvider);
		 final Map<String, ResourceModel> pathRootResourceMap = buildResourceModels(AuthenticationResources.class);
		 factory.setRootResources(pathRootResourceMap);
		 _authenticationResource = factory.create(AuthenticationResources.class);
		  Assert.assertNotNull(_authenticationResource);
		 
		 
	 }
	 
	 
	 @Test
	 public void authenticateTest(){
		 
		 User user = createUser();
		 String username = user.getEmail();
		 String password = user.getPassword();
		 ShixaAuth auth = new ShixaAuth();
		 auth.setPassword(password);
		 auth.setUsername(username);
		 CreateResponse cResp = _authenticationResource.create(auth);
		 LOG.info(cResp.getId());
		 Assert.assertNotNull(cResp);
		 
	 }
}
