package com.shixa.impl.search;

import com.shixa.formats.question.Question;

public interface Index {

	
	public boolean index(String text, Question question);
	
	
}
