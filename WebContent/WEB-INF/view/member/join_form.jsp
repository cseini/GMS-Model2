<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
 String ctx = application.getContextPath();
%>
<!--
	userId, teamId, name, ssn, roll, password
-->
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원가입 화면</title>
	<link rel="stylesheet" href="<%=ctx %>/resources/css/style.css" />
</head>
<body>
	<div id="join-layout">
	<h3>회원가입</h3>
		<form id="join-form" action="<%=ctx%>/member.do">
			아이디         <input type="text" name="userid" /><br />
			비밀번호      <input type="password" name="password" /><br />
			이름            <input type="text" name="name"/><br />
			주민등록번호<input type="text" name="ssn"/><br />
			<input type="hidden" name="action" value="join"/>
			<input type="hidden" name="page" value="join_result" />
			<input type="submit" value="전송"/>		
		</form>
	</div>
</body>
</html>