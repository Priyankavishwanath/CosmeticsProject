<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
    <%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:url value="/resources/images" var="img"/>
    <c:url value="/resources/css" var="css"/>
      <c:url value="/resources/js" var="js"/>
      
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>
div.gallery {
    margin: 5px;
    border: 1px solid #ccc;
    float: left;
    width: 180px;
}

div.gallery:hover {
    border: 1px solid #777;
}

div.gallery img {
    width: 100%;
    height: 200px;
}

div.desc {
    padding: 15px;
    text-align: center;
}
</style>
</head>
<body>
<c1:forEach items="${products}" var="pro">
<div class="gallery">
  <a target="_blank" href="fjords.jpg">
    <img src="${img}/${pro.getProductId()}.jpg" alt="Cinque Terre" width="300" height="200">
  </a>
  <div class="desc">${pro.getProductName()} ${pro.getProductPrice()}</div>
</div>

</c1:forEach>


</body>
</html>

</body>
</html>