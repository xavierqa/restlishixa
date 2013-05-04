package com.shixa.impl.db;


import java.util.Map;

import com.shixa.formats.User;

public interface DataBaseConnector {

	// public Long getCurrentId();
	 
	// public Map<Long, User> getData();

	 public Long createUser(User user); 
	 
	 public Long editUser(Long Id, User user);
	 
	 public Long removeUser(Long Id);
	 
	 public User getUser(Long Id);
	 
	 public Boolean existUser(Long Id);
	 
	 public Boolean existUser(String username, String password);
}
