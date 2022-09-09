package com.example.demo;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImplementation implements QuestionService{
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	
	//Post question for each user
	@Override
	public void postQuestion(Question question, Long userId) {
		
		User user = userRepository.findByuserid(userId);
		question.setUser(user);
		questionRepository.save(question);
		
	}
	
	//Post an answer to each question
	@Override
	public void postAnswer(Answer answer, Long questionId, Long userid) {
		
		
		Question question = questionRepository.findByquestionid(questionId);
		answer.setQuestion(question);
		User user = userRepository.findByuserid(userid);
		answer.setUser(user);
		
		answerRepository.save(answer);
	}
	
	
	//Create a new user
	@Override
	public User createUser(User user) {
		
		return userRepository.save(user);
	}
	
	
	//Get all questions from the user
	@Override
	public Set<Question> getQuestions(Long userId){
		
		User user = userRepository.findByuserid(userId);
		Set<Question> questions = questionRepository.findByUser(user);
		return questions;
		
	}
	
	//Get all answers for each question
	@Override
	public Set<Answer> getAnswers(Long userId, Long questionid) {
		
		User user = userRepository.findByuserid(userId);
		Question question = questionRepository.findByquestionid(questionid);
		//Question question = questionRepository.findByquestionid(questionId);
		Set<Answer> answers = answerRepository.findByUserAndQuestion(user, question);
		return answers;
	}
}
