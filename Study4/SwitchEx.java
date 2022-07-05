import java.util.Scanner;

public class SwitchEx {

	public static void main(String[] args) {
		//국어, 영어, 수학입력받아 총점, 평균, 학점을 구하라.
		// 단 if 문대신 switch문으로 작성하라
		Scanner scan = new Scanner(System.in);
	
			int kor, eng, mat, tot;
			double ave;
			
			System.out.println("국어점수=");
			kor = scan.nextInt();
			System.out.println("영어점수=");
			eng	= scan.nextInt();
			System.out.println("수학점수=");
			mat	= scan.nextInt();
			
			tot = kor + eng + mat;
			
			ave	= (double)tot / 3;
			
			String grade="";
			switch ((int)(ave/10)) {
			case 10:
			case 9:
				grade = "A";
				break;
			case 8:
				grade = "B";
				break;
			case 7:
				grade = "C";
				break;
			case 6:
				grade = "D";
				break;
			default:
				grade = "F";
			
			}
			
			System.out.printf("총점->%d\n 평균->%.2f\n 학점->%s\n", tot, ave, grade);
			
	}

}
