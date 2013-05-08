package com.shixa.impl.util;

public class ShixaErrors {

	public static enum errors { 
		USERNAME_ERROR("Username_error"),
		PASSWORD_ERROR("Password_error"),
		EMAIL_ERROR("Email_error"),
		ID_NULL("ID-Null"),
		USER_EXIST("User exist"),
		USER_NULL("User is null"),
		USER_DOESNOT_EXIST("User does not exist"),
		USER_HAS_BEEN_DELETE("User has been delete"),
		USER_HAS_NOT_BEEN_DELETE("User has not been delete"),
		USERNAME_PASSWORD_ERROR("Username/password error");
	
		private String message;
		
		private errors(String val) {
			this.message = val;
		}
		public String getError(){
			return message;
		}
	}  
}
