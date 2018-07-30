<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${css }/style.css" />
<jsp:include page="../common/head.jsp" />
<div>
	<table id="mypage-table">
		<tr>
			<td colspan="2" rowspan="3"></td>
			<td>아이디</td>
			<td>${user.userId }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${user.name }</td>
		</tr>
		<tr>
			<td>비번</td>
			<td>********</td>
		</tr>
		<tr>
			<td>나이</td>
			<td>${user.age }</td>
			<td>팀명</td>
			<td>${user.teamId }</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>${user.gender }</td>
			<td>역할</td>
			<td>${user.roll }</td>
		</tr>
	</table>
	<div id="move_uapdate_btn">
	<a id="move_update_form">개인정보 수정 이동</a>
	<a id="move_home_form">초기화면</a>
	</div>
</div>
<script>
	document.getElementById('move_update_form').addEventListener('click', function(){
		router.move({context:'${context}', domain:'member', action:'move',page:'update_form'});
	});
	document.getElementById('move_home_form').addEventListener('click', function(){
		router.moveHome({context:'${context}'});
	});
</script>