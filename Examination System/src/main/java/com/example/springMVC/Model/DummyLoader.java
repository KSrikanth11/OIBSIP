package com.example.springMVC.Model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.springMVC.Contoller.CustomerRepo;
import com.example.springMVC.Contoller.QuestionRepo;
@Component
public class DummyLoader implements CommandLineRunner{
	
	
	private CustomerRepo cRepo;
	private  QuestionRepo repo;

	@Autowired
	public DummyLoader(CustomerRepo cRepo,QuestionRepo repo) {
		
		this.cRepo = cRepo;
		this.repo = repo;
	}



public DummyLoader() {
	
}



@Override
public void run(String... args) throws Exception {
	
	
	
	
	  Customer customer1= new Customer();
	    customer1.setFirstName("K");
	    customer1.setLastName("S");
	    customer1.setEmail("s@gmail.com");
	    customer1.setPassword("K");
	    customer1.setConfirm_password("K");
	    customer1.setScore_Card(0L);
	    
	    cRepo.save(customer1);
	// TODO Auto-generated method stub
	Question question11 = new Question();
    question11.setQuestionDetail("What is the capital of France?");
    question11.setOptionA("Berlin");
    question11.setOptionB("Paris");
    question11.setOptionC("London");
    question11.setOptionD("Rome");
    question11.setCorrectAnswer("B");

    Question question12 = new Question();
    question12.setQuestionDetail("What is 2 + 2?");
    question12.setOptionA("1");
    question12.setOptionB("3");
    question12.setOptionC("4");
    question12.setOptionD("5");
    question12.setCorrectAnswer("C");
    
 // Question 1: General Knowledge
    Question question1 = new Question();
    question1.setQuestionDetail("Who is the current president of the United States?");
    question1.setOptionA("Donald Trump");
    question1.setOptionB("Joe Biden");
    question1.setOptionC("Barack Obama");
    question1.setOptionD("George W. Bush");
    question1.setCorrectAnswer("B");

    // Question 2: Mathematics
    Question question2 = new Question();
    question2.setQuestionDetail("What is the square root of 144?");
    question2.setOptionA("12");
    question2.setOptionB("14");
    question2.setOptionC("16");
    question2.setOptionD("18");
    question2.setCorrectAnswer("A");

    // Question 3: Science
    Question question3 = new Question();
    question3.setQuestionDetail("What is the chemical symbol for water?");
    question3.setOptionA("H2O");
    question3.setOptionB("CO2");
    question3.setOptionC("NaCl");
    question3.setOptionD("CH4");
    question3.setCorrectAnswer("A");

    // Question 4: History
    Question question4 = new Question();
    question4.setQuestionDetail("Who was the first man to step on the moon?");
    question4.setOptionA("Neil Armstrong");
    question4.setOptionB("Buzz Aldrin");
    question4.setOptionC("Alan Shepard");
    question4.setOptionD("John Glenn");
    question4.setCorrectAnswer("A");

    // Question 5: Geography
    Question question5 = new Question();
    question5.setQuestionDetail("Which continent is known as the 'Dark Continent'?");
    question5.setOptionA("Africa");
    question5.setOptionB("Asia");
    question5.setOptionC("Europe");
    question5.setOptionD("South America");
    question5.setCorrectAnswer("A");

    // Question 6: Literature
    Question question6 = new Question();
    question6.setQuestionDetail("Who wrote 'To Kill a Mockingbird'?");
    question6.setOptionA("Ernest Hemingway");
    question6.setOptionB("Harper Lee");
    question6.setOptionC("Mark Twain");
    question6.setOptionD("F. Scott Fitzgerald");
    question6.setCorrectAnswer("B");

    // Question 7: Sports
    Question question7 = new Question();
    question7.setQuestionDetail("Which sport does Cristiano Ronaldo play?");
    question7.setOptionA("Basketball");
    question7.setOptionB("Football (Soccer)");
    question7.setOptionC("Tennis");
    question7.setOptionD("Golf");
    question7.setCorrectAnswer("B");

    // Question 8: Technology
    Question question8 = new Question();
    question8.setQuestionDetail("Who is the CEO of Tesla?");
    question8.setOptionA("Bill Gates");
    question8.setOptionB("Elon Musk");
    question8.setOptionC("Jeff Bezos");
    question8.setOptionD("Tim Cook");
    question8.setCorrectAnswer("B");

    // Question 9: Movies
    Question question9 = new Question();
    question9.setQuestionDetail("Who directed the movie 'Titanic'?");
    question9.setOptionA("Steven Spielberg");
    question9.setOptionB("James Cameron");
    question9.setOptionC("Quentin Tarantino");
    question9.setOptionD("Christopher Nolan");
    question9.setCorrectAnswer("JB");

    // Question 10: Music
    Question question10 = new Question();
    question10.setQuestionDetail("Which band released the album 'The Dark Side of the Moon'?");
    question10.setOptionA("The Beatles");
    question10.setOptionB("Pink Floyd");
    question10.setOptionC("Led Zeppelin");
    question10.setOptionD("Queen");
    question10.setCorrectAnswer("B");
    
 // Question 11: Art
    Question question16 = new Question();
    question16.setQuestionDetail("Who painted the Mona Lisa?");
    question16.setOptionA("Vincent van Gogh");
    question16.setOptionB("Pablo Picasso");
    question16.setOptionC("Leonardo da Vinci");
    question16.setOptionD("Michelangelo");
    question16.setCorrectAnswer("C");

    // Question 12: Biology
    Question question17 = new Question();
    question17.setQuestionDetail("What is the powerhouse of the cell?");
    question17.setOptionA("Nucleus");
    question17.setOptionB("Ribosome");
    question17.setOptionC("Mitochondria");
    question17.setOptionD("Endoplasmic reticulum");
    question17.setCorrectAnswer("C");

    // Question 13: Politics
    Question question13 = new Question();
    question13.setQuestionDetail("Who is the Prime Minister of the United Kingdom?");
    question13.setOptionA("Boris Johnson");
    question13.setOptionB("Theresa May");
    question13.setOptionC("David Cameron");
    question13.setOptionD("Tony Blair");
    question13.setCorrectAnswer("A");

    // Question 14: Food & Drink
    Question question14 = new Question();
    question14.setQuestionDetail("What is the primary ingredient in guacamole?");
    question14.setOptionA("Tomato");
    question14.setOptionB("Avocado");
    question14.setOptionC("Onion");
    question14.setOptionD("Lime");
    question14.setCorrectAnswer("B");

    // Question 15: Mythology
    Question question15 = new Question();
    question15.setQuestionDetail("Who is the king of the gods in Greek mythology?");
    question15.setOptionA("Hera");
    question15.setOptionB("Ares");
    question15.setOptionC("Zeus");
    question15.setOptionD("Poseidon");
    question15.setCorrectAnswer("C");

    // Save each question to the database



    // Save each question to the database
    repo.save(question1);
    repo.save(question2);
    repo.save(question3);
    repo.save(question4);
    repo.save(question5);
    repo.save(question6);
    repo.save(question7);
    repo.save(question8);
    repo.save(question9);
    repo.save(question10);

    repo.save(question11);
    repo.save(question12);
    repo.save(question13);
    repo.save(question14);
    repo.save(question15);
    repo.save(question16);
    repo.save(question17);
    
    
    
    
  
}

}
