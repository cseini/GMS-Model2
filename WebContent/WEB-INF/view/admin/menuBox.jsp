<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu-box">
	<ul id="menu">
		<li><a id="move_member_list">USER LIST</a></li>
		<li><a id="move_find_by_id">FIND BY ID</a></li>
		<li><a id="move_find_by_team">FIND BY TEAM</a></li>
		<li><a id="move_update">UPDATE PASSWORD</a></li>
		<li><a id="move_delete">DELETE MEMBER</a></li>
		<li><a id="move_home">HOME</a></li>
	</ul>
</div>
<script>
	document.getElementById("move_member_list").addEventListener('click',function(){
		router.move(['${context}','member','list','member_list']);
	});
	document.getElementById("move_find_by_id").addEventListener('click',function(){
		router.move(['${context}','member','move','search_id_form']);
	});
	document.getElementById("move_find_by_team").addEventListener('click',function(){
		router.move(['${context}','member','move','search_team_form']);
	});
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