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
margin:50px 200px 50px 600px ;
}
body
{
background:url("${img}/background/back1.jpg") brown;
background-size: 1100px 600px;
}
</style>
</head>

<body>
<div>
<c:url value="/addproduct" var="product"/>
<form:form action="${product}" method="post" commandName="product" enctype="multipart/form-data">
<fieldset>
<legend> product Form</legend>
productId:<form:input type ="text" Id="productId" path="productId"/><br>
<br>
productName:<form:input type="text" Name="name" path="productName"/><br>
<br>
productPrice:<form:input type="text" Price="price" path="productPrice"/><br>
<br>
productQuantity:<form:input type ="text" Quantity="quantity" path="productQuantity"/><br>
<br>
productDescription:<form:input type="text" Description="description" path="productDescription"/><br>
<br>
productImage:<form:input type="file" Description="description" path="pimg"/><br>
<br>

<input type="submit"
value="submit">
<input type="reset" value="cancel">
</fieldset>
</form:form>
</div>

<table>
<tr>
<th>ProductImage</th>
<th>productId</th>
<th>productName</th>
<th>productPrice</th>
<th>productQuantity</th>
<th>productDescription</th>
<th>Edit/Delete</th>
</tr>
<c1:forEach items="${products}" var="product">
<tr>
<td><img src="${img}/${product.getProductId()}.jpg" width="150px" height="150px"></td>
<td>${product.getProductId()}</td>
<td>${product.getProductName()}</td>
<td>${product.getProductPrice()}</td>
<td>${product.getProductQuantity()}</td>
<td>${product.getProductDescription()}</td>
<td><a href="<c:url value="/editproduct/${product.getProductId()}"/>">Edit</a>/<a href="<c:url value="/deleteproduct/${product.getProductId()}"/>">Delete</a>
</tr>
</c1:forEach>
</table>


</body>


</html>