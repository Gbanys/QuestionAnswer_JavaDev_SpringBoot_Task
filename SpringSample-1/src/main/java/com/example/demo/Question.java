package com.example.demo;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class Question implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionid;
	private String ShortInfo;
	private String Details;
	
	@OneToMany(mappedBy="answerid", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Answer> Answers;
	
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name="userid", nullable=false)
	private User user;
}