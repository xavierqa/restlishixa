package com.shixa.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import com.shixa.formats.User;

public class DataBaseConnectorImpl implements DataBaseConnector {

	private final AtomicLong _currId = new AtomicLong();
	private final Map<Long, User> _data = new ConcurrentHashMap<Long, User>();

	
	public DataBaseConnectorImpl(){
		
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
