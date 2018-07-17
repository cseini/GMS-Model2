<%@page import="service.ProjectTeamServiceImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.ProjectTeamBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>팀 목록</title>
	<link rel="stylesheet" href="../../css/style.css" />
</head>
<body>
	<h3>팀 목록</h3>
	<table class ="team_list">
		<tr>
			<th>팀 아이디</th>
			<th>팀 이름</th>
		</tr>
		
	<%
		List<ProjectTeamBean> lst = ProjectTeamServiceImpl.getInstance().listProjectTeam();
		for(ProjectTeamBean e : lst){
		%>
			<tr>
			<td><%= e.getTeamId()%></td>
			<td><%= e.getTeamName()%></td>
			</tr>
		<%
		}
	%>
	</table>
</body>
</html>