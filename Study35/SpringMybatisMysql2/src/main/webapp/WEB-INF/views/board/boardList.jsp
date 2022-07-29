<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	#list{overflow:auto;}
	#list>li{
		float:left; height:40px; line-height:4-px; border-bottom:1px solid #ddd; width:10%;
		/*말줄임*/
		/*자리가 모자라도 줄 바꾸지 않도록 설정*/
		white-space:nowrap;
		/*넘친 데이터 안보이도록*/
		overflow:hidden;
		/*넘친 데이터는 줄임말(...)표시하기*/
		text-overflow:ellipsis;
	}
	#list>li:nth-child(5n+2){width:60%;}
</style>
<div class="container">

	<h1>게시판 리스트</h1>
	
	<!-- 로그인된 경우 -->
	<c:if test="${logStatus=='Y'}">
		<div><a href="/myapp/board/write">글쓰기</a></div>
	</c:if>
	
	<ul id="list">
		<li>번호</li>
		<li>제목</li>
		<li>글쓴이</li>
		<li>조회수</li>
		<li>등록일</li>
		
		<c:forEach var="vo" items="${list }"><!-- vo, vo, vo, .... -->
			<li>${vo.no}</li>
			<li><a href="/myapp/board/view?no=${vo.no}">${vo.subject}</a></li>
			<li>${vo.userid}</li>
			<li>${vo.hit}</li>
			<li>${vo.writedate}</li>
		</c:forEach>
		
	</ul>
	
</div>



