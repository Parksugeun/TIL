<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인</h1>
<form method="post" action="loginOk.jsp">
	아이디 : <input type="text" name="userid" id="userid" value="${param.userid }"/><br/>
	비밀번호 : <input type="password" name="userpwd" id="userpwd" value="${param.userpwd }"/><br/>
	<input type="submit" value="로그인" />
</form>
<hr/>
이름 : ${param.username}<br/>
연락처 : ${param.tel}


</body>
</html>