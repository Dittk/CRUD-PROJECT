<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>생성</title>
</head>
<body>
<h3>회원가입</h3>

	<form method="post">
		ID : <input type="text" name="id" value="${id}">
		<input type="submit" name="duplicate" value="중복확인" formaction="memberDuplicate.do">
		${duplicate}<br><br>
		비밀번호 : <input type="password" name="passwd"><br><br>
		이름 : <input type="text" name="name"><br><br>
		E-mail : <input type="text" name="mail"><br><br>
		<input type="submit" value="가입" formaction="memberInsert.do">
		<input type="button" value="홈" onclick="location.href='index.jsp'"><br><br>
		${error} ${duplicate_error}
	</form>
	
	
</body>
</html>