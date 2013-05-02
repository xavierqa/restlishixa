package com.shixa.impl;


import java.util.Map;

import com.shixa.formats.User;

public interface DataBaseConnector {

	 public Long getCurrentId();
	 
	 public Map<Long, User> getData();

}
