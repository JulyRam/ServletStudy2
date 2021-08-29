<%@page import="com.epic.s1.bankbook.BankbookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here By JSTL</title>
<link href="../css/list.css" type="stylesheet">
</head>
<body>

	<h1>Bankbook List Page</h1>

	<table>
		<tr>
			<th>일련번호</th><th>제품명</th><th>이자율</th><th>Status</th>
		</tr>
		
		<c:forEach items="${list}" var="dto" varStatus="i">
		<tr>
			<td>${dto.bookNumber}</td>
			<td><a href="./bankbookSelect.do">${dto.bookName}</a></td>
			<td>${dto.bookRate}</td>
			<td>
				<p>현재 아이템 : ${i.current}</p>
				<p>인덱스 번호 : ${i.index}</p>
				<p>순서 번호 : ${i.count}</p>
				<p>처음 : ${i.first}</p>
				<p>마지막 : ${i.last}</p>
			</td>
		</tr>
		
		</c:forEach>
	
	</table>
	
	<div>
		<c:forEach begin="1" end="10" var="num">
		<button></button>
		</c:forEach>
	</div>
	
	<a href = "bankbookInsert.do">Write</a>
	
</body>
</html>