<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="<%=application.getContextPath() %>"/>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>USER LOGIN</title>
	<link rel="stylesheet" href="${context}/resources/css/style.css" />
</head>
<body>
	<div>
		<h1>로그인</h1>
		<form id="user-login-form" action="${context}/member.do">
			ID <input type="text" name="userid" /><br />
			PASS <input type="password" name="password" /><br />
			<input type="hidden" name="action" value="login" />
			<input type="hidden" name="page" value="mypage" />
			<input type="submit" value="전송"/>
		</form>
	</div>
</body>
</html>
