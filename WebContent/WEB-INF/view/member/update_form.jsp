<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
 <jsp:include page="../common/head.jsp"/>
<body>
<h3> 정보 변경 </h3>
	<form id="update_member" name="update_member" >
	<input type="hidden" name="userid" value="${user.userId }" />
	<table>
	<tr>		
		<td>바꿀비밀번호 <input type="password" id="password" name="password" placeholder="${user.password}"/></td>
	</tr>
	<tr>
	<td>
		팀(현재소속팀:${user.teamId})
			<input type="radio" name="teamid" id="teamid_0" value="none" checked="checked" /> 없음
			<input type="radio" name="teamid" id="teamid_1" value="nolja" /> 걍놀자
			<input type="radio" name="teamid" id="teamid_2" value="jienHouse" /> 지은이네
			<input type="radio" name="teamid" id="teamid_3" value="turtleKing" /> 왕거북이
			<input type="radio" name="teamid" id="teamid_4" value="coddingZzang" /> 코딩짱
	</td>
	</tr>
	<tr>
	<td>
		역할(현재 역할: ${user.roll})
		<select name="roll" id="roll">
			<option value="leader" selected="selected">팀장</option>
			<option value="front">프론트개발</option>
			<option value="back">백단개발</option>
			<option value="android">안드로이드개발</option>
			<option value="minfe">민폐</option>
		</select>
	</td>
	</tr>
		</table>
		<input type="hidden" name="action" value="update" />
		<input id="update_member_btn" type="button" value="변경"/>
	</form>	
<script>
	var form = document.getElementById('update_member');
	var roll = document.getElementById('roll');
	for(var i=0;i<roll.options.length;i++){
		if(roll.options[i].value==='${user.roll}'){
			roll.options[i].setAttribute("selected","selected");
		}
	};

/* 	for(var i=0;i<5;i++){
		if(document.getElementById('teamid_'+i).value==='${user.teamId}'){
			document.getElementById('teamid_'+i).checked=true;
		}
	}; */
	
	var team = document.getElementsByName('teamid');
	for(var i=0;i<team.length;i++){
		if(team[i].value==='${user.teamId}'){
				team[i].checked=true;
		}
	};
	document.getElementById('update_member_btn').addEventListener('click',function(){
	var x = service.nullChecker([document.update_member.password.value,document.update_member.teamid.value,document.update_member.roll.value]);
		if(x.checker){
			form.action="${context }/member.do";
			form.method="post";
			form.submit();
		} else {
			alert(x.text);
		}
	});
</script>
</body>
</html>
