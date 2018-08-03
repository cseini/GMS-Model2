<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="content-box">
	<div id="search_box">
		<a id="search_btn">검색</a>
		<select name="search_option" id="search_option">
			<option value="none">검색조건</option>
			<option value="id">아이디</option>
			<option value="name">이      름 </option>
			<option value="team_id">팀이름</option>
		</select>
		<input id="search_word" name="search_word" type="text" placeholder="검색어 입력" />
	</div>
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
		<tr>
			<td colspan="6"> 
			카운트커맨드 : (${count1})
			<c:forEach begin="1" end="${count%5==0? count/5:count/5+1}" step="1" var="page">
				<span> ${page } </span>
			</c:forEach>
			</td>
		</tr>
	</table><br />
</div>
<script>
	admin.main('${context}');
</script>
