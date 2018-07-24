<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<jsp:include page="common/head.jsp"></jsp:include>
<body>
<div id="wrapper">
	<div id="header">
		<jsp:include page="common/titleBox.jsp"/>
		<jsp:include page="common/loginBox.jsp"/>
		<jsp:include page="common/menuBox.jsp"/>
	</div>
	<div id="content">
		<jsp:include page="common/contentBox.jsp"></jsp:include>
	</div>
	<div id="footer">
		<jsp:include page="common/footer.jsp"/>
	</div>
</div>
<script>
function move(domain, action, page) {
	alert('move 성공 ${context}')
	location.href = "${context}/"+domain+".do?action="+action+"&page="+page;
}
function moveHome(){
	alert('홈으로 이동 클릭')
	location.href ="${context}";
}
</script>
</body>
</html>
