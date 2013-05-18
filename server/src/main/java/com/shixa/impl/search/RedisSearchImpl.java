package com.shixa.impl.search;

import java.util.Set;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import com.shixa.impl.db.DBConnector;
import com.shixa.impl.db.RedisDBConnector;

public class RedisSearchImpl implements Search {

	
	private DBConnector _redis;
	
	private StringBuffer key = new StringBuffer("shixa:index:");

	private static Logger LOG = Logger.getLogger(RedisSearchImpl.class);
	
	public RedisSearchImpl() {
		_redis = RedisDBConnector.getDBConnector();
	}
	
	@Override
	public Set<String> search(String query) {
		// TODO Auto-generated method stub
		LOG.info("redis" + _redis.toString());
		StringTokenizer _query = new StringTokenizer(query);
		key.append(_query.nextToken());
		LOG.info(key.toString());
		Set<String> results = _redis.search(key.toString(), query);
		
		return results;
	} 
	
	
	
}
