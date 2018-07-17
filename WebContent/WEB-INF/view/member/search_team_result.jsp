<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
 String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>팀이름 검색 결과</title>
	<link rel="stylesheet" href="../../css/style.css" />
</head>
<body>
	<h3>팀이름 검색 결과</h3>
	<table class="search_team_result">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>팀명</th>
			<th>직책</th>
			<th>주민등록번호</th>
		</tr>
	</table>
	<form action="<%=ctx %>/index.jsp">
		<input type="submit" value="초기화면" />
	</form>
</body>
</html>