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
				$("#cfrForm").submit(function(){
					event.preventDefault();//기본 이벤트 제거
					
					if($("#image").val()==""){
						alert("이미지를 선택하세요..");
						return false;
					}else{
						console.log(123);
						//이미지파일이 포함된 폼을 객체로 만들어 서버로 전송한다.
						var form = $("#cfrForm")[0];
						var param = new FormData(form);
						
						$.ajax({
							type:"post",
							dataType:"text",
							url:"/cfrOk",
							async:false,
							processData:false,
							contentType:false,
							data: param,
							success:function(result){
								$("#txt").val(result);
								//문자열을 json으로 변환해준다.
								var jsonData = JSON.parse(result);
								var gender = jsonData.faces[0].gender.value;
									console.log(gender);
							//	$("#view").html(jsonData.faces[0].gender.value);
									$("#view").html(gender);
							},error:function(e){
								console.log(e.responseText);
							}
						});
					}
				});
			});
		</script>
	</head>
<body>
	<div>
		<h1>얼굴과 관련된 다양한 정보를 제공하는 얼굴 인식 API</h1>
		<p>입력된 비전 데이터를 통해 얼굴을 인식하거나 얼굴 감지를 이용한 애플리케이션을 만들 때 유용한 API 서비스입니다. 
		이미지 속의 얼굴과 가장 닮은 유명인을 찾거나, 얼굴의 윤곽과 눈/코/입 위치, 표정 값을 얻을 수 있습니다.</p>
		<hr/>	
		<form method="post" enctype="multipart/form-data" id="cfrForm">
			이미지파일선택 : <input type="file" id="image" name="image"/><br/>
			<button id="cfr">확인하기</button>
			<input type="submit" value="Ok"/>
			<input type="image" src=""/>
		</form>
		<hr/>
		<textarea id="txt" rows="20" cols="100"></textarea>
	</div>
	<div id="view"></div>
</body>
</html>