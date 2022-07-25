<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>에러발생시 실행될 페이지</h1>
<h2>
에러메시지 :
<%
	out.print(exception.getMessage());

%>
</h2>
<a href="/webJSP/index.jsp"><img src="../img/oops.png"/></a>
</body>
</html>