<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="domain.MemberBean"%>

<%
 String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Mypage</title>
	<link rel="stylesheet" href="<%=ctx %>/resources/css/style.css" />
</head>
<body>
	<table id="mypage-table-layout" class="width-90 margin-auto">
		<tr class="height-100">
			<th colspan="2"><h1>초특가 야놀자!</h1></th>
		</tr>
		<tr  id="mypage-table-layout-tr">
			<td>
			<% MemberBean user = (MemberBean)request.getAttribute("user"); %>
			<h3><%=user.getName() %>님의 마이페이지 진입</h3>			
			</td>
			<td id="mypage-table-layout-td">
			<a href="<%=ctx %>">로그아웃</a>
			</td>
		</tr>
		<tr class="height-100 text-align-left">
			<td colspan="2">
				(주)야놀자
				대표이사: 이수진
				주소: 서울 강남구 테헤란로 427
				메일:
				<a href="mailto:cseini@nate.com" data-reactid="273"><b
					data-reactid="274">cseini@nate.com</b></a>
				<br data-reactid="276">
				사업자 등록번호: 220-87-42885
				통신판매업신고: 강남-14211호
				관광사업자 등록번호: 제2016-31호
				호스팅 서비스 제공자: (주)야놀자
			<p>(주)야놀자는 통신판매중개자로서, 통신판매의 당사자가 아니라는 사실을
				고지하며 상품의 예약, 이용 및 환불 등과 관련한 의무와 책임은 각 판매자에게 있습니다.</p>
			</td>
		</tr>
	</table>
</body>
</html>