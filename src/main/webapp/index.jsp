<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link href="./css/test.css" rel="stylesheet">
</head>
<body>
	<h1>Index Page</h1>
	
	<h3 id="t1">Member</h3>
	
	<p id="t2"">
		<a href = "/ServletStudy2/member/memberLogin.do?id=t1&pw=pw1">로그인</a><br>
		<a href = "./member/memberJoin.do">회원가입</a><br>
		<a href = "member/memberPage.do">마이페이지</a>
	</p>
	
	<h3 id="t3 class="c2">Bankbook</h3>
	
	<p>
		<a href = "/ServletStudy2/bankbook/bankbookList.do">상품목록</a><br>
		<a href = "./bankbook/bankbookInsert.do">상품등록</a><br>
		<a href = "bankbook/bankbookSelect.do?bookNumber=5">상품상세조회</a>
	</p>
	<h2 class="c1 c2">Button</h2>
	<button class="c1">CLICK</button>
	
	<div id="circle">CIRCLE</div>
	
</body>
</html>