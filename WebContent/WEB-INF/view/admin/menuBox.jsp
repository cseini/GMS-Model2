<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu-box">
	<ul id="menu">
		<li><a onclick="common.move('member','list','member_list')">USER LIST</a></li>
		<li><a onclick="common.move('member','move','search_id_form')">FIND BY ID</a></li>
		<li><a onclick="common.move('member','move','search_team_form')">FIND BY TEAM</a></li>
		<li><a onclick="common.move('member','move','update_form')">UPDATE PASSWORD</a></li>
		<li><a onclick="common.move('member','move','delete_form')">DELETE MEMBER</a></li>
		<li><a onclick="common.moveHome()">HOME</a></li>
	</ul>
</div>