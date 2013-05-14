package com.shixa.impl.search;

import java.util.Set;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchTest {

	private static Logger LOG = Logger.getLogger(Search.class);
	
	@Test
	public void testIndex(){
		String question = "what is the best place to go in SF";
		String question1 = "what are the best restaurants in Paris";
		
		LOG.info("Test index");
		Index _index = new RedisIndexImpl();
		
		boolean retVal =  _index.index(question);
		boolean retval = _index.index(question1);
		
		Assert.assertEquals(retVal, true);
		
		Search _search = new RedisSearchImpl();
		
		Set<String> results = _search.search("what are");
		
		for(String r : results){
			LOG.info("results:" + r);
		}
		
	}
	
	
}
