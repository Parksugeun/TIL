<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
	#mFrm li{
		float:left; height:40px; line-height:40px; border-bottom:1px solid #ddd; width:30%
	}
	#mFrm li:nth-child(2n){ width:70%}
	#mFrm li:last-of-type{width:100%; text-align:center;}
</style>
<script>
	$(function(){
		// https://www.koreapost.go.kr/
		//우편번호 찾기
		$("#zipSearch").click(function(){
			window.open("/member/zipSearch","zipcode","width=500, height=600");
		});
		//유효성검사
		$("#mFrm").submit(function(){		
			//비밀번호
			if($("#userpwd").val()==""){
				alert("비밀번호를 입력하세요.");
				return false;
			}	
			//연락처
			if($("#tel1").val()=="" || $("#tel2").val()=="" || $("#tel3").val()==""){
				alert("연락처를 입력하세요...");
				return false;
			}
			return true;
		});
	});
</script>
<div class="container">
	<h1>회원정보수정</h1>
	<form method="post" action="/member/memberEditOk" id="mFrm">
		<ul>
			<li>아이디</li>
			<li><input type="text" name="userid" id="userid" value="${vo.userid }" readonly/></li>
			<li>비밀번호</li>
			<li><input type="password" name="userpwd" id="userpwd"/></li>
			<li>이름</li>
			<li><input type="text" name="username" id="username" value="${vo.username}" readonly/></li>
			<li>연락처</li>
			<li><input type="text" name="tel1" id="tel1" size="4" value="${vo.tel1 }"/>-
				<input type="text" name="tel2" id="tel2" size="4" value="${vo.tel2 }"/>-
				<input type="text" name="tel3" id="tel3" size="4" value="${vo.tel3 }"/></li>
			<li>이메일</li>
			<li><input type="text" name="email" id="email" value="${vo.email }"/></li>
			<li>우편번호</li>
			<li><input type="text" name="zipcode" id="zipcode" value="${vo.zipcode }"/>
				<input type="button" value="우편번호찾기" id="zipSearch"/></li>
			<li>주소</li>
			<li><input type="text" name="addr" id="addr" value="${vo.addr }" style="width:90%"/></li>
			<li>상세주소</li>
			<li><input type="text" name="detailaddr" id="detailaddr" value="${vo.detailaddr }"/></li>
			<li>
				<input type="submit" value="회원정보수정하기"/>
				<input type="reset" value="다시쓰기"/>
			</li>
		</ul>
	</form>	
</div>
