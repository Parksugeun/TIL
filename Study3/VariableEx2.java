import java.util.Scanner;

public class VariableEx2 {

	public static void main(String[] args) {
		/*
		   임의의 정수를 입력받아 1~100사이의 값이면 
		   입력받은 값에 100을 곱하여 출력하고 
		   그 외의 값은 0을 출력하라.
		
	*/
		Scanner scan = new Scanner(System.in);
		// 데이터
		System.out.print("정수=");
		int number = scan.nextInt();
		int result = (number>=1 && number<=100)? number*100 : 0;
		// 계산
		System.out.print(result);
		// 출력

	}

}
