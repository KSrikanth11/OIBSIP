package com.example.springMVC.Contoller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;

import com.example.springMVC.Model.MCQSelected;

public interface MCQRepo extends JpaRepository<MCQSelected, Integer> {

	

	

}
