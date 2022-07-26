## JAVA복습

자바에서 문자는 한 글자를 의미. 문자열은 여러 개의 문자의 결합. 
	문자는 '' (작은따옴표) 문자열은 ""(큰따옴표)를 써야한다
	다만 하나의 문자에 큰따옴표를 사용한다해도 에러가 발생하지는 않는다. 
	(한 글자도 문자열이 될수 있기 떄문)
	백슬래쉬를 " 앞에 위치시키면 "를 단순한 문자로 해석하도록 강제한다.
	이러한 기법을 escape(이스케이프:도망)라고 한다.
	백슬래쉬n은 줄바꿈

변수는 변할 수 있는 데이터 라는 뜻으로 Variable이다. 대명사와 비슷한 역할
	int는 정수 double은 실수 String은 문자열
	변수는 코드의 재활용성을 높여준다. (중복의 제거, 가독성, 유지보수쉬움)

주석은 로직에 대한 설명이나 코드를 비활성화 할 때 사용
	(//) 한줄 주석 (/*    * /) 여러줄 주석
	(/ ** ) 로 시작하는 주석은 JavaDoc주석이라고 하며 자바의 문서를 만들 때 사용

세미콜론은 문장의 끝을 의미한다. 문장의 끝에 세미콜론을 사용하지 않으면 컴파일 가 발생한다.

데이터의 크기
	8bit는 1byte 
	1024byte는 1kilobyte
	1024kilobyte는 1megabyte
	1024megabyte는 1gigabyte
	1024gigabyte는 1terabyte

정수형
	byte는 1byte  -128~127
	short는 2byte  -32,768~32,767
	int는 4byte -2,147,483,648~2,147,483,647
	long은 8byte -9223,372,036,854,775,808~9,223,372,036,854,775,807

실수형
	float는 4byte
	double은 8byte

문자
	char 2byte

상수의 데이터 타입
	상수는 변하지 않는 값을 의미 int a  = 1; 에서 a는 변수 1은 상수가 된다.
	float로 바꿔주려면 실수뒤에F를 붙여주면 float로 변환된다. ex) float a = 2.2F;

형 변환
	암시적 형 변환은 컴퓨터가 자동으로 형변환을 해주는 것
	명시적 형 변환은 데이터 타입을 지정해서 값 앞에 위치시키는 것

연산자 
	연산자란 특정한 작업을 하기 위해서 사용하는 기호를 의미
	대입 연산자, 산술 연산자, 비교 연산자, 논리 연산자 등이 있다.
	+ 더하기 - 빼기  * 곱하기  / 나누기 % 나머지
	단항 연산자
	++증가 연산자로 값을 1씩 증가  --감소 연산자로 항의 값을 1씩 감소

비교와 Boolean
	Boolean은 참과 거짓을 의미하는 데이터 타입으로 bool이라고도 부른다.
	불린은 정수나 문자와 같이 하나의 데이터 타입인데 
	참을 의미하는 true와 거짓을 의미하는 false 두 가지의 값을 가지고 있다.
	== 좌항과 우항을 비교해서 서로 값이 같다면 true 다르다면 flase
	!=   '!'는 부정을 의미한다. '같다'의 부정은 '같지 않다'  == 와 정반대 의미
	> 좌항이 우항보다 크면 true 작다면 false
	< 우항이 좌항보다 크면 true 작다면 false
	>=  좌항이 우항보다 크거나 같다면 true 아니면 false
	>=  우항이 좌항보다 크거나 같다면 true 아니면 false
	.equals 문자열을 비교할 때 사용하는 메소드 같으면 true 아니면 false

조건문
	비교 연산의 결과로 참이나 거짓을 얻을 수 있다(Boolean)
	불린은 조건문에서 실행 흐름을 제어할 수 있다.
	if  뒤에 오는 if절이 참이면 then 절이 실행되고 거짓이면 실행되지 않음
	if( true or false ){
		 then 절 
	}
	else     if절의 값이 참일 때 then절이 실행되고 faalse일 때 else절이 실행된다.
	if(true or false){
	}else{
	}
	else if       조건문의 흐름을 좀 더 자유롭게 제어할 수 있다. if절의 값이 참이라면 the절이 실행되고 거짓이라면 else if절로 제어가 넘어간다. else if가 참이면 else if then절이 실행되고 거짓이면 else절이 실행된다. else if절은 여러 개가 가능하고 else절은 생략이 가능하다. 한번이라도 참이 실행되는 절만 출력하고 나머지는 다 실행되지 않는다.
		if(true or false){
		}else if(true or false){
		}else{
		}
	switch 문
	switch문은 사용빈도는 적지만 조건이 많다면 switch문이 logic을 보다 명료하게 보여줄 수 있다. break를 걸어주지 않으면 해당하는 케이스부터 나머지 케이스가 다출력이 된다. 이에 각각 break을 걸어줘야 해당 절만 실행이 된다. switch문에 해당하는 케이스가 없으면 defalut문이 실행된다.
		switch(1){
		case 1:
			System.out.println("one");
			break;
		case 2:
			System.out.println("two");
			break;
		case 3:
			System.out.println("three");
			break;
		default:
			System.out.println("default");
		}
	switch 문에는 byte, short, char, int, enum, String, Character, Byte, Short, Integer 데이터 타입만 사용이 가능하다

논리연산자
	Boolean의 값을 결합해서 코드를 좀 더 간결하게 만들 수 있다.
	Boolean && Boolean 둘다 참이여야 참 하나라도 거짓이면 거짓
	Boolean || Boolean 둘중 하나만 참이여도 참
	! 부정의 의미로 not  true에 !를 붙이면 false가 되고 false에 !를 붙이면 true가 된다.

반복문
	while문은 조건이 참일 동안 실행을 반복적으로 수행한다.
	while(조건){
		반복 실행 영역
	}
	for문은 특정한 횟수만큼 반복 실행을 하는 경우에 자주 사용된다. for문과 while문은 서로 대체 가능하다.
	for(초기화; 종료조건; 반복실행){
		반복적으로 실행될 구문
	}
	반복문을 중간에 중단시키고 싶다면 중단시키고 싶은 값을 설정해주고 break를 사용하면 된다. 
	for(int i =0; i<10; i++) {
		if(i == 5)
			break;
		System.out.println(i);
	}
	continue를 만나면 그 순간에 멈추고 다시 for문이 실행되어 반복된다.
	(continue문에 해당하는 것만 빼고 출력)
	반복문의 중첩 for문안에 for문이 있으면 처음 for문에서 i가 0으로 내려오면 j에서는 0~9까지 출력되고 그 다음 i의 1이출력이 된다.
		00,01,02,03,04...10,11,12,13...20,21,22...,30,31,32...97,98,99
		for(int i =0; i<10; i++) {
			for(int j=0; j<10; j++){
				System.out.println(i+""+j);
			}
		}

배열
	Array 배열은 연관된 데이터를 모아서 관리하기 위해 사용하는 데이터 타입
	배열을 선언할 때는 데이터 타입 뒤에 [ ] 를 붙여야 한다. 데이터들은 element(원소)라고 부르며 { }안에 위치하고 쉼표로 구분한다. [ ] 안에 있는 것은 index(색인) 
	
	String[ ] classGroup = { '최진혁','최수인'  , '한이람'  ,'이고잉' };
	와
	String[ ] classGroup = new String[4];
	calssGroup[0] = "최진혁";
	System.out.println(calssGroup.length);
	calssGroup[1] = "최수인";
	System.out.println(calssGroup.length);
	calssGroup[2] = "한이람";
	System.out.println(calssGroup.length);
	calssGroup[3] = "이고잉";
	System.out.println(calssGroup.length);
	는 서로 같다
배열의 반복문
	for문을 이용
	String[] members = {"최진혁","최수인",한이람};
	for(i=0; i<members.length; i++){
		String member = members[i];
		System.out.println(member+"이 상담을 받았습니다");
	}
	for each문을 이용
	String[] members = {"최진혁","최수인",한이람};
	for(String e : members){
		System.out.println(e+"이 상담을 받았습니다");
	}
	두개는 서로 같다.
	배열은 정해진 크기 이상의 값을 넣을 수 없다. 
	배열의 크기를 미리 정의하지 않으려면 Collection을 사용해야 함

메소드
	method는  function(함수)과 같은 의미로 코드를 재사용할 수 있게 해준다.
	메소드를 만드는 것을 define(정의)라고 하고, 만들어진 메소드를 실행하는 것을 호출이라고 한다. 
		메소드 정의
		public static void numbering(){
			int i = 0;
			while(i<10){
				System.out.println(i);
					i++;
			}
		}
		메소드 호출
		public static void main(String[] args){
			numbering();
		}
	main 메소드는 규칙이다. public static void main(String[] args)가 이끄는 중괄호 안에 실행되기를 기대하는 로직을 위치시켜야 한다. (규칙이기 때문에 그냥 외워야함)
	!!!!void가 메소드 이름 앞에 오면 return값은 존재하지 않는다라는 것을 의미!!!!!

입력과 출력
	외부의 자극이 입력이라면 반응은 출력이라고 할 수 있다.
	입력 
	메소드의 입력 값(argument)은 parameter(매개변수)를 통해서 이루어진다.
	public static void numbering(int limit){
			int i = 0;
			while(i<limit){
				System.out.println(i);
					i++;
			}
		}
		public static void main(String[] args){
			numbering(5);
		}
	출력값 = 0,1,2,3,4
	매개변수(parameter)를 선언하고 입력 값(argument)만 바꾸기 때문에 수정이 용이하다.
	public static void numbering(int init, int limit){
			int i = init;
			while(i<limit){
				System.out.println(i);
					i++;
			}
		}
		public static void main(String[] args){
			numbering(3, 5);
		}
	출력값= 3,4
	출력
	return
	public static String numbering(int init, int limit){
			int i = init;
			String ouput = ""; //숫자들을 output이라는 변수에 담기 위해 빈 값을 줌
			while(i<limit){
				output += i; //숫자를 화면에 출력하는 대신 변수 output에 담았다.
				i++;              // output += i;는 output = output +i; 와 동일하다.
				}
			return output; //1,2,3,4  자바는 return에서 반드시 종료시킨다. !!!
			//output에 담겨 있는 문자열을 메소드 외부로 반환하려면 return선언
		}
		public static void main(String[] args){
			String result = numbering(1, 5);
			System.out.println(result);
		}
	데이터를 리턴하는 이유는 부품으로서의 가치를 높이기 위해 선언한다.
	다른곳에서도 사용이 가능하게 함
	메소드는 여러 개의 입력 값을 가질 수 있다. 여러 개의 값을 출력하고 싶다면 하나의 변수에 여러개의 값을 담아서 출력하면 된다.
		public static String[] getMembers(){
				String[]members = {"최진혁","최유빈","한이람"};
				return members;
		}
		public static void main(String[] args){
			String[] members = getMembers();
		}
	출력 값 = 최진혁,최유빈,한이람
	