<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	#view li{
		border-bottom:1px solid #ddd;
		margin:10px 0 10px;
	}
</style>
<script>
	function boardDel(){
		// alert() -> 확인
		// confirm() -> 확인(true), 취소(false)
		// prompt() -> 데이터를 입력할 수 있다.
		if(confirm("삭제하시겠습니까?")){
			location.href="/myapp/board/del?no=${viewVO.no}";//삭제
		}
	}
</script>
<div class="container">
	<h1>글내용보기</h1>
	<ul id="view">
		<li>번호 : ${viewVO.no }</li>
		<li>작성자 : ${viewVO.userid }</li>
		<li>등록일 : ${viewVO.writedate }, 조회수 : ${viewVO.hit }</li>
		<li>제목: ${viewVO.subject }</li>
		<li>
			${viewVO.content }
		</li>
	</ul>
	
	<div>
		<c:if test="${logId==viewVO.userid }"><!-- 현재글쓴이와 로그인 아이디 같을 때 수정,삭제 되도록 설정 -->
			<a href="/myapp/board/edit?no=${viewVO.no}">수정</a>
			<a href="javascript:boardDel()">삭제</a>
		</c:if>
	</div>
</div>
