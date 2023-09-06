<%@page import="Model_BEAN.CategoryBEAN"%>
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
		ArrayList<CategoryBEAN> ListOfCategories = (ArrayList<CategoryBEAN>)request.getAttribute("ListOfCategories");
		String productName = (String)request.getAttribute("productName");
		String quantity = (String)request.getAttribute("quantity");
		String unitPrice =(String) request.getAttribute("unitPrice");
		String unit = (String)request.getAttribute("unit");
		String categoryID = (String)request.getAttribute("categoryID");
		String photo = (String)request.getAttribute("photo");
		String productID = (String)request.getAttribute("productID");
	%>
  <main style="width: 60%;margin:50px auto;">
    <section class="section">
      <div class="row">

          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Chỉnh sửa sản phẩm</h5>

              <!-- General Form Elements -->
              <form method="post" action="AdEditProductController" enctype= "multipart/form-data">
              <input type="hidden" name="productID" value="<%=(productID != null)?productID:""%>">
                <div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">Tên sản phẩm:</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" required name="productName" value="<%=(productName != null)?productName:""%>">
                  </div>
                </div>
                <div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">Số lượng:</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" required name="quantity" value="<%=(quantity != null)?quantity:""%>">
                  </div>
                </div>
                <div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">Đơn giá:</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" required name="unitPrice" value="<%=(unitPrice != null)?unitPrice:""%>">
                  </div>
                </div>
                <div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">Đơn vị:</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" required name="unit" value="<%=(unit != null)?unit:""%>">
                  </div>
                </div>
                <div class="row mb-3">
                  <label for="inputNumber" class="col-sm-2 col-form-label">Ảnh:</label>
                  <div class="col-sm-10">
                    <input class="form-control" required name="photo" type="file" id="fileInput">
                  	<img id="preview" alt="product-img" src="<%=photo%>" style="max-width: 300px;margin-top:10px;">
                  </div>
                </div>
                
                <div class="row mb-3">
                  <label class="col-sm-2 col-form-label">Loại hàng:</label>
                  <div class="col-sm-10">
                    <select class="form-select" name="categoryID">
                      <option selected value="0">Chọn</option>
                    	<%for(CategoryBEAN category : ListOfCategories){%>
                      		<option value="<%=category.getCategoryID()%>" <%=(categoryID != null && Long.parseLong(categoryID) == category.getCategoryID())?"selected":"" %>><%=category.getCategoryName() %></option>
                      	<%} %>
                    </select>
                  </div>
                </div>

                <div class="row mb-3">
                  <label class="col-sm-2 col-form-label"></label>
                  <div class="col-sm-10">
                  	<a href="AdProductController" class="btn btn-secondary">Quay lại</a>
                    <button type="submit" class="btn btn-warning">Sửa</button>
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