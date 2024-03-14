<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <style>
      body {
            display: flex;
            justify-content: center; /* Center horizontally */
            align-items: center; /* Center vertically */
            height: 100vh; /* Make the body full height of the viewport */
            margin: 0; /* Remove default margin */
            background-color: #f2f2f2; /* Optional: Set background color */
        }
        .result-box {
            border: 2px solid #ccc;
            border-radius: 5px;
            padding: 10px;
            margin-top: 20px;
        }
p{
 display: flex;
            justify-content: center; /* Center horizontally */
            align-items: center; /

}
        /* Style for the title */
        .result-title {
            font-weight: bold;
            margin-bottom: 10px;
        }
        
        a{
        position:absolute;
        top:65%;
        right:45%;
        
        }
    </style>
</head>
<body>

 <div class="result-box">
        <h2 class="result-title">Result :</h2>
       
            <!-- Your result content goes here -->
            <p>${result}</p>
       
    </div>
    
      <a href="returntodashboard" id="button"> Go to Dash Board </a>
</body>


</body>
</html>