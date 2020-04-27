<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>detailsProduct</title>
</head>
<body>
	<table align='center' border='1' cellspacing='0'>
		<tr>
			<td>id</td>
			<td>${productDetails.id}</td>
		</tr>
		<tr>
			<td>name</td>
			<td>${productDetails.name}</td>
		</tr>
		<tr>
			<td>price</td>
			<td>${productDetails.price}</td>
		</tr>
		<tr>
			<td><a href="listProduct?start=${start}">返回</a></td>
		</tr>
	</table>
</body>
</html>