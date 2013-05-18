package com.shixa.impl.util;

import com.shixa.formats.question.Question;
import com.shixa.formats.user.User;

public interface JsonGenerator {

	public String serializeJson(User user);
	
	public User deserializeJson(String json);
	
	public String serializeQuestion(Question question);
	
	public Question deserializeQuestion(String json);
	
}


