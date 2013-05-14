package com.shixa.impl.search;

import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import com.shixa.impl.db.DBConnector;
import com.shixa.impl.db.RedisDBConnector;

public class RedisIndexImpl implements Index{
	
	private static Logger LOG = Logger.getLogger(RedisIndexImpl.class);

	private DBConnector _redis; 
	
	private String key = "shixa:index:";
	
	public RedisIndexImpl() {
		// TODO Auto-generated constructor stub
		_redis = RedisDBConnector.getDBConnector();
	}
	
	@Override
	public boolean index(String text) {
		// TODO Auto-generated method stub
		StringTokenizer tokens = new StringTokenizer(text);
		int i = 0;
		int tokenSize = tokens.countTokens();
		boolean indexed = true;
		StringBuffer buffer = new StringBuffer();
		while( tokens.hasMoreTokens()){
			
			String t = tokens.nextToken();
			LOG.info("Token:"+ t + "count:" + i + " tokens count:" + tokens.countTokens() + " token size"+tokenSize);
			
			if (i==0){
				buffer.append(t);
			}else if ( tokens.countTokens() > 0 ){
				LOG.info("adding space");
				buffer.append(" "+ t);
			}else{
				buffer.append(t);
			}
			i++;
			LOG.info("Buffer:"+buffer);
			long r = _redis.index(key,i, buffer.toString());
			LOG.info("return val:"+r);
			if (r < 0 ){
				indexed = false;
			}
		}
		
		return indexed;
		
	}

}
