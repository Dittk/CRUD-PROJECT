<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.dev.vo.MemberVO" %>
<html>
<head>
<title>수정</title>
</head>
<body>
	${error}
<form action="memberSearch.do" method="post">
	ID : <input type="text" name="id" />
	<input type="hidden" name="job" value="update" />
	<input type="submit" value="검색" /><br><br>
	<input type="button" value="홈" onclick="location.href='index.jsp'">
</form>

<% MemberVO member = (MemberVO)request.getAttribute("member");
	if(member != null){
%>
	<form action="memberUpdate.do" method="post">
	ID : <input type="text" name="id" value="${id}" readonly } /> <br>
	비밀번호 : <input type="password" name="passwd" /> <br>
	이름 : <input type="text" name="name" /> <br>
	메일 : <input type="text" name="mail" /> <br>
	<input type="submit" value="업데이트" />
	<input type="button" value="홈" onclick="location.href='index.jsp'"/>
	</form>
	<%} %>
		
	
</body>
</html>