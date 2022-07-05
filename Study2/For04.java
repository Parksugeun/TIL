
public class For04 {

	public static void main(String[] args) {
	/*	
		
		
		
		
		*/
		for(int i=1; i<=5; i++)	{
			for(int j=1; j<=3; j++) {
				//System.out.println(j);
				System.out.print(i);
				//System.out.println(i);
				
			}
			System.out.println();//ÁÙ¹Ù²Þ
		}
		/*
		 * 
		 * 1
		 * 12
		 * 123
		 * 1234
		 * 12345
		 * 
		 */
		for(int i=1; i<=5; i++) {//1,2,3,4,5
			
			for(int j=1; j<=i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		/*
		12345
		1234
		123
		12
		1
			
		
		*/
		//for(int i=1; i<=5; i++){//1,2,3,4,5
		for(int i=5; i>=1; i--) {//5,4,3,2,1
			for(int j=1; j<=i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
	
/*
 
    * 	
   ** 	
  *** 
 ****
*****
 
 */
		for(int r=1; r<=5; r++) {//r=1,2,3,4,5
			//°ø¹é
			for(int s=1;s<=5-r;s++) {
				System.out.print(" ");
				
			}
			for(int c=1; c<=r; c++) {
					System.out.print("*");
			}
			System.out.println();
		}
		
		for(int r=5; r>=1; r--) {//r=5,4,3,2,1
			for(int s=1; s<=5-r; s++) {
					System.out.print(" ");
			}
			for(int c=1; c<=r; c++) {
					System.out.print("*");
			}
			System.out.println();
}
	}
}
		