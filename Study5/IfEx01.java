import java.util.Scanner;

public class IfEx01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("금액입력=");
		int money = scan.nextInt();
	
		if(money>=10000) {
				int r = money/10*10;
				System.out.println("r="+ r);
		}
		
	}

}
/*
if문 사용하기
입력받은 값이 10000이상일 때만 마지막자리 값을 0으로 바꿔서 출력하라.

실행
금액입력 = 26315
결과 = 26310

금액입력 = 568259
결과 = 568250
*/