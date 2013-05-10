package com.shixa.impl.db;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;



import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.shixa.formats.user.User;
import com.shixa.impl.util.JsonGenerator;
import com.shixa.impl.util.JsonGeneratorImpl;
import com.shixa.impl.util.ShixaErrors;
import com.shixa.impl.util.UUIDGenerator;
import com.shixa.impl.util.UUIDGeneratorImpl;


public class UserDBConnectorImpl implements UserDBConnector {

	private static Logger LOG = Logger.getLogger(UserDBConnectorImpl.class);
	
	private final AtomicLong _currId = new AtomicLong();
	private final Map<Long, User> _data = new ConcurrentHashMap<Long, User>();

	private String host = "localhost";
	
	private String port = "6379";
	
	private JedisPool pool; 
	
	private Jedis _jedis; 
	
	private JsonGenerator _json;
	
	UUIDGenerator _uuid; 
	
	private String _user_redis="shixa:user:";
	
	public UserDBConnectorImpl(){
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
	
	private String getUserId(String id){
		return _user_redis.concat(id);
	}
	
	@Override
	public String createUser(User user) {
		// TODO Auto-generated method stub
		String id = _uuid.createUUID(user);
		LOG.info("ID:"+id);
		if ( existUser(id)){
			return ShixaErrors.errors.USER_EXIST.getError(); 
		}
		user.setId(id);
		LOG.info(user.toString());
		String json = _json.serializeJson(user);
		LOG.info(json);
		_jedis.set(getUserId(id), json);
		
		return id;
	}

	@Override
	public String editUser(String Id, User user) {
	
		
		if ( Id == null)
			return ShixaErrors.errors.ID_NULL.getError();
		if ( user == null){
			return ShixaErrors.errors.USER_NULL.getError();
		}
		if (!existUser(Id)){
			return ShixaErrors.errors.USER_DOESNOT_EXIST.getError();
		}
		
		String json = _json.serializeJson(user);
		_jedis.set(getUserId(Id), json);
		
		return Id;
	}

	@Override
	public String removeUser(String Id) {
		// TODO Auto-generated method stub
		long val = _jedis.del(getUserId(Id));
		String response; 
		if ( val < 0 ){
			response = ShixaErrors.errors.USER_HAS_NOT_BEEN_DELETE.getError();
		}else{
			response = ShixaErrors.errors.USER_HAS_BEEN_DELETE.getError();
		}
		return response;
	}

	@Override
	public User getUser(String Id) {
		String json = _jedis.get(getUserId(Id));
		User user = _json.deserializeJson(json);
		return user;
	}

	@Override
	public Boolean existUser(String Id) {
		// TODO Auto-generated method stub
		return _jedis.exists(getUserId(Id));
	}

	@Override
	public Boolean existUser(String username, String password) {
		// TODO Auto-generated method stub
		String id = _uuid.getUUID(username, password);
		return existUser(id);
	}

	@Override
	public User getUser(String username, String password) {
		// TODO Auto-generated method stub
		User user =null;
		if(existUser(username, password) ){
			String id = _uuid.getUUID(username, password);
			user = getUser(id);
			LOG.info("User:"+user.toString());
		}else{
			LOG.info("User does not exist");
		}
		return user;
	}

}
