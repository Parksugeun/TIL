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
	$("#summaryStart").click(function(){
		if($("#title").val()=="" || $("#title").val()==""){
			alert("제목과 글 내용을 입력하세요.");
			return false;
		}
		
		$.ajax({
			type:"post",
			dataType:"text",
			async:false,
			url: "/clova/summaryOk",
			data:{
				title:$("#title").val(),
				content:$("#content").val()
			},
			success:function(result){
			
			},error:function(e){
				console.log(e.responseText);
			}
			
		});
	});
});
</script>

</head>

<body>
	<h2>긴 문서를 요약하여 핵심 문장을 알려주는 문서 요약 API</h2>
	제목 : <input type="text" name="title" id="title" value="하루 2000억' 판 커지는 간편송금 시장" style="width:100%"/><br/>
	글내용 : <textarea id="content" name="content" style="width:100%;height:200px;">간편송금 이용금액이 하루 평균 2000억원을 넘어섰다. 한국은행이 17일 발표한 '2019년 상반기중 전자지급서비스 이용 현황'에 따르면 올해 상반기 간편송금서비스 이용금액(일평균)은 지난해 하반기 대비 60.7% 증가한 2005억원으로 집계됐다. 같은 기간 이용건수(일평균)는 34.8% 늘어난 218만건이었다. 간편 송금 시장에는 선불전자지급서비스를 제공하는 전자금융업자와 금융기관 등이 참여하고 있다. 이용금액은 전자금융업자가 하루평균 1879억원, 금융기관이 126억원이었다. 한은은 카카오페이, 토스 등 간편송금 서비스를 제공하는 업체 간 경쟁이 심화되면서 이용규모가 크게 확대됐다고 분석했다. 국회 정무위원회 소속 바른미래당 유의동 의원에 따르면 카카오페이, 토스 등 선불전자지급서비스 제공업체는 지난해 마케팅 비용으로 1000억원 이상을 지출했다. 마케팅 비용 지출규모는 카카오페이가 491억원, 비바리퍼블리카(토스)가 134억원 등 순으로 많았다.</textarea><br/>
	<input type="button" value="문서요약" id="summaryStart"/>
	<hr/>
	<textarea id="resultText" style="width:100%;height:200px;"></textarea>
	<div id="resultString"></div>
</body>

</html>