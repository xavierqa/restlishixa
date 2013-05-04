package com.shixa.impl.util;


import com.shixa.formats.User;

public interface UUIDGenerator {

	public Long createUUID(User user);
	
	public Long getUUID(String username, String password);
	
	
}
