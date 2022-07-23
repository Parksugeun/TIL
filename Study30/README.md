# ajax

AJAX란, JavaScript의 라이브러리중 하나이며 Asynchronous Javascript And Xml(비동기식 자바스크립트와 xml)의 약자이다. 브라우저가 가지고있는 XMLHttpRequest 객체를 이용해서 전체 페이지를 새로 고치지 않고도 페이지의 일부만을 위한 데이터를 로드하는 기법 이며 **JavaScript를 사용한 비동기 통신, 클라이언트와 서버간에 XML 데이터를 주고받는 기술**이다.

(댓글작성같은 곳에서 주로 사용됌)

ajax : 화면을 유지하면서, 화면전환이 이루어지지 않으면서 특정한 정보를 가져온다음 새롭게 꾸며주는 기능을 한다.   (비동기식)

a j(javascript) a x(xml)

jquery로도 구현이 가능하고 spring이나 jsp에서 사용 가능하다.

1. 객체 생성
		var xHttp = new XMLHttpRequest(); //웹서버와 통신하는 객체를 생성한다.
		
2. 서버에서 데이터가 넘어오면 전송받을 기능 구현 (이벤트로 처리됌)
	서버에서 정보가 오면 이벤트에 의해서 실행되는 함수
	전송결과 확인할 수 있는 변수
	readystate : XMLHttpRequest의 처리결과를 가지고 있다.
	0:초기화실패, 1:서버연결, 2:요청이 접수, 3:처리요청 , 4:요청이 완료됨
	status : 요청처리 상태 번호를 반환
	200:정상처리, 403:금지, 404:찾을 수 없음
	statusText : 'OK', 'Not Found'
	responseText : 실행결과 값 -> 서버에서 전송받은 내용이 있는 변수
1. 객체열기
		//		 전송방식,가져올 데이터파일명,동기식(false:화면이새로플레이)or 비동기식(true:화면을그대로가져오겠다.)
		xHttp.open('GET','abcd.txt',true);
4. 객체를 보냄 : 실제서버에 접속
		xHttp.send(); // 서버에 정보를 요청함.




