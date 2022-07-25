<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//로그아웃시 세션에 있는 모든 기록을 제거한다.
	// 세션객체를 삭제하면 새로운 세션이 할당된다.
	
	session.invalidate(); //세션을 지우는 것
	
	response.sendRedirect("/webJSP/index.jsp");
%>
