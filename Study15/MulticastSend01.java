import java.io.File;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSend01 {
	MulticastSocket ms;
	DatagramPacket dp;
	InetAddress ia;
	final int PORT = 11000;
	public MulticastSend01() {
		String str = "멀티캐스트를 이용한 파일전송 연습중..";
		try {
		ms = new MulticastSocket();
		ia = InetAddress.getByName("192.168.0.101");
		
		
		File f = new File("C://img/01.jfif");
		FileInputStream fis = new FileInputStream(f);
		String sendFileName = "[*$@File&]"+ f.getName();
		dp = new DatagramPacket(sendFileName.getBytes(), 0, sendFileName.getBytes().length, ia, PORT);
		
		int cnt=0;
		while(true) {
			byte[] b = new byte[512];
			int byteCount = fis.read(b, 0, b.length);
			System.out.println(++cnt+ ", byte="+ byteCount);
			if(byteCount<=0) break;
			dp = new DatagramPacket(b, 0, byteCount, ia, PORT);
			ms.send(dp);
			System.out.println("전송완료...send");
		}
		String endMessage = "[*%&$end4]";
		dp = new DatagramPacket(endMessage.getBytes(), 0, endMessage.getBytes().length, ia, PORT);
		ms.send(dp);
	
		}catch(Exception e) {
		e.printStackTrace();
	}
	}
		
	
	public static void main(String[] args) {
		new MulticastSend();

	}

}
