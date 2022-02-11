<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.dev.vo.MemberVO" %>
<html>
<head>
<title>삭제 </title>
</head>
<body>
	<h3>삭제 정보 검색</h3>
	${error}
	<form action="memberSearch.do" method="post">
	ID : <input type="text" name="id" />
	<input type="hidden" name="job" value="delete" />
	<input type="submit" value="검색"/>
	<input type="button" value="홈" onclick="location.href='index.jsp'"/>
	</form>
	
	<%
	MemberVO member = (MemberVO)request.getAttribute("member");
	if(member != null){
	%>
		<h3>검색 정보 결과</h3>
		${member.id} / ${member.passwd} / ${member.name} / ${member.mail} <br>
		<form action="memberDelete.do" method="post">
		<input type="hidden" name="id" value="${id}" />
		<input type="submit" value="삭제"/>
		</form>
	<%} %>
</body>
</html>