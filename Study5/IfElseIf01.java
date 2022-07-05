import java.util.Scanner;

public class IfElseIf01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수입력=");
		int num = scan.nextInt();
		
		if(num>0) {
			System.out.println("입력한 값은 양수입니다.");
				}else if(num<0) {
					System.out.println("입력한 값은 음수입니다.");
				}else {
					System.out.println("입력한 값은 0입니다");
				}

	}

}
