<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="content-box">
	<table id="content_box_table">
		<tr id="content_box_meta">
			<th>아이디</th>
			<th>이   름</th>
			<th>나   이</th>
			<th>성   별</th>
			<th>팀   명</th>
			<th>역   할</th>
		</tr>
		<c:forEach items="${list}" var="i">
		<tr>
			<td>${i.userId}</td>
			<%-- <td><a href="${context }/admin.do?action=retrieve&page=memberDetail&userid=${i.userId}">${i.name}</a></td> --%> <!-- 이렇게하지말자 -->
			<td><a class="username" id="${i.userId}">${i.name}</a></td>
			<td>${i.age}</td>
			<td>${i.gender}</td>
			<td>${i.roll}</td>
			<td>${i.teamId}</td>
		</tr>
		</c:forEach>
	</table>	
</div>
<script>
	document.getElementById('content_box_meta').className = 'bg_color_is_yellow';
	var x = document.querySelectorAll('.username');
	for(i in x){
		x[i].style.color='red';
		x[i].style.cursor='pointer';
		x[i].addEventListener('click',function(){
		location.href = '${context}/admin.do?action=retrieve&page=memberDetail&userid='+this.getAttribute('id');
		});
	}
</script>