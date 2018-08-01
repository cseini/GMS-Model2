<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<jsp:include page="../common/head.jsp"/>
<body>
<div id="wrapper">
	<div id="header">
		<jsp:include page="../common/titleBox.jsp"/>
		<jsp:include page="../common/menuBox.jsp"/>
	</div>
	<div id="content">
<div id="update_member_style">
<h3> 정보 변경 </h3>
	<form id="update_member" name="update_member" >
	<input type="hidden" name="userid" value="${user.userId }" />
		<input type="password" id="password" name="password" placeholder="이전비밀번호:${user.password}"/><br /><br />
		팀(현재소속팀:${user.teamId})
			<input type="radio" name="teamid" id="teamid_0" value="none" checked="checked" /> 없음
			<input type="radio" name="teamid" id="teamid_1" value="nolja" /> 걍놀자
			<input type="radio" name="teamid" id="teamid_2" value="jienHouse" /> 지은이네
			<input type="radio" name="teamid" id="teamid_3" value="turtleKing" /> 왕거북이
			<input type="radio" name="teamid" id="teamid_4" value="coddingZzang" /> 코딩짱<br /><br />
		역할(현재 역할: ${user.roll})
		<select name="roll" id="roll">
			<option value="leader" selected="selected">팀장</option>
			<option value="front">프론트개발</option>
			<option value="back">백단개발</option>
			<option value="android">안드로이드개발</option>
			<option value="minfe">민폐</option>
		</select><br /><br />
	</form>	
	<div id="update_member_btn_style">
		<a id="update_member_btn"> 업데이트 </a>
	</div>
</div></div></div>
	<div id="footer">
		<jsp:include page="../common/footer.jsp"/>
	</div>
<script>
	var form = document.getElementById('update_member');
	var roll = document.getElementById('roll');
	for(var i=0;i<roll.options.length;i++){
		if(roll.options[i].value==='${user.roll}'){
			roll.options[i].setAttribute("selected","selected");
		}
	};
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
			var node = document.createElement('input');
			node.setAttribute("type","hidden");
			node.setAttribute("name","action");
			node.setAttribute("value","update");
			form.appendChild(node);
			alert("변경 완료");
			form.submit();
		} else {
			alert(x.text);
		}
	});
</script>
</body>
</html>
