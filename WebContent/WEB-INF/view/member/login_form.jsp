<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<jsp:include page="../common/head.jsp"/>
<body>
<div id="wrapper">
	<div id="header">
		<jsp:include page="../common/titleBox.jsp"/>
		<jsp:include page="../common/menuBox.jsp"/>
	</div>
	<div id="content">
	<div id="content-box">
		<h1>로그인하고 혜택 받으세요!</h1><br /><br />
		<form id="login_form" name="login_form" >
			<input type="text" name="userid"  placeholder="아이디를 입력하세요."/><br /><br />
			<input type="password" name="password" placeholder="비밀번호를 입력하세요."/><br />
		</form>
	</div>
	<div id="login_form_btn_style">
		<h2><a id="login_form_btn">로그인</a></h2>
	</div>	
	</div>
	</div>
		<div id="footer">
		<jsp:include page="../common/footer.jsp"/>
	</div>
	<script>
	member.login('${context}');
	</script>
</body>
</html>
