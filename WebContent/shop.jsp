<%@page import="Model_BEAN.SearchBEAN"%>
<%@page import="Model_BEAN.CategoryBEAN"%>
<%@page import="Model_BEAN.ProductBEAN"%>
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
	%>

	<%
		ArrayList<ProductBEAN> ListOfProducts = (ArrayList<ProductBEAN>)request.getAttribute("ListOfProducts");
		ArrayList<CategoryBEAN> ListOfCategories = (ArrayList<CategoryBEAN>)request.getAttribute("ListOfCategories");
		ArrayList<SearchBEAN> SearchProducts = (ArrayList<SearchBEAN>)request.getAttribute("SearchProducts");
		int endPage = (int)request.getAttribute("endP");
		String nowPage = (String)request.getAttribute("page");
		String categoryID = (String)request.getAttribute("categoryID");
		String searchValue = (String)request.getAttribute("searchValue");
		String filter = (String)request.getAttribute("filter");
	%>
	<div class="app">
		<%@ include file="layout/header.jsp" %>
		
		<div class="main">
			<div class="shop">
	            <div class="sidebar">
	                <ul class="sidebar-list">
	                	<%
	                		for(CategoryBEAN category : ListOfCategories){
	                	%>
	                    	<li><a href="ShopController?categoryID=<%=category.getCategoryID()%>"><%=category.getCategoryName() %></a></li>
	                    <%} %>
	                </ul>
	            </div>
	
	            <div class="shop__container">
	                <div class="shop__header">
	                    <div class="filter">
	                        <form action="">
	                            <div>
	                                <input type="radio" name="filter" value="all" <%=(filter == null || filter.equals("all"))? "checked": "" %>>
	                                <label for="">Tất cả</label>
	                            </div>
	                            <div>
	                                <input type="radio" name="filter" value="ascending" <%=(filter != null && filter.equals("ascending"))? "checked": "" %>>
	                                <label for="">Thấp đến cao</label>
	                            </div>
	                            <div>
	                                <input type="radio" name="filter" value="decrease" <%=(filter != null && filter.equals("decrease"))? "checked": "" %>>
	                                <label for="">Cao đến thấp</label>
	                            </div>
	                            <button type="submit" name="" class="filter-btn">Lọc</button>
	                        </form>
	                    </div>
	                    <div class="shop__search">
	                        <form action="">
	                            <input type="text" name="searchValue" class="search-input" value="<%=(searchValue != null) ? searchValue : ""%>">
	                            <button type="submit" class="search-btn"><i class='bx bx-search'></i></button>
	                        </form>
	                    </div>
	                </div>
	                <div class="shop__list">
	                    <div class="home__product-list">
	                    	<%
	                    		if(searchValue != null){ 
	                    		for(SearchBEAN product : SearchProducts){
	                    	%>
	                    		<div class="home__product-items">
			                    	<div class="home__product-image">
			                            <img src="<%=product.getPhoto() %>" alt="">
			                        </div>
			                        <div class="home__product-details">
			                            <p class="home__product-name"><%=product.getProductName() %></p>
			                            <p class="home__product-price"><%=product.getUnitPrice() %></p>
			                            <a class="home__product-btn" href="ProductController?productid=<%=product.getProductID()%>">Xem chi tiết</a>
			                     	</div>
			                     </div>
	                    	<%}} else{
	                    		for(ProductBEAN product : ListOfProducts){
	                    	%>
	                    		<div class="home__product-items">
			                    	<div class="home__product-image">
			                            <img src="<%=product.getPhoto() %>" alt="">
			                        </div>
			                        <div class="home__product-details">
			                            <p class="home__product-name"><%=product.getProductName() %></p>
			                            <p class="home__product-price"><%=product.getUnitPrice() %></p>
			                            <a class="home__product-btn" href="ProductController?productid=<%=product.getProductID()%>">Xem chi tiết</a>
			                     	</div>
			                     </div>
	                        	<%} %>
	                        <%} %>
	                    </div>
	                </div>
	                <div class="page">
	                	<div class="main-page">
	                		<%if(nowPage != null && Integer.parseInt(nowPage) > 1){ %>
		                		<a href="ShopController?page=<%=Integer.parseInt(nowPage)-1%>">Previous</a>
		                	<%} %>
		                	<%for(int i = 1; i<=endPage;i++){ %>
		                		<a href="ShopController?<%=(categoryID == null)?"": "categoryID="+categoryID+"&"%><%=(filter == null)?"":"filter="+filter+"&"%>page=<%=i%>"><%=i %></a>
		                	<%} %>
		                	<%if((nowPage != null && Integer.parseInt(nowPage) != endPage && Integer.parseInt(nowPage) > 1) || nowPage == null){ %>
			                	<a href="ShopController?page=<%=(nowPage == null) ? 2 : Integer.parseInt(nowPage)+1%>">Next</a>	                		
		                	<%} %>
	                	</div>
	                </div>
	            </div>
	        </div>
		</div>
	</div>
	<script src="public/js/main.js"></script>
</body>
</html>