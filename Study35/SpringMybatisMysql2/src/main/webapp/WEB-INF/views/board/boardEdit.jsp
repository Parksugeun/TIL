<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="//cdn.ckeditor.com/4.19.1/full/ckeditor.js"></script>
<style>
	#subject{width:90%;}
</style>
<script>
	$(function(){
		CKEDITOR.replace("content");
		
		$("#editFrm").submit(function(){
			if($("#subject").val()==""){
				alert("제목을 입력하세요..");
				return false;
			}
			if(CKEITOR.instances.content.getData()==""){
				alert("글내용을 입력하세요..");
				return false;
			}
			return true;
		});
		
	});
</script>
<div class="container">
	<h1>글수정하기</h1>
	<form method="post" action="/myapp/board/editOk" id="editFrm">
		<input type="hidden" name="no" value="${vo.no }"/>
		<ul>
			<li>제목</li>
			<li><input type="text" name="subject" id="subject" value="${vo.subject }"/></li>
			<li>글내용</li>
			<li><textarea name="content" id="content">${vo.content}</textarea></li>
			<li>
				<input type="submit" value="수정하기"/>
				<input type="reset" value="다시쓰기"/>
			</li>
		</ul>
	</form>
</div>
