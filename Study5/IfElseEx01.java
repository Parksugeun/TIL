import java.util.Scanner;

public class IfElseEx01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
			//1. 메뉴입력
		System.out.print("원하는 메뉴선택(1.사각형의 넓이, 2,원의 넓이)?");
		int menu = scan.nextInt();
		
		if(menu==1) {
			System.out.print("밑변=");
			int width = scan.nextInt();
			System.out.print("높이=");
			int height = scan.nextInt();
			
			int rectResult =width*height;
			System.out.println("사각형의 넓이->"+rectResult);
			
		}else if(menu==2) {//2
			System.out.println("반지름=");
			int r = scan.nextInt();
			
			double radiusResult = r * r *Math.PI;
			System.out.println("원의 넓이->"+radiusResult);
			
		}else {
			System.out.println("메뉴를 잘못 선택하였습니다.");
		}
		
		//System.out.println("Math.PI->"+Math.PI);
		
		}

	}

/*
사각형의 넓이 = 밑변*높이
원의 넓이 = 반지름*반지름*3.14

실행결과
원하는 메뉴선택(1.사각형의 넓이, 2,원의 넓이)? 1
밑변=5
높이=6
사각형의 넓이 = 30

실행결과
원하는 메뉴선택(1.사각형의 넓이, 2,원의 넓이)? 2
반지름=5
원의 넓이 =

*/
