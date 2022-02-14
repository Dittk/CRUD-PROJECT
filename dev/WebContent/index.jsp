<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>초기화면</title>
</head>
<body>
<a href="memberInsert.jsp">회원 정보 생성</a> <br><br>
<a href="memberSearch.jsp">회원 정보 검색</a> <br><br>
<a href="memberUpdate.jsp">회원 정보 수정</a> <br><br>
<a href="memberDelete.jsp">회원 정보 삭제</a> <br><br>
<a href="memberList.do">모든 회원 정보 보기</a> <br><br>
<a href="memberLogin.jsp">로그인</a> <br>

<% String id = (String)request.getAttribute("id");
	if(id != null){ %>
		${id}님 환영합니다. 
		<form action="memberLogout.do" method="post">
		<input type="submit" value="로그아웃"/>
		</form>
	<% } %>
	


</body>
</html>