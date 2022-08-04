<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
	function boardDel(){
		if(confirm("글을 삭제하시겠습니까?")){
			location.href="/board/boardDel?no=${vo.no}";
		}
	}
</script>
<div class="container">
	<h1>글내용보기</h1>
	<ul>
		<li>번호</li>
		<li>${vo.no }</li>
		<li>작성자</li>
		<li>${vo.userid }</li>
		<li>제목</li>
		<li>${vo.subject }</li>
		<li>조회수 : ${vo.hit }, 등록일 : ${vo.writedate }</li>
		<li>글내용</li>
		<li>${vo.content}</li>
	</ul>
	<div>
		<a href="/board/boardList?nowPage=${pVO.nowPage }<c:if test='${pVO.searchWord!=null }'>&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}</c:if>">목록</a>
		<c:if test="${vo.userid==logId}">
			<a href="/board/boardEdit/${vo.no }">수정</a>
			<a href="javascript:boardDel();">삭제</a>
		</c:if>	
	</div>	
</div>
