import java.util.Scanner;

public class IfElselfEx01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//1. 국어, 영어, 수학점수
		int kor, eng, mat, tot;
		double ave;
		String grade;
		
		System.out.println("국어점수=");
		kor = scan.nextInt();
		System.out.println("영어점수=");
		eng	= scan.nextInt();
		System.out.println("수학점수=");
		mat	= scan.nextInt();
		
		//총점
		tot = kor + eng + mat;
		//평균
		ave	= (double)tot / 3;
		//학점
		
		if(ave>=90) {
			grade = "A";
			
		}else if(ave>=80) {
			grade = "B";
			
	 	}else if(ave>=70) {
			grade = "C";	

		}else if(ave>=60) {
			grade = "D";
		
		}else {	
			grade = "F";
		}
		
		/*if(ave>=90 && ave<=100) {
			grade = "A";
		}
		if(ave>=80 && ave<90) {
			grade = "B";
		}
		if(ave>=70 && ave<80) {
			grade = "C";
		}
		if(ave>=60 && ave<70) {
			grade = "D";	
		}
		if(ave>=0 && ave<60) {
			grade = "F";
				}
		*/
		
		System.out.println("총점="+ tot);
		//System.out.println("평균="+ ave);
		//평균은 소수이하 2자리까지 출력하라.
		System.out.printf("평균=%.2f\n",ave);
		System.out.println("학점="+ grade);
	}
			}
		
			

/*
 * 90~100	A 	String "A", Char 'A'
 * 80~89	B
 * 70~79	C
 * 60~69	D
 * 0~59		F
 * 실행결과
 * 국어점수=80
 * 영어점수=90
 * 수학점수=80
 * 총점=250
 * 평균=
 * 학점= B
 * 
 * 
 */