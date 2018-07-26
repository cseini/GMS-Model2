<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<jsp:include page="../common/head.jsp"/>
<body>
	<h3> 회원 탈퇴 </h3>
	<form id="delete_form">
	아이디 <input type="text" name="userid"/> <br />
	비밀번호 <input type="password" name="password"/>  <br />
	<input type="hidden" name="action" value="delete" />
	<input type="hidden" name="page" value="delete_result" />
	<input id="delete_form_btn" type="button" value="탈퇴"/>
	</form>	
<script>
	document.getElementById('delete_form_btn').addEventListener('click',function(){
		var form = document.getElementById('delete_form');
		form.action = "${context}/member.do";
		form.method = "post";
		member.setUserid(form.userid.value);
		member.setPassword(form.password.value);
		if(member.deleteValidation()){
			form.submit();
		}
	})
</script>
</body>
</html>

