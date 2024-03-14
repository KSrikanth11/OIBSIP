package com.example.springMVC.Contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.springMVC.Model.Question;

public interface QuestionRepo extends JpaRepository<Question,Long>{

	Optional<Question> findById(Long id);

	

	
	@Query("SELECT q.id FROM Question q")
    List<Long> findIds();




	
	
}
