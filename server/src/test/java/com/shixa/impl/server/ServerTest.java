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
import com.shixa.formats.User;
import com.shixa.impl.UserResources;
import com.shixa.impl.db.DataBaseConnector;
import com.shixa.impl.db.DataBaseConnectorImpl;



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

	 @BeforeMethod
	 public void Initresource(){
		 LOG.info("THis is a test");
		 SimpleBeanProvider beanProvider = new SimpleBeanProvider();
		 final DataBaseConnector _db = new DataBaseConnectorImpl();
		 beanProvider.add("userDB", _db);
		 final InjectResourceFactory factory = new InjectResourceFactory(beanProvider);
		 final Map<String, ResourceModel> pathRootResourceMap = buildResourceModels(UserResources.class);
		 factory.setRootResources(pathRootResourceMap);
		 _userResource = factory.create(UserResources.class);
		  Assert.assertNotNull(_userResource);
		 Assert.assertNotNull(_userResource.getDataBase());
		 
		 
	 }
	 
	 
	 @Test
	 public void TestCreateUser(){
		 Long id = 0l;
		 User user = new User();
		 user.setEmail("xavier@gmail.com");
		 user.setPassword("1234567");
		 user.setUsername("xavierqa");
		 LOG.info("Running test");
		 CreateResponse cResp = _userResource.create(user);
		 LOG.info(cResp.getId());
		 Assert.assertTrue(cResp.hasId());

		 cResp = _userResource.create(user);
		 LOG.info(cResp.getId());
		 Assert.assertTrue(cResp.hasId());

		 
	 }
	
}
