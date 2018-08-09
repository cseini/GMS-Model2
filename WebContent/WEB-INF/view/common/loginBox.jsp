<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="login-box">
	<a id="move_login_form">LOGIN</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a id="move_join_form">JOIN</a>
</div>
<script>
	service.addClass(document.getElementById('login-box'),'cursor height50px fontColorBlack floatRight marginRight30px ');
	document.getElementById('move_login_form').addEventListener('click',function(){ //콜백함수
		router.move({context : '${context}',domain : 'member',action : 'move',page : 'main'});
	});
	document.getElementById('move_join_form').addEventListener('click',function(){ //콜백함수
		router.move({context : '${context}',domain : 'member',action : 'move',page : 'add'});
	});
</script>
