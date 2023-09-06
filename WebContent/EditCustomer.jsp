<%@page import="Model_BEAN.CustomerBEAN"%>
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
		CustomerBEAN customer = (CustomerBEAN)request.getAttribute("customer");
	%>
  <main style="width: 60%;margin:50px auto;">
    <section class="section">
      <div class="row">

          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Chỉnh sửa khách hàng</h5>

              <!-- General Form Elements -->
              <form action="AdEditCustomerController" method="post">
              	<input type="hidden" name="customerID" value="<%=customer.getCustomerID()%>">
                <div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">Tên khách hàng:</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="customerName" value="<%=customer.getCustomerName() %>" required>
                  </div>
                </div>
                <div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">Address:</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="address" value="<%=(customer.getAddress() == null)?"":customer.getAddress() %>">
                  </div>
                </div>
                <div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">Phone number:</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="phoneNumber" value="<%=(customer.getPhoneNumber() == null)?"":customer.getPhoneNumber() %>">
                  </div>
                </div>
                <div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">User name:</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="userName" value="<%=customer.getUserName() %>" disabled>
                  </div>
                </div>
				<div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">Password:</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" name="password" value="<%=customer.getPassword() %>" required>
                  </div>
                </div>

                <div class="row mb-3">
                  <label class="col-sm-2 col-form-label"></label>
                  <div class="col-sm-10">
                  	<a href="AdCustomerController" class="btn btn-secondary">Quay lại</a>
                    <button type="submit" class="btn btn-warning">Chỉnh sửa</button>
                  </div>
                </div>

              </form><!-- End General Form Elements -->

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