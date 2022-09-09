package com.example.demo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Answer implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long answerid;
	private String ShortInfo;
	private String Details;
	
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name="questionid", nullable=false)
	private Question question;
	
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name="userid", nullable=false)
	private User user;
	
	

}
