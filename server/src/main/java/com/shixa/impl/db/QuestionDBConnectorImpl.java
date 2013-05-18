package com.shixa.impl.db;

import java.util.List;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.shixa.formats.question.Question;
import com.shixa.impl.search.Index;
import com.shixa.impl.search.RedisIndexImpl;
import com.shixa.impl.util.JsonGenerator;
import com.shixa.impl.util.JsonGeneratorImpl;
import com.shixa.impl.util.UUIDGenerator;
import com.shixa.impl.util.UUIDGeneratorImpl;


public class QuestionDBConnectorImpl implements QuestionDBConnector{

	private static Logger LOG = Logger.getLogger(QuestionDBConnectorImpl.class);
	
	private DBConnector _redis; 
	
	private JsonGenerator _json;
	
	private UUIDGenerator _uuid; 
	
	private Index _index;
	
	private String _question_redis = "shixa:question:";
	
	public QuestionDBConnectorImpl() {
		_uuid = new UUIDGeneratorImpl();
		_json = new JsonGeneratorImpl();
		_redis = RedisDBConnector.getDBConnector();
		_index = new RedisIndexImpl();
	}
	
	private String getQuestionId(String id){
		return _question_redis.concat(id);
		
	}
	
	@Override
	public String createQuestion(Question question) {
		
		String questionID = _uuid.createQuestionUUID(question);
		LOG.info("Question ID:"+questionID);
		question.setQuestionId(questionID);
		if(!_redis.exist(questionID)){
			_index.index(question.getTitle(), question);
		}else{
			//add the user to the current list of questions
		}
		
		
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
