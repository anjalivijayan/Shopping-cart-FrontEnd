 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!--  <meta charset="utf-8">-->
  	
        
<html>
<head>

<link href="<c:url value="/resources/css/Navheader.css"/>"
rel="stylesheet">

<link href="<c:url value="/resources/css/Loginstyle.css/" /> "
rel="stylesheet">


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  	<style>
  	.carousel-inner > .item > img,
  	.carousel-inner > .item > a > img {
        width: 70%;
        margin: auto;
	height:20em;
	</style>

</head>
<body>

<header>
	<div class="header-middle">
			<!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href=""><img
								src="resources/images/logo.jpg" alt="Bootsshop" /></a>
						</div>
					</div>
					
					
				
					<nav class="sidebar-menu slide-from-left">
					<div class="nano">
						<div class="content">
							<nav class="responsive-menu">
							<ul>
								<li><a href="Home">Home</a></li>
								<li class="menu-item-has-children"><a href="#">Category</a>
									<ul class="sub-menu">
										<li><a href="saree">Table</a></li>
										<li><a href="lehenga">Bed</a></li>
										<li><a href="gown">Chair</a></li>
										<li><a href="salwars">Lamp</a></li>
										

									</ul></li>
					
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							
										<div id = "myCart">
											<c:if test="${userClickedCartHere==true}">
											<%@ include file="Cart.jsp"%>	
    										</c:if>
    									</div> 
						</div>
					</div>
				</div>
			</div>
			
			
	 <table width="100%">
				<tr>
				
					<c:choose>
						<c:when test="${empty loggedInUser}">
							<td align="left">Existing user<a href="loginHere"> Login
									here</a></td>
							<td align="center">New user<a href="member.obj">
									Register here</a></td>
						</c:when>
						<c:when test="${not empty loggedInUser}">
							<td>Welcome ${loggedInUser},</td>
							
		<li><a href="myCart">myCart<i class="fa fa-shopping-cart"></i></a></li>
										<!--  Cart<span class="badge">${cartSize}</span></a></li> -->
										
							<td align="right"><a href="logout"> logout</a></td>
						</c:when>

					</c:choose>
				</tr>
				
				
				
				<tr>
					<c:if test="${loggedOut==true}">
						<td>${logoutMessage}</td>
					</c:if>
				</tr>
				</table>
				
			
					
						
				<div id="registerHere">
				<c:if test="${isUserClickedRegisterHere==true}">
				
					<%@ include file="/WEB-INF/views/Registration.jsp"%>
					
					
				</c:if>
			</div>
		
			<div id="loginHere">
				<c:if test="${isUserClickedLoginHere==true || invalidCredentials==true}">
				  <div id = "error">  ${errorMessage} </div>
					<%@ include file="/WEB-INF/views/Login.jsp"%>

				</c:if>
				</div>
				
				<div id="AdminHome">

				<c:if test="${isAdmin==true}">

					<%@ include file="/WEB-INF/views/AdminHome.jsp"%>
				
				</c:if>
				</div>
				<c:if test="${isUser==true}">
				<%@ include file="userhome.jsp"%>
					</c:if>
				<div id="categories">
					<c:if test="${isAdminClickedCategories==true}">
						<%@ include file="/WEB-INF/views/AdminHome.jsp"%>
						<%@ include file="/WEB-INF/views/Category.jsp"%>
					</c:if>
				</div>
				
				<div id="supplier">
					<c:if test="${isAdminClickedSuppliers==true}">
						<%@ include file="/WEB-INF/views/AdminHome.jsp"%>
						<%@ include file="/WEB-INF/views/Supplier.jsp"%>
					</c:if>
				</div>
				
				
				<div id="product">
					<c:if test="${isAdminClickedProducts==true}">
						<%@ include file="/WEB-INF/views/AdminHome.jsp"%>
						<%@ include file="/WEB-INF/views/Product.jsp"%>
					</c:if>
				</div>
				
				<!--<c:if test="${userClickedLoginHere==true}">
				<a href="Cart?uid="+${loggedInUser} >My cart<i class="fa fa-shopping-cart"></i></a></li> </c:if>-->
				
			
			
			<div id="Table">
		<c:if test="${isUserClickedTable==true }">
			<%@ include file="Table.jsp"%>
		</c:if>
		</div>
		
		<div id="Chair">
		<c:if test="${isUserClickedChair==true }">
			<%@ include file="Chair.jsp"%>
		</c:if>
		</div>
		
		<div id="Bed">
		<c:if test="${isUserClickedBed==true }">
			<%@ include file="Bed.jsp"%>
		</c:if>
		</div>
		
		
		<div id="Lamp">
		<c:if test="${isUserClickedLamp==true }">
			<%@ include file="Lamp.jsp"%>
		</c:if>
		</div>
		
		
		
		
			
		<c:if test="${userClickedCheckOut==true}">
	<%@ include file="checkout.jsp"%>
				
			</c:if>		
			</div>
				<div id="welcomemsg">
				<c:if test="${welcometrue==true}">
					${welcome}
					
				</c:if>
			</div>
				
			<div class="container">
  		<br>
  		<div id="myCarousel" class="carousel slide" data-ride="carousel">
    		<!-- Indicators -->
    		<ol class="carousel-indicators">
      		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      		<li data-target="#myCarousel" data-slide-to="1"></li>
      		<li data-target="#myCarousel" data-slide-to="2"></li>
      		<li data-target="#myCarousel" data-slide-to="3"></li>
    		</ol>

    		<!-- Wrapper for slides -->
    		<div class="carousel-inner" role="listbox">
      		<div class="item active">
        	<img src="<%=request.getContextPath()%>/resources/images/LampH.jpg" alt="image" style="width:100;height:100">
		</div>

      		<div class="item">
        	<img src="<%=request.getContextPath()%>/resources/images/decor1.jpg" alt="image" style="width:100;height:100">
      		</div>
    
      		<div class="item">
        	<img src="<%=request.getContextPath()%>/resources/images/decor2.jpg" alt="image" style="width:100;height:100">
      		</div>

      		<div class="item">
        	<img src="<%=request.getContextPath()%>/resources/images/decor3.jpg" alt="image" style="width:100;height:100">
      		</div>
    		</div>

    
    		<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      		<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      		<span class="sr-only">Previous</span>
    		</a>
    		<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      		<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      		<span class="sr-only">Next</span>
		</a>
  		</div>
		</div>
		<footer>

	<p>This is my shopping website for Home Decor</p><br><br><br><br><br>
<%@ include file="/WEB-INF/views/productlist.jsp"%>
	</footer>
				

</body>
</html>