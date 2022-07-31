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
		$("#idChk").click(function(){
			window.open("/member/idCheck?userid="+$("#userid").val(),"idchk","width=400, height=300");
		});
		
		$("#userid").change(function(){
			$("#idCheckState").val("N");
		});
		
		// https://www.koreapost.go.kr/
		//우편번호 찾기
		$("#zipSearch").click(function(){
			window.open("/member/zipSearch","zipcode","width=500, height=600");
		});
		//유효성검사
		$("#mFrm").submit(function(){
			//아이디
			if($("#userid").val()==""){
				alert("아이디를 입력하세요..");
				return false;
			}
			// 아이디 중복검사여부
			if($("#idCheckState").val()!='Y'){
				alert("아이디를 중복검사하세요");
				return false;
			}
			//비밀번호
			if($("#userpwd").val()==""){
				alert("비밀번호를 입력하세요.");
				return false;
			}
			if($("#userpwd").val() != $("#userpwd2").val()){
				alert("비밀번호가 일치하지 않습니다.");
				return false;
			}
			//이름
			if($("#username").val()==""){
				alert("이름을 입력하세요..");
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
	<h1>회원등록</h1>
	<form method="post" action="/member/memberWrite" id="mFrm">
		<ul>
			<li>아이디</li>
			<li><input type="text" name="userid" id="userid"/>
				<input type="button" value="아이디중복검사" id="idChk"/>
				<input type="hidden" id="idCheckState" value="N"/>
				</li>
			<li>비밀번호</li>
			<li><input type="password" name="userpwd" id="userpwd"/></li>
			<li>비밀번호확인</li>
			<li><input type="password" name="userpwd2" id="userpwd2"/></li>
			<li>이름</li>
			<li><input type="text" name="username" id="username"/></li>
			<li>연락처</li>
			<li><input type="text" name="tel1" id="tel1" size="4"/>-
				<input type="text" name="tel2" id="tel2" size="4"/>-
				<input type="text" name="tel3" id="tel3" size="4"/></li>
			<li>이메일</li>
			<li><input type="text" name="email" id="email"/></li>
			<li>우편번호</li>
			<li><input type="text" name="zipcode" id="zipcode"/>
				<input type="button" value="우편번호찾기" id="zipSearch"/></li>
			<li>주소</li>
			<li><input type="text" name="addr" id="addr" style="width:90%"/></li>
			<li>상세주소</li>
			<li><input type="text" name="detailaddr" id="detailaddr"/></li>
			<li>
				<input type="submit" value="회원가입하기"/>
				<input type="reset" value="다시쓰기"/>
			</li>
		</ul>
	</form>	
</div>
