package com.shixa.impl.util;


import com.shixa.formats.user.User;

public interface UUIDGenerator {

	public String createUUID(User user);
	
	public String getUUID(String username, String password);
	
	
}
