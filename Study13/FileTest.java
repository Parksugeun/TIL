package basic06_io;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileTest {

	public FileTest() {
		
	}
	public void start() {
		try {
		// 드라이브, 폴더, 파일에 관련한 정보를 사용하기 위해서는 File객체를 생성하여야 한다.
		/*
			File(File parent, String child)
			File(String parent, String child)
		
			File(String pathname)
		*/
		File f1 = new File("C://"); // C://  -> \n \n \
		File f2 = new File("D://dev/student");
		File f3 = new File("D://dev/Test.java");
	
		File f4 = new File(f2, "Test.java");
		File f5 = new File("c:/dev","Test.java");
		
		//경로 또는 파일 존재 유무, 있으면 true, 없으면 false
		System.out.println(f2.exists());
		System.out.println(f3.exists());
		// 폴더 생성
		if(!f2.exists()) {
			if(f2.mkdir()) {// mkdir(), mkdirs()
				System.out.println("폴더가 생성되었습니다.");
			}else {
				System.out.println("폴더생성 실패하였습니다.");
			}
			
		}
		//파일생성
		if(!f4.exists()) {
			if(f4.createNewFile()) { // 생성 true 실패 false
				System.out.println("파일생성됨");
			}else {
				System.out.println("파일생성못함");
			}
		}
		
		//마지막 수정날짜
		long lastDate = f3.lastModified();
		Calendar date = Calendar.getInstance(); 
		date.setTimeInMillis(lastDate);
		
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		String lastDateStr = fmt.format(lastDate);
		System.out.println("마지막수정일->"+ lastDateStr);
		
		// 특정드라이브에 있는 폴더와 파일목록을 구한다.
		File[] files = f1.listFiles();
		// getName() : 파일명
		// getParent() : 드라이브명+폴더
		// getPath(), getAbsolutePath() : 드라이브명+폴더+파일명
		
		for(File f : files) {
			if(f.isDirectory()) {// 디렉토리인지 확인
				if(f.isHidden()) {
					System.out.println(f.getPath()+ "[숨김폴더]");
				}else {
					System.out.println(f.getPath()+"[폴더]");
				}
				System.out.println(f.getPath()+"[폴더]");
			}else if(f.isFile()) {// 파일인지 확인
				if(f.isHidden()) {
					System.out.println(f.getPath()+"[숨김파일]");
				}else {
				System.out.println(f.getPath()+"[파일]");
				}
			}
		  }
			// 드라이브 목록
			File drive[] = File.listRoots();
			for(File f:drive) {
				System.out.println(f.getPath());
			}
			
			//파일의 크기 (byte)
			long fileSize = f3.length();
			System.out.println("fileSize=>"+ fileSize);
			
			//파일삭제
			boolean boo =f3.delete();
			System.out.println(boo);
		}catch(IOException ie) {
		  ie.printStackTrace();
	  }
	}
	public static void main(String[] args) {
		new FileTest().start();

	}

}
