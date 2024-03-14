package com.example.springMVC.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MCQSelected {
	@Id
	@GeneratedValue
	private long id;
	
//	@ManyToOne
//	@JoinColumn(name="user_id")
//	private Customer customer;
//	
	@ManyToOne
	@JoinColumn(name="question_id")
	private Question question;
	
	private String selectedOption;
	
	
	private boolean isCorrect;
	
	
	
	public String getSelectedOption() {
		return selectedOption;
	}
	public void setSelectedOption(String selectedOption) {
		this.selectedOption = selectedOption;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	


}
