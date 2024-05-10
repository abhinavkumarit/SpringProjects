<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FunCalc: Result</title>
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

  /* Style for heading */
  h2 {
    font-size: 2rem;
    font-weight: bold;
    color: #333;
    text-align: center;
    padding: 20px;
    background-color: rgba(255, 255, 255, 0.8);
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
    max-width: 400px;
    width: 100%;
  }
</style>
</head>
<body>
  <h2>Answer: ${result}</h2>
</body>
</html>
