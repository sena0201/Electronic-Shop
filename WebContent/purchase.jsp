<%@page import="Model_BEAN.PurchaseBEAN"%>
<%@page import="Model_BEAN.OrderDetailBEAN"%>
<%@page import="Model_BEAN.OrderBEAN"%>
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
		ArrayList<OrderBEAN> ListOfOrders = (ArrayList<OrderBEAN>)request.getAttribute("ListOfOrders");
		ArrayList<PurchaseBEAN> ListOfPurchaseds = (ArrayList<PurchaseBEAN>)request.getAttribute("ListOfPurchaseds");
		String status = (String)request.getAttribute("status");
	%>
	<div class="app">
		<%@ include file="layout/header.jsp" %>
		
		<div class="main">
			<div class="purchase__container">
                <nav class="purchase__nav">
                    <ul class="purchase__nav-list">
                        <li class="purchase__nav-item <%=(status == null)? "active":"" %>"><a href="PurchaseController">Tất cả</a></li>
                        <li class="purchase__nav-item <%=(status != null && status.toLowerCase().equals("wait"))? "active":"" %>"><a href="PurchaseController?status=wait">Chờ xác nhận</a></li>
                        <li class="purchase__nav-item <%=(status != null && status.toLowerCase().equals("done"))? "active":"" %>"><a href="PurchaseController?status=done">Hoàn thành</a></li>
                        <li class="purchase__nav-item <%=(status != null && status.toLowerCase().equals("cancel"))? "active":"" %>"><a href="PurchaseController?status=cancel">Đã hủy</a></li>
                    </ul>
                </nav>
                <div class="purchase__body">
                	<%for(OrderBEAN order : ListOfOrders){ %>
                    <div class="purchase__item">
                        <div class="purchase__item-id">
                            <h3>Mã hóa đơn: <%=order.getOrderID() %></h3>
                        </div>
                        <%
                        	for(PurchaseBEAN purchase : ListOfPurchaseds){ 
                        		if(order.getOrderID() == purchase.getOrderID()){
                        %>
	                        <div class="purchase__product">
	                            <div class="purchase__product-img">
	                                <img src="<%=purchase.getPhoto() %>" alt="">
	                            </div>
	                            <div class="purchase__product-detail">
	                                <p class="purchase__product-name"><%=purchase.getProductName() %></p>
	                                <div style="display: flex;justify-content: space-between;gap15px;">
	                                    <p>x<%=purchase.getQuantity() %></p>
	                                    <p><%=purchase.getSalePrice() %></p>
	                                </div>
	                            </div>
	                        </div>
                        	<%} %>
                        <%} %>
                    </div>
                    <%} %>
                </div>
            </div>
		</div>
	</div>

<script src="public/js/main.js"></script>
</body>
</html>