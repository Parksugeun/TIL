package basic06_io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;

public class ObjectOutputStreamTest {

	public ObjectOutputStreamTest() {
		
	}
	public void start() {
		//객체를 파일로 쓰기
		Calendar now = Calendar.getInstance();
		MemberVO vo = new MemberVO(1000, "홍길동", "총무부", "010-1234-5678");
		
		//년도 변경
		now.set(2000, 10 ,  15);
		vo.setUsername("이순신");
		
		try {
		//파일로 객체 저장
		File f = new File("c://testFolder/object.txt");
		FileOutputStream fos = new FileOutputStream(f);
	
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(now);
		oos.writeObject(vo);
		
		oos.close();
		fos.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ObjectOutputStreamTest().start();
	
	}

}
