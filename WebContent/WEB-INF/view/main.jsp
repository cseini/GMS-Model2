<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="<%=application.getContextPath()%>" />
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
</body>
</html>