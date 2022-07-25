<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="/webJSP/jsp05_error/errorTest.jsp">
	수1 : <input type="text" name="su1"/><br/>
	수2 : <input type="text" name="su2"/><br/>
	<input type="submit" value="계산하기"/>
</form>
<hr/>
<%
	String su1 = request.getParameter("su1");
	String su2 = request.getParameter("su2");
	
	if(su1!=null && su2 !=null){
		int n1 = Integer.parseInt(su1);
		int n2 = Integer.parseInt(su2);
	%>
		<%=n1 %> + <%=n2 %> = <%= n1+n2 %><br/>
		<%=n1 %> - <%=n2 %> = <%= n1-n2 %><br/>
		<%=n1 %> * <%=n2 %> = <%= n1*n2 %><br/>
		<%=n1 %> / <%=n2 %> = <%= n1/n2 %><br/>
	<% 
	}else{
		%>
		계산이 불가능한 데이터 입니다.
		<% 
	}
%>
</body>
</html>