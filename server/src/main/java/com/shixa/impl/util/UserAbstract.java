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
}
