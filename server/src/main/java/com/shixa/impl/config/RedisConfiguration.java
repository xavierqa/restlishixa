package com.shixa.impl.config;

public class RedisConfiguration implements Configuration{

	private String hostname; 
	
	private String port;
	
	public RedisConfiguration() {
		// TODO Auto-generated constructor stub
		this.hostname = "localhost";
		this.port = "6379";
	}
	
	@Override
	public String getHostname() {
		// TODO Auto-generated method stub
		return this.hostname;
	}

	@Override
	public String getPort() {
		// TODO Auto-generated method stub
		return this.port;
	}

}
