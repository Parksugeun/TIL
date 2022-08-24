<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function(){
		$("#query").click(function(){
			if($("#queryin").val()!=""){//질문이 있을 때
				
				$.ajax({
					type:"post",
					dataType:"text",
					async:false,
					url:"/clova/chatbotOk",
					data:{
						queryin:$("#queryin").val()
					},success:function(result){
							
						$("#jsonCode").val(result);
						
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
<h2>Chatbot</h2>
<div id="content" style="width:100%; height:400px; border:1px solid #ddd;"></div>
<input type="text" name="queryin" id="queryin"/>
<input type="button" value="query" id="query"/>
<textarea id="jsonCode" style="width:100%; height:300px;"></textarea>
</body>
</html>