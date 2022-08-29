// 노드js : 이벤트기반 서버 프레임 워크이다.
// 프로젝트 : dos>npm init -y
// 실행 : 터미널>node 파일명.js
////////////////////////////////
//1. 웹서버를 생성하기 위해서는 http모듈을 객체 생성하여야 한다.
var http = require("http");

//2. http를 이용하여 서버프로그램을 구현한다.
var server = http.createServer(function(request, response){
    // request: 클라이언트 측에 서버로 정보 보내기
    // response: 서버에서 클라이언트 측으로 정보 보내기
    //1). response에 head정보 설정
    response.writeHead(200, {"Content-Type":"text/html;charset=utf-8"});
    //2). response에 컨텐츠 보내기
    response.write("<html><head><title>처음으로 하는 노드</title></head>");
    response.write("<body>");
    response.write("<h1>노드 start</h1>");
    response.write("<p>이벤트 기반 서버 프레임워크</p>");
    //3). response에 응답의 마지막을 표기하여야 한다. 
    response.end("<b>끝!!!</b>"); 
});

//3. 클라이언트의 접속을 대기하는 함수
server.listen(3000, "localhost", function(){
    console.log("server in running... http://localhost:3000");
});