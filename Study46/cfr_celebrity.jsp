<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

<style>
</style>

<script>
	$(function(){
		$("#fileupload").submit(function(){
			event.preventDefault();
			
			if($("#image").val()==""){
				alert("이미지 파일을 선택하세요..");
				return;// return false해도 된다. 
			}
			
			//폼을 객체로 만들어서 보낸다.
			var data = new FormData($("#fileupload")[0]);
			
			//Ajax 폼을 데이터를 받는다 
			$.ajax ({
				url: "/clova/cfr_celebrity_ok",
				type: "post",
				async: false, //비동기식
				processData:false,
				contentType:false,
				data:data,
				dataType:"text",
				success: function(result){
					
					$("#txt").val(result);
					
					var jsonParse = JSON.parse(result);//제이슨으로 바꾼다. 
					
					var tag = "<table class='table table-dark'>";
					tag += "<tr><td>번호</td><td>이름</td><td>정확도</td><tr/>";
					
					jsonParse.faces.map(function(f, i){
						tag += "<tr><td>"+(i+1)+"</td>";
						tag += "<td>"+ f.celebrity.value+"</td>";
						tag += "<td>"+ parseInt(f.celebrity.confidence*100) + "%</td></tr>"
					});
					tag +="</table>";
					console.log(tag);
					$("body").append(tag);
				},error:function(e){
					console.log(e.responseText);
				}
			});
		});
	});
</script>

</head>

<body>

	<h2>유명인 얼굴 인식 API</h2>
	<pre>입력받은 이미지로부터 얼굴을 감지하고 감지한 얼굴이 어떤 유명인과 닮았는지 분석하여 그 결과를 반환하는 REST API입니다. 이미지에서 다음과 같은 정보를 분석합니다.
		감지된 얼굴의 수
		감지된 각 얼굴을 분석한 정보
		닮은 유명인 이름
		해당 유명인을 닮은 정도
	</pre>
	
	<form method="post" enctype="multipart/form-data" id="fileupload">
		이미지 선택 : <input type="file" name="image" id="image"/>
		<input type="submit" value="확인하기"/>
	</form>
	<textarea id="txt" style="width:600px; height:300px;"></textarea>
	
</body>

</html>