<%-- 
    Document   : newjsp
    Created on : 15-Apr-2023, 11:03:06 pm
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <%
        String r=String.valueOf(session.getAttribute("acc_no")); 
        RequestDispatcher rd;
        request.setAttribute("acc_no",r);
        rd=request.getRequestDispatcher("AccountServlet");
        rd.forward(request, response);
        %>
    </body>
</html>
