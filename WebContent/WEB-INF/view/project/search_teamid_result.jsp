<%@page import="service.ProjectTeamServiceImpl"%>
<%@page import="domain.ProjectTeamBean"%>
<%@page import="service.*"%>
<%@page import="dao.MemberDaoImpl"%>
<%@page import="domain.MemberBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>팀 아이디 검색 결과</title>
	<link rel="stylesheet" href="../../css/style.css" />
</head>
<body>
	<h2>팀 아이디 검색 결과</h2>
	<table>
		<tr>
			<th>팀아이디</th>
			<th>팀이름</th>
		</tr>
	<%
		ProjectTeamBean team = ProjectTeamServiceImpl.getInstance().findProjectTeamBySeq(request.getParameter("teamid"));
		%>
		<tr>
			<td><%=team.getTeamId() %></td>
			<td><%=team.getTeamName() %></td>
		</tr>
		<%
	%>
	</table>
	<form action="../../main.jsp">
	<input type="submit" value="초기화면"/>
	</form>
</body>
</html>