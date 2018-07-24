<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>팀이름 검색</title>
	<link rel="stylesheet" href="${context }/resources/css/style.css" />
</head>
<body>
	<form action="${context }/member.do" onsubmit="return sendForm()" method="get">
		팀 이름<input type="text" name="team_name"/>
		<input type="hidden" name="action" value="search" />
		<input type="hidden" name="page" value="search_team_result" />
		<input type="submit" value="검색" />
	</form>
<script>
function sendForm(){
	alert('alert 팀찾기에서 sendform 성공!! ${context}');
	return true;
}
</script>
</body>
</html>