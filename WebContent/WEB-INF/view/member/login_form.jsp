<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>USER LOGIN</title>
	<link rel="stylesheet" href="${context}/resources/css/style.css" />
</head>
<body>
	<h1>로그인</h1>
	<form action="${context}/member.do" onsubmit="return sendForm()" method="get" >
		ID <input type="text" name="userid" /><br />
		PASS <input type="password" name="password" /><br />
		<input type="hidden" name="action" value="login" />
		<input type="hidden" name="page" value="main" />
		<input type="submit" value="전송"/>
	</form>
<script>
	function sendForm(){
	alert('alert 로그인폼에서 sendform 성공!! ${context}');
	return true;
}
</script>
</body>
</html>
