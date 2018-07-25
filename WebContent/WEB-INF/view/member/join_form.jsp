<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원가입 화면</title>
	<link rel="stylesheet" href="${conterxt}/resources/css/style.css" />
</head>
<body>
	<div id="join-layout">
	<h3>회원가입</h3>
		<form id="join_form">
			아이디         <input type="text" name="userid" /><br />
			비밀번호      <input type="password" name="password" /><br />
			이름            <input type="text" name="name"/><br />
			주민등록번호<input type="text" name="ssn"/><br />
			<input type="hidden" name="action" value="join"/>
			<input type="hidden" name="page" value="mypage" />
			<input id="join_form_btn" type="submit" value="전송"/>		
		</form>
<script>
	document.getElementById('join_form_btn').addEventListener('click',function(){
		var form = document.getElementById('join_form');
		form.action = "${context}/member.do";
		form.method = "post";
		member.setUserid(form.userid.value);
		member.setPassword(form.password.value);
		member.setName(form.name.value);
		member.setSsn(form.ssn.value);
		form.submit();
	})
</script>
	</div>
</body>
</html>