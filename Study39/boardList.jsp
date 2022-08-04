<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
	/*목록*/
	#board, #page{overflow:auto;}
	#board li{
		float:left; line-height:40px; border-bottom:1px solid #ddd; width:10%;
	}
	#board li:nth-child(6n+1){ width:5%;}
	#board li:nth-child(6n+3){ 
		width:55%; white-space:nowrap; overflow:hidden; text-overflow:ellipsis;
	}
	/*페이지*/
	#page li{
		float:left; padding:10px; 
	}
</style>
<script>
	$(function(){
		$("#searchFrm").submit(function(){
			if($("#searchWord").val()==""){
				alert("검색어를 입력하세요.");
				return false;
			}
			return true;
		});
		
		//리스트 전체 선택
		$("#allChk").click(function(){
			$("#board input[type=checkbox]").prop("checked",$("#allChk").prop("checked"));
		});
		
		//선택된 갯수를 구하여 여러개를 삭제하도록 한다.
		$("#multiDel").click(function(){
			//체크 갯수 확인
			var countChk = 0;		//						 input, input, input...
			$("#board input[name=noList]").each(function(idx, obj){
				if(obj.checked){// input 태그가 체크 상태이면 true 아니면 false
					countChk++;
				}			
			});
			console.log(countChk);
			if(countChk<=0){
				alert("삭제할 레코드를 선택후 삭제하세요..");
				return false;
			}
			
			$("#listFrm").submit();
		});
	});
</script>
<div class="container">
	<h1>게시판 리스트</h1>
	<c:if test="${logStatus=='Y' }">
		<div>
			<a href="/board/boardForm">글쓰기</a>
		</div>
	</c:if>	
	<div>
			${pVO.totalPage }/${pVO.nowPage }, 총레코드 수 :${pVO.totalRecord}
	</div>
	<div>
		<input type="button" value="선택삭제" id="multiDel"/>
	</div>
	<form method="post" action="/board/multiDel" id="listFrm">
		<ul id="board">
			<li><input type="checkbox" id="allChk"/></li>
			<li>번호</li>
			<li>제목</li>
			<li>작성자</li>
			<li>조회수</li>
			<li>등록일</li>
			
			<c:forEach var="vo" items="${list }">
			<li><input type="checkbox" name="noList" value="${vo.no}"/></li>
			<li>${vo.no }</li>
			<li><a href="/board/boardView?no=${vo.no }&nowPage=${pVO.nowPage}<c:if test='${pVO.searchWord!=null}'>&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}</c:if>">${vo.subject }</a></li>
			<li>${vo.userid }</li>
			<li>${vo.hit }</li>
			<li>${vo.writedate }</li>
			</c:forEach>
		</ul>
	</form>
	<div>
		<ul id="page">
		<!-- 페이지 번호 -->
			<c:if test="${pVO.nowPage<=1 }"><!-- 이전페이지가 없을때 -->
				<li>prev</li>
			</c:if>
			<c:if test="${pVO.nowPage>1 }"><!-- 이전페이지가 있을때 -->
				<li><a href="/board/boardList?nowPage=${pVO.nowPage-1 }<c:if test='${pVO.searchWord!=null}'>&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}</c:if>">prev</a></li>
			</c:if>
			
			<!--  1      5       1+5-1 = 5 
				 11     15       11+5-1 = 15
			
			-->
			<c:forEach var="p" begin="${pVO.startPage }" end="${pVO.startPage+pVO.onePageCount-1 }">
				<!--  출력할 페이지번호 총페이지수 보다 작거나 같을 떄 -->
				<c:if test="${p<=pVO.totalPage }">
					<li
					<c:if test="${p==pVO.nowPage }">
						style="background-color:#f00;color:#fff;"
					</c:if>
					><a href="/board/boardList?nowPage=${p}<c:if test='${pVO.searchWord!=null}'>&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}</c:if>">${p}</a></li>
				</c:if>
			</c:forEach>
			
			<!-- 다음페이지 -->
			<c:if test="${pVO.nowPage==pVO.totalPage }">
				<li>next</li>
			</c:if>
			<c:if test="${pVO.nowPage<pVO.totalPage }">
				<li><a href="/board/boardList?nowPage=${pVO.nowPage+1 }<c:if test='${pVO.searchWord!=null}'>&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}</c:if>">next</a></li>
			</c:if>
		</ul>
	</div>
	<div>
		<form method="get" action="/board/boardList" id="searchFrm">
			<select name="searchKey">
				<option value="subject">제목</option>
				<option value="userid">작성자</option>
				<option value="content">글내용</option>
			</select>
			<input type="text" name="searchWord" id="searchWord"/>
			<input type="submit" value="Search"/>
			
		</form>	
	</div>
</div>
