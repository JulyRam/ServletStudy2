<%@page import="com.epic.s1.bankbook.BankbookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Bankbook Select Page</h1>
	
	
	
	<h3>num : %{dto.bookNumber}</h3>
	<h3>Name : ${requestScope.dto.bookName}</h3>
	<h3>count : ${requestScope.count}</h3>
	<h3>name : ${name}</h3>
	<h3>se : ${sessionScape.se}</h3>
	<h3>se : ${se}</h3>
</body>
</html>