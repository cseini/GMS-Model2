<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu-box">
	<ul id="menu">
		<li><a id="move_update">UPDATE PASSWORD</a></li>
		<li><a id="move_delete">DELETE MEMBER</a></li>
		<li><a id="move_home">HOME</a></li>
	</ul>
</div>
<script>
	service.addClass(document.getElementById('menu-box'),'menu-box ');
	service.addClass(document.getElementById('menu'),'menu ');
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
