package com.shixa.impl.db;

import java.util.Set;

import org.apache.log4j.Logger;





import com.shixa.impl.config.RedisConfiguration;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisDBConnector implements DBConnector{

	private static Logger LOG = Logger.getLogger(RedisDBConnector.class);
	
	private RedisConfiguration _redisconfig; 
	
	private JedisPool _pool; 
	
	private Jedis _jedis; 
	
	private static RedisDBConnector _redis = null;
	
	private RedisDBConnector(){
		_redisconfig = new RedisConfiguration();
		_pool = new JedisPool(new JedisPoolConfig(),_redisconfig.getHostname());
		_jedis = _pool.getResource();
	}
	
	public static RedisDBConnector getDBConnector(){
		if ( _redis == null){
			_redis = new RedisDBConnector();
		}
		return _redis;
	}
	
	
	
	@Override
	public Object set(String key, String value) {
		String _value = null;
		if (value.getClass().equals(String.class)){
			_value = String.valueOf(value);
		}
		_jedis.set(key, _value);
		return null;
	}

	@Override
	public String get(String key) {
		String value = _jedis.get(key);
		return value;
	}

	@Override
	public Object executeQuery(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long delete(String key) {
		// TODO Auto-generated method stub
		long val = _jedis.del(key);
		return val;
	}

	@Override
	public Object update(String key, String value) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Boolean exist(String key) {
		// TODO Auto-generated method stub
		return _jedis.exists(key);
	}

	@Override
	public long index(String key, long score, String val) {
		 long ret = _jedis.zadd(key, score, val);
		 LOG.info("indexing:"+ret + " "+score);
		return ret;
	}

	@Override
	public Set<String> search(String key, String member) {
		// TODO Auto-generated method stub
		LOG.info("Starting search"+ key + " "  + member);
		Long start = _jedis.zrank(key, member);
		if ( start == null){
			LOG.info("this is a null val");
			return null;
		}
		LOG.info("Start value:"+start);
		long end = 50;
		Set<String> results = _jedis.zrange(key, start, end);
		
		return results;
	}

	

	

}
