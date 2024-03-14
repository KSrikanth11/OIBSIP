package com.example.springMVC.Model;

public class QuestionCountDto {

	
	 private  long questionCount ;
	 
	 public QuestionCountDto(long questionCount) {
         this.questionCount = questionCount;
     }

     public long getQuestionCount() {
         return questionCount;
     }
}
