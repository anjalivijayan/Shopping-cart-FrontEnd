<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Sign In </h2>
	
	<form:form modelAttribute="user" >
							<form:input path="id" pattern=".{4,7}" title="id should contains 4 to 7 characters" 
								placeholder="ID" />
							
								<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('id')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach><br />
							<form:input path="name"  placeholder="Name" 
								 />
								 
								 <c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('name')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach><br />
							
							<form:input path="password"  pattern=".{4,15}" title="password should contains 4 to 15 characters"
								placeholder="Password"
								 />
							
							<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('password')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach><br />
							
							<form:input type="tel"  path="contact" pattern="^\d{10}$" title="Please enter valid mobile number"
								placeholder="Mobile" 
								 />
								 
								 <c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('mobile')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach><br />
					
					
							<form:input type="mail"  path="mail" placeholder="Email" />
							
							<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('mail')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach><br />
							
							<form:input path="address" placeholder="Address" />
							
							<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('address')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach><br />
							
							
							<button name="_eventId_submit" type="submit" class="btn btn-default">Register</button>
						</form:form>
					</div>
					<!--/sign up form-->
				</div>
			</div>
		</div>


</body>
</html>