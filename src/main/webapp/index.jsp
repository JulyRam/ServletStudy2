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
		<a href = "/ServletStudy2/member/memberLogin.do?id=t1&pw=pw1">�α���</a><br>
		<a href = "./member/memberJoin.do">ȸ������</a><br>
		<a href = "member/memberPage.do">����������</a>
	</p>
	
	<h3>Bankbook</h3>
	
	<p>
		<a href = "/ServletStudy2/bankbook/bankbookList.do">��ǰ���</a><br>
		<a href = "./bankbook/bankbookInsert.do">��ǰ���</a><br>
		<a href = "bankbook/bankbookSelect.do?bookNumber=5">��ǰ����ȸ</a>
	</p>
</body>
</html>