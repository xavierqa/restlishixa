package com.shixa.impl.util;

import java.util.UUID;

import org.apache.log4j.Logger;

import com.shixa.formats.question.Question;
import com.shixa.formats.user.User;




public class UUIDGeneratorImpl implements UUIDGenerator{

	private static Logger LOG = Logger.getLogger(UUIDGeneratorImpl.class);
	
	private String _salt = "!!@@@##$xavier_app";
	
	/*
	 * Error code:
	 * code = -1 ( no email )
	 * code = -2 ( no password ) 
	 *   
	 * (non-Javadoc)
	 * @see com.shixa.impl.util.UUIDGenerator#createUUID(com.shixa.formats.User)
	 */
	
	@Override
	public String createUUID(User user) {
		// TODO Auto-generated method stub
		if (!user.hasEmail())
			return ShixaErrors.errors.EMAIL_ERROR.getError();
		if (!user.hasPassword())
			return ShixaErrors.errors.PASSWORD_ERROR.getError();
		
		return generateUUID(user.getEmail(), user.getPassword());
		
	}

	@Override
	public String getUUID(String username, String password) {
		return generateUUID(username, password);
	}

	private String generateUUID(String username, String password){
		if ( username == null || username.isEmpty())
			return ShixaErrors.errors.USERNAME_ERROR.getError();
		if ( password == null){
			return ShixaErrors.errors.PASSWORD_ERROR.getError();
		}
		
		String _userstring= username+ password+ _salt;
		
		UUID uuid = UUID.nameUUIDFromBytes(_userstring.getBytes());
		LOG.info(uuid.toString());
		//LOG.info(uuid.getMostSignificantBits());
		return uuid.toString();

	}

	/*
	 * Room for improvement: 
	 * - Check spelling of the title
	 * 
	 * (non-Javadoc)
	 * @see com.shixa.impl.util.UUIDGenerator#createQuestionUUID(com.shixa.formats.question.Question)
	 */
	
	@Override
	public String createQuestionUUID(Question question) {
		// TODO Auto-generated method stub
		
		String questionID = null;
		
		if ( !question.getTitle().equals("")){
			questionID = UUID.nameUUIDFromBytes(question.getTitle().toLowerCase().getBytes()).toString();
		}
		
		return questionID;
	}

	@Override
	public Integer createTextID(String text) {
		// TODO Auto-generated method stub
		Integer textID = UUID.nameUUIDFromBytes(text.getBytes()).hashCode();
		return textID;
	}

	
		
}
