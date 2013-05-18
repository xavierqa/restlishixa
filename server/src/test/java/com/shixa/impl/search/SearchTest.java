package com.shixa.impl.search;

import java.util.Set;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shixa.formats.question.Question;
import com.shixa.formats.user.User;
import com.shixa.impl.db.DBConnector;
import com.shixa.impl.db.QuestionDBConnector;
import com.shixa.impl.db.QuestionDBConnectorImpl;
import com.shixa.impl.db.RedisDBConnector;
import com.shixa.impl.db.UserDBConnector;
import com.shixa.impl.db.UserDBConnectorImpl;
import com.shixa.impl.util.UserTest;


public class SearchTest {

	private static Logger LOG = Logger.getLogger(Search.class);
	
	
	
	@BeforeMethod
	 public void Initresource(){
		String question = "what is the best place to go in SF";
		String question1 = "what are the best restaurants in Paris";
		
		DBConnector _redis = RedisDBConnector.getDBConnector();
		String key = "shixa:index:places";
		_redis.delete(key);
		String key1 = "shixa:index:tips";
		_redis.delete(key1);
		
	}
	
	@Test
	public void testIndex(){
		//String q = "how i can change a diper";
		//String q1 = "could we meet at the park";
		User user = new UserTest().createUser();
		UserDBConnector _user = new UserDBConnectorImpl();
		String id  = _user.createUser(user);
		user.setId(id);
		Question q = new Question();
		q.setUserId(user.getId());
		q.setUsername(user.getUsername());
		q.setTitle("places to have fun");
		q.setBody("I am looking for some place to have fun in SF");
		q.setUserRank(0);
/*		Question q1 = new Question();
		q1.setTitle("tips for baby to sing");
		Question q2 = new Question();
		q2.setTitle("tips for restaurants in sf");
		Question q3 = new Question();
		q3.setTitle("places to dance");
		Question q4 = new Question();
		q4.setTitle("places to eat");
		Question q5 = new Question();
		q5.setTitle("places of the city to visit");
*/		
		
		QuestionDBConnector _question = new QuestionDBConnectorImpl();
		_question.createQuestion(q);
	/*	_question.createQuestion(q1);
		_question.createQuestion(q2);
		_question.createQuestion(q3);
		_question.createQuestion(q4);
		_question.createQuestion(q5);*/

		Search _search = new RedisSearchImpl();
		
		Set<String> results = _search.search("places to");
		
		LOG.info(results);
		
		
		for(String r : results){
			LOG.info("results:" + r);
		}
		
	}
	
	
}
