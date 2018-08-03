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
		<jsp:include page="common/contentBox.jsp"/>
	</div>
	<div id="footer">
		<jsp:include page="common/footer.jsp"/>
	</div>
</div>
<script>
	service.addClass(document.getElementById('wrapper'),'width100pt padding0px margetnLeftAuto margetnRightAuto ')
	service.addClass(document.getElementById('body'),'fontDefault backgroundColorWhite margin0px padding0px fontColorGray ')
</script>
</body>
</html>
