package com.example.demo;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.User;
import com.example.demo.Question;
import com.example.demo.Answer;

public interface QuestionRepository extends CrudRepository<Question, Long> {

	Set<Question> findByUser(User user);
	Question findByquestionid(Long questionid);
}
