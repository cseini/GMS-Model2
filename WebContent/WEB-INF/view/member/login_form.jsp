<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<jsp:include page="../common/head.jsp"/>
<body>
	<div>
		<h1>로그인</h1>
		<form id="login_form">
			ID <input type="text" name="userid" /><br />
			PASS <input type="password" name="password" /><br />
			<input type="hidden" name="action" value="login" />
			<input type="hidden" name="page" value="main" />
			<input id="login_form_btn" type="button" value="전송"/>
		</form>
	</div>
	<script>
	document.getElementById('login_form_btn').addEventListener('click',function(){
		var member = new Member();
		var form = document.getElementById('login_form');
		form.action = "${context}/member.do";
		form.method = "post";
		member.setUserid(form.userid.value);
		member.setPassword(form.password.value);
		if(member.loginValidation()){
			form.submit();
		}
	})
	</script>
</body>
</html>
