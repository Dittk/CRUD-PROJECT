<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>출력 결과 페이지</title>
</head>
<body>
	<h3>회원가입 완료 !</h3>
	ID : ${member.id} <br> 
	비밀번호 : ${member.passwd} <br> 
	이름 : ${member.name} <br> 
	E-mail : ${member.mail} <br><br>
	<%@ include file="home.jsp" %> 
</body>
</html>