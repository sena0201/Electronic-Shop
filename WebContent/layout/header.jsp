<%@page import="Model_BEAN.CustomerBEAN"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	CustomerBEAN user = (CustomerBEAN)session.getAttribute("user");
	int count = (int)session.getAttribute("count");
%>
<header class="header">
            <div class="logo">MK</div>
            <nav class="navbar">
                <ul class="nav-list">
                    <li><a href="HomeController">Home</a></li>
                    <li><a href="ShopController">Shop</a></li>
                    <li><a href="PurchaseController">Purchased</a></li>
                </ul>
            </nav>
            <div class="header__right">
                <div class="cart">
                	<a href="CartController"><i class='bx bx-cart'></i></a>
                	<%if(user != null && count != 0){ %>
                		<div class="cart__quantity"><%=count %></div>
                	<%} %>	
                </div>
                <%if(user == null){ %>
					<a href="LoginController" class="header__login">Login</a>
                <%} else {%>
	                <div class="header__right-text">Hello <%=user.getCustomerName() %></div>
	                <div class="user">
	                	<i class='bx bx-user-circle'></i>
	                	<ul class="user__list">
	                		<li><a href="#">Tài khoản</a></li>
	                		<li><a href="LogoutController">Đăng xuất</a></li>
	                	</ul>
	                </div>
	            <%} %>
                <div class="menu-icon"><i class='bx bx-menu'></i></div>
            </div>
        </header>