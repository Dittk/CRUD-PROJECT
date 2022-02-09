<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>출력 결과 페이지</title>
</head>
<body>
	<h3>회원가입 완료</h3>
	${member.id} / ${member.passwd} / ${member.name} / ${member.mail} <br>
	<%@ include file="home.jsp" %> 
</body>
</html>