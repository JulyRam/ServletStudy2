<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>Index Page</h1>
	
	<h3>Member</h3>
	
	<p>
		<a href = "/ServletStudy2/member/memberLogin.do?id=t1&pw=pw1">로그인</a><br>
		<a href = "./member/memberJoin.do">회원가입</a><br>
		<a href = "member/memberPage.do">마이페이지</a>
	</p>
	
	<h3>Bankbook</h3>
	
	<p>
		<a href = "/ServletStudy2/bankbook/bankbookList.do">상품목록</a><br>
		<a href = "./bankbook/bankbookInsert.do">상품등록</a><br>
		<a href = "bankbook/bankbookSelect.do?bookNumber=5">상품상세조회</a>
	</p>
</body>
</html>