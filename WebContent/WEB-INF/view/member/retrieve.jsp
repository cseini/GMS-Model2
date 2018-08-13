<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<jsp:include page="../common/head.jsp"/>
<div id="content-box">
	<table id="mypage-table">
		<tr>
			<td colspan="2" rowspan="3"><img src="${img}/mypage/default.png" alt="" /></td>
			<td>아이디</td>
			<td>${member.userId }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${member.name }</td>
		</tr>
		<tr>
			<td>비번</td>
			<td>********</td>
		</tr>
		<tr>
			<td>나이</td>
			<td>${member.age }</td>
			<td>팀명</td>
			<td>${member.teamId }</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>${member.gender }</td>
			<td>역할</td>
			<td>${member.roll }</td>
		</tr>
	</table><br />
	<div id="move_update_btn">
	<a id="move_update_form">개인정보 수정 이동</a>
	<a id="move_delete_form">회원탈퇴 이동</a>
	</div>
</div>
<script>
	
</script>