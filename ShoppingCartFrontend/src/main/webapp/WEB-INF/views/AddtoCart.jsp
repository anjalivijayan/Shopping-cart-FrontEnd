<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<div class="features_items">
					<!--features_items-->
					<h2 class="title text-center">Products</h2>
					
					 <c:forEach items="${category.product}" var="product">
					<div class="col-sm-4">
						<div class="product-image-wrapper">
							<div class="single-products">
								<div class="productinfo text-center">
								    <a href = "product/get/${product.id}">
									<img src="<c:url value = 'D:\Shoppingcart\images\id${product.id}.jpg"' />" alt="" />
									</a>
									<h2>Rs.${product.price}</h2>
									<p>${product.name}</p>
									<a href="<c:url value='/cart/add/${product.id}' />" class="btn btn-default add-to-cart"><i
										class="fa fa-shopping-cart"></i>Add to cart</a>
								</div>
								
							</div>
							
						</div>
					</div>
					</c:forEach>
					
					<br>
					<br>
					



</body>
</html>