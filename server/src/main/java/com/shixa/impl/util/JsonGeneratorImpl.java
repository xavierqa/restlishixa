package com.shixa.impl.util;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.shixa.formats.question.Question;
import com.shixa.formats.user.User;



public class JsonGeneratorImpl implements JsonGenerator{

	private static Logger LOG = Logger.getLogger(JsonGeneratorImpl.class);
	
	@Override
	public String serializeJson(User user) {
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.getSerializationConfig().addMixInAnnotations(User.class,UserAbstract.class);
		if( !mapper.canSerialize(User.class)) {
			return null;
		}
		String json = null;
		try {
			json = mapper.writeValueAsString(user);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			LOG.error("JSON Generation ERROR" , e);
			//e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			LOG.error("JSON Mapping ERROR" , e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.error("JSON IOException ERROR" , e);
		}
		return json;
	}

	@Override
	public User deserializeJson(String json) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.getDeserializationConfig().addMixInAnnotations(User.class, UserAbstract.class);
		User user = null;
		try {
			 user = mapper.readValue(json, User.class);
		} catch (JsonParseException e) {
			LOG.error("Json parser error", e);
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			LOG.error("Json mapping error", e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.error("Json IO error", e);
		}
		return user;
	}

	@Override
	public String serializeQuestion(Question question) {
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.getSerializationConfig().addMixInAnnotations(Question.class,QuestionAbstract.class);
		if( !mapper.canSerialize(Question.class)) {
			return null;
		}
		String json = null;
		try {
			json = mapper.writeValueAsString(question);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			LOG.error("JSON Generation ERROR" , e);
			//e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			LOG.error("JSON Mapping ERROR" , e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.error("JSON IOException ERROR" , e);
		}
		return json;
	}

	@Override
	public Question deserializeQuestion(String json) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.getDeserializationConfig().addMixInAnnotations(Question.class, QuestionAbstract.class);
		Question question = null;
		try {
			 question = mapper.readValue(json, Question.class);
		} catch (JsonParseException e) {
			LOG.error("Json parser error", e);
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			LOG.error("Json mapping error", e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.error("Json IO error", e);
		}
		return question;
	}

}
