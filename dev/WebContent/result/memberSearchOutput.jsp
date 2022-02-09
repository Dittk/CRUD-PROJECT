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
		%>
		<h3>검색 결과 : </h3>
		${member.id} / ${member.passwd} / ${member.name} / ${member.mail} <br>
		<%} %>
		<%@ include file="home.jsp" %>
</body>
</html>