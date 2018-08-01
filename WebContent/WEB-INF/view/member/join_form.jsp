<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
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
	<div id="join_form_style">
		<h3>회원가입</h3>
		<form id="join_form">
			<input class="join_textbox" type="text" name="userid" placeholder="아이디를 입력하세요."/><br /><br />
			<input class="join_textbox" type="password" name="password" placeholder="비밀번호를 입력하세요."/><br /><br />
			<input class="join_textbox" type="text" name="name" placeholder="이름을 입력하세요."/><br /><br />
			<input class="join_textbox" type="text" name="ssn" placeholder="주민등록번호를 입력하세요.(예: xxxxxx-x)"/><br /><br /><br />
			소속팀
			<input type="radio" name="teamid" value="none" checked="checked" /> 없음
			<input type="radio" name="teamid" value="nolja" /> 걍놀자
			<input type="radio" name="teamid" value="jienHouse" /> 지은이네
			<input type="radio" name="teamid" value="turtleKing" /> 왕거북이
			<input type="radio" name="teamid" value="coddingZzang" /> 코딩짱<br /><br />
			프로젝트역할
			<select name="roll" id="roll">
				<option value="leader">팀장</option>
				<option value="front">프론트개발</option>
				<option value="back">백단개발</option>
				<option value="android">안드로이드개발</option>
				<option value="minfe">민폐</option>
			</select><br /><br />
			수강과목
			<input type="checkbox" name="subject" value="Java" checked="checked"  /> Java
			<input type="checkbox" name="subject" value="JSP" checked="checked" /> JSP
			<input type="checkbox" name="subject" value="PHP" checked="checked"/> PHP
			<input type="checkbox" name="subject" value="nodejs" checked="checked"/> NodeJS
			<input type="checkbox" name="subject" value="linux" checked="checked"/> Linux
			<input type="checkbox" name="subject" value="HTML" checked="checked"/> HTML
			<input type="checkbox" name="subject" value="Spring" checked="checked"/> Spring<br /><br />
		</form>
		<div id="join_form_btn_style">
			<a id="join_form_btn">가입하기</a>
		</div>
	</div></div></div>
		<div id="footer">
		<jsp:include page="../common/footer.jsp"/>
	</div>
	<script>
	document.getElementById('join_form_btn').addEventListener('click',function() {
	var x = service.nullChecker([document.getElementById('join_form').userid.value,document.getElementById('join_form').password.value]);
		if (x.checker) {
			var form = document.getElementById('join_form');
			form.action = "${context}/member.do";
			form.method = "post";
			member.join(form.ssn.value);
			var arr =[{name:'action', value:'join'},{name:'gender',value:member.getGender()},{name:'age',value:member.getAge()}]
			for(var i in arr){
				var node = document.createElement('input');
					node.setAttribute('type','hidden');
					node.setAttribute('name', arr[i].name);
					node.setAttribute('value', arr[i].value);
				form.appendChild(node);
			}
			/* [배열{제이슨}] */
			/* var arr={name:['action','gender','age'],value:['join']};
			for(i in arr.name){
				var node=document.createElement('input');
				node.setAttribute("type","hidden");
				node.setAttribute("name", arr.name[i]);
				node.setAttribute("value", arr.value[i]);
			form.appendChild(node);
			} */
			/* form.gender.value = member.getGender();
			form.age.value = member.getAge();  */
			alert("회원가입 완료");
			form.submit();
			/* {제이슨[배열]} */
		} else {
			alert(x.text);
		}
	})
	</script>
</body>
</html>