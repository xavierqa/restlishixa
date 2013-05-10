package com.shixa.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.linkedin.restli.server.CreateResponse;
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.linkedin.restli.server.resources.CollectionResourceTemplate;
import com.shixa.formats.question.Question;


@RestLiCollection(name = "question", namespace = "com.shixa.formats")
public class QuestionResources extends CollectionResourceTemplate<String,Question>{

/*	@Inject
    @Named("questionDB")
	private DataBaseConnector _db = null;
	
	
	public QuestionResources() {
		_db = new DataBaseConnectorImpl();
	}
	
*/	@Override
	public CreateResponse create(Question entity) {
		// TODO Auto-generated method stub
		return super.create(entity);
	}
}
