	<%@page import="Model_BEAN.EmployeeBEAN"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%
    	EmployeeBEAN user = (EmployeeBEAN)session.getAttribute("user");
    %>
	
	  <!-- ======= Header ======= -->
	  <header id="header" class="header fixed-top d-flex align-items-center">
	
	    <div class="d-flex align-items-center justify-content-between">
	      <a href="AdminController" class="logo d-flex align-items-center">
	        <img src="assets/img/logo.png" alt="">
	        <span class="d-none d-lg-block">MKShop</span>
	      </a>
	      <i class="bi bi-list toggle-sidebar-btn"></i>
	    </div><!-- End Logo -->
	    <nav class="header-nav ms-auto">
	      <ul class="d-flex align-items-center">
	
	        <li class="nav-item dropdown pe-3">
	
	          <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
	            <img src="<%=user.getPhoto() %>" alt="Profile" class="rounded-circle">
	            <span class="d-none d-md-block dropdown-toggle ps-2"><%=user.getEmployeeName() %></span>
	          </a><!-- End Profile Iamge Icon -->
	
	          <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
	            <li class="dropdown-header">
	              <h6><%=user.getEmployeeName() %></h6>
	              <span><%=user.getRole() %></span>
	            </li>
	            <li>
	              <a class="dropdown-item d-flex align-items-center" href="users-profile.html">
	                <i class="bi bi-person"></i>
	                <span>My Profile</span>
	              </a>
	            </li>
	            <li>
	              <a class="dropdown-item d-flex align-items-center" href="users-profile.html">
	                <i class="bi bi-gear"></i>
	                <span>Account Settings</span>
	              </a>
	            </li>
	            <li>
	              <a class="dropdown-item d-flex align-items-center" href="LogoutController">
	                <i class="bi bi-box-arrow-right"></i>
	                <span>Sign Out</span>
	              </a>
	            </li>
	
	          </ul><!-- End Profile Dropdown Items -->
	        </li><!-- End Profile Nav -->
	
	      </ul>
	    </nav><!-- End Icons Navigation -->
	
	  </header><!-- End Header -->