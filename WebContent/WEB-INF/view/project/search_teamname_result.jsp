<%@page import="service.ProjectTeamServiceImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.ProjectTeamBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>팀이름 검색 결과</title>
	<link rel="stylesheet" href="../../css/style.css" />
</head>
<body>
	<h3>팀이름 검색 결과</h3>
	<table>
		<tr>
			<th>팀이름</th>
			<th>팀아이디</th>
		</tr>
	<%
		List<ProjectTeamBean> lst = ProjectTeamServiceImpl.getInstance().findProjectTeamByWord(request.getParameter("team_name"));
		for(ProjectTeamBean e : lst){
		%>
			<tr>
				<td><%=e.getTeamId() %></td>
				<td><%=e.getTeamName() %></td>
			</tr>
		<%
		}
	%>
	</table>
	<form action="../../main.jsp">
		<input type="submit" value="초기화면" />
	</form>
</body>
</html>