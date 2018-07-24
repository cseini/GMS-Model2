<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원 탈퇴</title>
	<link rel="stylesheet" href="${context }/resources/css/style.css" />
</head>
<body>
	<h3> 회원 탈퇴 </h3>
	<form action="${context }/member.do" onsubmit="return sendForm()" method="get">
	아이디 <input type="text" name="userid"/> <br />
	비밀번호 <input type="password" name="password"/>  <br />
	<input type="hidden" name="action" value="delete" />
	<input type="hidden" name="page" value="delete_result" />
	<input type="submit" value="탈퇴"/>
	</form>	
<script>
function sendForm(){
	alert('alert 회원탈퇴에서 sendform 성공!! ${context}');
	return true;
}
</script>
</body>
</html>

