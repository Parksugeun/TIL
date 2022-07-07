import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class FileUnicastReceive {
	DatagramSocket ds;
	DatagramPacket dp;
	FileOutputStream fos;
	public FileUnicastReceive() {
		
	}
	public void receiveStart() {
		try {
			ds = new DatagramSocket(15000);
			byte[] receiveData = new byte[512];
			dp = new DatagramPacket(receiveData, receiveData.length);
			
			while(true) {
				//전송받기 대기
				System.out.println("전송받기 대기중....");
				ds.receive(dp);//전송받기
				
				byte[] receive = dp.getData();
				int byteCount = dp.getLength();//전송받은 byte수
				
				String receiveStr = new String(receive, 0, byteCount);// [*$@File&]01/jfif
				if(byteCount>=10 && receiveStr.substring(0,10).equals("[*$@File&]")) {//파일명이 전송되었다.
					fos = new FileOutputStream(new File("c://testFolder", receiveStr.substring(10)));// 
					System.out.println("파일생성됨...--->"+ receiveStr);
				}else if(byteCount>=10 && receiveStr.equals("[*%&$end4]")) {
					fos.close();
					ds.close();
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
		new FileUnicastReceive().receiveStart();

	}

}
