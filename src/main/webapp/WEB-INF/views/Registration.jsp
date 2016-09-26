<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register User</title>
</head>
<body>

<h2>Please fill the details</h2>

	<form:form action="user/register" method="post" commandName="userDetails">
		<table>
			<tr>
				<td><form:label path="id">Id</form:label></td>

				<td><form:input path="id" pattern=".{4,7}" required="true"
						title="id should contains 4 to 7 characters" /></td>
			</tr>
			<tr>
				<td><form:label path="name">UserName</form:label></td>

				<td><form:input path="name" required="true"
						title="name should not be empty" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>

				<td><form:input path="password" pattern=".{4,15}"
						required="true"
						title="password should contains 4 to 15 characters" /></td>
			</tr>
			<tr>
				<td><form:label path="contact">Contact</form:label></td>

				<td><form:input type="tel" path="contact" pattern="^\d{10}$" required="true"
						title="Please enter valid mobile number" /></td>
			</tr>

			<tr>
				<td><form:label path="mail">Email</form:label></td>

				<td><form:input type="mail" path="mail" /></td>
			</tr>

			<tr>
				<td><form:label path="address">Address</form:label></td>

				<td><form:input path="address" required="true" /></td>
			</tr>

			<tr>

				<td><input type="submit"
					value="Register"/></td>
				<td><input type="reset" value="Reset"/>
				</td>
			</tr>

		</table>

	</form:form>

</body>
</html>