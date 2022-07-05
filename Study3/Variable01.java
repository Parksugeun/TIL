
public class Variable01 {
     ////멤버변수=전역변수
	int t=500;
	//메소드
	//클래스
	public static void main(String[] args) {
		// 변수와 상수
		// 변수 생성규칙
		//1. 소문자, _, $로 시작한다.
		//2. 영어 대소문자, _, $, 숫자를 허용한다.
		//3. 합성어일 경우 두번째 단어부터 첫번째 글자는 대문자로 한다. multicampusKorea, MulticampusKorea, MulticampustKorea,
		//4. 변수의 길이는 256글자까지 허용한다.
		
		byte kor = 80;
		int eng = 90;
		short mat = 75;
		
		// type casting : 형변환
		int tot = kor + eng + mat;
		
		System.out.println("국어="+ kor); // 문자열과 어떤 데이터형을 더하든지 문자열이 된다.	
		System.out.println("영어="+eng);
		System.out.println("수학="+mat);
		
		System.out.println("총점="+tot);
	
	}

}
