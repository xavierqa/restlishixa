package com.shixa.impl.util;

public class ShixaErrors {

	public static enum errors { 
		USERNAME_ERROR(-1),
		PASSWORD_ERROR(-2),
		EMAIL_ERROR(-3),
		ID_NULL(-4),
		USER_EXIST(-5),
		USER_NULL(-6),
		USER_DOESNOT_EXIST(-7);
	
		private long id;
		
		private errors(long val) {
			this.id = val;
		}
		public long getError(){
			return id;
		}
	}  
}
