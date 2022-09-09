package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionUserController {
	
	@Autowired
	private QuestionServiceImplementation questionServiceImpl;
	
	@PostMapping("/createUser")
	public String createUser(@RequestParam(value = "userid", defaultValue = "1") Long userid) {
		
		User tempUser = new User();
		tempUser.setName("Giedrius");
		tempUser.setAddress("UK");
		tempUser.setPhoneNumber(83745776L);
		
		questionServiceImpl.createUser(tempUser);
		return "User created";
	}
	
	@PostMapping("/createQuestion")
	public String createQuestion(@RequestParam(value = "userid", defaultValue = "1") Long userId) {
			
			Question question = new Question();
			question.setShortInfo("Question");
			question.setDetails("What is this question?");
			questionServiceImpl.postQuestion(question, userId);
			return "Question created";
			
	}
	
	@PostMapping("/createAnswer")
	public String createAnswer(@RequestParam(value = "questionid", defaultValue = "1") Long questionId,
			@RequestParam(value = "userid", defaultValue = "1") Long userId) {
		
		Answer answer = new Answer();
		answer.setShortInfo("Answer");
		answer.setDetails("Answer to the question");
		questionServiceImpl.postAnswer(answer, questionId, userId);
		return "Answer Created";
		
	}
	
	@GetMapping("/getQuestions")
	public Set<Question> getQuestions(@RequestParam(value = "userid", defaultValue = "1") Long userId) {
		
		Set<Question> questions = questionServiceImpl.getQuestions(userId);
		return questions;
	}
	
	@GetMapping("/getAnswers")
	public Set<Answer> getAnswers(@RequestParam(value = "userid", defaultValue = "1") Long userid,
			@RequestParam(value = "questionid", defaultValue = "1") Long questionid) {
		
		Set<Answer> answers = questionServiceImpl.getAnswers(userid, questionid);
		return answers;
	}
	
}

