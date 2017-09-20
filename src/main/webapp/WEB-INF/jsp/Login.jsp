<%@ page isELIgnored ="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
 <body>
    <font color="red">${message}</font>
    
  <form:form id="loginForm" method = "POST" action="loginCheck" modelAttribute="loginBean">
 	 <label>Enter your user-name</label>
 	 <input type="text" name="username" /><br>
 	 <label>Enter your password</label>
 	 <input type="text" name="password" /><br>
 	 <input type="submit" value = "submit" />
  </form:form>
 </body>
</html>
