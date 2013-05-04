package com.shixa.impl.db;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.shixa.formats.User;
import com.shixa.impl.util.JsonGenerator;
import com.shixa.impl.util.JsonGeneratorImpl;
import com.shixa.impl.util.ShixaErrors;
import com.shixa.impl.util.UUIDGenerator;
import com.shixa.impl.util.UUIDGeneratorImpl;
import com.shixa.impl.util.UserErrors;

public class DataBaseConnectorImpl implements DataBaseConnector {

	private final AtomicLong _currId = new AtomicLong();
	private final Map<Long, User> _data = new ConcurrentHashMap<Long, User>();

	private String host = "localhost";
	
	private String port = "6379";
	
	private JedisPool pool; 
	
	private Jedis _jedis; 
	
	private JsonGenerator _json;
	
	UUIDGenerator _uuid; 
	
	public DataBaseConnectorImpl(){
		_uuid = new UUIDGeneratorImpl();
		_json = new JsonGeneratorImpl();
		pool = new JedisPool(new JedisPoolConfig(),host);
		_jedis = pool.getResource();
	}
	
	/*@Override
	public Long getCurrentId() {
		// TODO Auto-generated method stub
		
		return _currId.incrementAndGet();
	}

	@Override
	public Map<Long, User> getData() {
				// TODO Auto-generated method stub
	
		return _data;
	}*/

	/*
	 * User code: 
	 * -3 user exist 
	 * (non-Javadoc)
	 * @see com.shixa.impl.db.DataBaseConnector#createUser(com.shixa.formats.User)
	 */
	
	@Override
	public Long createUser(User user) {
		// TODO Auto-generated method stub
		Long id = _uuid.createUUID(user);
		if ( id < 0 )
			return id;
		
		if ( existUser(id)){
			return ShixaErrors.errors.USER_EXIST.getError(); 
		}
		user.setId(id);
		String json = _json.serializeJson(user);
		_jedis.set(String.valueOf(id), json);
		
		return id;
	}

	@Override
	public Long editUser(Long Id, User user) {
	
		
		if ( Id == null)
			return ShixaErrors.errors.ID_NULL.getError();
		if ( user == null){
			return ShixaErrors.errors.USER_NULL.getError();
		}
		if (!existUser(Id)){
			return ShixaErrors.errors.USER_DOESNOT_EXIST.getError();
		}
		
		_jedis.set(Id, user);
		
		return Id;
	}

	@Override
	public Long removeUser(Long Id) {
		// TODO Auto-generated method stub
		long val = _jedis.del(String.valueOf(Id));
		return val;
	}

	@Override
	public User getUser(Long Id) {
		String json = _jedis.get(String.valueOf(Id));
		User user = _json.deserializeJson(json);
		return user;
	}

	@Override
	public Boolean existUser(Long Id) {
		// TODO Auto-generated method stub
		return _jedis.exists(String.valueOf(Id));
	}

	@Override
	public Boolean existUser(String username, String password) {
		// TODO Auto-generated method stub
		long id = _uuid.getUUID(username, password);
		return existUser(id);
	}

}
