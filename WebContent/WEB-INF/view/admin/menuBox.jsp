<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="<%=application.getContextPath()%>" />
<div id="menu-box">
	<ul id="menu">
		<li><a href="${context}/member.do?action=list&page=member_list">USER LIST</a></li>
		<li><a href="${context}/member.do?action=move&page=search_id_form">FIND BY ID</a></li>
		<li><a href="${context}/member.do?action=move&page=search_team_form">FIND BY TEAM</a></li>
		<li><a href="${context}/member.do?action=move&page=delete_form">DELETE MEMBER</a></li>
		<li><a href="${context}">HOME</a></li>
	</ul>
</div>