<%@page import="Model_BEAN.CategoryBEAN"%>
<%@page import="Model_BEAN.ProductBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Dashboard</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="public/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="public/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="public/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="public/vendor/quill/quill.snow.css" rel="stylesheet">
  <link href="public/vendor/quill/quill.bubble.css" rel="stylesheet">
  <link href="public/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="public/vendor/simple-datatables/style.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="public/css/admin.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: NiceAdmin
  * Updated: Jul 27 2023 with Bootstrap v5.3.1
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>
<body>
			<%
				String warning = (String)request.getAttribute("warning");
				if(warning != null){
					out.print("<script>alert('"+ warning +"')</script>");
				}
			%>
	  <%@ include file="layout/admin/header.jsp" %>
	  <%@ include file="layout/admin/sidebar.jsp" %>
<%-- 	  <%@ include file="layout/admin/footer.jsp" %> --%>

  <main id="main" class="main">
  		<%
  			ArrayList<ProductBEAN> ListOfProducts = (ArrayList<ProductBEAN>)request.getAttribute("ListOfProducts");
  		%>
		    <div class="pagetitle">
		      <h1>Quản lý sản phẩm</h1>
		    </div><!-- End Page Title -->
		<section class="section">
	      <div class="row">
		    	<div class="card">
		            <div class="card-body">	
		            <div align="right" style="margin: 10px 0;">
		            	<a href="AddProductController" class="btn btn-success"><i class="bi bi-plus"></i>Thêm</a>
		            </div>
		              <!-- Default Table -->
		              <table class="table">
		                <thead>
		                  <tr>
		                    <th scope="col">#</th>
		                    <th scope="col">Photo</th>
		                    <th scope="col">Product name</th>
		                    <th scope="col">Quantity</th>
		                    <th scope="col">Unit price</th>
		                    <th scope="col"></th>
		                  </tr>
		                </thead>
		                <tbody>
		                <%
		                	int i = 0;
		                	for(ProductBEAN product : ListOfProducts){
		                		i++;
		                %>
		                  <tr>
		                    <th scope="row"><%=i %></th>
		                    <td><img alt="product-photo" src="<%=product.getPhoto()%>" style="max-width: 200px;"></td>
		                    <td><%=product.getProductName() %></td>
		                    <td><%=product.getQuantity() %></td>
		                    <td><%=product.getUnitPrice() %></td>
		                    <td style="display:flex;gap:10px;">
		                    	<form action="EditProductController" method="post">
		                    		<input type="hidden" name="productID" value="<%=product.getProductID()%>">
		                    		<input type="hidden" name="productName" value="<%=product.getProductName()%>">
		                    		<input type="hidden" name="quantity" value="<%=product.getQuantity()%>">
		                    		<input type="hidden" name="unitPrice" value="<%=product.getUnitPrice()%>">
		                    		<input type="hidden" name="unit" value="<%=product.getUnit()%>">
		                    		<input type="hidden" name="photo" value="<%=product.getPhoto()%>">
		                    		<input type="hidden" name="categoryID" value="<%=product.getCategoryID()%>">
		                    		<button class="btn btn-warning"><i class="bi bi-pencil-square"></i></button>
		                    	</form>
		                    	<form action="AdDeleteProductController" method="post">
		                    		<input type="hidden" name="productID" value="<%=product.getProductID()%>">
		                    		<button class="btn btn-danger"><i class="bi bi-pencil-square"></i></button>
		                    	</form>
		                    </td>
		                  </tr>
		                  <%} %>
		                </tbody>
		              </table>
		              <!-- End Default Table Example -->
		            </div>
		          </div>
				</div>
			</section>
			
	</main>
	
	  <!-- Vendor JS Files -->
	  <script src="public/vendor/apexcharts/apexcharts.min.js"></script>
	  <script src="public/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	  <script src="public/vendor/chart.js/chart.umd.js"></script>
	  <script src="public/vendor/echarts/echarts.min.js"></script>
	  <script src="public/vendor/quill/quill.min.js"></script>
	  <script src="public/vendor/simple-datatables/simple-datatables.js"></script>
	  <script src="public/vendor/tinymce/tinymce.min.js"></script>
	  <script src="public/vendor/php-email-form/validate.js"></script>
	
	  <!-- Template Main JS File -->
	  <script src="public/js/admin.js"></script>
</body>
</html>