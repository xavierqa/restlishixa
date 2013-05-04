package com.shixa.impl;

import javax.inject.*;

import org.apache.log4j.Logger;
import org.mortbay.log.Log;

import com.linkedin.restli.common.HttpStatus;
import com.linkedin.restli.common.PatchRequest;
import com.linkedin.restli.server.CreateResponse;
import com.linkedin.restli.server.RestLiServiceException;
import com.linkedin.restli.server.UpdateResponse;
import com.linkedin.restli.server.resources.CollectionResourceTemplate;
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.shixa.formats.User;
import com.shixa.impl.db.DataBaseConnector;
import com.shixa.impl.db.DataBaseConnectorImpl;


@RestLiCollection(name = "users", namespace = "com.shixa.formats")
public class UserResources extends CollectionResourceTemplate<Long, User>{

	private static Logger LOG = Logger.getLogger(UserResources.class);
	
	 @Inject
     @Named("userDB")
	 private DataBaseConnector      _db;

	public UserResources() {
		// TODO Auto-generated constructor stub
		_db = new DataBaseConnectorImpl();
	}
	 
	public DataBaseConnector getDataBase(){
		return _db;
	}
	
	
	@Override
	public CreateResponse create(User entity) {
		
		
		//System.out.println(id);
		System.out.println(entity.toString());		
		return new CreateResponse(1l);
	}
	
	@Override
	public User get(Long key) {
		User user = new User();
		user.setEmail("xavier.qa@go.com");
		user.setPassword("1234566");
		user.setUsername("xavierqa");
		LOG.info("get message");
		return user;
	}
	
	/*@Override
	public UpdateResponse update(Long key, User entity) {
		// TODO Auto-generated method stub
		return super.update(key, patch);
	}*/
}
