
public class Switch01 {

	public static void main(String[] args) {
		// 1->해바라기
		// 2->코스모스
		// 3->장미
		
		int inData = 6;
		String flowerName = "";
		
		
		switch(inData) {
		case 1:
			flowerName = "해바라기";
			break;
		case 2:
			flowerName = "코스모스";
			break;
		case 3:
			flowerName = "장미";
			break;
		default:
				flowerName = "없는 꽃";
		
		}
		
		System.out.printf("%d는 %s입니다.\n", inData, flowerName);
		
		
	}

}

/*
byte, short, int, char, String

switch(변수 or 상수 or 수식){
	
		case 상수:
			실행문;
			실행문;
			[break;]    ->생략가능
		case 상수:
			실행문;
			:
			break;
		:
		:
		default: -->생략가능
			실행문;
			


*/