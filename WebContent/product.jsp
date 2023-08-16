<%@page import="Model_BEAN.ProductBEAN"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<title>My Shop</title>
	<link rel="stylesheet" href="public/css/main.css">
    <link rel="stylesheet" href="public/css/responsive.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
	<%
		String warning = (String)request.getAttribute("warning");
		if(warning != null){
			out.print("<script>alert('"+ warning +"')</script>");
		}
	%>
	<%
		ProductBEAN product = (ProductBEAN)request.getAttribute("product");
	%>
	<div class="app">
		<%@ include file="layout/header.jsp" %>
		
		<div class="product__container">
			<form action="AddtocartController" class="product" method="post">
				<input type="hidden" name="productID" value="<%=product.getProductID()%>">
	            <div class="product__img">
	                <img src="<%=product.getPhoto() %>" alt="">
	                <input type="hidden">
	            </div>
	            <div style="display: flex;align-items: center;flex:5">
	            	<div class="product__details">
		                <div class="product__details-name">
		                    <%=product.getProductName() %>
		                    <input type="hidden">
		                </div>
		                <div class="product__details-price">
		                    <%=product.getUnitPrice() %>đ
		                    <input type="hidden" name="unitPrice" value="<%=product.getUnitPrice() %>">
		                </div>
		                <div class="product__details-quantity">
		                    <p class="btn-decrease">-</p>
		                    <input type="text" class="input-value" name="quantity" min="1" value="1">
		                    <p class="btn-increase">+</p>
		                </div>
		                <button class="addtocart-btn">
		                    <i class='bx bx-cart-add'></i>
		                    <p class="addtocart-text">Add to cart</p>
		                </button>
		            </div>
	            </div>
        	</form>
		</div>
	</div>
	<script type="text/javascript" src="public/js/main.js"></script>
</body>
</html>