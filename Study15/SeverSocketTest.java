

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SeverSocketTest {
	ServerSocket ss;
	public SeverSocketTest() {
		try {
			//접속을 대기할 수 있는 SeverSocket은 port번호를 지정하여 객체를 생성한다.
			ss = new ServerSocket(10000);
			while(true) {
			//클라이언트 접속을 accept()메소드가 기다리고
			//접속을 하면 클라이언트 정보가 있는 Socket객체를 리턴해준다.
			System.out.println("Server start.... 접속대기중");
			Socket s = ss.accept();
			
			InetAddress ia = s.getInetAddress();
			System.out.println(ia.getHostAddress()+"->클라이언트가 접속하였습니다.");
			
			//서버에서 클라이언트에게 문자보내기
			OutputStream os = s.getOutputStream();// 1byte
			OutputStreamWriter osw = new OutputStreamWriter(os);// 1 char
			PrintWriter pw = new PrintWriter(osw);
			
			pw.println("서버->클라이언트에게->서버에 접속되었습니다.");
			pw.flush();
			
			//클라이언트가 보낸 문자 받기
			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String txt = br.readLine();
			System.out.println("server가 받은 문자 ==>"+ txt);
			}	
	}catch(IOException ie) {
		ie.printStackTrace();
		}
		System.out.println("server 종료.....");
	}

	public static void main(String[] args) {
		new SeverSocketTest();

	}

}
