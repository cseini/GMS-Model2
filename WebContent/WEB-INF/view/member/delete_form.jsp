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
	<h3> 회원 탈퇴 </h3>
	<form id="delete_form">
	<input type="password" name="password" placeholder="비밀번호를 입력하세요."/>  <br /><br />
	</form>	
	<div id="delete_form_btn_style">
	<a id="delete_form_btn">탈퇴</a>
	</div>
	</div></div>
		<div id="footer">
		<jsp:include page="../common/footer.jsp"/>
	</div>
<script>
	var form = document.getElementById('delete_form');
	document.getElementById('delete_form_btn').addEventListener('click',function(){
		var val = form.password.value;
		if(form.password.value.ckecker){
			alert('비밀번호를 입력해주세요');
		} else if(val=='${user.password}'){
		form.action = "${context}/member.do";
		form.method = "post";
		/*var node = document.createElement('input');
 		node.innerHTML = 
			'<input type="hidden" name="action" value="delete" />'; */
		var node = document.createElement('input');
			node.setAttribute('type','hidden');
			node.setAttribute('name','action');
			node.setAttribute('value','delete');
		form.appendChild(node);
		alert("탈퇴 완료");
		form.submit();
	} else{
		alert('비밀번호가 다릅니다!!');
	};
});
</script>
</body>
</html>

