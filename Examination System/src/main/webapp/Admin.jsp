<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

#ques{
width:600px;
height:30px;


}



</style>
</head>
<body>


    <h1>Admin Interface - Add Questions</h1>
    <form action="addquestion" method="POST">
        <label for="question">Question:</label><br>
       <input type="text" id="ques"name="questionDetail"  required><br><br>
 
        <label for="optionA">Option A:</label><br>
        <input type="text" id="optionA" name="optionA" required><br><br>

        <label for="optionB">Option B:</label><br>
        <input type="text" id="optionB" name="optionB" required><br><br>

        <label for="optionC">Option C:</label><br>
        <input type="text" id="optionC" name="optionC" required><br><br>

        <label for="optionD">Option D:</label><br>
        <input type="text" id="optionD" name="optionD" required><br><br>

        <label for="correctAnswer">Correct Answer:</label><br>
        <select id="correctAnswer" name="correctAnswer" required>
            <option value="A">Option A</option>
            <option value="B">Option B</option>
            <option value="C">Option C</option>
            <option value="D">Option D</option>
        </select><br><br>

        <input type="submit" value="Add Question">
    </form>
</body>
</html>


