<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
	#listView li{
		float:left; width:8%; line-height:43px; border-bottom:1px solid #ddd;
		white-space:nowrap; overflow:hidden; text-overflow:ellipsis;
	}
	#listView li:nth-child(7n+2){width:52%;}
</style>
<script>
	$(function(){
		$("#listView img[src='/img/disk.jfif']").click(function(){
			var no = $(this).attr('alt'); //레코드 번호 
			var countObj = $(this).parent().parent().prev().prev();//다운로드 횟수를 바꿀 li
			
			$.ajax({
				url:'/data/downCountUpdate',
				data: "no="+no,
				success:function(down){
					countObj.text(down);
				},error:function(e){
					console.log(e.responseText);
				}
			});
		});
	});
</script>
<div class="container">
	<h1>자료실 목록</h1>
	<div>
		<a href="/data/dataWrite">자료실 글쓰기</a>
	</div>
	<div id="listView">
		<ul>
			<li>번호</li>
			<li>제목</li>
			<li>글쓴이</li>
			<li>down</li>
			<li>조회수</li>
			<li>첨부파일</li>
			<li>등록일</li>
			
			<c:forEach var="vo" items="${dataList}">
				<li>${vo.no }</li>
				<li><a href="dataView/${vo.no}">${vo.title }</a></li>
				<li>${vo.userid}</li>
				<li>${vo.downcount }</li>
				<li>${vo.hit }</li>
				<li>
					<a href="/upload/${vo.filename1 }" title="${vo.filename1 }" download><img src="/img/disk.jfif" height="27" alt="${vo.no }"/></a>
					<c:if test="${vo.filename2!=null && vo.filename2!='' }">
						<a href="/upload/${vo.filename2 }" title="${vo.filename2 }" download><img src="/img/disk.jfif" height="27" alt="${vo.no }"/></a>
					</c:if>
				</li>
				<li>${vo.writedate }</li>
			</c:forEach>	
		</ul>
	</div>	
</div>
