<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="//cdn.ckeditor.com/4.19.1/full/ckeditor.js"></script>
<style>
	.del{
		cursor:pointer;
	}
</style>
<script>
	$(function(){
		CKEDITOR.replace("content");
		//첨부파일 수정
		
		$(".del").click(function(){
			//기본 파일명 숨기기
			$(this).parent().css("display", "none");
			//새로 첨부가능하도록 file컴퍼넌 만들기
			$(this).parent().next().attr("type","file");
			//삭제된 파일명을 서버로 보내기 위해서 name속성을 설정한다.
			$(this).parent().next().next().attr("name","delFile");
			//남은 파일의 수를 감소시킨다.
			$("input[name=fileCount]").val($("input[name=fileCount]").val()-1);
		});
		
		
		
		
		$("#dataFrm").submit(function(){
			if($("#title").val()==""){
				alert("제목을 입력하세요.");
				return false;
			}
			if(CKEDITOR.instances.content.getData()==""){
				alert("글내용을 입력하세요.");
				return false;
			}
			
			var fileCount = $("input[name=fileCount]").val(); //선택한 첨부파일의 갯수
			if($("#filename1").val() !=""){
				fileCount++;
			}
			if($("#filename2").val() !=""){
				fileCount++;
			}
			if(fileCount<1){
				alert("첨부파일을 반드시 1개 이상 선택하여야 합니다.");
				return false;
			}
			return true;
		});
		
		
	});
</script>
<div class="container">
	<h1>자료실 글 수정</h1>
	<!-- form안에 파일 첨부가 있을 경우 form태그에는 반드시 enctype="multipart/form-data"가 기술되어야 한다. -->
	<form method="post" action="/data/dataEditFormOk" id="dataFrm" enctype="multipart/form-data">
		<input type="hidden" name="no" value="${vo.no }"/>
		
		<ul>
			<li>제목</li>
			<li><input type="text" name="title" id="title" style="width:80%" value="${vo.title }"/></li>
			<li>글내용</li>
			<li><textarea name="content" id="content">${vo.content }</textarea></li>
			<li>첨부파일</li>
			<li>
				<!-- 첫번째 첨부파일 -->
				<div>
					<!-- 현재 있는 파일명 -->
					<div>${vo.filename1 } <b class="del">X</b></div>
					<!-- 파일명을 삭제시 새로운 파일을 첨부 할 수 있도록 표시 -->
					<input type="hidden" name="filename" id="filename1"/>
					<!-- 삭제한 경우 삭제 파일명을 보관할 컴퍼넌트 -->
					<input type="hidden" name="" value="${vo.filename1 }"/>
				</div>
				<!-- 두번째 첨부파일 -->
				<div>
					<!-- 첨부파일이 있을때 -->
					<c:if test="${vo.filename2!=null && vo.filename2!='' }">
						<div>${vo.filename2 }&nbsp;<b class="del">X</b></div>
						<input type="hidden" name="filename" id="filename2"/>
						<input type="hidden" name="" value="${vo.filename2 }"/>
						<!-- 첨부파일의 갯수 -->
						<input type="hidden" name="fileCount" value="2"/>
					</c:if>
					<!-- 첨부파일이 없을때 -->
					<c:if test="${vo.filename2==null || vo.filename2=='' }">
						<input type="file" name="filename" id="filename2"/>
						<input type="hidden" name="fileCount" value="1"/>
					</c:if>
				</div>
			</li>
			<li><input type="submit" value="자료실 글수정하기"/></li>
		</ul>	
	</form>		
</div>
