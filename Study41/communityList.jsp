<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
	/*목록*/
	#community, #page{overflow:auto;}
	#community li{
		float:left; line-height:40px; border-bottom:1px solid #ddd; width:10%;
	}
	#community li:nth-child(6n+1){ width:5%;}
	#community li:nth-child(6n+3){ 
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
			$("#community input[type=checkbox]").prop("checked",$("#allChk").prop("checked"));
		});
		
		//선택된 갯수를 구하여 여러개를 삭제하도록 한다.
		$("#multiDel").click(function(){
			//체크 갯수 확인
			var countChk = 0;		//						 input, input, input...
			$("#community input[name=noList]").each(function(idx, obj){
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
	<h1>자유게시판 리스트</h1>
		<div>
			<a href="/community/communityForm">글쓰기</a>
		</div>	
		<div>
			${pVO.totalPage }/${pVO.nowPage }, 총레코드 수 :${pVO.totalRecord}
		</div>
		<div>
		<input type="button" value="선택삭제" id="multiDel"/> <!-- 게시글 삭제버튼 -->
	</div>
		<form method="post" action="/community/multiDel" id="listFrm">
		<ul id="community">
			<li><input type="checkbox" id="allChk"/></li>
			<li>번호</li>
			<li>제목</li>
			<li>닉네임</li>
			<li>조회수</li>
			<li>등록일</li>
			
			<c:forEach var="vo" items="${list }">
			<li><input type="checkbox" name="noList" value="${vo.no}"/></li>
			<li>${vo.no }</li>
			<li><a href="/community/communityView?no=${vo.no }&nowPage=${pVO.nowPage}<c:if test='${pVO.searchWord!=null}'>&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}</c:if>">${vo.subject }</a></li>
			<li>${vo.nickname }</li>
			<li>${vo.hit }</li>
			<li>${vo.writedate }</li>
			</c:forEach>
			
		</ul>
	</form>
	
	<div>
		<form method="get" action="/community/communityList" id="searchFrm">
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
