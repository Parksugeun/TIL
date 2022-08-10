<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Black+And+White+Picture&family=Black+Han+Sans&family=Cute+Font&family=Do+Hyeon&family=Dokdo&family=East+Sea+Dokdo&family=Gaegu&family=Gamja+Flower&family=Gothic+A1&family=Gugi&family=Hi+Melody&family=Jua&family=Kirang+Haerang&family=Nanum+Brush+Script&family=Nanum+Gothic&family=Nanum+Gothic+Coding&family=Nanum+Myeongjo&family=Nanum+Pen+Script&family=Noto+Sans+KR&family=Noto+Serif+KR&family=Poor+Story&family=Single+Day&family=Song+Myung&family=Stylish&family=Sunflower:wght@300&family=Yeon+Sung&display=swap" rel="stylesheet">
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
		
		//여러개를 삭제하도록
		$("#multiDel").click(function(){
			//체크 갯수 확인
			var countChk = 0;		//						
			$("#community input[name=noList]").each(function(idx, obj){
				if(obj.checked){
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
	<h1>자유게시판</h1>
	
	<div id="board">		
		<!--  
		<div>
			<h6>${pVO.totalPage }/${pVO.nowPage }, 총레코드 수 :  ${pVO.totalRecord}</h6>
		</div>
		-->
		<div>
		<input type="button" value="선택삭제" id="multiDel" style="margin:15px;"/> <!-- 게시글 삭제버튼 -->
		</div>
		
		<form method="post" action="/community/multiDel" id="listFrm">
			<ul id="community">
				<li><input type="checkbox" id="allChk"/></li>
				<li>번호</li>
				<li>제목</li>
				<li>닉네임</li>   
				<li>조회수</li>
				<li>작성일</li>
				
				<c:forEach var="vo" items="${list }">
				<li><input type="checkbox" name="noList" value="${vo.no}"/></li>
				<li>${vo.no }</li>
				<li><a href="/community/communityView?no=${vo.no }&nowPage=${pVO.nowPage}<c:if test='${pVO.searchWord!=null}'>&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}</c:if>">${vo.subject }</a></li>
				<li>${vo.nickname }</li>
				<li>${vo.hit }</li>
				<li>${vo.writedate }</li>
				</c:forEach>
				
			</ul>
		<!--	<table class="table table-hover">
			 	 <thead>
				    <tr>
				      <th scope="col">번호</th>
				      <th scope="col">제목</th>
				      <th scope="col">닉네임</th>
				      <th scope="col">조회수</th>
				      <th scope="col">작성일</th>
				    </tr>
			 	 </thead>
			  <tbody>
			  	
			    <tr>
			      <c:forEach var="vo" items="${list }">
			      <input type="checkbox" name="noList" value="${vo.no}"/>
			      <th scope="row">${vo.no }</th>
			      <td><a href="/community/communityView?no=${vo.no }&nowPage=${pVO.nowPage}<c:if test='${pVO.searchWord!=null}'>&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}</c:if>">${vo.subject }</a></td>
			      <td>${vo.nickname }</td>
			      <td>${vo.hit }</td>
			      <td>${vo.writedate }</td>
			      </c:forEach>
			    </tr>
			  </tbody>
			
			 </table>-->
		</form>
		
		<div>
			<ul id="page">
		
			<!-- 페이지 번호 -->
				<c:if test="${pVO.nowPage<=1 }"> <!-- 이전페이지가 없을때 -->
					<li>prev</li>
				</c:if>
				<c:if test="${pVO.nowPage>1 }"> <!-- 이전페이지가 있을때 -->
					<li><a href="/community/communityList?nowPage=${pVO.nowPage-1 }<c:if test='${pVO.searchWord!=null}'>&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}</c:if>">prev</a></li>
				</c:if>
				
				<c:forEach var="p" begin="${pVO.startPage }" end="${pVO.startPage+pVO.onePageCount-1 }">
					<!--  출력할 페이지번호 총페이지수 보다 작거나 같을 떄 -->
					<c:if test="${p<=pVO.totalPage }">
						<li
						<c:if test="${p==pVO.nowPage }">
							style="background-color:#F98169;color:#fff;"
						</c:if>
						><a href="/community/communityList?nowPage=${p}<c:if test='${pVO.searchWord!=null}'>&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}</c:if>">${p}</a></li>
					</c:if>
				</c:forEach>
				
				<c:if test="${pVO.nowPage==pVO.totalPage }">
					<li>next</li>
				</c:if>
				<c:if test="${pVO.nowPage<pVO.totalPage }">
					<li><a href="/community/communityList?nowPage=${pVO.nowPage+1 }<c:if test='${pVO.searchWord!=null}'>&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}</c:if>">next</a></li>
				</c:if>
				
			</ul>
		
		
			<div id="listsearch">
				<form method="get" action="/community/communityList" id="searchFrm">
					<select name="searchKey" id="sk">
						<option value="subject">제목</option>
						<option value="nickname">닉네임</option>
						<option value="content">글내용</option>
					</select>
					<input type="text" name="searchWord" id="searchWord"/>
					<input type="submit" value="Search" id="sc"/>
					
				</form>	
			</div>
			<div id="write">
				<input type="button" class="button" value="글쓰기" id="comwrite" onclick="location.href='/community/communityForm'"/>
			</div>
	 	</div>
	</div>
</div>