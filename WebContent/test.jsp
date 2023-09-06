<%@page import="Model_BO.OrderDetailBO"%>
<%@page import="Model_BO.OrderBO"%>
<%@page import="Model_BEAN.CustomerBEAN"%>
<%@page import="java.util.Enumeration"%>
<%@page import="Model_BEAN.CategoryBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model_BO.CategoryBO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		CustomerBEAN user = (CustomerBEAN)session.getAttribute("user");
		OrderBO orderBO = new OrderBO();
		OrderDetailBO orderDetailBO = new OrderDetailBO();
		
		
		if(user != null){
			long millis = System.currentTimeMillis();
			java.sql.Date orderTime = new java.sql.Date(millis);
			
// 			long orderID = orderBO.CreateOrder(user.getCustomerID(), orderTime, "", "WAIT");
			
			Enumeration<String> d= request.getParameterNames();
			while(d.hasMoreElements()){
				String ms = d.nextElement();
// 				out.print(ms + "<br>");
				String gt = request.getParameter(ms);
				String quantity = request.getParameter("quantity"+gt);
				String salePrice = request.getParameter("salePrice"+gt);
				if(ms.equals("checked"+gt)){
					out.print(gt + "<br>");	
				}
				if(gt != null && gt.length() > 0 && quantity != null && salePrice != null){
// 					out.print(quantity + "<br>");
// 					out.print(salePrice + "<br>");
// 					int check = orderDetailBO.AddOrderDetail(orderID, Long.parseLong(gt), Long.parseLong(quantity), Long.parseLong(salePrice));
					
				}
			}
		}
		
	%>
</body>
</html>