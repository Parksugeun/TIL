

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

// 192.168.0.101
public class SocketTest {
	Socket s;
	public SocketTest() {
		try {
			InetAddress ia = InetAddress.getByName("192.168.0.101");
			s = new Socket(ia, 10000);// 서버에 접속됨
			System.out.println("서버에 접속됨....");
			
			//서버에서 보낸 문자 받기
			InputStream is =s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String str = br.readLine();
			System.out.println("받은 문자 : "+ str);
			
			//클라이언트가 서버에게 문자 보내기
			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os); 
			PrintWriter pw = new PrintWriter(osw);
			
			pw.println("client--> server : 클라이언트가 서버로 문자 보냄.,");
			pw.flush();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("client 종료......");
	}
	public static void main(String[] args) {
		new SocketTest();

	}

}
