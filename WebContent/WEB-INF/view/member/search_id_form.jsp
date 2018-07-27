<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <jsp:include page="../common/head.jsp"/>
<body>
	<h2>아이디 검색</h2>
	<form id="search_id_form" name="search_id_form">
		<input type="text" name="userid"/>
		<input type="hidden" name="action" value="retrieve" />
		<input type="hidden" name="page" value="search_id_result" />
		<input id="search_id_form_btn" type="button" value="검색"/>
	</form>
<script>
	document.getElementById('search_id_form_btn').addEventListener('click',function(){
		var x = service.nullChecker([document.search_id_form.userid.value]);
		if(x.checker){
			var form = document.getElementById('search_id_form');
			form.action="${context }/member.do";
			form.method="get";
			form.submit();
		} else {
			alert(x.text);
		};
	})
</script>
</body>
</html>