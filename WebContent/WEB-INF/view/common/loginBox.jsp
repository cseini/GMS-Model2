<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="login-box">
	<a id="move_login_form">LOGIN</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a onclick="common.move('member','move','join_form')">JOIN</a>
</div>
<script>
	document.getElementById('move_login_form').addEventListener('click',function(){ //콜백함수
	alert('클릭 이벤트 체크!!');
	common.move('member','move','login_form');
	});
</script>
