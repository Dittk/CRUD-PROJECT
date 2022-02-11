<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.dev.vo.MemberVO" %>
<html>
<head>
<title>검색결과</title>
</head>
<body>
	
	<% ArrayList<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("list");
	   if(!list.isEmpty()){ %>
		 <table border="1">
			<tr><th>ID</th><th>비밀번호</th><th>이름</th><th>이메일</th></tr>
			
			<%	for(int i=0;i<list.size();i++){ //리스트 사이즈 (행 크기)
					MemberVO member = list.get(i);	%> 
				
					<tr>
						<td><%=member.getId() %></td>
						<td><%=member.getPasswd() %></td>
						<td><%=member.getName() %></td>
						<td><%=member.getMail() %></td>
					</tr>
			<%}
	}else{
	 System.out.println("등록된 회원 정보가 없습니다."); 
	 }%>
	 </table>
<%@ include file="home.jsp" %> 
</body>
</html>