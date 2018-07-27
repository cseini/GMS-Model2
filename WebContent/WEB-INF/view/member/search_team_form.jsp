<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<jsp:include page="../common/head.jsp"/>
<body>
	<form id="search_team" name="search_team">
		팀 이름<input type="text" name="team_name"/>
		<input type="hidden" name="action" value="search" />
		<input type="hidden" name="page" value="search_team_result" />
		<input id="search_team_btn"type="button" value="검색" />
	</form>
<script>
	document.getElementById('search_team_btn').addEventListener('click', function(){
		var x = service.nullChecker([document.search_team.team_name.value]);
		if(x.checker){
			var form = document.getElementById('search_team');
			form.action="${context }/member.do";
			form.method="get";
			form.submit();
		} else {
			alert(x.text);
		}
	})
</script>
</body>
</html>