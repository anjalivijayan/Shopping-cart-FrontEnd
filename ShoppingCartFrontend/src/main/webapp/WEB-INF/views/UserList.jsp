<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center>

  <div style="color: teal; font-size: 30px">ShoppingCart | User
   Details</div>

  <c:if test="${!empty userList}"> 
   <table border="1" bgcolor="black" width="600px"> 
    <tr
     style="background-color: teal; color: white; text-align: center;"
     height="40px">
     
     <td>Name</td>
     
     <td>Mail</td>
     <td>Contact</td>
     <td>Address</td>
     <td>Edit</td>
     <td>Delete</td>
    </tr> 
    
    
    
    <c:forEach items="${userList}" var="userDetails">
     <tr
      style="background-color: white; color: black; text-align: center;"
      height="30px">
      
      <td><c:out value="${userDetails.name}" />
      </td>
      
      
      <td><c:out value="${userDetails.mail}" />
      </td>
      <td><c:out value="${userDetails.contact}" />
      </td>
      <td><c:out value="${userDetails.address}" />
      </td>
      <td><a href="edit?id=${userDetails.id}">Edit</a></td>
      <td><a href="delete?id=${userDetails.id}">Delete</a></td>
     </tr>
    </c:forEach>
   </table>
  </c:if>


  <a href="form">Click Here to add new User</a>
 </center>

</body>
</html> 
