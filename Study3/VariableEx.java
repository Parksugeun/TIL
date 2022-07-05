import java.util.Scanner;

public class VariableEx {

	public static void main(String[] args) {
		Scanner inData = new Scanner(System.in);
	
		// 사과의 갯수와 바구니 크기를 입력받아 
		// 바구니에 사과를 담을 경우 한바구니에는 사과를 10개를 담을 수 있다.
		// 사과가 31개일때 바구니 수를 구하라.
		System.out.print("바구니 크기=");
		int basketSize = inData.nextInt(); 
		System.out.print("사과갯수=");
		int apple = inData.nextInt();
	
		
		int basket = (apple%basketSize==0)? apple/basketSize: apple/basketSize+1;
		System.out.println("바구니수:"+ basket);
		
		

		
				
				
				
				
				
				
				
				

				
	}

}
