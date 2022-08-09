-el표현식
- a 태그 <a href="주소" title="네이트로가요" target="_blank"> 네이트 </a>
-javascript 함수 생성하는 방법 
function 함수명( ){ }   
함수명( )=>{ }  
var a = ( ) =>{ }       익명의 함수선언 하는것 

-html sementic 태그 
header, footer, nav, section, main article, aside, tbody, thead, tfoot, figure, figcaption, mark details. summary time
-웹에서 클라이언트 측과 서버측에 정보를 저장할 수 있는 내장객체
               cookie                  session
-jquery 표기법
$(document).ready(function(){
});
Jquery(document).ready(function(){
});
$(function(){
});
$(()=>{
};
-css 선택자
#A>div: nth- child(2)
#A div: nth- of type(2)
-spring 컨트롤러
접속을 받는다.(서살 dispatch survlet이 받음)
restcontroller 나 conroller이 서버로 데이터를 request, view페이지, 서버에서 클라이언트 정보보내기
-유효성 검사 아이디가 있나없나 
$("#log").submit(function(){
			if($("#userid").val()==""){
				alert("아이디를 입력하세요..");
                                                $("#userid").value=""; 초기화
                                                 $("#userid").focus();
				return false;
			}
커서를 원하는 쪽에 옮겨놓는 것 focus 

if(document.getElementById("userid").value==""){
                alert("아이디를 입력하세요..");
    
                document.getElementById("userid").focus();
                 return false;
}
if(document.getElementById("userid").value.length<8 || document.getElementById("userid").value.length>12){
                alert("아이디를 입력하세요..");
                document.getElementById("userid").value=""; 초기화
                document.getElementById("userid").focus();
                 return false;
}
-ajax 에서 url data type success등이 무엇을 뜻하는 지 알고 있으면 됌

- 로그인 하기(백엔드)
 세션에다 넣기 위해서 리퀘스트도가능  코드에 대해 이해하고 있으면 된다.

-mybatis 쿼리문 구현하는 방법
parameteType="int" 속성을 써줌 
VO클래스는 반드시 가르켜 줘야함 
