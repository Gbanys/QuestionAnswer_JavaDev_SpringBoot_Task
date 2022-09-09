package com.example.demo;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userid;
	private String Name;
	private String Address;
	private Long phoneNumber;
	
	@OneToMany(mappedBy="questionid", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Question> Questions;
	
	@OneToMany(mappedBy="answerid", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Answer> Answers;
}
