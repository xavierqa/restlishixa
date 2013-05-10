package com.shixa.impl.util;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import com.linkedin.data.template.SetMode;
import com.shixa.formats.user.User;

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
	abstract User setContactMe(Boolean value, SetMode mode);
	
	@JsonIgnore
	abstract User setContactMe(boolean value);
	
	@JsonIgnore
	abstract User setUseEmail(Boolean value, SetMode mode);
	
	@JsonIgnore
	abstract User setUseEmail(boolean value);
	
	@JsonIgnore
	abstract User setUseTwitter(Boolean value, SetMode mode);
	
	@JsonIgnore
	abstract User setUseTwitter(boolean value);
	
	@JsonIgnore
	abstract User setVoice(Boolean value, SetMode mode);
	
	@JsonIgnore
	abstract User setVoice(boolean value);
	
	@JsonIgnore
	abstract User setSms(Boolean value, SetMode mode);
	
	@JsonIgnore
	abstract User setSms(boolean value);

}
