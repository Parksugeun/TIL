<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String userid = request.getParameter("userid");
	String userpwd = request.getParameter("userpwd");
	System.out.println(userid+","+userpwd);
	//DB조회
	if(userid.equals("goguma")&& userpwd.equals("1234")){//로그인 성공
		//다른페이지로 이동
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}else{//로그인 실패
		//response.sendRedirect("/webJSP/jsp02_response/login.jsp");
	%>
	<script>
		history.go(-2) ;// history.back(), history.forward(), history.go(-1)
	</script>
	<% 
	}
%>
