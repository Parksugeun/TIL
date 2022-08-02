

## Spring MVC 흐름도
<a> 1. lacation href 등 모든 접속(사용자의 요청)을 Dispatcher Servlet이 받아서 (localhost:9090)
	2.  Dispatcher Servle은 URL이나 parameter정보 등을 참고하여 Handler Mapping에게 어떤 Controller가 처리해야 하는지 파악한다. (하나의 요청을 특정한 컨트롤러와 연결하고자 할 때 Dispatcher Servlet은 이를 핸들러 매핑 빈에 의뢰한다.)
	3.  Dispatcher Servlet 컨트롤러를 부를 때 모든 웹 요청 정보가 담긴 HttpServletRequset 타입의 오브젝트를 컨트롤러에게 넘어가는 핸들러 어댑터에 담아서 컨트롤러의 메소드에 전달한다.
	4. 하나 이상의 서비스 객체에 비즈니스 로직 위임 ModelAndView 리턴(컨트롤러가 작업을 하고 최종적으로  Dispatcher Servlet에게 돌려줄 정보는 모델과 뷰이다.)
	5. Dispatcher Servlet이 View객체를 찾기 위한 질의를 ViewResolver에 보내고 리졸버는 View객체를 반환한다. (컨트롤러가 직접 뷰 오브젝트를 리턴할 수도 있지만 보통은 뷰의 논리적인 이름을 리턴 뷰 리졸버가 이를 이용해 뷰 오브젝트를 생성해준다.)
	6. 다시 Servlet이 Model객체를 View에 전달하고 클라이언트에게 돌려줄 최종 결과물을 생성해 달라고 요청한다.
	7. 뷰를 통해 전달받은 최종 결과물은 응답(HttpServletResponse) 오브젝트에 담아 넘긴다.
	인터페이스임에도 Bodardllist를 상속받고 있는 클래스가 있기 때문에 가능한것
	foot-context.xml은 환경설정같은것


스프링은 주소만 넣어주면 framwork가 있는 곳에서 다운

스프링구조의 흐름을 익혀라!

servlet-context.xml 이 파일유형을 자동으로

스프링 버전을 변경하고 
데이터가 서버로 리퀘스트 될 때 한글이 깨지는 경우 해당 파일에 인코딩 선언문을 넣어줬지만 스프링은 web.xml에 넣어준다,

인터페이스에는 추상메소드만 들어갈 수 있다.

컨트롤러, 뷰, 서비스, 서비스임플, 맴퍼, DB를 만듬 