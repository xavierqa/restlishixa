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
import com.shixa.impl.util.ShixaErrors;
import com.sun.xml.internal.bind.marshaller.Messages;


@RestLiCollection(name = "users", namespace = "com.shixa.formats")
public class UserResources extends CollectionResourceTemplate<String, User>{

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
		String id = _db.createUser(entity);
		
		return new CreateResponse(id);
	}
	
	@Override
	public User get(String key) {
		User user = null;
		user = _db.getUser(key);
		return user;
	}

	@Override
	public UpdateResponse update(String key, User entity) {
		// TODO Auto-generated method stub
		String id = _db.editUser(key, entity);
		if ( id.equals(ShixaErrors.errors.ID_NULL.getError()))
			return new UpdateResponse(HttpStatus.S_404_NOT_FOUND);
		if ( id.equals(ShixaErrors.errors.USER_NULL.getError()))
			return new UpdateResponse(HttpStatus.S_404_NOT_FOUND);
		if (id.equals(ShixaErrors.errors.USER_DOESNOT_EXIST.getError()))
			return new UpdateResponse(HttpStatus.S_404_NOT_FOUND);
		
		return new UpdateResponse(HttpStatus.S_204_NO_CONTENT);
	}
	
	
	@Override
	public UpdateResponse delete(String key) {
		// TODO Auto-generated method stub
		String message = _db.removeUser(key);
		if( message.equals(ShixaErrors.errors.USER_HAS_NOT_BEEN_DELETE.getError())){
			return new UpdateResponse(HttpStatus.S_404_NOT_FOUND);
	}
		return new UpdateResponse(HttpStatus.S_200_OK);
	}
	/*@Override
	public UpdateResponse update(Long key, User entity) {
		// TODO Auto-generated method stub
		return super.update(key, patch);
	}*/
}
