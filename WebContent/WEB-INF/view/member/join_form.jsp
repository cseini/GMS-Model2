<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp" />
<body>
	<div id="join-layout">
		<h3>회원가입</h3>
		<form id="join_form" name="join_form">
			아이디 <input type="text" name="userid" /><br />
			비밀번호 <input type="password" name="password" /><br />
			이름 <input type="text" name="name" /><br />
			주민등록번호<input type="text" name="ssn" /><br />
			<input type="hidden" name="action" value="join" />
			<input type="hidden" name="page" value="mypage" />
			<input type="hidden" name="gender" />
			<input type="hidden" name="age" />
			소속팀
			<input type="radio" name="teamid" value="none" checked="checked" /> 없음
			<input type="radio" name="teamid" value="nolja" /> 걍놀자
			<input type="radio" name="teamid" value="jienHouse" /> 지은이네
			<input type="radio" name="teamid" value="turtleKing" /> 왕거북이
			<input type="radio" name="teamid" value="coddingZzang" /> 코딩짱<br />
			프로젝트역할
			<select name="roll" id="roll">
				<option value="leader">팀장</option>
				<option value="front">프론트개발</option>
				<option value="back">백단개발</option>
				<option value="android">안드로이드개발</option>
				<option value="minfe">민폐</option>
			</select><br />
			수강과목
			<input type="checkbox" name="subject" value="Java" checked="checked"  /> Java
			<input type="checkbox" name="subject" value="JSP" checked="checked" /> JSP
			<input type="checkbox" name="subject" value="PHP" checked="checked"/> PHP
			<input type="checkbox" name="subject" value="nodejs" checked="checked"/> NodeJS
			<input type="checkbox" name="subject" value="linux" checked="checked"/> Linux
			<input type="checkbox" name="subject" value="HTML" checked="checked"/> HTML
			<input type="checkbox" name="subject" value="Spring" checked="checked"/> Spring<br />
			<input id="join_form_btn" type="button" value="전송" /><br />
		</form>
	</div>
	<script>
	document.getElementById('join_form_btn').addEventListener('click',function() {
	var x = service.nullChecker([document.getElementById('join_form').userid.value,document.getElementById('join_form').password.value]);
		if (x.checker) {
			var form = document.getElementById('join_form');
			form.action = "${context}/member.do";
			form.method = "post";
			member.join(form.ssn.value);
			form.gender.value = member.getGender();
			form.age.value = member.getAge();
			form.submit();
		} else {
			alert(x.text);
		}
	})
	</script>
</body>
</html>