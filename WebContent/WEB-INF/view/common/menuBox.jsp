<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu-box">
	<ul id="menu">
		<li><a id="move_home">HOME</a></li>
		<li><a id="move_about">ABOUT</a></li>
		<li><a id="move_admin">ADMIN</a></li>
	</ul>
</div>
<script>
	document.getElementById('move_home').addEventListener('click',function(){ //콜백함수
	router.moveHome({context:'${context}'});
	});
	document.getElementById('move_about').addEventListener('click',function(){ //콜백함수
	router.move({context:'${context}',domain:'member',action:'move',page:'mypage'});
	});
	document.getElementById('move_admin').addEventListener('click',function(){ //콜백함수
	router.move({context:'${context}',domain:'admin',action:'move',page:'main'});
	});
</script>
