package com.shixa.impl.db;


import java.util.Map;

import com.shixa.formats.user.User;

public interface UserDBConnector {

	// public Long getCurrentId();
	 
	// public Map<Long, User> getData();

	 public String createUser(User user); 
	 
	 public String editUser(String Id, User user);
	 
	 public String removeUser(String Id);
	 
	 public User getUser(String Id);
	 
	 public User getUser(String username, String password);
	 
	 public Boolean existUser(String Id);
	 
	 public Boolean existUser(String username, String password);
}
