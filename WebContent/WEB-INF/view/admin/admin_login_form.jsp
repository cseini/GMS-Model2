<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>ADMIN LOGIN</title>
	<link rel="stylesheet" href="../../css/style.css" />
</head>
<body>
	<div id="admin-login-layout">
	<h1>로그인</h1>
		<form id="admin-login-form" action="../mypage/mypage.jsp">
			ID<input type="text" name="id" value="Mickey" /><br />
			PASS<input type="password" name="password" value="Mouse"/><br />
			<input type="submit" value="제출"/>
		</form>
	</div>
</body>
</html>