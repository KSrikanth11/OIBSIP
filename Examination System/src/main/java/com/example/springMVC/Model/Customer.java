package com.example.springMVC.Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue
   private Long id;
	private String firstName;
   private String lastName;
  
private String email;
   private String password;
   private String confirm_password;
   private Long Score_Card;

   private Date dateOfBirth;
   private String gender;
   private String nationality;
   private String profilePicture;
   private String phoneNumber;
   
   
   
   public Long getScore_Card() {
		return Score_Card;
	}
	public void setScore_Card(Long score_Card) {
		Score_Card = score_Card;
	}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getConfirm_password() {
	return confirm_password;
}
public void setConfirm_password(String confirm_password) {
	this.confirm_password = confirm_password;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getNationality() {
	return nationality;
}
public void setNationality(String nationality) {
	this.nationality = nationality;
}
public String getProfilePicture() {
	return profilePicture;
}
public void setProfilePicture(String profilePicture) {
	this.profilePicture = profilePicture;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

}
