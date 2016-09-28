<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="#">Home</a></li>
				  <li class="active">Check out</li>
				</ol>
			</div><!--/breadcrums-->

		
			<div class="review-payment">
				<h2>Review & Payment</h2>
			</div>

			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Item</td>
							<td class="description"></td>
							<td class="price">Price</td>
							<td class="quantity">Quantity</td>
							<td class="total">Total</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cartList}" var="cart">
						<tr>
							<td class="cart_product">
								<a href=""><img src="<c:url value = 'D:\\shoppingcart\\images\\id${cart.product.id}.jpg"' />" alt=""></a>
							</td>
							<td class="cart_description">
								<h4><a href="">${cart.product.name}</a></h4>
							
							</td>
							<td class="cart_price">
								<p>Rs.${cart.price}</p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<a class="cart_quantity_up" href=""> + </a>
									<input class="cart_quantity_input" type="text" name="quantity" value="1" autocomplete="off" size="2">
									<a class="cart_quantity_down" href=""> - </a>
								</div>
							</td>
							<td class="cart_total">
								<p class="cart_total_price">Rs.${cart.price}</p>
							</td>
							<td class="cart_delete">
								<a class="cart_quantity_delete" href="cart/remove/${cart.id}"><i class="fa fa-times"></i></a>
							</td>
						</tr>
						</c:forEach>
						
						<tr>
							<td colspan="4">&nbsp;</td>
							<td colspan="2">
								<table class="table table-condensed total-result">
									<tr>
										<td>Cart Sub Total</td>
										<td>Rs.${totalAmount}</td>
									</tr>
								
									<tr class="shipping-cost">
										<td>Shipping Cost</td>
										<td>Free</td>										
									</tr>
									<tr>
										<td>Total</td>
										<td><span>Rs.${totalAmount}</span></td>
									</tr>
									
								</table>
								<a class="btn btn-default check_out" href="checkOut">Confirm Purchase</a>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			</div>
			
	
	</section> <!--/#cart_items-->


</body>
</html>