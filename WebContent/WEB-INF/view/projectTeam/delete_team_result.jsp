<%@page import="service.ProjectTeamServiceImpl"%>
<%@page import="domain.ProjectTeamBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>팀 삭제 결과</title>
</head>
<body>
	<%
	ProjectTeamBean team = new ProjectTeamBean();
	team.setTeamId(request.getParameter("team_id"));
	team.setTeamName(request.getParameter("team_name"));
	ProjectTeamServiceImpl.getInstance().removeProjectTeam(team);
	%>
	<h3><%=team.getTeamName() %>팀삭제</h3>
	<form action="../../main.jsp">
	<input type="submit" value="초기화면" />
	</form>
</body>
</html>