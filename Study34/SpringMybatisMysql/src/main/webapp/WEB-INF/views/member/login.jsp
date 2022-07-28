<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="js/member.js"></script>
</head>
<body>
<h1>로그인</h1>
<form method="post" action="loginOk" id="frm">
아이디 : <input type="text" name="userid" id="userid"/><br/>
비밀번호 : <input type="password" name="userpwd" id="userpwd"/><br/>
<input type="submit" value="로그인"/>
</form>
</body>
</html>