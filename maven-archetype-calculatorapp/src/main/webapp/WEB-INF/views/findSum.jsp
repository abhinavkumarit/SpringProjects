<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FunCalc: Adding numbers</title>
<style>
  /* Body styles */
  body {
    background-image: url('https://cdn.pixabay.com/photo/2022/09/21/17/02/blue-background-7470781_640.jpg');
    background-size: cover;
    background-position: center;
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
  }

  /* Style for form */
  form {
    background-color: rgba(255, 255, 255, 0.8);
    border-radius: 10px;
    padding: 20px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
    max-width: 400px;
    width: 100%;
  }

  /* Style for input fields */
  input[type="number"] {
    width: calc(50% - 5px);
    margin-right: 10px;
    padding: 10px;
    border-radius: 5px;
    border: 1px solid #ccc;
    box-sizing: border-box;
    margin-bottom: 10px; /* Add margin between inputs */
  }

  input[type="submit"] {
    width: 100%;
    padding: 10px;
    border-radius: 5px;
    border: none;
    background-color: #007bff;
    color: #fff;
    cursor: pointer;
  }

  input[type="submit"]:hover {
    background-color: #0056b3;
  }

  /* Style for placeholders */
  input::placeholder {
    color: #888;
  }
</style>
</head>
<body>
<form action="sum">
  <input type="number" name="num1" placeholder="Enter the 1st no.">
  <input type="number" name="num2" placeholder="Enter the 2nd no.">
  <input type="submit" value="FindSum"/>
</form>
</body>
</html>
