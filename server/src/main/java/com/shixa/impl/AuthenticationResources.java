package com.shixa.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

import com.linkedin.restli.server.CreateResponse;
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.linkedin.restli.server.resources.CollectionResourceTemplate;
import com.shixa.formats.ShixaAuth;
import com.shixa.formats.User;
import com.shixa.impl.db.DataBaseConnector;
import com.shixa.impl.db.DataBaseConnectorImpl;
import com.shixa.impl.util.ShixaErrors;

@RestLiCollection(name = "authentication", namespace = "com.shixa.formats")
public class AuthenticationResources extends CollectionResourceTemplate<String, ShixaAuth>{

	
	private static Logger LOG = Logger.getLogger(AuthenticationResources.class);
	
	@Inject
    @Named("userDB")
	private DataBaseConnector      _db;
	
	public AuthenticationResources() {
		// TODO Auto-generated constructor stub
		_db = new DataBaseConnectorImpl();
	}
	
	@Override
	public CreateResponse create(ShixaAuth entity) {
		
		String username = entity.getUsername();
		String password = entity.getPassword();
		
		User user = _db.getUser(username, password);
		
		if (user == null){
			return new CreateResponse(ShixaErrors.errors.USERNAME_PASSWORD_ERROR.getError());
		}
		return new CreateResponse(user.getId());
		
	}
	
}
