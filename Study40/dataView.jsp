<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
	.container li{border-bottom:1px solid #ddd;}
</style>
<script>
	$(function(){
		$(".down a").click(function(){
		
			
			$.ajax({
				url:"/data/downCountUpdate",
				data : "no=${dataVO.no}",
				success:function(result){
					$("#dCount").text(result);
				},error:function(){
					console.log(e.responseText);
				}
			});
		});
	});
	function dataDel(){
		if(confirm("삭제하시겠습니까?")){
			location.href = "/data/dataDelete/${dataVO.no}";
		}
	}
</script>
<div class="container">
	<h1>글내용보기</h1>
	<ul>
		<li>번호</li>
		<li>${dataVO.no}</li>
		<li>작성자</li>
		<li>${dataVO.userid}</li>
		<li>조회수 : ${dataVO.hit}, 다운횟수 :<span id="dCount"> ${dataVO.downcount}</span>, 등록일 : ${dataVO.writedate}</li>
		<li class="down">첨부파일 :
				<a href="/upload/${dataVO.filename1 }" download>${dataVO.filename1 }</a>
				<c:if test="${dataVO.filename2!=null && dataVO.filename2!='' }">
					, <a href="/upload/${dataVO.filename2 }" download>${dataVO.filename2 }</a>
				</c:if>
		</li>
		<li>제목</li>
		<li>${dataVO.title }</li>
		<li>글내용</li>
		<li>${dataVO.content }</li>
		
	</ul>
	<div>
		<!-- 본인 쓴 글일경우 수정, 삭제  -->
		<c:if test="${dataVO.userid==logId}">
			<a href="/data/dataEditForm/${dataVO.no }">수정</a>
			<a href="javascript:dataDel()">삭제</a>
		</c:if>
	</div>
	
</div>
