package com.example.springMVC.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Question {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	 private String correctAnswer;
	    private String optionA;
	    private String optionB;
	    private String optionC;
	    private String optionD;
	    private String questionDetail;

	public String getQuestionDetail() {
		return questionDetail;
	}
	public void setQuestionDetail(String questionDetail) {
		this.questionDetail = questionDetail;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	

}
