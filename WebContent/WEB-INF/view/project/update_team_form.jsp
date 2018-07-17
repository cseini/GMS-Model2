<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>팀명 변경</title>
</head>
<body>
	<form action="update_team_result.jsp">
	팀 아이디 <input type="text" name="teamid"/><br />
	기존 팀 명 <input type="text" name="old_teamname"/><br />
	변경할 팀 명 <input type="text" name="new_teamname"/><br />
	<input type="submit" value="변경" />
	</form>
</body>
</html>