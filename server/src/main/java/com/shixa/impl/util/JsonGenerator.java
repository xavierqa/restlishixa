package com.shixa.impl.util;

import com.shixa.formats.User;

public interface JsonGenerator {

	public String serializeJson(User user);
	
	public User deserializeJson(String json);
}
