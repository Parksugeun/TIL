$(function(){
	$("#frm").submit(function(){
		if($("#userid").val()==""){
			alert("아이디를 입력하세요.");
			return false;
		}
		if($("#userpwd").val()==""){
			alert("비밀번호를 입력하세요..");
			return false;
		}
		return true;	
	});
});