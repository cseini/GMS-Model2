<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="content-box">
<h1> 정보 변경 </h1><br />
	<form id="update_member" name="update_member" >
	<input type="hidden" name="userid" value="${member.userId }" />
		<input type="password" id="password" name="password" placeholder="이전비밀번호:${user.password}"/><br /><br />
		팀(현재소속팀:${member.teamId})
			<input type="radio" name="teamid" id="teamid_0" value="none" checked="checked" /> 없음
			<input type="radio" name="teamid" id="teamid_1" value="nolja" /> 걍놀자
			<input type="radio" name="teamid" id="teamid_2" value="jienHouse" /> 지은이네
			<input type="radio" name="teamid" id="teamid_3" value="turtleKing" /> 왕거북이
			<input type="radio" name="teamid" id="teamid_4" value="coddingZzang" /> 코딩짱<br /><br />
		역할(현재 역할: ${member.roll})
		<select name="roll" id="roll">
			<option value="leader" selected="selected">팀장</option>
			<option value="front">프론트개발</option>
			<option value="back">백단개발</option>
			<option value="android">안드로이드개발</option>
			<option value="minfe">민폐</option>
		</select><br /><br /><br />
	</form>	
	<div id="update_member_btn_style">
		<a id="update_member_btn"> 업데이트 </a>
	</div>
	</div>
<script>
	service.addClass(document.getElementById('content-box'),'textCenter ');
	service.addClass(document.getElementById('update_member_btn_style'),'btnStyle padding13px115px ');
	var form = document.getElementById('update_member');
	var roll = document.getElementById('roll');
	document.getElementById('update_member_btn').addEventListener('click',()=>{
		form.action="${context}/member.do";
		form.method="post";
		var node = document.createElement('input');
		node.setAttribute("type","hidden");
		node.setAttribute("name","action");
		node.setAttribute("value","modify");
		form.appendChild(node);
		alert("변경 완료");
		form.submit();
	});
	
	for(var i=0;i<roll.options.length;i++){
		if(roll.options[i].value==='${member.roll}'){
			roll.options[i].setAttribute("selected","selected");
		}
	};
	var team = document.getElementsByName('teamid');
	for(var i=0;i<team.length;i++){
		if(team[i].value==='${member.teamId}'){
				team[i].checked=true;
		}
	};
</script>
