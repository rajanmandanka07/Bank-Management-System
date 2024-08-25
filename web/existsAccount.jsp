<%-- 
    Document   : existsAccount
    Created on : 15-Apr-2023, 1:09:27 pm
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exists Account</title>
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
        <h1>Account already exists.</h1>
  <div class="container">
    <div class="btn-container">
      <button onclick="location.href='index.html'">Home</button>
      <button onclick="location.href='CreatAccount.jsp'">Create Account</button>
    </div>
  </div>
    </body>
</html>
