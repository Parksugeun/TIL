import java.util.Scanner;

public class Switch02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		/* 
			월을 입력받아 봄, 여름, 가을, 겨울의 정보를 출력하는 프로그램을 작성하라.
			
			겨울 - 11, 12, 1, 2
			봄 - 3, 4,
			여름 - 5, 6, 7, 8
			가을 - 9, 10
		
		
		
		*/
		System.out.print("월입력=");
		int month = scan.nextInt();
		if(month>=1 && month<=12 ) {
			
		String season="";
		switch(month) {
		case 11:
		case 12:
		case 1:
		case 2:
			season = "겨울";
			break;
		case 3:
		case 4:
			season = "봄";
			break;
		case 5:
		case 6:
		case 7:
		case 8:
			season = "여름";
			break;
		default:
			season = "가을";
		}
		System.out.printf("%d은 %s입니다.", month, season);
      }else {
			System.out.println("월을 잘못입력하였습니다.");
		}
	}

}
