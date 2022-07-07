import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

public class MulticastReceive {
	MulticastSocket ms;
	DatagramPacket dp;
	InetAddress ia;
	FileOutputStream fos;
	final int PORT = 20000;
	public MulticastReceive() {
		try {
			ms = new MulticastSocket(PORT);
			ia = InetAddress.getByName("231.100.100.2");
			
			InetSocketAddress isa = new InetSocketAddress(ia, PORT);
			NetworkInterface ni = NetworkInterface.getByName("PSG");
			ms.joinGroup(isa,ni);
			
			byte data[] = new byte[512];
			while(true) {
				//전송받기 대기
				System.out.println("전송받기 대기중....");
				ms.receive(dp);//전송받기
				
				byte[] receive = dp.getData();
				int byteCount = dp.getLength();
				
				String receiveStr = new String(receive, 0, byteCount);
				if(byteCount>=10 && receiveStr.substring(0,10).equals("[*$@File&]")) {
					fos = new FileOutputStream(new File("c://testFolder", receiveStr.substring(10)));// 
					System.out.println("파일생성됨...--->"+ receiveStr);
				}else if(byteCount>=10 && receiveStr.equals("[*%&$end4]")) {
					fos.close();
					ms.close();
					System.out.println("파일로 저장되었습니다....");
					break;
				}else {//파일내용
					fos.write(receive,0, byteCount);
					
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new MulticastReceive();

	}

}
