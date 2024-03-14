
 
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
       <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exam Page</title>
     <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
     <!-- Include Handlebars library from CDN -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
     
    <style>
       .button-container {
    position: fixed;
    top: 50%;
    right: 20px; /* Adjust this value as needed */
    transform: translateY(-50%);
    max-width: 200px; /* Adjust the maximum width of the container as needed */
    padding: 20px;
    border: 2px solid #ccc;
    border-radius: 10px;
    background-color: #f2f2f2;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    display: flex;
    flex-direction: row; /* Change flex-direction to row */
    flex-wrap: wrap; /* Allow items to wrap to the next line if needed */
    align-items: center;
}

.question-button {
    width: 50px; /* Adjust button width and margin as needed */
    height: 50px;
    margin: 5px;
    border: 1px solid #ccc;
    border-radius: 5px;
    text-align: center;
    line-height: 50px;
    cursor: pointer;
}
       
      #countdown {
            position: fixed;
            top: 4%;
            right: 20px;
      
           width:70px;
            font-size: 18px;
            color: #333; /* Change color as needed */
            font-family: Arial, sans-serif; /* Change font family as needed */
            border: 2px solid #000; /* Border style */
            padding: 10px; /* Padding to create space inside the border */
            background-color: #f0f0f0; /* Background color inside the div */
        }
       #submit {
        position: fixed;
            top: 4%;
            right: 120px;
        
        
      
        } 
         #button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #007bff; /* Button background color */
            color: #fff; /* Button text color */
            text-decoration: none; /* Remove underline */
            border: none; /* Remove border */
            border-radius: 5px; /* Rounded corners */
            cursor: pointer; /* Show pointer cursor on hover */
            transition: background-color 0.3s; /* Smooth transition */
        }

        /* Change button background color on hover */
        #button:hover {
            background-color: #0056b3; /* Darker shade of button color */
        }
        
        .container{
        width:600px;
        position:absolute;
        top:7%;
        left:15%;
        font-size: 25px;
        }
       
        
    </style>
</head>
<body>

<div id="fixednav">


<div id="submit">
      <a href="submitTest" id="button">Submit</a>
        </div>
     
<div id="countdown">00:30:00</div>
</div>

    <div class="button-container" id="buttonContainer">
         <!-- Buttons will be loaded here dynamically -->
    </div>


 <div id="questionContainer" class="container">  </div>
       <!--  Questions will be loaded here dynamically  -->
        
        
        
        
    <script>
    
    
   
        // Fetch question count and create buttons dynamically
        window.onload = function() {
            fetch('/questionCount')
            .then(response => response.json())
            .then(data => {
                const buttonContainer = document.getElementById('buttonContainer');
                for (let i = 1; i <= data.questionCount; i++) {
                    const button = document.createElement('div');
                    button.className = 'question-button';
                    button.innerText = i;
                    
                    (function(questionId) {
                        button.addEventListener('click', function() {
                            loadQuestion(questionId); // Fetch question when button is clicked
                        });
                    })(i);
                    buttonContainer.appendChild(button);
                }
                loadQuestion(1);
            })
            .catch(error => console.error('Error fetching question count:', error));
        };
        
        
        
        
        
        function loadQuestion(questionId) {
           
           
             $.ajax({
            	    type: 'GET',
            	    url: '/question/' + questionId,
            	    cache:false,
            	    dataType: 'json',
            	    success: function(data) {
            	    	 console.log('Received data:', data);
            	    	 
            	    	 var source = $("#question-template").html();
                         var template = Handlebars.compile(source);
                         var html = template(data);
                         $('#questionContainer').html(html);
            	      
            	    },
            	    error: function(xhr, status, error) {
            	        console.error('Error fetching question:', error);
            	    }
            	});
            
             
     
        	/*  $.ajax({
        	    type: 'GET',
        	    url: '/question/' + questionId,
        	    success: function(data) {
        	        console.log('Received data:', data); // Log the received data object
        	        // Your code to handle the received data goes here
        	        
        	        console.log('Question ID:', data.id);
        	        console.log('Question Detail:', data.questionDetail);
        	        console.log('Option A:', data.optionA);
        	    },
        	    error: function(xhr, status, error) {
        	        console.error('Error fetching question:', error);
        	    }
        	});  
 */
        }
        
        $(document).on('click', '.saveResponseBtn', function() {
            var questionId = $(this).data('question-id');
            var selectedOption = $('input[name=option]:checked').val();
            if (!selectedOption) {
                selectedOption = ''; // Send empty value if no option is selected
            }
            // Make an AJAX request to save the response to the database
            $.ajax({
                url: '/save',
                type: 'POST',
                data: {
                    questionId: questionId,
                    option: selectedOption
                },
                success: function (response) {
                    console.log('Response saved successfully:', response);
                    console.log("questionId :",questionId);
                    console.log("option :",selectedOption);
                },
                error: function (xhr, status, error) {
                    console.error('Error saving response:', error);
                }
            });
        });
    
   
    </script>
    <script id="question-template" type="text/x-handlebars-template">
    <div class="question">
        <h2>Question {{id}}:</h2>
        <p>{{questionDetail}}</p>
        <div class="options">
            <form class="responseForm" action="save" method="post">
                <input type="hidden" name="questionId" value="{{id}}" />
                <label>A<input type="radio" name="option" value="A"> {{optionA}}</label><br>
                <label>B<input type="radio" name="option" value="B"> {{optionB}}</label><br>
                <label>C<input type="radio" name="option" value="C">{{optionC}}</label><br>
                <label>D<input type="radio" name="option" value="D"> {{optionD}}</label><br>
            </form>
        </div>
        <button class="saveResponseBtn" data-question-id="{{id}}">Save Response</button>

    </div>
</script>





<script>
// Add your JavaScript logic here
// Example JavaScript functions for illustration
// Set the initial time in seconds
var totalTime = 1 * 60 * 60 + 30 * 60; // 1 hour 30 minutes
var countdownElement = document.getElementById('countdown');

/* function startCountdown() {
    var timer = setInterval(function() {
        var hours = Math.floor(totalTime / 3600);
        var minutes = Math.floor((totalTime % 3600) / 60);
        var seconds = totalTime % 60;

        // Pad with zeros if needed
        var formattedTime = hours.toString().padStart(2, '0') + ':' +
                            minutes.toString().padStart(2, '0') + ':' +
                            seconds.toString().padStart(2, '0');

        countdownElement.innerHTML = formattedTime;

        // If timer reaches 0, clear the interval
        if (totalTime <= 0) {
            clearInterval(timer);
            countdownElement.innerHTML = "00:00:00"; // Optionally, display a message when time is up
            // You can add additional logic here, like auto-submitting the exam
            submit();
        }

        totalTime--; // Decrement the total time
    }, 1000); // Update the timer every second
} */

function startCountdown() {
    var totalTime = 60; // Set total time to 60 seconds (1 minute)
    var timer = setInterval(function() {
        var minutes = Math.floor(totalTime / 60);
        var seconds = totalTime % 60;

        // Pad with zeros if needed
        var formattedTime = minutes.toString().padStart(2, '0') + ':' +
                            seconds.toString().padStart(2, '0');

        countdownElement.innerHTML = formattedTime;

        // If timer reaches 0, clear the interval
        if (totalTime <= 0) {
            clearInterval(timer);
            countdownElement.innerHTML = "00:00"; // Optionally, display a message when time is up
            // You can add additional logic here, like auto-submitting the exam
            document.getElementById('button').click();
        }

        totalTime--; // Decrement the total time
    }, 1000); // Update the timer every second
}


startCountdown(); // Start the countdown when the page loads





</script>
</body>
</html>
 
 
 
 
 
 