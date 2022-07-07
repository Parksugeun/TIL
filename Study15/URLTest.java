

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {

	public URLTest() {
		
	}
	public void start() {
		try {
			URL url = new URL("https://www.seoul.go.kr/main/index.jsp");
			System.out.println("protoco->"+ url.getProtocol());
			System.out.println("port->"+ url.getPort());
			System.out.println("host->"+ url.getHost());
			System.out.println("path->"+ url.getPath());
			System.out.println("file->"+ url.getFile());
			//--------인코딩 코드 -----------------------
			// URLConnection객체를 통해 헤더정보를 얻어올 수 있다.
			URLConnection connection= url.openConnection();
			connection.connect();// 채널확보하여 헤더정보 가져오기
			String header = connection.getContentType();
			String encode = header.substring(header.indexOf("=")+1); // UTF-8, euc-kr g
			//---------------------------------------
			
			InputStream is = url.openStream(); //byte단위
			InputStreamReader isr = new InputStreamReader(is, encode);
			BufferedReader br = new BufferedReader(isr);
			
			File f = new File("c://testFolder/seoul.html");
			FileWriter fos = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fos);
			
			String inData="";
			while((inData = br.readLine()) != null){
				System.out.println(inData);
				bw.write(inData+"\n");
			}
			bw.close();
			br.close();
			
			System.out.println("--------------------------------");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		URLTest ut = new URLTest();
		ut.start();

	}

}
