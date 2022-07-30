<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function(){
		// 문자열 받아오기//////////////////
		$("#ajaxString").click(function(){
			//비동기식으로 서버에 접속하여 문자열을 결과로 리턴받는다.
			//ajax구현
			var url = "/home/ajaxString";
			var params = "num=123&name=세종대왕&tel=010-7879-9999";
			$.ajax({
				url : url,
				data : params,
				type : "GET",
				success:function(result){
					$("#view").append(result);
				},
				error:function(e){
					console.log(e.responseText);
				}
			});
		});
		//객체 받아오기  ///////////////////////////
		$("#ajaxObject").click(function(){
			
			$.ajax({
				url : "/home/ajaxObject",
				data : "num=568&username=이순신",
				type: "GET",
				success: function(obj){
					var tag = "<ol>";
					tag += "<li>번호 = "+obj.no+"</li>";
					tag += "<li>이름 = "+obj.username+"</li>";
					tag += "<li>연락처 = "+obj.tel+"</li>";
					tag += "<li>주소 = "+obj.addr+"</li></ol>";
					
					$("#view").append(tag);
				},
				error:function(){
					console.log("에러발생...");
				}
			});
		});
		// List객체 얻어오기
		$("#ajaxList").click(function(){
			$.ajax({
				url : "/home/ajaxList",
				success:function(result){
					var tag = "<ul>";
					
					//컬렉션 List를 반복문을 돌리기 위해서는 컬렉션이 변수를 선택자로 지정해야 한다.
					var $result = $(result);
					
					$result.each(function(idx, vo){
						tag += "<li>"+ vo.no + ","+ vo.username+","+ vo.tel+","+vo.addr+"</li>";
					});
					
					tag += "</ul>";
					$("#view").append(tag);
					
				},error:function(){
					console.log("List에러...");
				}
			});
		});
		// Map
		$("#ajaxMap").click(function(){
			$.ajax({
				url:"/home/ajaxMap",
				success:function(result){
					var tag = "<ul>"
					tag += "<li>"+ result.m1.no+","+result.m1.username+","+result.m1.tel+","+result.m1.addr+"</li>";
					tag += "<li>"+ result.m2.no+","+result.m2.username+","+result.m2.tel+","+result.m2.addr+"</li>";
					tag += "<li>"+ result.m3.no+","+result.m3.username+","+result.m3.tel+","+result.m3.addr+"</li>";
					tag += "</ul>";
					$("#view").append(tag);
				},error:function(){
					console.log("에러발생..");
				}
			});
		});
		// ajax를 이용하여 서버로 json데이터 보내기
		//		 클라이언트 json형식을 문자열 보내기
		$("#ajaxJson").click(function(){
			var url = "/home/ajaxJson";
			var jsonData = {
					num : 100,
					name : "홍길동",
					tel : "010-5656-8989"		
			}
			$.ajax({
				url:url,
				type:"GET",
				data:jsonData,
				dataType:"json",
				success:function(result){
					//json데이터로 받아짐.
					console.log(result);
					//문자열을 json으로 바꾸는 작업
					var jsonString = JSON.stringify(result);//json을 문자화
					console.log(jsonString);
					var json = JSON.parse(jsonString);//문자를 json으로
					console.log(json);
					
					var tag = "<ul>";
					tag += "<li>코드 : "+ result.code+"</li>";
					tag += "<li>상품명 :"+ result.productName+"</li>";
					tag += "<li>가격 :"+ result.price+"</li></ul>";
					$("#view").append(tag);
				},
				error:function(e){
					console.log(e.responseText);
				}
			});
		});
		
		$("#frm").submit(function(){
			//form태그는 action의 주소로 이동하는 기능이 있는 것을 제거한다.
			event.preventDefault();
			
			//	num=54&username=홍길동
			//var params = "num="+$("#num").val()+"&username="+$("#username").val();
			var params = $("#frm").serialize(); //폼의 값을 전송데이터로 만들어주는 기능
			
			$.ajax({
				url:"/home/ajaxForm",
				type:"POST",
				data:params,
				success:function(result){
					$("#view").append("<p>"+result+"</p>");		
				},
				error:function(error){
					console.log	(error.responseText)
				}
			});
		});
	});
</script>
</head>
<body>
<h1>비동기식으로 controller에 접속하여 정보를 리턴 받는다.</h1>
<button id="ajaxString">ajax 문자열</button>
<button id="ajaxObject">ajax 객체</button>
<button id="ajaxList">ajax List</button>
<button id="ajaxMap">ajax Map</button>
<button id="ajaxJson">ajax Json</button><br/>
<form method="post" id="frm">
	번호 : <input type="text" name="num" id="num"/><br/>
	이름 : <input type="text" name="username" id="username"/><br/>
	<input type="submit" value="전송하기"/><br/>
</form>

<hr/>
<div id="view" style="border:1px solid gray;"></div>
</body>
</html>