<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>검색 결과</title>
</head>
<body>
	<%
		String result = (String)request.getAttribute("result");
		if(result != null){
			out.println(result);
		}
		else{
		%><br><br>
		<h3>검색 결과 : </h3>
		ID : ${member.id} <br>
		비밀번호 : ${member.passwd} <br>
		이름 : ${member.name} <br>
		E-mail : ${member.mail} <br><br>
		<%} %>
		<%@ include file="home.jsp" %>
</body>
</html>