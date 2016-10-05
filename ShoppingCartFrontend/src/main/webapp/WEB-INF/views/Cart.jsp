<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Cart List</h3>
	<!--<c:if test="${!empty cartList}">
		<table class="tg"> -->
		<table>
		<tr>
			<th align="left" width="80">Cart ID</th> &nbsp;
			<th align="left" width="80">Total</th>  &nbsp;
			<th align="left" width="120">Product Name</th>  &nbsp;
			<th align="left" width="100">Quantity</th>  &nbsp;
			<th align="left" width="80">Price</th>  &nbsp;

			<th align="left" width="80">Status</th>  &nbsp;
			<th align="left" width="80">Product ID</th>  &nbsp;
			
		 	<!-- <th align="left" width="60">Delete</th> -->
			

		</tr>
		<c:forEach items="${cartList}" var="cart">
			<tr>
				
				
				<td align="left">${cart.id}</td> &nbsp;
				<th align="left">${cart.total}</th> &nbsp;
				<td align="left">${cart.product.name}</td> &nbsp;
				<td align="left">${cart.quantity}</td> &nbsp;
				<td align="left">${cart.price}</td> &nbsp;
				<th align="left">${cart.status}</th> &nbsp;
				<th align="left">${cart.product.id}</th> &nbsp;
				<td align="left"><a href="<c:url value='/cart/edit/${cart.id}' />">Edit</a></td> &nbsp; &nbsp;
				<td align="left"><a href="<c:url value='/cart/remove/${cart.id}'  />">Delete</a></td> 
				
			</tr>
		</c:forEach>
	</table>
	</c:if>

	
	
	<h4>Total cost : ${totalAmount}</h4>
					<%-- <a href="<c:url value='/pay/${cart.userID}'/>">Proceed</a>  --%>
					<a href="<c:url value='/pay/${cart.id}'/>">Checkout</a></br>
				
	
	<h5><B>Mode of Payment</B></h5>
	<form action="">
 	 <input type="radio" name="payment" value="cash"> cash on Delivery<br>
  	<input type="radio" name="payment" value="net"> Net Banking<br>
 	 
</form>


</body>
</html>