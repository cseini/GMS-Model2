<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="domain.*" %>
<%@ page import="java.util.*" %>
<!doctype html>
<html lang="en">
	<jsp:include page="../common/head.jsp"/>
<body>
	<form action="${context }"><input type="submit" value="초기화면"/></form>
	<h2>회원명단</h2>
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>팀명</th>
			<th>직책</th>
			<th>주민등록번호</th>
			<th>성별</th>
		</tr>
		<%
		List<MemberBean> lst = (List<MemberBean>)request.getAttribute("memberList");
		for(MemberBean e : lst){
			%>
				<tr>
					<td><%=e.getUserId() %></td>
					<td><%=e.getPassword() %></td>
					<td><%=e.getName() %>	</td>
					<td><%=e.getTeamId() %>	</td>
					<td><%=e.getRoll() %>	</td>
					<td><%=e.getSsn() %>	</td>
					<td><%if(e.getSsn().substring(7,8).equals("1")){
						%> 남 <% 
					} else {
						%> 여 <%
						}%>
					</td>
				</tr>
			<%
		}
	%>
	</table>
<script>

</script>
</body>
</html>
