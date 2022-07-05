package basic05_collection;

import java.util.Calendar;
import java.util.Scanner;
import java.util.Vector;

public class VectorTest {
	public static Vector vv = new Vector();
	public VectorTest() {

		
	}
	//컬렉션 : 데이터 또는 정보를 저장할 수 있는 객체
	//List 인터페이스를 상속받은 클래스는 저장순서유지(index를가짐)
	
	public Vector getData() {
		int num = 20;
		String username = "이순신";
		Scanner scan = new Scanner(System.in);
		Calendar now = Calendar.getInstance();
		ConsoleCalendarOOP calOOP = new ConsoleCalendarOOP();
		
		Vector vector = new Vector();
		vector.add(num);// index 0
		vector.add(scan);// 2
		vector.add(username);//3
		vector.add(1, now);//1
		vector.add(calOOP);//4
		
		///////////////////////
		vv.add("홍길동");//0
		vv.add("김길동");//1
		vv.add("박길동");//2
		vv.add("이길동");//3
		///////////////////////
		return vector;
	}
}
