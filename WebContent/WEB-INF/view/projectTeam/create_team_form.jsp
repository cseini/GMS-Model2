<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>팀 생성</title>
</head>
<body>
	<form action="<%=ctx %>/projectTeam.do">
	팀 아이디	<input type="text" name="team_id" /><br />
	팀 이름 <input type="text" name="team_name" /><br />
	<input type="hidden" name="action" value="create"/>
	<input type="hidden" name="page" value="create_team_result"/>
	<input type="submit" value="팀생성" />
	</form>
</body>
</html>