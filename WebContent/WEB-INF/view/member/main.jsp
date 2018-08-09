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
		<jsp:include page="login.jsp" />
	</div>
	<div id="footer">
		<jsp:include page="../common/footer.jsp"/>
	</div>
</div>
<script>
	member.main('${context}');
</script>
</body>
</html>
