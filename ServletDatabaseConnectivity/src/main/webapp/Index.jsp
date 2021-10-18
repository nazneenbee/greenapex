<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert form Data</title>
</head>
<body>
<form action="ServletDatabaseConnectivity" method="post">
Student Id <input type="number" name="stid"><br>
Student Name <input type="text" name="stname"><br>
Course <input type="text" name="stcourse"><br>
Marks <input type="number" name="stmarks"><br>
<input type="submit" value="Insert Data">
</form>
</body>
</html>