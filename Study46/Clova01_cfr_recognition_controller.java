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

@Controller //1
public class Clova01_cfr_recognition_controller {
	//폼으로 가는것
	@RequestMapping("/clova/cfr") //2
	public String cfr() {
		return "clova/cfr_recognition";//cft_recognition.jsp로 리
	}
	@RequestMapping(value="/cfrOk", method=RequestMethod.POST)
	@ResponseBody//뷰페이지 명이 아니다.
	public String cfrOk(@RequestParam("image") MultipartFile file, HttpSession session) {//이미지 파일을 리퀘스트해서 받는다. | 이미지를 담을 변수 Multipart file
		//4.번 업로드할 위치 경로 | 세션 또는 Request로 할 수 있다.
		String path = session.getServletContext().getRealPath("/file");
		System.out.println("path->"+ path);
		
		//////////////3.복사////////////////  
		StringBuffer reqStr = new StringBuffer();
        String clientId = "2gvgooduud";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "tJAUZJhq9IRyw7CrGpJWJlkhsQBBiRPbrhwHSFUf";//애플리케이션 클라이언트 시크릿값";
        
        //버퍼 아래서 이동(원래있던 복사한 파일)
        BufferedReader br = null;//전송받은 정보가 있는 InputStream
        StringBuffer response = new StringBuffer();  //버퍼 아래서 이동(원래있던 복사한 파일)
        String filename = null;// 6.업로드한 파일명 
        try {
        	//5번 클라이언트의 이미지를 서버에 업로드
        	filename = ClovaFileupload.FileUpload(path, file);
        	
            String paramName = "image"; // 파라미터명은 image로 지정
            String imgFile = path+"/"+filename; //이미지가 업로드 될 경로 | 서버에 실제 있는 파일의 절대주소
            
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
                //StringBuffer response = new StringBuffer();//위로 보낸다.
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                //System.out.println(response.toString());
            } 
//            else {
//                System.out.println("error !!!");
//            }
        } catch (Exception e) {
            System.out.println(e);
        }
        /////////////////// 복사 ///////////////////////
        System.out.println("response->"+ response.toString());
        return response.toString();//콘솔에 데이터를 찍어본다. | null 값에서 response.toString()를 반환한다. 
	}
}
