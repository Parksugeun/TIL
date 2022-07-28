<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
<link rel="stylesheet" href="css/style.css" type="text/css"/>	
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p>스프링 홈페이지</p>
<h2>아이디 : ${userid}</h2>
<h2>이름 : ${username}</h2>
<img src="img/02.jfif"/>
</body>
</html>
