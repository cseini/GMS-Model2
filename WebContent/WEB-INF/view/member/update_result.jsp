<%@page import="domain.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
 String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>비밀번호 변경 결과</title>
</head>
<body>
	<% MemberBean m = (MemberBean)request.getAttribute("update"); %>
	<h3> 변경 정보 : <%= m.toString() %></h3>
	<form action="<%=ctx %>/index.jsp"><input type="submit" value="초기화면"/> </form>
</body>
</html>