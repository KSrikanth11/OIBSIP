<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



    <style>
        /* Add your CSS styles here */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f2f2f2;
        }
        .container {
            max-width: 600px;
            margin: 100px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .exam-box {
            padding: 20px;
            border: 2px solid #007bff;
            border-radius: 10px;
            text-align: center;
            background-color: #f8f9fa;
            transition: all 0.3s ease;
        }
        .exam-box:hover {
            transform: translateY(-5px);
            box-shadow: 0 5px 15px rgba(0, 123, 255, 0.2);
        }
        .exam-box a {
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
            font-size: 20px;
        }
        
        .logout{
        position:absolute;
        top:5%;
        right:5%;
        font-size: 20px;
        }
       
        h1{
        display:flex;
         justify-content: center;
        align-items: center;
        }
    </style>
</head>
<body>

<%-- <h1>${stuid}</h1> --%>
<h1>Exam DashBoard</h1>

<div class="logout">
 <a href="login.jsp" class="">
           
          Logout
        </a></div>
    <div class="container">
 
   
        <div class="exam-box">
            <a href="updationForm?userId=${stuid}">Update your Profile & Password</a>
        </div>
    </div>


    <div class="container">
   
        <div class="exam-box">
            <a href="exam">Start Exam</a>
        </div>
    </div>
</body>
</html>

