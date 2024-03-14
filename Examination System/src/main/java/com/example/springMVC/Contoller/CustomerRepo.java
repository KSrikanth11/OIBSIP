package com.example.springMVC.Contoller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springMVC.Model.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {

	



	Customer findByEmail(String email);

	

}

