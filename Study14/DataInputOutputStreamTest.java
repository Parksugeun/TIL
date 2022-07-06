package basic06_io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataInputOutputStreamTest {

	public DataInputOutputStreamTest() {
		
	}
	public void start() {
		//원래 데이터형으로 파일로 읽고 쓰기
		try {
			int dataInt = 256328;
			double dataDouble = 352.365;
			boolean dataBoolean = true;
			char dataChar = 'Z';
			
			File f = new File("c://testFolder/data.txt");
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(f));
			dos.writeInt(dataInt);// 4byte
			dos.writeDouble(dataDouble);// 8byte
			dos.writeBoolean(dataBoolean);// 1byte
			dos.writeChar(dataChar);//1,2byte
			dos.close();
			System.out.println("데이터형으로 파일 쓰기가 완료되었습니다");
			
			// Data형으로 저장된 데이터 읽어오기
			DataInputStream dis = new DataInputStream(new FileInputStream(f));
			int readInt = dis.readInt();
			double readDouble = dis.readDouble();
			boolean readBoolean = dis.readBoolean();
			char readChar = dis.readChar();
			
			System.out.println("int->"+ readInt);
			System.out.println("double->"+ readDouble);
			System.out.println("boolean->"+ readBoolean);
			System.out.println("char->"+ readChar);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new DataInputOutputStreamTest().start();

	}

}
