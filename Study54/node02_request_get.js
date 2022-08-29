//1. 웹서비스 객체 생성
var http = require('http');
const { URLSearchParams} = require('url');
//2. 서버생성 및 구현
http.createServer(function(request, response){
    //get방식으로 전송된 데이터를 서버에서 받기
    let data = new URLSearchParams(request.url.substring(2));
    console.log(data);

    response.writeHead(200, {"Content-Type":"text/html; charset=UTF-8"});
    response.write("<h1>서버에서 받은 데이터</h1>");
    response.write("<ul><li>이름=" +data.get("username")+"</li>");
    response.write("<li>연락처="+data.get("tel")+"</li>");
    response.write("<li>나이="+ (parseInt(data.get("age"))+10)+"</li>");
    response.write("</ul>");

    //post방식접속을 위한 폼 만들기
    response.write("<hr/><form method='post' action='http://localhost:10001'>");
    response.write("아이디: <input type='text' name='userid'/><br/>");
    response.write("비밀번호 : <input type='password' name='userpwd'/><br/>");
    response.write("이름 : <input type='text' name='username'/><br/>");
    response.write("<input type='submit' value='노드에서 post방식으로 데이터 전송하기'/>");
    response.end("</form>");

}).listen(10000, function(){//3. 접속대기
    console.log("server start... http://127.0.0.1:10000?username=홍길동&tel=010-7777-8888&age=25");
});




