package com.shixa.impl.db;

import java.util.List;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.shixa.formats.question.Question;
import com.shixa.impl.util.JsonGenerator;
import com.shixa.impl.util.JsonGeneratorImpl;
import com.shixa.impl.util.UUIDGenerator;
import com.shixa.impl.util.UUIDGeneratorImpl;


public class QuestionDBConnectorImpl implements QuestionDBConnector{

	private static Logger LOG = Logger.getLogger(QuestionDBConnectorImpl.class);
	
	private String host = "localhost";
	
	private String port = "6379";
	
	private JedisPool pool; 
	
	private Jedis _jedis; 
	
	private JsonGenerator _json;
	
	private UUIDGenerator _uuid; 
	
	private String _question_redis = "shixa:question:";
	
	public QuestionDBConnectorImpl() {
		_uuid = new UUIDGeneratorImpl();
		_json = new JsonGeneratorImpl();
		pool = new JedisPool(new JedisPoolConfig(),host);
		_jedis = pool.getResource();
	}
	
	private String getQuestionId(String id){
		return _question_redis.concat(id);
		
	}
	
	@Override
	public String createQuestion(Question question) {
		
		String questionID = _uuid.createQuestionUUID(question);
		
		return null;
	}

	@Override
	public Question getQuestion(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteQuestion(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateQuestion(String id, Question question) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String deleteAllQuestions(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> getAllQuestions(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
