package basic02_api;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
		// StringTokenizer : 문자열 조각내기
		String colorName = "Red?Blue-Green,Cyan,?,Yellow/Brown";

		StringTokenizer st = new StringTokenizer(colorName,",.-/?");
		
		System.out.println("tokencounts->"+ st.countTokens());
	
		while(st.hasMoreElements()) {//true:토큰이 있다. false:토큰이 없다
			System.out.println(st.nextElement());
		}
	}
 
}
