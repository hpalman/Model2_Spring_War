<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.*, com.model2.spring.vo.*" %>

<%
	String strPath = (String) request.getAttribute("path");
	Vo_People vo_People = (Vo_People) request.getAttribute("vo_people");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select</title>
</head>
<body>

<h1> ■모델2, Spring boot - jdbc/list_id.jsp</h1>
<a href='/index_jt.html'>● Home</a>
<p>
