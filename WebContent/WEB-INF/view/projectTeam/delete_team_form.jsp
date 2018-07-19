<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String ctx = request.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>틸 삭제</title>
</head>
<body>
	<form action="<%=ctx %>/projectTeam.do">
	팀 아이디<input type="text" name="team_id"/>
	팀 이름<input type="text" name="team_name"/>
	<input type="hidden" name="action" value="delete" />
	<input type="hidden" name="page" value="delete_team_result" />
	<input type="submit" value="삭제"/>
	</form>
</body>
</html>