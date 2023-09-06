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
	<div class="app">
		<%@ include file="layout/header.jsp" %>
		
		<div class="home" style="background: url(public/img/bg-image.png);background-repeat: no-repeat; background-position: center;background-size: cover;">
            <div class="home__card">
                <h2 class="home__card-title">Wellcome To My Shop</h2>
                <a href="ShopController" class="home__card-button">Shoping now <i class='bx bx-right-arrow-alt'></i></a>
            </div>
        </div>

        <div class="home__product">
            <h1 class="home__product-title">Hot Products</h1>
            <div class="home__product-list">
                <div class="home__product-items">
                    <div class="home__product-image">
                        <img src="public/img/image.png" alt="">
                    </div>
                    <div class="home__product-details">
                        <p class="home__product-name">Product Name</p>
                        <p class="home__product-price">10$</p>
                    </div>
                </div>
                <div class="home__product-items">
                    <div class="home__product-image">
                        <img src="public/img/image.png" alt="">
                    </div>
                    <div class="home__product-details">
                        <p class="home__product-name">Product Name</p>
                        <p class="home__product-price">10$</p>
                    </div>
                </div>
                <div class="home__product-items">
                    <div class="home__product-image">
                        <img src="public/img/image.png" alt="">
                    </div>
                    <div class="home__product-details">
                        <p class="home__product-name">Product Name</p>
                        <p class="home__product-price">10$</p>
                    </div>
                </div>
                <div class="home__product-items">
                    <div class="home__product-image">
                        <img src="public/img/image.png" alt="">
                    </div>
                    <div class="home__product-details">
                        <p class="home__product-name">Product Name</p>
                        <p class="home__product-price">10$</p>
                    </div>
                </div>
                <div class="home__product-items">
                    <div class="home__product-image">
                        <img src="public/img/image.png" alt="">
                    </div>
                    <div class="home__product-details">
                        <p class="home__product-name">Product Name</p>
                        <p class="home__product-price">10$</p>
                    </div>
                </div>
                <div class="home__product-items">
                    <div class="home__product-image">
                        <img src="public/img/image.png" alt="">
                    </div>
                    <div class="home__product-details">
                        <p class="home__product-name">Product Name</p>
                        <p class="home__product-price">10$</p>
                    </div>
                </div>
                <div class="home__product-items">
                    <div class="home__product-image">
                        <img src="public/img/image.png" alt="">
                    </div>
                    <div class="home__product-details">
                        <p class="home__product-name">Product Name</p>
                        <p class="home__product-price">10$</p>
                    </div>
                </div>
                <div class="home__product-items">
                    <div class="home__product-image">
                        <img src="public/img/image.png" alt="">
                    </div>
                    <div class="home__product-details">
                        <p class="home__product-name">Product Name</p>
                        <p class="home__product-price">10$</p>
                    </div>
                </div>
            </div>
        </div>
	</div>
	<script src="public/js/main.js"></script>
</body>
</html>