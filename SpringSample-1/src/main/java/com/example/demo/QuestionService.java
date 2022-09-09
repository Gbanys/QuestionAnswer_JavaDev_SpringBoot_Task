package com.example.demo;

import java.util.Optional;
import java.util.Set;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface QuestionService {

	void postQuestion(Question question, Long userId);
	void postAnswer(Answer answer, Long questionId, Long userId);
	User createUser(User user);
	Set<Question> getQuestions(Long userId);
	Set<Answer> getAnswers(Long questionid, Long userId);
}
