package com.example.demo;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.User;
import com.example.demo.Question;
import com.example.demo.Answer;

public interface AnswerRepository extends CrudRepository<Answer,Long>{
	
	Set<Answer> findByQuestion(Question question);
	Set<Answer> findByUser(User user);
	Set<Answer> findByUserAndQuestion(User user, Question question);
}
