package com.shixa.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.shixa.formats.User;

public class DataBaseConnectorImpl implements DataBaseConnector {

	private final AtomicLong _currId = new AtomicLong();
	private final Map<Long, User> _data = new ConcurrentHashMap<Long, User>();

	private String host = "localhost";
	
	private String port = "6379";
	
	private JedisPool pool; 
	
	private Jedis _jedis; 
	
	public DataBaseConnectorImpl(){
		pool = new JedisPool(new JedisPoolConfig(),host);
		
	}
	
	@Override
	public Long getCurrentId() {
		// TODO Auto-generated method stub
		
		return _currId.incrementAndGet();
	}

	@Override
	public Map<Long, User> getData() {
		// TODO Auto-generated method stub
		return _data;
	}

}
