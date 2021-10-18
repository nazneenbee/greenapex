<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
   int n, result=1;
   int num,i;
   int fact(int n) {
      for(i=1;i<=n; i++)
      {
    	  result=result*i;
      }      return result;
   }
%>
<%    
    num = Integer.parseInt(request.getParameter("num"));      
    result = fact(num);
%>
<b>Factorial value: </b> <%= result %>
</body>
</html>