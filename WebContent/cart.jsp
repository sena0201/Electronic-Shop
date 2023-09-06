<%@page import="Model_BEAN.NowCartBEAN"%>
<%@page import="java.util.ArrayList"%>
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
		ArrayList<NowCartBEAN> ListOfCarts = (ArrayList<NowCartBEAN>)request.getAttribute("ListOfCarts");
	%>
	<div class="app">
		<%@ include file="layout/header.jsp" %>
		
		<div class="main">
            <div class="cart__title">
                <h1>Giỏ hàng</h1>
            </div>
            <form action="PayController" class="cart__body" method="post">
                <div class="cart__body-title">
                    <div>
                        <input type="checkbox" id="select-all" onchange="toggleAll(this)">
                        <label for="all-product">Chọn tất cả sản phẩm</label>
                    </div>
                    <span>Đơn giá</span>
                    <span>Số lượng</span>
                    <span>Thành tiền</span>
                    <span style="flex:0;"><i class='bx bx-trash'></i></span>
                </div>
				<%if(ListOfCarts.size() == 0){ %>
					<div style="display: flex;flex-direction: column;align-items: center;gap: 20px;">
	                	<img alt="" src="public/img/cart.png">
	                	<a href="ShopController" class="buy-btn" style="text-decoration: none;">Shopping now</a>
	                </div>
	             <%} %>   
                <%for(NowCartBEAN cart : ListOfCarts){ %>
                	<div class="cart__body-container">
	                    <div class="cart__product-details">
	                        <input type="checkbox" name="checked<%=cart.getProductID()%>" value="<%=cart.getProductID()%>">
	                        <img src="<%=cart.getProductPhoto() %>" alt="product-img" class="cart__product-img">
	                        <span><%=cart.getProductName() %></span>
	                    </div>
	                    <span>
	                    	<%=cart.getUnitPrice() %>
	                    	<input type="hidden" class="unit-price" name="unitPrice<%=cart.getProductID()%>" value="<%=cart.getUnitPrice()%>">
	                    </span>
	                    <div style="width: fit-content;flex:1">
	                    	<div class="product__details-quantity" >
	                    		<span class="decrease">-</span>
		                    	<input class="input-value" type="text" name="quantity<%=cart.getProductID()%>" value="<%=cart.getQuantity()%>">
		                    	<span class="increase">+</span>
	                    	</div>
	                    </div>
	                    <span>
	                    	<p class="salePrice"><%=cart.getSalePrice() %></p>
	                    	<input type="hidden" class="sale-price" name="salePrice<%=cart.getProductID()%>" value="<%=cart.getSalePrice()%>">
	                    </span>
	                    <span style="flex:0;"><a style="color:#000;" href="DeleteController?cartID=<%=cart.getCartID()%>&productID=<%=cart.getProductID()%>"><i class='bx bx-trash'></i></a></span>
	                </div>
                <%} %>
                <%if(ListOfCarts.size() > 0){ %>
	                <div align="right">
	                	<button class="buy-btn">Mua hàng</button>
	                </div>
                <%} %>
            </form>
        </div>
	</div>
	<script src="public/js/main.js"></script>
</body>
</html>