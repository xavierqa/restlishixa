package com.shixa.impl.util;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import com.linkedin.data.template.SetMode;
import com.shixa.formats.User;

public abstract class UserAbstract {
	public UserAbstract() {
		// TODO Auto-generated constructor stub
	}
	@JsonIgnore
	abstract User setId(Long value, SetMode mode);
	@JsonIgnore
	abstract User setId(long value);
	
	@JsonIgnore
	abstract User setLatitud(Double value, SetMode mode);
	@JsonIgnore
	abstract User setLatitud(double value);
	
	@JsonIgnore
	abstract User setLongitud(Double value, SetMode mode);
	@JsonIgnore
	abstract User setLongitud(double value);
	
	@JsonIgnore
	abstract User setContactme(Boolean value, SetMode mode);
	
	@JsonIgnore
	abstract User setContactme(boolean value);
	
	@JsonIgnore
	abstract User setUse_email(Boolean value, SetMode mode);
	
	@JsonIgnore
	abstract User setUse_email(boolean value);
	
	@JsonIgnore
	abstract User setUse_twitter(Boolean value, SetMode mode);
	
	@JsonIgnore
	abstract User setUse_twitter(boolean value);
	
	@JsonIgnore
	abstract User setVoice(Boolean value, SetMode mode);
	
	@JsonIgnore
	abstract User setVoice(boolean value);
	
	@JsonIgnore
	abstract User setSms(Boolean value, SetMode mode);
	
	@JsonIgnore
	abstract User setSms(boolean value);

}
