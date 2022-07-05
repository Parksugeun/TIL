package basic06_io;

import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public RandomAccessFileTest() {
		
	}
	public void start() {
		try {
			// RandomAccessFile	: 비순차적 입출력
			// mode : r->읽기전용, w->쓰기전용, rw->읽기쓰기모두 가능
			File f = new File("c://testFolder/random.txt");
			RandomAccessFile raf = new RandomAccessFile(f,"rw");
					//	  0123456789
			String str = "JAVA Random Access File Test...";
			raf.writeChars(str);
			
			int dataInt = 1234;
			raf.writeInt(dataInt);
			
			double dataDouble = 89.36;
			raf.writeDouble(dataDouble);
			
			
			////////////////////////
			String txt = "자바프로그래밍";
			//위치를 쓸곳으로 이동
			raf.seek(5);
			raf.writeChars(txt);
			
			// 읽기
			raf.seek(20);
			byte[] data = new byte[10];
			int cnt = raf.read(data, 0, data.length);
			System.out.println(new String(data));
			
			raf.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("프로그램이 종료되었습니다..");
	}
	public static void main(String[] args) {
		new RandomAccessFileTest().start();

	}

}
