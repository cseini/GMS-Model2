<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<jsp:include page="../common/head.jsp"></jsp:include>
<body>
<div id="wrapper">
	<div id="header">
		<jsp:include page="../common/titleBox.jsp"/>
		<jsp:include page="menuBox.jsp"></jsp:include>
	</div>
	<div id="content">
		<jsp:include page="contentBox.jsp"></jsp:include>
	</div>
	<div id="footer">
		<jsp:include page="../common/footer.jsp"></jsp:include>	
	</div>
</div>
</body>
</html>