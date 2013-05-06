package com.shixa.impl.db;


import java.util.Map;

import com.shixa.formats.User;

public interface DataBaseConnector {

	// public Long getCurrentId();
	 
	// public Map<Long, User> getData();

	 public String createUser(User user); 
	 
	 public String editUser(String Id, User user);
	 
	 public String removeUser(String Id);
	 
	 public User getUser(String Id);
	 
	 public Boolean existUser(String Id);
	 
	 public Boolean existUser(String username, String password);
}
