<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ol>
	<%
		// 클라이언트 컴퓨터의 쿠키정보를 서버로 가져오기
		Cookie[] coo = request.getCookies();
	
		for(int idx=0; idx<coo.length; idx++){
	%>
			<li><%=coo[idx].getName() %> : <%=coo[idx].getValue() %></li>
	<% }%>
</ol>
</body>
</html>