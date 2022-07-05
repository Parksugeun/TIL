import java.util.Scanner;

public class IfElse01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//임의의 값이 1~100사이면 임의의 값을 출력하고
		// 			그외의(양수(100초과), 음수) 값은 양수로 만들어 출력하라.
		
		System.out.print("정수입력=");
		int data = scan.nextInt();
		
		if(data>=1 && data<=100) {
			System.out.println("data->"+data);
		}else {// 100보다 클때, 1보다 작을 때
			if(data<0) {//부호를 양수로 변경하는 식
				data = -data;
			}
			data = Math.abs(data);
			System.out.println("data(else)->"+data);
		}

	}

}

/*

if(조건문){
	//조건문이 참일때 실행문;
	 ;
	 ;
	  
	  
	 }else{
	  //조건문이 거짓일때 실행문;
	   ;
	   ;
	  }
	  
	  
	  
	 
	 */







