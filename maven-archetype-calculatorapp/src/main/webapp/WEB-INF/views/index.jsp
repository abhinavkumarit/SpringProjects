<!DOCTYPE html>
<html>

<head>
<title>FunCalc: The Kid-Friendly Calculator</title>
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

  /* Style for container */
  .container {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    align-items: center;
    padding: 20px;
    background-color: rgba(255, 255, 255, 0.8);
    border-radius: 10px;
    max-width: 800px;
    width: 100%;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
  }

  /* Style for links */
  .operation-link {
    text-decoration: none;
    color: #333;
    text-align: center;
    margin: 10px;
    flex-basis: 40%; /* Adjust as needed */
    max-width: 250px; /* Adjust as needed */
  }

  /* Style for images */
  .operation-img {
    width: 100%;
    height: auto;
    margin-bottom: 10px;
  }

  /* Style for heading */
  h1 {
    text-align: center;
    font-size: 3rem;
    font-weight: bold;
    color: #fff;
    text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
    margin-bottom: 20px;
  }
</style>
</head>
<body>
  <h1>Welcome to FunCalc</h1>

  <div class="container">
    <a href="open-view?view=findSum" class="operation-link">
      <img class="operation-img" src="https://static.thenounproject.com/png/65474-200.png" alt="Sum Icon">
      
    </a>

    <a href="open-view?view=findDiff" class="operation-link">
      <img class="operation-img" src="https://pngimg.com/d/minus_PNG41.png" alt="Difference Icon">
      
    </a>

    <a href="open-view?view=findProd" class="operation-link">
      <img class="operation-img" src="https://icons.veryicon.com/png/o/weather/2px-linear-icon/multiply-sign-error.png" alt="Product Icon">
      
    </a>

    <a href="open-view?view=findQuotient" class="operation-link">
      <img class="operation-img" src="https://cdn-icons-png.flaticon.com/512/1/1246.png" alt="Quotient Icon">
      
    </a>
  </div>
</body>
</html>
