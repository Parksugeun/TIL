<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


<style>
</style>

<script>
	$(function(){
		$(document).on('submit','#csrForm',function(){
			event.preventDefault();
			if(filename!=""){
			// mp3, aac, ac3, ogg, flac, wav
			var filename = $("#audio").val();//파일명이 audio로 존재 
			let point = filename.lastIndexOf(".");
			let extension = filename.substring(point+1);
			//console.log(filename);
			
				if(extension=='mp3' || extension=='aac' || extension=='ac3' || extension=='ogg' 
						|| extension=='flac' || extension=='wav'){
					
					var formObj = new FormData($("#csrForm")[0]);//폼 객체로 만들기 
					var url = "/clova/csr_speech_ok";
					
					$.ajax({//서버로호출
						type:'post',
						async:false,
						processData:false,
						contentType:false,
						data:formObj,
						dataType:"text",
						url:url,
						success:function(result, status){
							console.log(result);
							console.log(status);
							
							$("#csrResult").val(result);
							
							var jsonObject = JSON.parse(result)
							
							$("#csrTxt").html(jsonObject.text);
							
							
						},error:function(e){
							console.log(e.responseText);
						}
						
					});
				}else{
					alert("음성파일이 아닙니다.");
					return false;
				}
			}else {
				alert("음성파일을 선택하세요..");
				return false;
			}
			
		});
	});
</script>

</head>

<body>

<h2>가장 뛰어난 한국어 음성 인식률을 가진 음성 인식 API</h2>
<p>CLOVA Speech Recognition REST API (이하 CSR REST API)는 HTTP 기반의 REST API로 제공하는 음성인식 API입니다. 인식에 사용할 언어와 음성 데이터를 입력받고 그에 맞는 인식 결과를 텍스트로 반환합니다.
입력 음성 데이터 포맷은 mp3, aac, ac3, ogg, flac, wav을 지원합니다</p>
	<form method="post" enctype="multipart/form-data" id="csrForm">
		음성파일 선택 : <input type="file" name="audio" id="audio"/>
		<input type="submit" value="시작"/>
	</form>
	<textarea id="csrResult" style="width:600px; height:100px;"></textarea>
	<div id="csrTxt" style="border:1px solid red"></div>
</body>

</html>