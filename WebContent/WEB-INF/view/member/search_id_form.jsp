<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원 id 검색</title>
	<link rel="stylesheet" href="${context }/resources/css/style.css" />
</head>
<body>
	<h2>아이디 검색</h2>
	<form action="${context }/member.do" onsubmit="return sendForm()" method="get">
		<input type="text" name="userid"/>
		<input type="hidden" name="action" value="retrieve" />
		<input type="hidden" name="page" value="search_id_result" />
		<input type="submit" value="검색"/>
	</form>
<script>
function sendForm(){
	alert('alert search id에서 sendform 성공!! ${context}');
	return true;
}
</script>
</body>
</html>