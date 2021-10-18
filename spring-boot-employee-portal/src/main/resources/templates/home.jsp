<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="border: 1px solid #ccc; padding: 5px; margin-bottom: 20px;">

    <a href="/welcome">Home</a> |  

    <a href="/addNewEmployee">Add
        Employee</a> |   <a
        href="/getEmployees">Show
        Employees</a> |   
     <h2 style="color: red;">
            <a onclick="document.forms['logoutForm'].submit()">Logout</a>
            </h2>

    <form id="logoutForm" method="POST" action="/logout">
    </form>


</div>
</body>
</html>