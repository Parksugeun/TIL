package basic02_api;

import java.util.Scanner;
import java.util.StringTokenizer;

public class EmailCheckEx {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);  
		
		do {
			System.out.print("이메일=");
			String email = scan.nextLine();
			// @ 있어야 한다, .있어야한다
			int atMark = email.indexOf("@");
			int point = email.indexOf("."); // sdadsa@f.natecom
			
			if(atMark<3 || point<atMark || Math.abs(atMark-point)<=2) {//잘못된 이메일 찾기
				System.out.println(email+"은 잘못된 메일입니다.");
			}else {//정상이메일 일때
				// split(), substring, StringTokenizer
				/* split
				String emailSplit[] = email.split("@");
				System.out.println("아이디="+ emailSplit[0]);
				System.out.println("도메인="+ emailSplit[1]);
				*/
			/* substring()
				String id = email.substring(0, atMark);
				String domain = email.substring(atMark+1);
				System.out.println("id="+ id);
				System.out.println("domain="+ domain);
			*/
			//StringTokenizer
				StringTokenizer emailobj = new StringTokenizer(email, "@");
				String id = emailobj.nextToken();
				String domain = emailobj.nextToken();
				System.out.println("id="+ id);
				System.out.println("domain="+ domain);
			}
			
			System.out.println("계속하시겠습니까(y:예, n: 아니오)?");
			//String q = scan.nextLine();
			if(!scan.nextLine().equalsIgnoreCase("y")) {
				System.out.println("The End...");
				break;
			}
			
		}while(true);
			

	}

}
/*
실행

이메일=fjfkdjfkd@nate.com
아이디=fjfkdjfkd
도메인=nate.com
다시하시겠습니까(y.예, n.아니오)?y

이메일=addd.com



*/