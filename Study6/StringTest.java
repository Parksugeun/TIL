package basic02_api;

import java.util.Arrays;

public class StringTest {

	public static void main(String[] args) {
		String name = "홍길동";
		String name2 = "홍길동";
		
		String addr = new String("Seoul 강남구 강남구 역삼동(DONG)");
		String addr2 = new String("서울시 강남구 역삼동(dong)");
		
		// == : 같으냐
		if(name == name2) {
			System.out.println("name과 name2는 같다");
		}else {
			System.out.println("name과 name2는 다르다");
		}
		if(addr == addr2) {
			System.out.println("addr과 addr2는 같다");
		}else {
			System.out.println("addr과 addr2는 다르다");
		}
		
		String addr3 = addr2;
		if(addr2== addr3) {
			System.out.println("addr2 과 addr3는 같다");
		}else {
			System.out.println("addr2 과 addr3는 다르다");
		}
		
		// equals() : 객체내의 값을 비교해준다. (대소문자 구별)
		boolean boo = addr.equals(addr2); // addr2.equals(addr)
		if(boo) {
			System.out.println("addr과 addr2는 같다...");
		}else {
			System.out.println("addr과 addr2는 다르다...");
		}
		// equalsIgnoreCase() : 값을 비교해준다.(대소문자를 구별하지 않는다.)
		if(addr.equalsIgnoreCase(addr2)) {
			System.out.println("같다(대소문자구별안함)");
		}else {
			System.out.println("다르다(대소문자구별안함");
		}
		
		String str = "A";
		str = str + "B";
		String str2 = str + 100;
		
		System.out.println("charAt()->"+ addr.charAt(5)); //index위치의 문자를 반환한다.
		addr = addr.concat(name);
		System.out.println("concat()->" + addr);//문자연결
	
		
		String txt = "Hello!";
		byte txtCode[] = txt.getBytes();
		System.out.println(Arrays.toString(txtCode));
	
		
		// 없는 문자일때 -1
		int idx = addr.indexOf("강남역"); // 서울시 강남구 강남구 역삼동(DONG)
		System.out.println("indexOf->"+idx);
		System.out.println("lastIndexOf->"+ addr.lastIndexOf("강"));
		System.out.println("indexOf->"+ addr.indexOf("강",5));
		System.out.println("length->"+ addr.length());
		System.out.println("repeat->" + addr.repeat(3));
		System.out.println("*".repeat(50));
		
		addr = addr.replaceAll("강남구", "GangNamGu");
		System.out.println("replaceAll->"+ addr);
	
		String tel = "010-1234-5678";
		String telSplit[] = tel.split("-");
		System.out.println(Arrays.toString(telSplit));
		//         0123456789012345678901234
		// addr -> Seoul GangNamGu GangNamGu 역삼동(DONG)홍길동
		// substring : 문자열에서 일부의 문자열을 얻을 때 
		String sub1 = addr.substring(6, 15);//시작위치 6, 끝위치 14
		System.out.println("substring(int, int)->"+ sub1);
		String sub2 = addr.substring(20);
		System.out.println("substring(int)->"+ sub2);
		
		System.out.println("lower->"+ addr.toLowerCase());
		System.out.println("upper->"+ addr.toUpperCase());
		// "2500"
		// "5.3"
		String x = String.valueOf(5.3)+ 500;
		System.out.println(x);
	
		char c[] = {'j','a','v','a'};// "Java"
		System.out.println(c);
		System.out.println(String.valueOf(c));
		
		int d[] = {23,45,67,88};
		System.out.println(d);
		
		String data = "         Test          Programing     ";
		System.out.println("data->"+ data.trim()+"?");//양쪽 끝의 공백문자를 지운다.
	}

}
