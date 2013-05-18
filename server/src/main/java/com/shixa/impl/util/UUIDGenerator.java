package com.shixa.impl.util;


import com.shixa.formats.question.Question;
import com.shixa.formats.user.User;

public interface UUIDGenerator {

	public String createUUID(User user);
	
	public String getUUID(String username, String password);
	
	public String createQuestionUUID(Question question);
	
	public Integer createTextID(String text);
}
