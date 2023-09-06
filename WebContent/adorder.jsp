<%@page import="Model_BEAN.ProcessedBEAN"%>
<%@page import="Model_BEAN.AdWaitOrderBEAN"%>
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
		<%
			ArrayList<AdWaitOrderBEAN> ListOfAdOrders = (ArrayList<AdWaitOrderBEAN>)request.getAttribute("ListOfAdOrders");
			ArrayList<ProcessedBEAN> ListOfProcesseds = (ArrayList<ProcessedBEAN>)request.getAttribute("ListOfProcesseds");
			String status = (String)request.getAttribute("status");
		%>
	  <%@ include file="layout/admin/header.jsp" %>
	  <%@ include file="layout/admin/sidebar.jsp" %>
<%-- 	  <%@ include file="layout/admin/footer.jsp" %> --%>
		  <main id="main" class="main">
		  	<div class="pagetitle">
		      <h1>Quản lý hóa đơn</h1>
		    </div><!-- End Page Title -->
		    <nav class="header-nav ms-auto">
		      <ul class="d-flex align-items-center" style="gap:20px;margin-bottom: 20px;">
		
		        <li class="nav-item">
					<a href="AdOrderController">Tất cả</a>
		        </li>
		        <li class="nav-item">
					<a href="AdOrderController?status=wait">Chờ xác nhận</a>
		        </li>
		        <li class="nav-item">
					<a href="AdOrderController?status=done">Đã hoàn thành</a>
		        </li>
				<li class="nav-item">
					<a href="AdOrderController?status=cancel">Đã hủy</a>
		        </li>
		      </ul>
		    </nav><!-- End Icons Navigation -->

		<section class="section">
	      <div class="row">
		    	<div class="card">
		            <div class="card-body">	
		              <!-- Default Table -->
		              <table class="table">
		              <%
	                	int i = 0;
	                	if(ListOfAdOrders != null){
		              %>
		                <thead>
		                  <tr>
		                    <th scope="col">#</th>
		                    <th scope="col">OrderID</th>
		                    <th scope="col">Customer name</th>
		                    <th scope="col">Order time</th>
		                    <th scope="col">Status</th>
		                    <th scope="col"></th>
		                    <th scope="col"></th>
		                  </tr>
		                </thead>
		                <tbody>
		                <%
		                	for(AdWaitOrderBEAN order : ListOfAdOrders){i++;
		                %>
		                  <tr>
		                    <th scope="row"><%=i %></th>
		                    <td><%=order.getOrderID() %></td>
		                    <td><%=order.getCustomerName() %></td>
		                    <td><%=order.getOrderTime() %></td>
		                    <td><%=order.getStatus() %></td>
		                    <td>
		                    	<%if(order.getStatus().toLowerCase().equals("wait")){ %>
		                    		<form action="AdAcceptController" method="post">
		                    			<input type="hidden" name="orderID" value="<%=order.getOrderID()%>">
		                    			<input type="hidden" name="status" value="<%=(status != null)?status : ""%>">
		                    			<button class="btn btn-success"><i class="bi bi-check-square"></i></button>
		                    		</form>
		                    		<form action="AdCancelController" method="post" style="margin-top:10px">
		                    			<input type="hidden" name="orderID" value="<%=order.getOrderID()%>">
		                    			<input type="hidden" name="status" value="<%=(status != null)?status : ""%>">
		                    			<button class="btn btn-danger"><i class="bi bi-x-circle"></i></button>
		                    		</form>
		                    	<%} %>
		                    </td>
		                    <td><a href="AdOrderDetailController?orderID=<%=order.getOrderID() %>">Xem chi tiết</a></td>
		                  </tr>
		                   </tbody>
		                  <%}}else if(ListOfProcesseds != null){ %>
		                  		<thead>
				                  <tr>
				                    <th scope="col">#</th>
				                    <th scope="col">OrderID</th>
				                    <th scope="col">Customer name</th>
				                    <th scope="col">Order time</th>
				                    <th scope="col">Employee name</th>
				                    <th scope="col">Status</th>
				                    <th scope="col"></th>
				                  </tr>
				                </thead>
				                <tbody>
		                  		<%
		                	  		for(ProcessedBEAN processed : ListOfProcesseds){i++;
		                	  	%>
			                	  <tr>
				                    <th scope="row"><%=i %></th>
				                    <td><%=processed.getOrderID() %></td>
				                    <td><%=processed.getCustomerName() %></td>
				                    <td><%=processed.getOrderTime() %></td>
				                    <td><%=processed.getEmployeeName() %></td>
				                    <td><%=processed.getStatus() %></td>
				                    <td><a href="AdOrderDetailController?orderID=<%=processed.getOrderID() %>">Xem chi tiết</a></td>
				                  </tr>
		                	  <%}} %>
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