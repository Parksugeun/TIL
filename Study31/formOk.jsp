<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Enumeration"%>
<%
	// post방식의 전송일 때 인코딩해준다.
	out.print(request.getCharacterEncoding()+"<br/>");
	request.setCharacterEncoding("UTF-8");


	String userid = request.getParameter("userid");
	String userpwd = request.getParameter("userpwd");
	String username = request.getParameter("username");
	String state = request.getParameter("state");
	// 하나의 변수에 값이 여러개일때
	String[] hobby = request.getParameterValues("hobby");
	// 전화번호
	String tel1[] = request.getParameterValues("tel1");
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");
	
	String num = request.getParameter("num");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
아이디 : <%=userid %><br/>
비밀번호 : <%=userpwd %><br/>
이름 : <%=username %><br/>
동의여부 : <%=state %><br/>
취미 : <%=Arrays.toString(hobby) %><br/>
연락처 : <%= Arrays.toString(tel1) +"-"+tel2+"-"+tel3 %><br/>
연락처 : <%= Arrays.toString(tel1) %>-<%=tel2 %>-<%=tel3 %><br/>
번호 : <%=num %>
<%
	System.out.println(username);
%>
<hr/>
<ul>
<% 
	//폼의 name들을 구한다.
	Enumeration<String> nameList = request.getParameterNames();
	while(nameList.hasMoreElements()){
		%>
			<li><%=nameList.nextElement() %></li>
		<%
	}
%>
</ul>
<ol>
	<li>접속자의 컴퓨터 ip : <%=request.getRemoteAddr() %></li>
	<li>인코딩 코드값 : <%= request.getCharacterEncoding()%></li>
	<li>contentType : <%= request.getContentType() %></li>
	<li>전송방식 : <%= request.getMethod() %></li>
	<li>protocol : <%= request.getProtocol() %></li>
	<li>URI : <%= request.getRequestURI() %></li>
	<li>ContextPath : <%=request.getContextPath() %></li> <!-- /webjsp -->
	<li>서버이름 : <%= request.getServerName() %></li>
	<li>포트 : <%= request.getServerPort() %></li>
	<li>절대주소 : <%= request.getServletContext().getRealPath("/jsp01_request") %></li>
</ol>
</body>
</html>