package com.campus.clova.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Clova06_captcha_image_controller {
	String clientId = "lej4iiht43";
	String clientSecret = "TRvVcP2bXZdQ3D3ZYTs4GXc39g6ESUCFgHj1Bmfu";
	
	//폼으로 이동하기
	@GetMapping("/clova/captchaForm")
	public String captchaForm() {
		return "clova/captchaForm_img";
	}
	String key;
	//캡차 이미지 수신
	@RequestMapping("/clova/captchaImage")
	public void captchaImage(HttpServletRequest request , HttpServletResponse res) { //res 위치가 뷰단에서 받음
		String path = request.getServletContext().getRealPath("/file");
		////////////////////////////////////////////////////////// 
		//String clientId = "YOUR_CLIENT_ID";//애플리케이션 클라이언트 아이디값";
	        try {
	            key = captchaKey(); // https://naveropenapi.apigw.ntruss.com/captcha/v1/nkey 호출로 받은 키값
	           
	            String apiURL = "https://naveropenapi.apigw.ntruss.com/captcha-bin/v1/ncaptcha?key=" + key + "&X-NCP-APIGW-API-KEY-ID" + clientId;
	            URL url = new URL(apiURL);
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("GET");
	            
	            int responseCode = con.getResponseCode();
	            BufferedReader br;
	            if(responseCode==200) { // 정상 호출
	                InputStream is = con.getInputStream();
	                int read = 0;
	                byte[] bytes = new byte[1024];
	                // 랜덤한 이름으로 파일 생성
	                String tempname = Long.valueOf(new Date().getTime()).toString();
	                File f = new File(tempname + ".jpg");
	                f.createNewFile();
	                OutputStream fileOutputStream = new FileOutputStream(f);
	                OutputStream outputStream = res.getOutputStream();
	                
	                while ((read =is.read(bytes)) != -1) {
	                    fileOutputStream.write(bytes, 0, read);//파일로 쓰기
	                    outputStream.write(bytes, 0, read);//클라이언트에게 쓰기
	                }
	                is.close();
	                fileOutputStream.close();
	                outputStream.close();
	            } else {  // 오류 발생
	                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	                String inputLine;
	                StringBuffer response = new StringBuffer();
	                while ((inputLine = br.readLine()) != null) {
	                    response.append(inputLine);
	                }
	                br.close();
	                System.out.println(response.toString());
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        //////////////////////////////////////////////////
	}
	// 캡챠 키값 비교
	@PostMapping("/clova/captchaCheck")
	public ResponseEntity<String> captchaCheck(@RequestParam("userIn") String userIn) {
		//////////
		StringBuffer response = new StringBuffer();
		 try {
	            String code = "1"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
	            //String key = "CAPTCHA_KEY"; // 캡차 키 발급시 받은 키값
	            String value = userIn; // 사용자가 입력한 캡차 이미지 글자값
	            String apiURL = "https://naveropenapi.apigw.ntruss.com/captcha/v1/nkey?code=" + code +"&key="+ key + "&value="+ value;

	            URL url = new URL(apiURL);
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("GET");
	            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
	            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
	           
	            int responseCode = con.getResponseCode();
	            BufferedReader br;
	            if(responseCode==200) { // 정상 호출
	                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	            } else {  // 오류 발생
	                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	            }
	            String inputLine;
	            
	            while ((inputLine = br.readLine()) != null) {
	                response.append(inputLine);
	            }
	            br.close();
	            System.out.println(response.toString());
	        } catch (Exception e) {
	            System.out.println(e);
	        }
		
		//////////
		 JSONObject jsonObj = new JSONObject(response.toString());
			 
		 ResponseEntity<String> entity = null;
		 HttpHeaders headers = new HttpHeaders();
		 headers.setContentType(new MediaType("text","html", Charset.forName("UTF-8")));
		 headers.add("Content-Type", "text/html; charset=UTF-8");
		 
		 String message = "";
		 if(jsonObj.getBoolean("result")) {//문자가 맞을 경우
			 message += "<script>";
			 message += "alert('홈으로 이동합니다.');";
			 message += "location.href='/'";
			 message += "</script>";
			 entity = new ResponseEntity<String>(message, headers, HttpStatus.OK);
		 }else {//문자가 틀릴 경우
			 message += "<script>";
			 message += "alert('문자가 잘못입력되었습니다.');";
			 message += "location.href='/clova/captchaForm'";
			 message += "</script>";
			 entity = new ResponseEntity<String>(message, headers, HttpStatus.BAD_REQUEST);
		 }
	
		 return entity;
	}
	
	
	
	
	
	
	// 캡챠 키 발금
	public String captchaKey() {
		//////////////////////////////////  
		StringBuffer response = new StringBuffer();
		try {
            String code = "0"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
            String apiURL = "https://naveropenapi.apigw.ntruss.com/captcha/v1/nkey?code=" + code;
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 오류 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
         
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
	    ////////////////////////////////
		JSONObject jsonObj = new JSONObject(response.toString());
		String key = jsonObj.getString("key");
		return key;
	}
}
