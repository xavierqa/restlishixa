package com.shixa.impl.db;

import java.util.List;

import com.shixa.formats.question.Question;


public interface QuestionDBConnector {
	
	public String createQuestion(Question question);
	
	public Question getQuestion(String questionId);
	
	public List<Question> getAllQuestions(String userId);
	
	public String deleteQuestion(String questionId);
	
	public String deleteAllQuestions(String userId);
	
	public String updateQuestion(String questionId, Question question);

	
}
