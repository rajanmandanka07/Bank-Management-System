<%-- 
    Document   : edit
    Created on : 12-May-2023, 11:14:01 am
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit</title>
          <style>
    /* Center the form on the page */
    form {
      margin: 0 auto;
      width: 50%;
    }

    /* Style the heading */
    h1 {
      text-align: center;
      font-size: 2em;
      margin-bottom: 1em;
    }

    /* Style the radio buttons */
    input[type="radio"] {
      margin: 0.5em;
      transform: scale(1.5);
      align-items: center;
    }

    /* Style the submit button */
    button[type="submit"] {
      display: block;
      margin: 1em auto;
      padding: 0.5em 1em;
      font-size: 1.2em;
      border: none;
      background-color: #4CAF50;
      color: white;
      border-radius: 0.3em;
      cursor: pointer;
    }

    /* Change the background color of the form when the mouse is over the submit button */
    button[type="submit"]:hover {
      background-color: #3e8e41;
    }

    div {
      margin: 1rem auto;
      padding-left: 25.7rem;
    }
  </style>
    </head>
    <body>
        <% String r=String.valueOf(request.getAttribute("acc_no"));%>
        <h1>Options</h1>
        <form action="editServlet">
        <div>
        <label>
        <input type="radio" name="transaction-type" value="name">
        Name
        </label>
        <br>
        <label>
        <input type="radio" name="transaction-type" value="password">
        Password
        </label>
        <br>
      </div>
      <button type="submit">Submit</button>
      <input name="acc_no" value=${acc_no} readonly style="display: none"><br>
    </form>
    </body>
</html>
