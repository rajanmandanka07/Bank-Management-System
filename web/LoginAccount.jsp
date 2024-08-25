<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login to Bank Account</title>
	<style>
                h1 {
                        text-align: center;
                        margin-top: 50px;
                }
		form {
			max-width: 500px;
			margin: 0 auto;
			padding: 20px;
			border: 1px solid #ccc;
			border-radius: 5px;
			background-color: #f2f2f2;
		}
		input[type=text], input[type=password] {
			width: 100%;
			padding: 12px 20px;
			margin: 8px 0;
			display: inline-block;
			border: 1px solid #ccc;
			border-radius: 4px;
			box-sizing: border-box;
		}
		input[type=submit] {
			background-color: #4CAF50;
			color: white;
			padding: 14px 20px;
			margin: 8px 0;
			border: none;
			border-radius: 4px;
			cursor: pointer;
			width: 100%;
		}
		input[type=submit]:hover {
			background-color: #45a049;
		}
	</style>
</head>
<body>
	<h1>Login to Bank Account</h1>
	<form action="NewServlet1" method="post">
		<label for="acc_no">Account Number:</label>
		<input type="text" name="acc_no" required><br>
		<label for="password">Password:</label>
		<input type="password" name="password" required><br>
		<input type="submit" value="Login">
	</form>
</body>
</html>
