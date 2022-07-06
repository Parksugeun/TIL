package basic06_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public FileCopy() {
		
	}
	public void start() {
		// D:\workspaceJava\basic01\src\GuGuDan.java
		// C:\testFolder\GuGuDan.java
		File orgFile = new File("D://workspaceJava/basic01/src/GuGuDan.java");
		File tarFile = new File("C://testFolder/GuGuDan.java");
	try {	
			//바이트수 만큼 한번에 orgFile 파일의 내용을 읽어 tarFile로 쓰기를 한다.
			FileInputStream fis = new FileInputStream(orgFile);
			FileOutputStream fos = new FileOutputStream(tarFile);
			
			//파일의 내용을 읽어 저장할 배열
			byte[] sourceCode = new byte[(int)orgFile.length()];
			
			//읽어온 바이트수를 리턴해준다.
			int cnt = fis.read(sourceCode);
			
			//쓰기
			fos.write(sourceCode, 0, cnt);
		
			fis.close();
			fos.close();
			
		}catch(FileNotFoundException fnfe) {
			System.out.println("파일이 없습니다. ->"+ fnfe.getMessage());
		}catch(IOException ie) {
			System.out.println("입출력예외발생->"+ ie.getMessage());
		}
		System.out.println(orgFile.getPath()+"의 내용을"+ tarFile.getPath()+"로 복사하였습니다.");
	}
	public static void main(String[] args) {
		new FileCopy().start();

	}

}
