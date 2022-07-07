

import java.net.InetAddress;

public class InetAddressTest {

	public InetAddressTest() {
	}
	public void start() {
		try {
		// ip에 관련된 객체를 생성한다.
		// 내컴퓨터의 아이피정보 얻어오기
		InetAddress ia = InetAddress.getLocalHost();
		String ip = ia.getHostAddress();// 내컴퓨터 ip
		String name = ia.getHostName();// 컴퓨터이름 또는 url 주소
		System.out.println("ia.address->"+ ip);
		System.out.println("ia.name->"+ name);
		
		//도메인 이용한 inetAddress를 얻어오기
		InetAddress ia2 = InetAddress.getByName("www.nate.com");
		System.out.println("ia2.address->"+ ia2.getHostAddress());
		System.out.println("ia2.name->"+ ia2.getHostName());
		
		// naver
		
		InetAddress ia3 = InetAddress.getByName("120.50.131.112");
		System.out.println("ia3.address->"+ ia3.getHostAddress());
		System.out.println("ia3.name->"+ ia3.getHostName());
		System.out.println("----------------------");
		
		//여러개의 netAddress객체 얻어오기
		InetAddress[] ia4 = InetAddress.getAllByName("www.seoul.go.kr");
		for(InetAddress i:ia4) {
			System.out.println("ia4.address->"+ i.getHostAddress());
			System.out.println("ia4.address->"+ i.getHostName());
		}
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
		
	public static void main(String[] args) {
		InetAddressTest it = new InetAddressTest();
		it.start();
	}
	
 }

