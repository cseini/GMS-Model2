<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
 String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="ㄴUTF-8" />
	<title>회원목록</title>
	<link rel="stylesheet" href="../../css/style.css" />
</head>
<body>
	<form action="<%=ctx %>/index.jsp"><input type="submit" value="초기화면"/></form>
	<h2>회원명단</h2>
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>팀명</th>
			<th>직책</th>
			<th>주민등록번호</th>
			<th>나이</th>
			<th>성별</th>
		</tr>
	</table>
</body>
</html>
