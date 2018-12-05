<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
    <%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <c:url value="/resources/images" var="img"/>
    <c:url value="/resources/css" var="css"/>
      <c:url value="/resources/js" var="js"/>
      
<link rel="stylesheet" href="${css}/style.css">
<script src="${js}/script.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  
    <ul class="nav navbar-nav">
      <li class="active"><a href="<c:url value="/"/>">Home</a></li>
	<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Categories <span class="caret"></span></a>
        <ul class="dropdown-menu">
        <c1:forEach items="${categories}" var="cat">
          <li><a href="<c:url value="/Gallery"/>">${cat.getCatName()}</a></li>
         </c1:forEach>
        </ul>
      </li><c1:if test="${pageContext.request.userPrincipal.name!=null}">
	   <security:authorize access="hasRole('ROLE_ADMIN')">
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Admin <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="<c:url value="/Category"/>">Add category</a></li>
          <li><a href="<c:url value="/Supplier"/>">Add Supplier</a></li>
          <li><a href="<c:url value="/Product"/>">Add Product</a></li>
        </ul>
      </li>
      </security:authorize>
      </c1:if>
      <li><a href="#"></a></li>
    </ul>
      welcome ${pageContext.request.userPrincipal.name}
    <c1:if test="${pageContext.request.userPrincipal.name==null}">
    <ul class="nav navbar-nav navbar-right">
      <li><a href="<c:url value="/User"/>"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="<c:url value="/login"/>"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
    </c1:if>
    
    <c1:if test="${pageContext.request.userPrincipal.name!=null}">
    <ul class="nav navbar-nav navbar-right">
     <li><a href="<c:url value="/j_spring_security_logout"/>"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
    </c1:if>
  </div>
</nav>

<div class="container--head">
  <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <div class="carousel-tooltip">
      <div class="caraousel-tooltip-item active" data-index="0">
        <a href="#" class="tooltip-carousel" style="top:100px;left: 100px;padding:5px 10px;background:#f00;color:#fff;display:inline-block" data-container="body" data-toggle="popover" data-placement="bottom" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus.">
          <span class="fa fa-heart"></span>
        </a>
        <a href="#" class="tooltip-carousel" style="top:120px;left: 400px;padding:5px 10px;background:#000;color:#fff;display:inline-block" data-container="body" data-toggle="popover" data-placement="bottom" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus.">
          <span class="fa fa-star"></span>
        </a>
      </div>
      <div class="caraousel-tooltip-item" data-index="1">
        <a href="#" class="tooltip-carousel" style="top:120px;left: 300px;padding:5px 10px;background:#000;color:#fff;display:inline-block" data-container="body" data-toggle="popover" data-placement="top" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus.">
          <span class="fa fa-plus"></span>
        </a>
      </div>
      <div class="caraousel-tooltip-item" data-index="2">
        <a href="#" class="tooltip-carousel" style="top:100px;left: 500px;padding:5px 10px;background:#000;color:#fff;display:inline-block" data-container="body" data-toggle="popover" data-placement="bottom" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus.">
          <span class="fa fa-plus"></span>
        </a>
      </div>
      <div class="caraousel-tooltip-item" data-index="3">
        <a href="#" class="tooltip-carousel" style="top:20px;left: 300px;padding:5px 10px;background:#000;color:#fff;display:inline-block" data-container="body" data-toggle="popover" data-placement="right" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus.">
          <span class="fa fa-plus"></span>
        </a>
      </div>
      <div class="caraousel-tooltip-item" data-index="4">
        <a href="#" class="tooltip-carousel" style="top:180px;left: 200px;padding:5px 10px;background:#000;color:#fff;display:inline-block" data-container="body" data-toggle="popover" data-placement="bottom" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus.">
          <span class="fa fa-plus"></span>
        </a>
      </div>
    </div>

    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
      <li data-target="#carousel-example-generic" data-slide-to="1"></li>
      <li data-target="#carousel-example-generic" data-slide-to="2"></li>
      <li data-target="#carousel-example-generic" data-slide-to="3"></li>
      <li data-target="#carousel-example-generic" data-slide-to="4"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="${img}/background/15.jpg" alt="..." style="width:100%">
        <div class="carousel-caption">
          <h3>Lorem ipsum dolor</h3> Lorem ipsum dolor sit amet, tharsiam eam est in.
        </div>
      </div>
      <div class="item">
        <img src="${img}/background/12.jpg" alt="..." style="width:100%">
        <div class="carousel-caption">
          <h3>Lorem ipsum dolor</h3> Lorem ipsum dolor sit amet, tharsiam eam est in.
        </div>
      </div>
      <div class="item">
        <img src="${img}/background/19.jpg" alt="..." style="width:100%">
        <div class="carousel-caption">
          <h3>Lorem ipsum dolor</h3> Lorem ipsum dolor sit amet, tharsiam eam est in.
        </div>
      </div>
      <div class="item">
        <img src="${img}/background/18.jpg" alt="..." style="width:100%">
        <div class="carousel-caption">
          <h3>Lorem ipsum dolor</h3> Lorem ipsum dolor sit amet, tharsiam eam est in.
        </div>
      </div>
      <div class="item">
        <img src="${img}/background/17.jpg" alt="..." style="width:100%">
        <div class="carousel-caption">
          <h3>Lorem ipsum dolor</h3> Lorem ipsum dolor sit amet, tharsiam eam est in.
        </div>
      </div>
    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
    </a>
  </div>
</div>

