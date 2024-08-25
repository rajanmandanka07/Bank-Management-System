<!DOCTYPE html>
<html>
<head>
  <title>Bank Application</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
    }

    h1 {
      text-align: center;
      margin-top: 50px;
    }

    .container {
      display: flex;
      flex-direction: column;
      align-items: center;
      margin-top: 50px;
    }

    button {
      padding: 10px 20px;
      font-size: 18px;
      background-color: #007bff;
      color: #fff;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      transition: all 0.3s ease;
    }

    button:hover {
      background-color: #0062cc;
    }

    .btn-container {
      display: flex;
      justify-content: space-between;
      width: 400px;
      margin-top: 30px;
    }

    .btn-container button {
      width: 180px;
    }
  </style>
</head>
<body>
    <%String r=String.valueOf(request.getAttribute("acc_no"));
        session.setAttribute("acc_no", r);
    %>
    <h1>Insufficient balance in account!</h1>
  <div class="container">
    <div class="btn-container">
      <button onclick="location.href='index.html'">Logout</button>
      <button onclick="location.href='newjsp.jsp'">Options</button>
    </div>
  </div>
</body>
</html>