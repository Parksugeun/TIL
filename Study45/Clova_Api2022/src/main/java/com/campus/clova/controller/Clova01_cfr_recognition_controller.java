package com.campus.clova.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class Clova01_cfr_recognition_controller {

	//폼
	@RequestMapping("/clova/cfr")
	public String cfr() {
		return "clova/cfr_recognition";
	}
	//
	@RequestMapping(value="/cfrOk", method=RequestMethod.POST)
	@ResponseBody //view페이지가 아니라는 뜻
	public String cfrOk(@RequestParam("image") MultipartFile file, HttpSession session) {
		//*업로드할 위치 경로
		String path = session.getServletContext().getRealPath("/file");
		System.out.println("path->"+ path);
		
		////////////////
		StringBuffer reqStr = new StringBuffer();
        String clientId = "zejn0nuoby";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "HHPBJfv9XrCaZbGLIWpStKWeIqHwg7aoCrC7eMJA";//애플리케이션 클라이언트 시크릿값";
        
        BufferedReader br = null;//전송받은 정보가 있는 InputStream
        StringBuffer response = new StringBuffer();//buffer reader에 잇는 것을 담아서 
        String filename = null;//업로드한 파일명
        
        try {
        	//*클라이언트에 있는 이미지를 업로드
        	filename = ClovaFileupload.fileUpload(path, file);
        	
        	
            String paramName = "image"; // 파라미터명은 image로 지정
            String imgFile = path+"/"+filename; //서버에 실제 있는 파일의 절대주소
            
            File uploadFile = new File(imgFile);
            String apiURL = "https://naveropenapi.apigw.ntruss.com/vision/v1/face"; // 얼굴 감지
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setUseCaches(false);
            con.setDoOutput(true);
            con.setDoInput(true);
            // multipart request
            String boundary = "---" + System.currentTimeMillis() + "---";
            con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            OutputStream outputStream = con.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
            String LINE_FEED = "\r\n";
            // file 추가
            String fileName = uploadFile.getName();
            writer.append("--" + boundary).append(LINE_FEED);
            writer.append("Content-Disposition: form-data; name=\"" + paramName + "\"; filename=\"" + fileName + "\"").append(LINE_FEED);
            writer.append("Content-Type: "  + URLConnection.guessContentTypeFromName(fileName)).append(LINE_FEED);
            writer.append(LINE_FEED);
            writer.flush();
            FileInputStream inputStream = new FileInputStream(uploadFile);
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
            inputStream.close();
            writer.append(LINE_FEED).flush();
            writer.append("--" + boundary + "--").append(LINE_FEED);
            writer.close();
            
            int responseCode = con.getResponseCode();
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 오류 발생
                System.out.println("error!!!!!!! responseCode= " + responseCode);
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }
            //전송받은 InputStream의 값을 읽어내기 
            String inputLine;
            if(br != null) {
                //StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
               // System.out.println(response.toString());
           } 
//                 else {
//                System.out.println("error !!!");
//            }
        } catch (Exception e) {
            System.out.println(e);
        }
        /////////////////////////
        System.out.println("response=>"+ response.toString());
        return response.toString();
	}
	
}
