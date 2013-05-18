package com.shixa.impl.search;

import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import com.shixa.formats.question.Question;
import com.shixa.impl.db.DBConnector;
import com.shixa.impl.db.RedisDBConnector;
import com.shixa.impl.util.JsonGenerator;
import com.shixa.impl.util.JsonGeneratorImpl;
import com.shixa.impl.util.UUIDGenerator;
import com.shixa.impl.util.UUIDGeneratorImpl;

public class RedisIndexImpl implements Index{
	
	private static Logger LOG = Logger.getLogger(RedisIndexImpl.class);

	private DBConnector _redis; 
	
	private String key = new String("shixa:index:");
	
	 
	public RedisIndexImpl() {
		// TODO Auto-generated constructor stub
		_redis = RedisDBConnector.getDBConnector();
	
	}
	
	@Override
	public boolean index(String text, Question question) {
		// TODO Auto-generated method stub
		StringTokenizer tokens = new StringTokenizer(text);
		
		int tokenSize = tokens.countTokens();
		boolean indexed = true;
		
	//	JsonGenerator _json = new JsonGeneratorImpl();
	//	String json = _json.serializeQuestion(question);
		StringBuffer buffer = new StringBuffer();
		int i = 0;
		StringBuffer _key = new StringBuffer(key);
		while( tokens.hasMoreTokens()){
			
			String t = tokens.nextToken();
		
			
			if (i==0){
				buffer.append(t);
				_key.append(t);
			}else if ( tokens.countTokens() >= 0 ){
				LOG.info("adding space");
				buffer.append(" "+ t);
				_key.append(" "+t);
			}else{
				
			}
			
			LOG.info("Buffer:"+buffer);
			i++;
			//UUIDGenerator qID = new UUIDGeneratorImpl();
		//	Integer textid = qID.createTextID(buffer.toString());
			LOG.info("Token:"+ t + "id:" + _key.toString() + " tokens count:" + tokens.countTokens() + " token size"+tokenSize);
		//	qID.createQuestionUUID(question)
			
			long r = _redis.index(_key.toString(),i, buffer.toString());
			LOG.info("return val:"+r);
			
			if (r < 0 ){
				indexed = false;
			}
		}
		
		return indexed;
		
	}

}
