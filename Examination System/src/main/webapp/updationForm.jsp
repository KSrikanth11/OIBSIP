<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        
      /*   .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
         */
        h1 {
            font-size: 24px;
            margin-bottom: 20px;
            text-align: center;
        }
        
        form {
            max-width: 300px;
            margin: 0 auto;
        }
        
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #007bff;
            color: #fff;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        
        .error {
            color: red;
            text-align: center;
            margin-bottom: 15px;
        }
    </style>
    <style>
   body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
}

.container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.form-container {
    background-color: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    max-width: 600px;
    width: 100%;
}

h1 {
    font-size: 24px;
    margin-bottom: 20px;
    text-align: center;
}

form {
    display: flex;
    flex-wrap: wrap;
}

.form-column {
    flex: 1;
    padding: 0 10px;
}

label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
}

input[type="text"],
input[type="date"],
input[type="file"],
select {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
}

input[type="submit"] {
    width: 100%;
    padding: 10px;
    border: none;
    border-radius: 5px;
    background-color: #007bff;
    color: #fff;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

input[type="submit"]:hover {
    background-color: #0056b3;
}

p {
    color: green;
    text-align: center;
    margin-bottom: 15px;
}
</style>
   
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        
        .form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin: 0 10px;
        }
        
        h1 {
            font-size: 24px;
            margin-bottom: 20px;
            text-align: center;
        }
        
        form {
            max-width: 300px;
            margin: 0 auto;
        }
        
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        
        input[type="text"],
        input[type="date"],
        input[type="file"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #007bff;
            color: #fff;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        
        .error {
            color: red;
            text-align: center;
            margin-bottom: 15px;
        }
        
        .success {
            color: green;
            text-align: center;
            margin-bottom: 15px;
        }
        
        
        
/*         back link css
 */       
  
        .container {
   
   
    position :relative;
    top:-300px;
    left:-250px;
}

.back-link {
    display: flex;
    align-items: center;
    text-decoration: none;
    color: #000;
}
        
    .arrow-left {
    width: 0;
    height: 0;
    border-top: 10px solid transparent;
    border-bottom: 10px solid transparent;
    border-right: 15px solid #000;
    margin-right: 10px;
}

span {
    font-size: 18px;
}
        
        
    </style>

</head>
<body>
<%-- <p>userId :${userId}</p> --%>

 <div class="container">
        <a href="success.jsp" class="back-link">
            <div class="arrow-left"></div>
            <span>Back</span>
        </a>
    </div>
<div class="form">
   <h1>Update Password</h1>
   
        <p>${error}</p>
   
    <form action="/updatePassword" method="post">
     <input type="hidden" name="userId" value="${param.userId}">
        <label for="oldPassword">Old Password:</label><br>
        <input type="password" id="oldPassword" name="oldPassword"><br>
        
        <label for="newPassword">New Password:</label><br>
        <input type="password" id="newPassword" name="newPassword"><br>
        
        <input type="submit" value="Submit">
    </form>
    
    
</div>



<div class="form">

 <h1>Update Profile</h1>
  <p>${msg}</p>
    <form action="/updateProfile" method="post">
     <input type="hidden" name="userId" value="${param.userId}">
        <label for="firstName">First Name:</label><br>
        <input type="text" id="firstName" name="firstName"><br>
        
        <label for="lastName">Last Name:</label><br>
        <input type="text" id="lastName" name="lastName"><br>
        
        <label for="dateOfBirth">Date of Birth:</label><br>
        <input type="date" id="dateOfBirth" name="dateOfBirth"><br>
        
        <label for="gender">Gender:</label><br>
        <select id="gender" name="gender">
            <option value="male">Male</option>
            <option value="female">Female</option>
            <option value="other">Other</option>
        </select><br>
        
        <label for="nationality">Nationality:</label><br>
        <input type="text" id="nationality" name="nationality"><br>
        
        <label for="profilePicture">Profile Picture:</label><br>
        <input type="file" id="profilePicture" name="profilePicture"><br>
        
        <label for="phoneNumber">Phone Number:</label><br>
        <input type="text" id="phoneNumber" name="phoneNumber"><br>
        
        <input type="submit" value="Update Profile">
    </form>








</div>

</body>
</html>