<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="login-box">
	<a id="move_login_form">LOGIN</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a id="move_join_form">JOIN</a>
</div>
<script>
	document.getElementById('move_login_form').addEventListener('click',function(){ //콜백함수
		router.move(['${context}','member','move','login_form']);
	});
	document.getElementById('move_join_form').addEventListener('click',function(){ //콜백함수
		router.move(['${context}','member','move','join_form']);
	});
</script>
