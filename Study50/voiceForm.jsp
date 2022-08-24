<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
	#voiceText{
		width:100%;
		height:200px;
	}
</style>
<script>
	$(function(){
		$("#voiceBtn").click(function(){
			let xhr = new XMLHttpRequest();
			
			xhr.responseType = "blob"; //응답받는 데이터 타입
			
			//응답받은 경우 실행하는 곳
			xhr.onload = function(){
				var audioURL = URL.createObjectURL(this.response);	
				var audio = new Audio();
				audio.src = audioURL;
				audio.play();//재생
				
			};
			
			//서버에 매핑주소
			xhr.open("post", "/clova/voiceOk");
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			xhr.send("text="+$("#voiceText").val());
		});
	});
</script>
</head>
<body>
	<h1>CLOVA Voice</h1>
	<p>CLOVA Voice - Premium API는 음성으로 변환할 텍스트와 음색, 속도, 감정 등을 파라미터로 입력받은 후 음성을 합성하여 그 결과를 반환하는 HTTP 기반의 REST API입니다.</p>

	<textarea id="voiceText">
	위르겐 클롭 리버풀 감독은 발끈했다. 그는 "맨유의 두 번째 골은 받아들이기 어렵다. 오프사이드였다"고 분통을 터트렸다.
	영국의 '더선'이 이날 그 해답을 공개했다. 지난 시즌까지는 래시포드는 오프사이드였지만 새로운 규칙이 적용된 올 시즌에는 온사이드라는 해석이다.</textarea><br/>
	<input type="button" value="음성으로 변환하기" id="voiceBtn"/>
</body>
</html>