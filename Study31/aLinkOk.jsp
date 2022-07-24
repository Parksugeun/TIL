<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//request : 클라이언트측의 데이터를 서버로 가져오기
	int num = Integer.parseInt(request.getParameter("num"));
	String username = request.getParameter("username");
	String tel = request.getParameter("tel");	
%>
<img src="../img/03.jfif"/>
<hr/>
번호 : <%=num %><br/>
이름 : <%=username %><br/>
연락처 : <%=tel %>




