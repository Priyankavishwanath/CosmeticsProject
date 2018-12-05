<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
      <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
       <%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="header.jsp" %>

<style> 
div
{
margin:50px 20px 50px 780px ;
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
<c:url value="/addsupplier" var="supplier"/>
<form:form action="${supplier}" method="post" commandName="supplier">
<fieldset>
<legend> Supplier Form</legend>
supplierId:<form:input type ="text" Id="supplierId" path="supplierId"/><br>
<br>
Supplier
Name:<form:input type="text" Name="name" path="supplierName"/><br>
<br>
SupplierAdress:<form:input type="text" Address="adress" path="supplierAddress"/><br>
<br>
SupplierEmailid:<form:input type ="text" Emailid="emailid" path="supplierEmailid"/><br>
<br>
SupplierPhno:<form:input type="text" Phno="phno" path="supplierPhno"/><br>
<br>

<input type="submit"
value="submit">
<input type="reset" value="cancel">
</fieldset>
</form:form>
</div>

<table>
<tr>
<th>supplierId</th>
<th>supplierName</th>
<th>supplierAdress</th>
<th>supplierEmailid</th>
<th>supplierPhno</th>
<th>Edit/Delete</th>
</tr>
<c1:forEach items="${supplies}" var="supplier">
<tr>
<td>${supplier.getSupplierId()}</td>
<td>${supplier.getSupplierName()}</td>
<td>${supplier.getSupplierAddress()}</td>
<td>${supplier.getSupplierEmailid()}</td>
<td>${supplier.getSupplierPhno()}</td>
<td><a href="<c:url value="/editsupplier/${supplier.getSupplierId()}"/>">Edit</a>/<a href="<c:url value="/deletesupplier/${supplier.getSupplierId()}"/>">Delete</a>
</tr>
</c1:forEach>
</table>


</body>


</html>