package com.example.springMVC.Contoller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springMVC.Model.Customer;
import com.example.springMVC.Model.Question;
import com.example.springMVC.Model.QuestionCountDto;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;



@Controller
public class controller {

	@Autowired
	CustomerRepo repo;
	
	@Autowired
	QuestionRepo qRepo;
	@Autowired
	MCQRepo mcqSelected;
	
	
	@GetMapping(value="/")
	public String getHome() {
		return "home.jsp";
	}
	@GetMapping(value="/registration")
	public String getregistered() {
		return "Registration.jsp";
	}
	@GetMapping(value="/login")
	public String getlogin() {
		return "login.jsp";
	}
	@GetMapping(value="/forgotpass")
	public String getForgotPass(){
		return null;
	}
	@GetMapping(value="/exam")
	public String getExam(Model m) {
//		List<Question> ques=qRepo.findAll();
		m.addAttribute("ques",qRepo.findAll());
		return "Exam.jsp";
	}
	@GetMapping(value="/submitTest")
	public String getResultpage(Model m) {
		 Customer customer = repo.findById(1).orElse(null);
		m.addAttribute("result", customer.getScore_Card());
		
		return "result.jsp";
	}
	
	@GetMapping(value="/returntodashboard")
	public String getReturnToDashboeard() {
		return "success.jsp";
	}
	
	
	@GetMapping(value="updationForm")
	public String getupdationForm() {
		return "updationForm.jsp";
	}
	 @GetMapping("/questionCount")
	    public ResponseEntity<QuestionCountDto> getQuestionCount() {
	        long questionCount = qRepo.count();
	        QuestionCountDto questionCountDto = new QuestionCountDto(questionCount);
	        return ResponseEntity.ok(questionCountDto);
	    }
	 
	 
//	 @GetMapping("/question/{questionId}")
//	    @ResponseBody
//	    public String getQuestionById(@PathVariable Long questionId ,Model m) {
//	        Question question = qRepo.findById(questionId).orElse(null);;
//	        
//	            m.addAttribute("data", question);
//	            return "Exam.jsp"; // Assuming there's a JSP file named "question.jsp" to display the question
//	        
//	    }
	 
	    @GetMapping("/question/{questionId}")
	    public ResponseEntity<Question> getQuestionById(@PathVariable Long questionId) {
	        Optional<Question> optionalQuestion = qRepo.findById(questionId);
	        if (optionalQuestion.isPresent()) {
	            Question question = optionalQuestion.get();
	            return new ResponseEntity<>(question, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	
	@PostMapping(value="/addCustomer")
	public String addCustomer(Customer data, Model m) {
//		System.out.println(firstName +" " +lastName+" "+email);
//		m.addAttribute("firstName",firstName );
//		m.addAttribute("lastName",lastName );
//		m.addAttribute("email",email );
		repo.save(data);
//		m.addAttribute("data", repo.findAll());
		return "login.jsp";
		
		
	}
	
	@PostMapping(value="/updatePassword")
	public String updatePassword(@RequestParam("userId") String userId,
            @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword") String newPassword ,Model m) {
		
	Customer customer=repo.findByEmail(userId);
	if(customer==null) {
		m.addAttribute("error", "Student not found ");
		return "updationForm.jsp";
	}
	if(newPassword.equals(customer.getPassword())) {
		m.addAttribute("error", "OldPassword and new password is same Choose anyther one ");
//		System.out.println("user id ;"+userId);
		return "updationForm.jsp";
	}
	customer.setPassword(newPassword);
	customer.setConfirm_password(newPassword);
	repo.save(customer);
	m.addAttribute("error", "Successfully updated ");
		return "updationForm.jsp";
	}
	
	
	@PostMapping(value="/updateProfile")
	public String getupdateProfile(@RequestParam("userId") String userId,@RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("dateOfBirth")
	        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateOfBirth,Date dateOfBirth1,
            @RequestParam("gender") String gender,
            @RequestParam("nationality") String nationality,
            @RequestParam("profilePicture") String profilePicture,
            @RequestParam("phoneNumber") String phoneNumber ,Model m ) {
		System.out.println(userId);
		
		Customer customer = repo.findByEmail(userId);
		if(customer ==null) {
			m.addAttribute("msg", "Student is unavailable in databse ");
			return "updationForm.jsp";
		}
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setDateOfBirth(dateOfBirth1);
		customer.setGender(gender);
		customer.setNationality(nationality);
		customer.setProfilePicture(profilePicture);
		customer.setPhoneNumber(phoneNumber);
		
		repo.save(customer);
		m.addAttribute("msg", "Successfully updated ");
		
		return "updationForm.jsp";
		
	}
	

	@PostMapping(value="/addquestion")
	public String addQuestion(Question data1,Model m1) {
		qRepo.save(data1);
//		m1.addAttribute("data1", qRepo.findAll());
		return "Admin.jsp";
		
	}
	
	
	
	
	
	
	
	
	@PostMapping(value="/login")
	public String login(@RequestParam String email,@RequestParam String password,Model m) {
		Customer customer=repo.findByEmail(email);
		
		
		String admin="admin@gmail.com";
		String adminpass="pass";
		if(customer != null && customer.getPassword().equals(password)) {
			m.addAttribute("data", repo.findAll());
			
			m.addAttribute("stuid", customer.getEmail());
			return "success.jsp";
		}else if(email.equals(admin) && password.equals(adminpass)) {
			return "Admin.jsp";
		}
		
		m.addAttribute("errorMsg","Incorrect email or Password");
		return "login.jsp";
		
		
	}
	
	@PostMapping(value="/save")
	@ResponseBody
	public void  getUserResponse(@RequestParam("questionId") Long questionId,@RequestParam("option") String selectedOption, Model m) {
		System.out.println("Question ID: " + questionId);
        System.out.println("Selected Option: " + selectedOption);
        
        Question question = qRepo.findById(questionId).orElse(null);
        Customer customer = repo.findById(1).orElse(null);
//        long score = customer.getScore_Card();
        String correctOption = question.getCorrectAnswer();
        if(correctOption.equals(selectedOption)) {
        	System.out.println("Correct");
  
        	 long newScore = customer.getScore_Card() + 1;
             customer.setScore_Card(newScore);
        	repo.save(customer);
//        	 m.addAttribute("message", "Response saved successfully!");
        }else {
        	System.out.println("Wrong answer");
        	 m.addAttribute("message", "Response not saved");
        }
       
        
//    return "Exam.jsp";
        
	}
	
	
	
}
