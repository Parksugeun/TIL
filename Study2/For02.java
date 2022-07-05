import java.util.Scanner;

public class For02 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("정수=");
		int max= s.nextInt();
		int sum=0;
		for(int i=1; i<=max ; i++) {//1,2,3,4,5,6,...max
			// i의 값을 누적시킨다.
			sum = sum + i;
		}
		System.out.printf("1~%d까지의 합은 %d입니다.", max, sum);
	}

}
