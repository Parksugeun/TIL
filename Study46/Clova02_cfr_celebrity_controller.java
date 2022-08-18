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

public class Clova02_cfr_celebrity_controller {
	@RequestMapping("/clova/cfr_celebrity")
	public String celebrity() {
		return "clova/cfr_celebrity";//jsp로 리턴한다. 
	}
	@RequestMapping(value="/clova/cfr_celebrity_ok", method = RequestMethod.POST) //방식 포스트 
	@ResponseBody//ajax처리
	public String celebrityOk(@RequestParam("image") MultipartFile file, HttpSession session) {//파일을 가져온다. 
		String path = session.getServletContext().getRealPath("/file");//절대경로를 구해서 필요하다.
		
		
		// 네이버 얼굴인식 //
		 StringBuffer reqStr = new StringBuffer();
	        String clientId = "2gvgooduud";//애플리케이션 클라이언트 아이디값";
	        String clientSecret = "tJAUZJhq9IRyw7CrGpJWJlkhsQBBiRPbrhwHSFUf";//애플리케이션 클라이언트 시크릿값";
	        StringBuffer response = new StringBuffer();
	        
	        try {
	        	
	        	//part2. 파일 업로드(!)
	        	String filename = ClovaFileupload.FileUpload(path, file);//파일 업로드 수행
	        	
	            String paramName = "image"; // 파라미터명은 image로 지정
	            String imgFile = path+"/"+filename;
	            File uploadFile = new File(imgFile);
	            String apiURL = "https://naveropenapi.apigw.ntruss.com/vision/v1/celebrity"; // 유명인 얼굴 인식
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
	            OutputStream outputStream = con.getOutputStream();//아웃풋 스트림을 con에서 만들고 있다.
	            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
	            String LINE_FEED = "\r\n";
	            // file 추가
	            String fileName = uploadFile.getName();
	            writer.append("--" + boundary).append(LINE_FEED);
	            writer.append("Content-Disposition: form-data; name=\"" + paramName + "\"; filename=\"" + fileName + "\"").append(LINE_FEED);
	            writer.append("Content-Type: "  + URLConnection.guessContentTypeFromName(fileName)).append(LINE_FEED);
	            writer.append(LINE_FEED);
	            writer.flush();//아웃풋 스트림을 여기서 한다.
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
	            BufferedReader br = null;
	            int responseCode = con.getResponseCode();
	            if(responseCode==200) { // 정상 호출
	                br = new BufferedReader(new InputStreamReader(con.getInputStream()));// con.getInputStream()) <- 인 풋이다.
	            } else {  // 오류 발생
	                System.out.println("error!!!!!!! responseCode= " + responseCode);
	                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	            }
	            String inputLine;
	            if(br != null) {
	                //StringBuffer response = new StringBuffer();한줄씩 읽는다. Try 앞으로 위로 뺀다.
	                while ((inputLine = br.readLine()) != null) {
	                    response.append(inputLine);
	                }
	                br.close();
	                System.out.println(response.toString());
	            } 
	            //else {
	            //    System.out.println("error !!!");
	            //}
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        System.out.println("celebrity->"+ response.toString());
		// 네이버 얼굴인식 //
		return response.toString();
	}
}
