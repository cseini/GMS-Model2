<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
 <jsp:include page="../common/head.jsp"/>
<body>
<h3> 비밀번호 변경 </h3>
	<form id="update_password" name="update_password" >
		아이디 <input type="text" name="userid"/> <br />
		현재비밀번호 <input type="password" name="old_password"/>  <br />
		바꿀비밀번호 <input type="password" name="new_password"/>  <br />
		<input type="hidden" name="action" value="update" />
		<input type="hidden" name="page" value="update_result" />
		<input id="update_password_btn" type="button" value="변경"/>
	</form>	
<script>
	document.getElementById('update_password_btn').addEventListener('click',function(){
	var x = service.nullChecker([document.update_password.userid.value,document.update_password.old_password.value,document,update_password.new_password.value]);
		if(x.checker){
			var form = document.getElementById('update_password');
			form.action="${context }/member.do";
			form.method="post";
			form.submit();
		} else {
			alert(x.text);
		}
	})
</script>
</body>
</html>
