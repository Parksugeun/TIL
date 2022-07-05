
public class For01 {

	public static void main(String[] args) {
		for(int i=3; i<=10; i+=3) {// i=1,2,3,4,5
			System.out.println(i);
		}

		for(int i=3; i<=10; i++) {// i= 1,2,3,4,5,6,7,8,9,10
			if(i%3==0) {
				System.out.println(i);
			}
		}
		System.out.println("--------------------");
		for(int i=10; i>=1; i--) {// i=10,9,8,7,6,5,4,3,2,1
			
			System.out.println(i);
		}
		
		for(int i=1; ;i++) {
			System.out.println(i);
		}
		
		
	}

}


/*
 1
 2
 3
 4
 5
 
 for(초기값 ; 최종값(조건식) ; 증감식){
 		실행문;
 		if, switch
 		출력문
 		계산식
 		변수선언
 		:

}




*/