<%-- Document : deposit Created on : 13-Apr-2023, 2:31:01 pm Author : Asus --%>

  <%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>DEPOSIT PAGE</title>
      <style>
        /* Apply a CSS reset to normalize browser styles */
        * {
          box-sizing: border-box;
          margin: 0;
          padding: 0;
        }

        /* Style the body and form */
        body {
          font-family: Arial, sans-serif;
          background-color: #f7f7f7;
        }

        form {
          max-width: 500px;
          margin: 0 auto;
          padding: 1rem;
          background-color: #fff;
          border-radius: 5px;
          box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        /* Style the labels */
        label {
          display: block;
          margin-bottom: 0.5rem;
          color: #555;
        }

        /* Style the input fields */
        input[type="text"],
        input[type="number"] {
          display: block;
          width: 100%;
          padding: 0.5rem;
          font-size: 1.2rem;
          margin-bottom: 1rem;
          border-radius: 3px;
          border: 1px solid #ccc;
          background-color: #f7f7f7;
        }

        input[type="number"]::-webkit-outer-spin-button,
        input[type="number"]::-webkit-inner-spin-button {
          -webkit-appearance: none;
          margin: 0;
        }

        input[type="number"] {
          -moz-appearance: textfield;
        }

        /* Style the submit button */
        button[type="submit"] {
          display: block;
          margin: 1em auto;
          padding: 0.5em 1em;
          font-size: 1.2em;
          border: none;
          background-color: #4CAF50;
          color: #fff;
          border-radius: 0.3em;
          cursor: pointer;
        }

        /* Change the background color of the form when the mouse is over the submit button */
        button[type="submit"]:hover {
          background-color: #3e8e41;
        }
      </style>
    </head>

    <body>

      <% String r=String.valueOf(request.getAttribute("acc_no"));%>
        <form action="DepositAmount" method="post">
          <label for="acc_no">Account Number:</label>
          <input type="text" name="acc_no" value="<%=r%>" readonly><br>
          <label for="amount">Deposit Amount:</label>
          <input type="number" name="amount" id="deposit"><br>
          <button type="submit">Deposit</button>
        </form>
    </body>

    </html>