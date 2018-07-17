<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
 String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원가입 결과</title>
</head>
<body>
	<form action="<%=ctx %>/index.jsp">
		<input type="submit" value="초기화면" />
	</form>
</body>
</html>