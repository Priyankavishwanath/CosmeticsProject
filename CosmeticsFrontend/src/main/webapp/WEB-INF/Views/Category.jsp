<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
      <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
       <%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
     <%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<style> 
div
{
margin:50px 200px 50px 600px ;
}
body
{
background:url("${img}/background/back1.jpg");
background-size: 1100px 700px;
}
</style>
</head>

<body>
<div>
<c:url value="/addcat" var="cat"/>
<form:form action="${cat}" method="post" commandName="category">
<fieldset>
<legend> Category Form</legend>
CatId:<form:input type ="text" Id="catid" path="catId"/><br>
<br>
Cat Name:<form:input type="text" Name="name" path="catName"/><br>
<br>
<input type="submit"
value="submit">
<input type="reset" value="cancel">
</fieldset>
</form:form>
</div>

<table>
<tr>
<th>CatId</th>
<th>CatName</th>
<th>Edit/Delete</th>
</tr>
<c1:forEach items="${categories}" var="cat">
<tr>
<td>${cat.getCatId()}</td>
<td>${cat.getCatName()}</td>
<td><a href="<c:url value="/edicat/${cat.getCatId()}"/>">Edit</a>/<a href="<c:url value="/deletecategory/${cat.getCatId()}"/>">Delete</a>
</tr>
</c1:forEach>
</table>


</body>


</html>