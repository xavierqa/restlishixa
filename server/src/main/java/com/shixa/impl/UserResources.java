package com.shixa.impl;

import javax.inject.*;

import com.linkedin.restli.common.HttpStatus;
import com.linkedin.restli.server.CreateResponse;
import com.linkedin.restli.server.RestLiServiceException;
import com.linkedin.restli.server.resources.CollectionResourceTemplate;
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.shixa.formats.User;


@RestLiCollection(name = "users", namespace = "com.shixa.formats")
public class UserResources extends CollectionResourceTemplate<Long, User>{

	 @Inject
     @Named("userDB")
	 private DataBaseConnector      _db;

	
	public DataBaseConnector getDataBase(){
		return _db;
	}
	
	
	@Override
	public CreateResponse create(User entity) {
		final Long id = _db.getCurrentId();
		
		if( entity.hasId() ){
			throw new RestLiServiceException(HttpStatus.S_400_BAD_REQUEST,
                    "User ID is not acceptable in request");
		}
		return super.create(entity);
	}
}
