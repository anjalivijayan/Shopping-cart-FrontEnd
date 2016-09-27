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

	<div class="jumbotron">
	<section id="form">
		<!--form-->
	
		<div class="container">
		
	
			<div class="row">
				
							
				<div class="col-sm-4 col-sm-offset-4 panel panel-default">
			
					<div class="signup-form">
						<!--sign up form-->
						<div class="panel-heading">New User Signup!</div>
				
						<form:form modelAttribute="userDetails" method="post">
						
					  
						<form:input path="id" disabled="true" readonly="true" />
							
								<form:input path="name" disabled="true" readonly="true" />
							
							<form:input path="password" disabled="true" readonly="true" />
							
							<form:input path="contact" disabled="true" readonly="true" />
							
						    <form:input path="mail" disabled="true" readonly="true" />
						   
							<form:input path="address" disabled="true" readonly="true" />
							<div class="col-sm-4">
							<button name="_eventId_edit" type="submit" class="btn btn-default">Edit</button>
							</div>
							<div class="col-sm-5">
							<button name="_eventId_submit" type="submit" class="btn btn-default">Confirm Details</button>
								</div>
							<br/>
						</form:form>
					</div>
				
					<!--/sign up form-->
				</div>
			</div>
		</div>
	
	</section>
	<!--/form-->

</div>


</body>
</html>