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
		CategoryBO categoryBO = new CategoryBO();
		ArrayList<CategoryBEAN> ListOfCategories = categoryBO.ListOfCategories();
		for(CategoryBEAN category : ListOfCategories){
			out.print(category.getCategoryName() + "<br>");
		}
	%>
</body>
</html>