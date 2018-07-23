<%@page import="domain.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
 String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원 id 검색 결과</title>
	<link rel="stylesheet" href="../../css/style.css" />
</head>
<body>
	<h2>회원 id 검색 결과</h2>
	<table class="search_id_result">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>팀명</th>
			<th>직책</th>
			<th>주민등록번호</th>
		</tr>
		<tr>
			<%MemberBean m = (MemberBean)request.getAttribute("retrieve"); %>
			<td><%= m.getUserId()%></td>
			<td><%= m.getPassword()%></td>
			<td><%= m.getName()%></td>
			<td><%= m.getTeamId()%></td>
			<td><%= m.getRoll()%></td>
			<td><%= m.getSsn()%></td>
		</tr>
	</table>
	<form action="<%=ctx %>/index.jsp">
	<input type="submit" value="초기화면" />
	</form>
</body>
</html>