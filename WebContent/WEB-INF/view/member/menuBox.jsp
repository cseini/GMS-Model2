<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu-box">
	<a id="move_update">UPDATE PASSWORD</a>
	<a id="move_delete">DELETE MEMBER</a>
	<a id="move_home">HOME</a>
</div>
<script>
	service.addClass(document.getElementById('menu-box'),'btnStyle ');
	document.getElementById("move_update").addEventListener('click',function(){
		router.move(['${context}','member','move','update_form']);
	});
	document.getElementById("move_delete").addEventListener('click',function(){
		router.move(['${context}','member','move','delete_form']);
	});
	document.getElementById("move_home").addEventListener('click',function(){
		router.moveHome('${context}');
	});
</script>
