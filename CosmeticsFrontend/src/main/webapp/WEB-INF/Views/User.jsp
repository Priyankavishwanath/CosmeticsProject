<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
      <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
       <%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="header.jsp" %>

<style> 
div
{
margin:50px 200px 50px 600px ;
}
body
{
background:url("${img}/background/23.jpg");
background-size: 1100px 700px;
}
</style>
</head>

<body>
<div>
<c:url value="/adduser" var="user"/>
<form:form action="${user}" method="post" commandName="user">
<fieldset>
<legend> User Form</legend>
UserId:<form:input type ="text" Id="userId" path="userId"/><br>
<br>
UserName:<form:input type="text" Name="name" path="userName"/><br>
<br>
UserAdress:<form:input type="text" Address="adress" path="userAdress"/><br>
<br>
UserEmailid:<form:input type ="text" Emailid="emailid" path="userEmailid"/>
<br>
UserPhno:<form:input type ="text" Phno="phno" path="userPhno"/>
UserPassword:<form:input type="text" Phno="password" path="Password"/><br>
<br>
<input type="submit"
value="submit">
<input type="reset" value="cancel">
</fieldset>
</form:form>
</div>

<table>
<tr>
<th>userId</th>
<th>userName</th>
<th>userAdress</th>
<th>userEmailid</th>
<th>userPhno</th>
<th>password</th>
<th>Save</th>
</tr>
<c1:forEach items="${user}" var="user">
<tr>
<td>${User.getUserId()}</td>
<td>${User.getUserName()}</td>
<td>${User.getUserAdress()}</td>
<td>${User.getUserEmailid()}</td>
<td>${User.getUserPhno()}</td>
<td>${User.getPassword()}</td>
</tr>
</c1:forEach>
</table>


</body>


</html>
</body>
</html>