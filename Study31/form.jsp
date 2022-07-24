<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>폼을 이용한 서버로 데이터 보내기</h1>
<form method="post" action="formOk.jsp"> 
	<!--  readonly, disabled -->
	아이디 : <input type="text" name="userid" value="goguma" disabled/><br/>
	비밀번호 : <input type="password" name="userpwd"/><br/>
	이름 : <input type="text" name="username"/><br/>
	동의여부 : <input type="radio" name="state" value="Ok"/>동의함
			<input type="radio" name="state" value="No"/>동의안함<br/>
	취미 :<input type="checkbox" name="hobby" value="농구"/>농구
		 <input type="checkbox" name="hobby" value="축구"/>축구
		 <input type="checkbox" name="hobby" value="야구"/>야구
		 <input type="checkbox" name="hobby" value="배구"/>배구
		 <input type="checkbox" name="hobby" value="탁구"/>탁구
		 <input type="checkbox" name="hobby" value="족구"/>족구<br/>
	연락처 : 
		<select name="tel1" multiple>
			<option>010</option>
			<option>02</option>
			<option>031</option>
			<option value="111">032</option>
			<option>041</option>
		</select> -	 
		<input type="text" name="tel2"/> -
		<input type="text" name="tel3"/><br/> 
	<input type="hidden" name="num" value="1234"/>	 
	<input type="submit" value="전송"/>

</form>
</body>
</html>