<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Form</title>
</head>
<body>
 <h3>Welcome, Enter the Employee Details</h3>
 <form:form method="POST" action="addUser" modelAttribute="user">
  <table>
     <tr>
        <td><form:label path="firstname">First Name:</form:label></td>
        <td><form:input path="firstname"></form:input></td>
     </tr>
     <tr>
        <td><form:label path="lastname">Last Name:</form:label></td>
        <td><form:input path="lastname"></form:input></td>
     </tr>
     <tr>
       <td><form:label path="id">Employee ID:</form:label></td>
       <td><form:input path="id"></form:input></td>
     </tr>
     <tr>
        <td><form:label path="email">Email:</form:label></td>
        <td><form:input path="email"></form:input></td>
     </tr>
   <tr> <td><input type = "submit" value = "submit" /></td></tr>
   </table>   
        
 </form:form>
</body>
</html>