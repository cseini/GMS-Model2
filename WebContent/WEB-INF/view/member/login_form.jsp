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
	<div id="div_login_form">
		<h1><b>로그인</b>하고 혜택 받으세요!</h1><br />
		<form id="login_form" name="login_form" >
			<h2>
			<input type="text" name="userid"  placeholder="아이디를 입력하세요."/><br /><br />
			<input type="password" name="password" placeholder="비밀번호를 입력하세요."/><br /></h2>
			<br />
		</form>
	</div>
	<div id="login_btn_style">
		<h2><a id="login_form_btn">로그인</a></h2>
	</div>
	</div>
	</div>
		<div id="footer">
		<jsp:include page="../common/footer.jsp"/>
	</div>
	<script>
	document.getElementById('login_form_btn').addEventListener('click',function(){
		var x = service.nullChecker([document.login_form.userid.value,document.login_form.password.value]);
		if(x.checker){
			var form = document.getElementById('login_form');
			form.action = "${context}/member.do";
			form.method = "post";
			var node = document.createElement('input');
			node.setAttribute("type","hidden");
			node.setAttribute("name","action");
			node.setAttribute("value","login");
			form.appendChild(node);
			form.submit();
		} else {
			alert(x.text);
		}
	})
	</script>
</body>
</html>
