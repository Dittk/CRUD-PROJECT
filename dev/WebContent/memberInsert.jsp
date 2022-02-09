<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>생성</title>
</head>
<body>
<h3>회원가입</h3>

	${error}
	<form action="memberInsert.do" method="post">
		ID : <input type="text" name="id"><br>
		비밀번호 : <input type="password" name="passwd"><br>
		이름 : <input type="text" name="name"><br>
		E-mail : <input type="text" name="mail"><br>
		<input type="submit" value="가입">
		<input type="button" value="홈" onclick="location.href='index.jsp'">
	</form>
	
	
</body>
</html>