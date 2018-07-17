<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
 String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원 id 검색</title>
</head>
<body>
	<h2>아이디 검색</h2>
<form action="<%=ctx %>/member.do">
	<input type="text" name="memid"/>
	<input type="hidden" name="action" value="move" />
	<input type="hidden" name="page" value="search_id_result" />
	<input type="submit" value="검색"/>
</form>
</body>
</html>