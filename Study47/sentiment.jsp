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
	var sentiKor = {
						neutral:'중립',
						positive:'긍정',
						negative:'부정'
					};
	//	sentiKor.neutral
	//	sentiKor[neutral]
	$(function(){
		$("#sentiBtn").click(function(){
			$.ajax({
				type:"post",
				dataType:"text",
				async:false,
				url:"/clova/sentimentOk",
				data: {
					content:$("#content").val()
				},
				success:function(result){
					console.log(result);
					var jsonData = JSON.parse(result); 
					console.log(jsonData);
					
					var tag = "<h2>감정분석결과 :"+ sentiKor[jsonData.analVO.sentiment]+"("+jsonData.analVO.sentiment+")</h2>";
					
					
					$("#sentiResult").append(tag);
					
					tag = "<h3>(중립 : "+ jsonData.analVO.neutral+"%, 긍정 :"+ jsonData.analVO.positive+"%, 부정 :"+ jsonData.analVO.negative+"%)</h3>";
					$("#sentiResult").append(tag);
					
					tag += "<table class='table table-hover'><tr><td>번호</td><td>문장</td><td>감정분석</td><td>중립(%)</td><td>긍정</td><td>부정</td></tr>";
					
					jsonData.list.map(function(vo, idx){
						tag +="<tr><td>"+(idx+1)+"</td>";
						tag +="<td>"+vo.content+"</td>";
						tag +="<td>"+sentiKor[vo.sentiment]+"</td>";
						tag +="<td>"+vo.neutral+"</td>";
						tag +="<td>"+vo.positive+"</td>";
						tag +="<td>"+vo.negative+"</td></tr>";
					});
					$("#sentiResult").append(tag);
					/*상상의 나래 시작
					$("#content").val(result);
					
					
					
					tag += "<table class='table table-striped'>";
					tag += "<tr><td>번호</td><td>문장</td><td>분석결과</td><td>중립</td><td>긍정</td><td>부정</td></tr>";
				
				jsonData.sentiment.map(function(document,sentences){
					tag += "<tr><td>"+(idx+1)+"</td>";
					tag += "<td>"+ sentences.content.value+"</td>";
					if(sentences.sentiment.value=='negative'){
						tag += "<td>부정<td>";
					}else if(sentences.sentiment.value=='positive'){
						tag += "<td>긍정<td>";
					}else if(sentences.sentiment.value=='neutral'){
						tag += "<td>중립<td>";
					}
					if(sentences.confidence==null){
						tag += "<td></td><td></td><td></td>";
					}else{
						tag += "<td>"+ sentences.confidence.neutral+"</td>"
						tag += "<td>"+ sentences.confidence.positive+"</td>"
						tag += "<td>"+ sentences.confidence.negative+"</td>"
					}
				});
				tag += "<table>";
					
					$("#1").html(tag);*/
				},error:function(e){
					console.log(e.responseText);
					
				}
			});	
		});
	});
</script>
</head>
<body>
	<h2>Sentiment API</h2>
	<p>텍스트 데이터를 분석해서 해당 단어/문장/문구 내용의 감정을 분석하는 서비스로 그 결과를 반환하는 HTTP 기반의 REST API입니다.</p>
	글내용
	<textarea name="content" id="content" style="width:600px; height:400px;">
싸늘하다. 가슴에 비수가 날아와 꽂힌다.
한강이 넘치고 풍랑이 부니 기분이 좋다.
행복한 일이 많을 것 같다.
	
서시
죽는 날까지 하늘을 우러러
한 점 부끄럼이 없기를
잎새에 이는 바람에도
나는 괴로워했다.
별을 노래하는 마음으로
모든 죽어가는 것을 사랑해야지
그리고 나한테 주어진 길을
걸어야겠다.
오늘 밤에도 별이 바람에 스치운다.
윤동주 
	
내가 손을 잡을께 너는 힘을 빼도 돼
우리 복사꽃핀 거릴 걷자.
너의 마음이 녹아 우리 밤을 합치면
무너진 달을 세워놓자.
가끔 너의 모습은 봄날의 낮과 밤 같아
따스하다가도 차갑곤 해
또 넌 맑은 하늘에 내리는 소나기 같아
넌 대체 내게 뭐를 원해	
	</textarea><br/>
	<input type="button" id="sentiBtn" value="감정평가(netural:중립, positive:긍정, negative:부정)"/>
	<div id="sentiResult" style="background-color:#ddd"></div>
</body>
</html>